package com.archql.labs.wtlab4pst.dao.api;

import com.archql.labs.wtlab4pst.dao.Dao;
import com.archql.labs.wtlab4pst.entity.Role;
import com.archql.labs.wtlab4pst.exeptions.DaoException;

import java.util.Optional;

public interface RoleDao extends Dao<Role> {


    Optional<Role> findByName(String name) throws DaoException;
}