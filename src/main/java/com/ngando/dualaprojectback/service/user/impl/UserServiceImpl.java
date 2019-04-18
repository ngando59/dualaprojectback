package com.ngando.dualaprojectback.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngando.dualaprojectback.dao.user.UserRepository;
import com.ngando.dualaprojectback.model.user.User;
import com.ngando.dualaprojectback.service.user.IUserService;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserbyId(Long id) {
		User user = null;
		user = userRepository.getOne(id);
		return user;
	}

	@Override
	public User findByLogin(String login) {
		User user = null;
		user = userRepository.findByLogin(login);
		return user;
	}

	@Override
	@Transactional(readOnly = false)
	public User saveOrUpdateUser(User user) {
		User userSaved = null;
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userSaved = userRepository.save(user);
		return userSaved;
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(Long id) {
		User user = getUserbyId(id);
		userRepository.delete(user);
	}

}
