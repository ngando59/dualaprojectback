package com.ngando.dualaprojectback.service.user;

import java.util.List;

import com.ngando.dualaprojectback.model.user.User;

public interface IUserService {

	List<User> getAllUsers();

	User getUserbyId(Long id);

	User findByLogin(String login);

	User saveOrUpdateUser(User user);

	void deleteUser(Long id);

}
