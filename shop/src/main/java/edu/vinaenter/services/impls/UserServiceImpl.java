package edu.vinaenter.services.impls;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import edu.vinaenter.daos.UserDao;
import edu.vinaenter.models.User;
import edu.vinaenter.services.UserServices;
import edu.vinaenter.utils.DefineUtil;

@Service
public class UserServiceImpl implements UserServices {
	@Autowired
	private UserDao userDao;
	@Autowired
	private JavaMailSender mailSender;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public List<User> findAllPagination(int offset) {
		return userDao.findUserByOffset(offset);
	}

	public int countPagination() {
		return userDao.countUser();
	}

	public int addUser(User user) {
		return userDao.add(user);
	}

	public boolean checkUser(User user) {
		return userDao.checkUsere(user)!=null ? false : true;
	}

	public int delete(Integer id) {
		return userDao.del(id);
	}

	public User getItem(Integer id) {
		return userDao.getItem(id);
	}

	public int edit(User user) {
		return userDao.edit(user);
	}

}
