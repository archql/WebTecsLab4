package com.archql.labs.wtlab4pst.dao.mapper;

import com.archql.labs.wtlab4pst.entity.MyIdentifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends MyIdentifiable> {
    T map(ResultSet resultSet) throws SQLException;
}