package com.tang.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tang.web.dao.TestUserDao;
import com.tang.web.po.TestUser;
import com.tang.web.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	TestUserDao testUserDao;
	@Override
	public List<TestUser> queryList() {
		return testUserDao.findList();
	}
	@Override
	public TestUser get(Long id) {
		return testUserDao.get(id);
	}

	
}
