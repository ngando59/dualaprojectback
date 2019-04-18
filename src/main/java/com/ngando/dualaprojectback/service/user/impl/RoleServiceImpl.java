package com.ngando.dualaprojectback.service.user.impl;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngando.dualaprojectback.dao.user.RoleRepository;
import com.ngando.dualaprojectback.model.user.Role;
import com.ngando.dualaprojectback.service.user.IRoleService;

@Service(value = "roleService")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Stream<Role> getAllRolesStream() {
		return roleRepository.getAllRolesStream();
	}

}
