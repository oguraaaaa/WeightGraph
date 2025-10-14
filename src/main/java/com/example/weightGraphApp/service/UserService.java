package com.example.weightGraphApp.service;

import com.example.weightGraphApp.entity.Authentication;
import com.example.weightGraphApp.entity.User;

public interface UserService {
	void insert(User user);
	void insertAuth(Authentication auth);
	void delete();
	void deleteAuth();
}
