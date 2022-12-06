package com.archql.labs.wtlab4pst.dao.mapper.impl;

import com.archql.labs.wtlab4pst.dao.mapper.Column;
import com.archql.labs.wtlab4pst.dao.mapper.RowMapper;
import com.archql.labs.wtlab4pst.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role map(ResultSet resultSet) throws SQLException {
        Role role = new Role();
        role.setId(resultSet.getInt(Column.ID));
        role.setName(resultSet.getString(Column.ROLE_NAME));
        return role;
    }
}