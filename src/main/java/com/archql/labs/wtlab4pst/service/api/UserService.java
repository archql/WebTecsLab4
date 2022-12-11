package com.archql.labs.wtlab4pst.service.api;

import com.archql.labs.wtlab4pst.entity.User;
import com.archql.labs.wtlab4pst.entity.UserOrder;
import com.archql.labs.wtlab4pst.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {


    Optional<User> login(String email, String password) throws ServiceException;


    boolean register(String name, String surname,  String email, String phone, String password) throws ServiceException;


    Optional<User> retrieveUserById(int userId) throws ServiceException;

    public List<User> getUsersFromOrders(List<UserOrder> orders) throws ServiceException;


}
