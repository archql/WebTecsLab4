package com.archql.labs.wtlab4pst.controller.command.impl.transition;

import com.archql.labs.wtlab4pst.controller.command.Command;
import com.archql.labs.wtlab4pst.controller.command.CommandResult;
import com.archql.labs.wtlab4pst.controller.command.CommandResultType;
import com.archql.labs.wtlab4pst.controller.context.RequestContext;
import com.archql.labs.wtlab4pst.controller.context.RequestContextHelper;
import com.archql.labs.wtlab4pst.entity.Apartment;
import com.archql.labs.wtlab4pst.entity.User;
import com.archql.labs.wtlab4pst.entity.UserInformation;
import com.archql.labs.wtlab4pst.entity.UserOrder;
import com.archql.labs.wtlab4pst.exeptions.ServiceException;
import com.archql.labs.wtlab4pst.service.ServiceFactory;
import com.archql.labs.wtlab4pst.service.api.ApartmentService;
import com.archql.labs.wtlab4pst.service.api.UserInformationService;
import com.archql.labs.wtlab4pst.service.api.UserOrderService;
import com.archql.labs.wtlab4pst.service.api.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToViewOrdersCommand implements Command {
    private static final String PAGE = "WEB-INF/view/viewOrders.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String USER_ORDERS = "userOrders";
    private static final String USERS = "users";
    private static final String APARTMENTS = "apartments";
    private static final String USER_INFORMATION = "userInformation";
    private static final String EXPECTED = "booked";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {


            UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
            List<UserOrder> userOrders = userOrderService.retrieveUserOrderByStatus(EXPECTED);
            requestContext.addRequestAttribute(USER_ORDERS, userOrders);



            UserService userService = ServiceFactory.getInstance().getUserService();
            List<User> users = userService.getUsersFromOrders(userOrders);
            requestContext.addRequestAttribute(USERS, users);

            ApartmentService apartmentService=ServiceFactory.getInstance().getApartmentService();
            List<Apartment> apartments=apartmentService.retrieveApartamentsByUserOrders(userOrders);
            requestContext.addRequestAttribute(APARTMENTS, apartments);

            UserInformationService userInformationService = ServiceFactory.getInstance().getUserInformationService();
            List<UserInformation> userInformation = userInformationService.getUserInformationFromUsers(users);
            requestContext.addRequestAttribute(USER_INFORMATION, userInformation);

        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.FORWARD);
    }
}
