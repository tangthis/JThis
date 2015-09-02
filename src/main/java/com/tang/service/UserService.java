package com.tang.service;

import java.util.List;

import com.tang.po.TestUser;

public interface UserService {
	
	public List<TestUser> queryList();

	public TestUser get(Long id);
}
