package com.archql.labs.wtlab4pst.dao.impl;

import com.archql.labs.wtlab4pst.dao.api.UserDao;
import com.archql.labs.wtlab4pst.dao.mapper.RowMapperFactory;
import com.archql.labs.wtlab4pst.dao.AbstractDao;
import com.archql.labs.wtlab4pst.dao.Table;
import com.archql.labs.wtlab4pst.entity.User;
import com.archql.labs.wtlab4pst.exeptions.DaoException;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD_QUERY = "SELECT * FROM " + Table.USER + " WHERE email=? and password=SHA1(?)";
    private static final String FIND_USER_BY_EMAIL_QUERY = "SELECT * FROM " + Table.USER + " WHERE email=?";
    private static final String SAVE_USER_QUERY = "INSERT INTO " + Table.USER + " (email, password, role_id, userInformation_id) VALUES (?, ?, ?, ?)";
    private static final String DELETE_USER_QUERY = "DELETE FROM " + Table.USER + " WHERE id=?";

    public UserDaoImpl() {
        super(RowMapperFactory.getInstance().getUserRowMapper(), Table.USER);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) throws DaoException {
        return executeQueryForSingleResult(FIND_USER_BY_EMAIL_AND_PASSWORD_QUERY, email, DigestUtils.sha1Hex(password));
    }


    @Override
    public Optional<User> findByEmail(String email) throws DaoException {
        return executeQueryForSingleResult(FIND_USER_BY_EMAIL_QUERY, email);
    }



    @Override
    public int save(User user) throws DaoException {
        return executeInsertQuery(SAVE_USER_QUERY, user.getEmail(), user.getPassword(),
                user.getRoleId(), user.getUserInformationId());
    }



    @Override
    public void removeById(int id) throws DaoException {
        executeUpdateQuery(DELETE_USER_QUERY, id);
    }
}
