package com.tang.web.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tang.core.generic.BaseDao;
import com.tang.core.generic.BaseServiceImpl;
import com.tang.web.dao.UserDao;
import com.tang.web.po.User;
import com.tang.web.po.enums.Status;
import com.tang.web.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public BaseDao<User, Long> getDao() {
		return userDao;
	}
	
	@Override
	public List<User> queryList() {
		return userDao.findList();
	}
	@Override
	public User get(Long id) {
		return userDao.get(id);
	}
	@Override
	public User authentication(User user) {
		return userDao.authentication(user);
	}
	@Override
	public User selectByUsername(String username) {
		User queryUser = new User();
		queryUser.setUname(username);
		queryUser.setStatus(Status.NORMAL);
		List<User> userList = userDao.queryUsers(queryUser);
		if(CollectionUtils.isNotEmpty(userList)){
			return userList.get(0);
		}
		
		return null;
	}
	
	

	
}
