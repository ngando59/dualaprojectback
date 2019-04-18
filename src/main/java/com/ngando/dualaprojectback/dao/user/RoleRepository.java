package com.ngando.dualaprojectback.dao.user;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ngando.dualaprojectback.model.user.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleName(String roleName);

	@Query("select role from Role role")
	Stream<Role> getAllRolesStream();
}
