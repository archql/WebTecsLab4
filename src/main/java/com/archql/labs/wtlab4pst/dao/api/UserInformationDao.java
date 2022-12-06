package com.archql.labs.wtlab4pst.dao.api;

import com.archql.labs.wtlab4pst.dao.Dao;
import com.archql.labs.wtlab4pst.entity.UserInformation;
import com.archql.labs.wtlab4pst.exeptions.DaoException;


public interface UserInformationDao extends Dao<UserInformation> {

    void updateById(int id, UserInformation userInformation) throws DaoException;
}
