package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	
	int createUser(User user);
	
	User loginUser(User user);
}
