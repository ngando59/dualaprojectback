package com.ngando.dualaprojectback.controller.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ngando.dualaprojectback.model.user.Role;
import com.ngando.dualaprojectback.model.user.User;
import com.ngando.dualaprojectback.service.user.IRoleService;
import com.ngando.dualaprojectback.service.user.IUserService;

@Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/user/*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@GetMapping(value = "/all-users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		logger.info("liste des utilisateurs : " + users.toString());
		return new ResponseEntity<List<User>>(users, HttpStatus.FOUND);
	}

	@GetMapping(value = "/users-by-name/{loginName}")
	public ResponseEntity<User> findUserByLogin(@PathVariable("loginName") String login) {
		User user = userService.findByLogin(login);
		logger.debug("Utilisateur trouvé : " + user);
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}

	@PostMapping(value = "/add-user")
	@Transactional
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		Set<Role> roles = new HashSet<>();
		Role roleUser = new Role("ROLE_USER");
		roles.add(roleUser);
		user.setRoles(roles);
		user.setActive(0);

		Set<Role> roleFromDB = extractRole_Java8(user.getRoles(), roleService.getAllRolesStream());
		user.getRoles().removeAll(user.getRoles());
		user.setRoles(roleFromDB);
		User userSave = userService.saveOrUpdateUser(user);
		logger.info("userSave : " + userSave.toString());
		return new ResponseEntity<User>(userSave, HttpStatus.CREATED);
	}

	@GetMapping(value = "/find-user/{id}")
	public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
		User user = userService.getUserbyId(id);
		logger.debug("Utilisateur trouvé : " + user);
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}

	@PutMapping(value = "/update-user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {

		User userToUpdate = userService.getUserbyId(id);
		if (userToUpdate == null) {
			logger.debug("L'utilisateur avec l'identifiant " + id + " n'existe pas");
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}

		logger.info("UPDATE ROLE: " + userToUpdate.getRoles().toString());
		userToUpdate.setLogin(user.getLogin());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setActive(user.getActive());
		User userUpdated = userService.saveOrUpdateUser(userToUpdate);
		return new ResponseEntity<User>(userUpdated, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete-user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.GONE);
	}

	private Set<Role> extractRole_Java8(Set<Role> rolesSetFromUser, Stream<Role> roleStreamFromDB) {
		// Collect UI role names
		Set<String> uiRoleNames = rolesSetFromUser.stream().map(Role::getRoleName)
				.collect(Collectors.toCollection(HashSet::new));
		// Filter DB roles
		return roleStreamFromDB.filter(role -> uiRoleNames.contains(role.getRoleName())).collect(Collectors.toSet());
	}

}
