package com.archql.labs.wtlab4pst.dao.api;

import com.archql.labs.wtlab4pst.dao.Dao;
import com.archql.labs.wtlab4pst.entity.User;
import com.archql.labs.wtlab4pst.exeptions.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User> {


    Optional<User> findByEmailAndPassword(String email, String password) throws DaoException;


    Optional<User> findByEmail(String email) throws DaoException;
}
