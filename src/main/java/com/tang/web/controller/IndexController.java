/**
 * 
 */
package com.tang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页控制器
 * 
 * @author tangthis
 * <p>https://github.com/tangthis</p>
 *
 */
@Controller
@RequestMapping(value="/")
public class IndexController {
	@RequestMapping(value="index")
	public String index(){
		return "index";
	}
}
