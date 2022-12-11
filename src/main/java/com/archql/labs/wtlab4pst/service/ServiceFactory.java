package com.archql.labs.wtlab4pst.service;

import com.archql.labs.wtlab4pst.service.api.*;
import com.archql.labs.wtlab4pst.service.impl.ApartmentServiceImpl;
import com.archql.labs.wtlab4pst.service.impl.RoleServiceImpl;
import com.archql.labs.wtlab4pst.service.impl.UserOrderServiceImpl;
import com.archql.labs.wtlab4pst.service.impl.UserServiceImpl;
//import com.archql.labs.wtlab4pst.service.description.*;
import com.archql.labs.wtlab4pst.service.impl.*;

public class ServiceFactory {

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }



    private final UserOrderService userOrderService=new UserOrderServiceImpl();
    private final UserInformationService userInformationService=new UserInformationServiceImpl();
    private final ApartmentService apartmentService=new ApartmentServiceImpl();
    private final UserService userService=new UserServiceImpl();
    private final RoleService roleService=new RoleServiceImpl();


    public ApartmentService getApartmentService() {
        return apartmentService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public UserService getUserService() {
        return userService;
    }

    public UserOrderService getUserOrderService() {
        return userOrderService;
    }

    public UserInformationService getUserInformationService() {
        return userInformationService;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }
}
