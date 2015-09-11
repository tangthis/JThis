package com.tang.web.service;

import java.util.List;

import com.tang.web.po.TestUser;

public interface UserService {
	
	public List<TestUser> queryList();

	public TestUser get(Long id);
}
