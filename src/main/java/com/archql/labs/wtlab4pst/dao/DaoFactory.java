package com.archql.labs.wtlab4pst.dao;

import com.archql.labs.wtlab4pst.dao.impl.ApartamentDaoImpl;
import com.archql.labs.wtlab4pst.dao.impl.RoleDaoImpl;
import com.archql.labs.wtlab4pst.dao.impl.UserDaoImpl;
import com.archql.labs.wtlab4pst.dao.impl.UserInformationDaoImpl;
import com.archql.labs.wtlab4pst.dao.impl.UserOrderDaoImpl;


public class DaoFactory {
    private final UserDaoImpl userDao = new UserDaoImpl();
    private final RoleDaoImpl roleDao = new RoleDaoImpl();
    private final UserInformationDaoImpl userInformationDao = new UserInformationDaoImpl();
    private final UserOrderDaoImpl userOrderDao=new UserOrderDaoImpl();
    private final ApartamentDaoImpl apartamentDao=new ApartamentDaoImpl();

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public RoleDaoImpl getRoleDao() {
        return roleDao;
    }

    public UserInformationDaoImpl getUserInformationDao() {
        return userInformationDao;
    }

    public UserOrderDaoImpl getUserOrderDao() {
        return userOrderDao;
    }

    public ApartamentDaoImpl getApartamentDao() {
        return apartamentDao;
    }

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return Holder.INSTANCE;
    }


    private static class Holder {
        static final DaoFactory INSTANCE = new DaoFactory();
    }
}