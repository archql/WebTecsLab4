package com.archql.labs.wtlab4pst.dao.impl;

import com.archql.labs.wtlab4pst.dao.api.UserInformationDao;
import com.archql.labs.wtlab4pst.dao.mapper.RowMapperFactory;
import com.archql.labs.wtlab4pst.dao.AbstractDao;
import com.archql.labs.wtlab4pst.dao.Table;
import com.archql.labs.wtlab4pst.entity.UserInformation;
import com.archql.labs.wtlab4pst.exeptions.DaoException;

public class UserInformationDaoImpl extends AbstractDao<UserInformation> implements UserInformationDao {
    private static final String SAVE_USER_INFORMATION_QUERY = "INSERT INTO " + Table.USER_INFORMATION +
            " (name, surname,  phone) VALUES (?, ?, ?)";
    private static final String UPDATE_BY_ID =
            "UPDATE "+ Table.USER_INFORMATION +"  SET name=?, surname=?, phone=?, WHERE account_id=?";

    public UserInformationDaoImpl() {
        super(RowMapperFactory.getInstance().getUserInformationRowMapper(), Table.USER_INFORMATION);
    }

    @Override
    public int save(UserInformation userInformation) throws DaoException {
        return executeInsertQuery(SAVE_USER_INFORMATION_QUERY, userInformation.getName(),
                userInformation.getSurname(),  userInformation.getPhone());
    }

    @Override
    public void updateById(int id, UserInformation userInformation) throws DaoException {
        executeUpdateQuery(UPDATE_BY_ID,userInformation.getName(),userInformation.getSurname(),userInformation.getPhone(),id);
    }
}
