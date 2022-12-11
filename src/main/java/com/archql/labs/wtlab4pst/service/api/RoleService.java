package com.archql.labs.wtlab4pst.service.api;

import com.archql.labs.wtlab4pst.entity.Role;
import com.archql.labs.wtlab4pst.exeptions.ServiceException;

import java.util.Optional;

public interface RoleService {

    Optional<Role> retrieveRoleById(int roleId) throws ServiceException;
    Optional<Role> retrieveRoleByRoleName(String roleName) throws ServiceException;

}
