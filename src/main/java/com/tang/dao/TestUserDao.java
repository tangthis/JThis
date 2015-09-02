/**
 * 
 */
package com.tang.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tang.po.TestUser;

/**
 * 
 * @author tangthis
 * <p>https://github.com/tangthis</p>
 *
 */
@Repository
public interface TestUserDao {
	List<TestUser> findList();

	TestUser get(Long id);
}
