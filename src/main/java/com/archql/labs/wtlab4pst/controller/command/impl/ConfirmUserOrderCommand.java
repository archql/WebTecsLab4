package com.archql.labs.wtlab4pst.controller.command.impl;

import com.archql.labs.wtlab4pst.controller.command.Command;
import com.archql.labs.wtlab4pst.controller.command.CommandResult;
import com.archql.labs.wtlab4pst.controller.command.CommandResultType;
import com.archql.labs.wtlab4pst.controller.context.RequestContext;
import com.archql.labs.wtlab4pst.controller.context.RequestContextHelper;
import com.archql.labs.wtlab4pst.entity.User;
import com.archql.labs.wtlab4pst.exeptions.ServiceException;
import com.archql.labs.wtlab4pst.service.ServiceFactory;
import com.archql.labs.wtlab4pst.service.api.UserOrderService;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class ConfirmUserOrderCommand implements Command {
    private static final String ADD_ORDER_PAGE = "WEB-INF/view/addUserOrder.jsp";
    private static final String MY_ORDERS_PAGE = "command=myOrders";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String ERROR_MESSAGE = "errorMessage";

    private static final String LEASE_DURATION= "lease_duration";
    private static final String MONTH = "month";
    private static final String YEAR = "year";
    private static final String DAY = "day";
    private static final String HOUR = "hour";
    private static final String MINUTE="minute";

    private static final String USER = "user";
    private static final String APARTMENT_ID = "apartment_id";




    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();


        Optional<String> leaseDuration = Optional.ofNullable(requestContext.getRequestParameter(LEASE_DURATION));
        Optional<String> month = Optional.ofNullable(requestContext.getRequestParameter(MONTH));
        Optional<String> year = Optional.ofNullable(requestContext.getRequestParameter(YEAR));
        Optional<String> day = Optional.ofNullable(requestContext.getRequestParameter(DAY));
        Optional<String> minute = Optional.ofNullable(requestContext.getRequestParameter(MINUTE));
        Optional<String> hour = Optional.ofNullable(requestContext.getRequestParameter(HOUR));


        try {
            User user = (User) requestContext.getSessionAttribute(USER);
            int apartmentId=Integer.parseInt(requestContext.getRequestParameter(APARTMENT_ID));
            int userId = user.getId();


            if ( leaseDuration.isPresent() && month.isPresent() && year.isPresent() && day.isPresent()
            && minute.isPresent() && hour.isPresent()) {
                UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
               boolean result = userOrderService.addNewUserOrder(year.get(), month.get(), day.get(), hour.get(), minute.get(),
                       leaseDuration.get(), String.valueOf(userId),String.valueOf(apartmentId));
                if (result) {
                    helper.updateRequest(requestContext);

                    return new CommandResult(MY_ORDERS_PAGE, CommandResultType.REDIRECT);
                }

            }

            requestContext.addRequestAttribute(ERROR_MESSAGE, true);
            helper.updateRequest(requestContext);
            return new CommandResult(ADD_ORDER_PAGE, CommandResultType.FORWARD);
        } catch (ServiceException e) {
            e.printStackTrace();
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }
    }


}
