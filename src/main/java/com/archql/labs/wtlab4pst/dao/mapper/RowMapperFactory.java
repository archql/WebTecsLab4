package com.archql.labs.wtlab4pst.dao.mapper;

import com.archql.labs.wtlab4pst.dao.mapper.impl.ApartmentRowMapper;
import com.archql.labs.wtlab4pst.dao.mapper.impl.RoleRowMapper;
import com.archql.labs.wtlab4pst.dao.mapper.impl.UserInformationRowMapper;
import com.archql.labs.wtlab4pst.dao.mapper.impl.UserOrderRowMapper;
import com.archql.labs.wtlab4pst.dao.mapper.impl.UserRowMapper;
import com.archql.labs.wtlab4pst.entity.Apartment;
import com.archql.labs.wtlab4pst.entity.Role;
import com.archql.labs.wtlab4pst.entity.User;
import com.archql.labs.wtlab4pst.entity.UserInformation;
import com.archql.labs.wtlab4pst.entity.UserOrder;
import com.archql.labs.wtlab4pst.dao.mapper.impl.*;
import com.archql.labs.wtlab4pst.entity.*;

public class RowMapperFactory {
    public static RowMapperFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final RowMapper<User> userRowMapper = new UserRowMapper();
    private final RowMapper<Role> roleRowMapper = new RoleRowMapper();
    private final RowMapper<UserInformation> userInformationRowMapper = new UserInformationRowMapper();
    private final RowMapper<UserOrder> userOrderRowMapper = new UserOrderRowMapper();
    private final RowMapper<Apartment> apartmentRowMapper = new ApartmentRowMapper();

    public RowMapper<User> getUserRowMapper() {
        return userRowMapper;
    }

    public RowMapper<Role> getRoleRowMapper() {
        return roleRowMapper;
    }

    public RowMapper<UserInformation> getUserInformationRowMapper() {
        return userInformationRowMapper;
    }

    public RowMapper<UserOrder> getUserOrderRowMapper() {
        return userOrderRowMapper;
    }

    public RowMapper<Apartment> getApartmentRowMapper() {
        return apartmentRowMapper;
    }

    private static class Holder {
        private static final RowMapperFactory INSTANCE = new RowMapperFactory();
    }
}
