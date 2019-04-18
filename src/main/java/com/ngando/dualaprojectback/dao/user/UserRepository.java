package com.ngando.dualaprojectback.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngando.dualaprojectback.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByLogin(String login);

}
