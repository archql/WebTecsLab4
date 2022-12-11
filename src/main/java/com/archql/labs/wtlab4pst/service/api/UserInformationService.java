package com.archql.labs.wtlab4pst.service.api;

import com.archql.labs.wtlab4pst.entity.User;
import com.archql.labs.wtlab4pst.entity.UserInformation;
import com.archql.labs.wtlab4pst.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserInformationService {

    Optional<UserInformation> retrieveUserInformationById(int userInformationId) throws ServiceException;


    List<UserInformation> getUserInformationFromUsers(List<User> users) throws ServiceException;
}
