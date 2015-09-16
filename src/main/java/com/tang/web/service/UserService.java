package com.tang.web.service;

import java.util.List;

import com.tang.web.po.User;

public interface UserService {
	
	public List<User> queryList();

	public User get(Long id);
	

    /**
     * 用户验证
     * 
     * @param user
     * @return
     */
    User authentication(User user);

    /**
     * 根据用户名查询用户
     * 
     * @param username
     * @return
     */
    User selectByUsername(String username);
}
