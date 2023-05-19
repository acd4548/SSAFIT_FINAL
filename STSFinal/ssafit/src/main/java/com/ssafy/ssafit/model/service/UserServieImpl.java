package com.ssafy.ssafit.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.User;

@Service
public class UserServieImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserServieImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int createUser(User user) { //회원가입
		return userDao.insertUser(user);
	}

	@Override
	public User loginUser(User user) { //로그인
		User tmp = userDao.selectOne(user.getUserId());
		if(tmp != null && tmp.getPassword().equals(user.getPassword())) {
			return tmp;
		}
		return null;
	}

}
