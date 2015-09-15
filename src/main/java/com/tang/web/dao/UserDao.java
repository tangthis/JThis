/**
 * 
 */
package com.tang.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tang.core.generic.BaseDao;
import com.tang.web.po.User;

/**
 * User查询DAO
 * @author tangthis
 * <p>https://github.com/tangthis</p>
 *
 */
@Repository
public interface UserDao extends BaseDao<User, Long>{
	List<User> findList();

	User get(Long id);

	User authentication(@Param("record") User user);

	List<User> queryUsers(@Param("record") User queryUser);
}
