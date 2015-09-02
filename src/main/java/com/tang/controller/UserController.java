package com.tang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tang.po.TestUser;
import com.tang.service.UserService;
import com.tang.vo.Result;
import com.tang.vo.ResultStatus;
/**
 * 用户控制器-示例
 * @author tangthis
 * <p>https://github.com/tangthis</p>
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/list")
	@ResponseBody
	public Result list(){
		List<TestUser> data = userService.queryList();
		Result ret = new Result(ResultStatus.OK.value(),data);
		return ret;
	}
	
	@RequestMapping(value="/detail/{id}")
	@ResponseBody
	public Result detail(@PathVariable Long id){
		TestUser data = userService.get(id);
		Result ret = new Result(ResultStatus.OK.value(), data);
		return ret;
	}
}
