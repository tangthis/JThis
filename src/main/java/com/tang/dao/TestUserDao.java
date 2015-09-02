/**
 * 
 */
package com.tang.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tang.po.TestUser;

/**
 * @author 唐有欢
 * <p>微信：tangcoder</p>
 *
 */
@Repository
public interface TestUserDao {
	List<TestUser> findList();

	TestUser get(Long id);
}
