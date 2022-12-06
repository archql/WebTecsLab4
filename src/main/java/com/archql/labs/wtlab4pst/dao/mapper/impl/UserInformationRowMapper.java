package com.archql.labs.wtlab4pst.dao.mapper.impl;

import com.archql.labs.wtlab4pst.dao.mapper.Column;
import com.archql.labs.wtlab4pst.dao.mapper.RowMapper;
import com.archql.labs.wtlab4pst.entity.UserInformation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInformationRowMapper implements RowMapper<UserInformation> {
    @Override
    public UserInformation map(ResultSet resultSet) throws SQLException {
        UserInformation userInformation = new UserInformation();
        userInformation.setId(resultSet.getInt(Column.ID));
        userInformation.setName(resultSet.getString(Column.USER_INFORMATION_NAME));
        userInformation.setSurname(resultSet.getString(Column.USER_INFORMATION_SURNAME));
        userInformation.setPhone(resultSet.getString(Column.USER_INFORMATION_PHONE));
        return userInformation;
    }
}