package com.archql.labs.wtlab4pst.controller.command.impl.transition;

import com.archql.labs.wtlab4pst.controller.command.Command;
import com.archql.labs.wtlab4pst.controller.command.CommandResult;
import com.archql.labs.wtlab4pst.controller.command.CommandResultType;
import com.archql.labs.wtlab4pst.controller.context.RequestContext;
import com.archql.labs.wtlab4pst.controller.context.RequestContextHelper;
import com.archql.labs.wtlab4pst.entity.Apartment;
import com.archql.labs.wtlab4pst.entity.User;
import com.archql.labs.wtlab4pst.entity.UserOrder;
import com.archql.labs.wtlab4pst.exeptions.ServiceException;
import com.archql.labs.wtlab4pst.service.ServiceFactory;
import com.archql.labs.wtlab4pst.service.api.ApartmentService;
import com.archql.labs.wtlab4pst.service.api.UserOrderService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToMyOrdersCommand implements Command {
    private static final String PAGE = "WEB-INF/view/myOrders.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String USER_ORDERS = "userOrders";
    private static final String APARTMENTS = "apartments";
    private static final String USER = "user";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        User user = (User) requestContext.getSessionAttribute(USER);
        if (user == null) {
            helper.updateRequest(requestContext);
            return new CommandResult(PAGE, CommandResultType.FORWARD);
        }
        try {
            UserOrderService userOrderService= ServiceFactory.getInstance().getUserOrderService();
            List<UserOrder> userOrders=userOrderService.retrieveUserOrderByUserId(user.getId());
            requestContext.addRequestAttribute(USER_ORDERS, userOrders);
            ApartmentService apartmentService=ServiceFactory.getInstance().getApartmentService();
            List<Apartment> apartments=apartmentService.retrieveApartamentsByUserId(user.getId());
            requestContext.addRequestAttribute(APARTMENTS, apartments);

        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
