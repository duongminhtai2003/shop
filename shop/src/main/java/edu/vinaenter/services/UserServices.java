package edu.vinaenter.services;

import java.util.List;

import edu.vinaenter.models.User;

public interface UserServices {

	List<User> findAll();
	List<User> findAllPagination(int offset);
	int countPagination();
	int addUser(User user);
	boolean checkUser(User user);
	int delete(Integer id);
	User getItem(Integer id);
	int edit(User user);
}
