package com.archql.labs.wtlab4pst.controller.command.impl;

import com.archql.labs.wtlab4pst.controller.command.Command;
import com.archql.labs.wtlab4pst.controller.command.CommandResult;
import com.archql.labs.wtlab4pst.controller.command.CommandResultType;
import com.archql.labs.wtlab4pst.controller.context.RequestContext;
import com.archql.labs.wtlab4pst.controller.context.RequestContextHelper;
import com.archql.labs.wtlab4pst.exeptions.ServiceException;
import com.archql.labs.wtlab4pst.service.ServiceFactory;
import com.archql.labs.wtlab4pst.service.api.UserOrderService;

import javax.servlet.http.HttpServletResponse;

public class DeleteUserOrderCommand implements Command {
    private static final String PAGE = "command=viewOrders";
    private static final String USER_ORDER_ID = "userOrderId";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String CANCELED = "canceled";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        try {
            int userOrderId = Integer.parseInt(requestContext.getRequestParameter(USER_ORDER_ID));
            UserOrderService userOrderService = ServiceFactory.getInstance().getUserOrderService();
            userOrderService.updateStatusAtUserOrderById(userOrderId, CANCELED);
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        helper.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandResultType.REDIRECT);
    }
}
