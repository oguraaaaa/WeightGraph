package com.example.weightGraphApp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.weightGraphApp.entity.Authentication;
import com.example.weightGraphApp.entity.User;
import com.example.weightGraphApp.repository.UserMapper;
import com.example.weightGraphApp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserMapper userMapper;
	@Override
	public void insert(User user) {
		userMapper.insert(user);
		
	}

	@Override
	public void insertAuth(Authentication auth) {
		userMapper.insertAuth(auth);
		
	}

	@Override
	public void delete(Integer id) {
		userMapper.delete(id);
		
	}

}
