package com.ngando.dualaprojectback.service.user;

import java.util.List;
import java.util.stream.Stream;

import com.ngando.dualaprojectback.model.user.Role;

public interface IRoleService {

	Role findByRoleName(String roleName);

	List<Role> getAllRoles();

	Stream<Role> getAllRolesStream();
}
