package com.chainsys.demo2.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.demo2.model.User;

public interface UserDAO {
	@Autowired
	public void insertUser(User user);

	public List<User> listUsers();

	public void deleteUser(int id);

	public User findUserById(int id);

	public void updateUser(User user);

	public List<User> findUsersByName(String name);
}
