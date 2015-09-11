package com.tang.web.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tang.web.po.TestUser;
import com.tang.web.service.UserService;
import com.tang.web.vo.Result;
import com.tang.web.vo.ResultStatus;
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
	/**
	 * 上传图像
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/icon")
	@ResponseBody
	public Result icon(@RequestParam(value = "file", required = true) MultipartFile file,HttpServletRequest request){
		String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }
  
        try {  
            file.transferTo(targetFile);
            return new Result(ResultStatus.OK.value(),"上传成功");
        } catch (Exception e) {  
            e.printStackTrace();
            return new Result(ResultStatus.INTERNAL_SERVER_ERROR.value(),"系统异常");
        }
	}
}
