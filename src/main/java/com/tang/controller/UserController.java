package com.tang.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
@RestController
//spring4中，为了方便Rest开发，增加@RestController注解，此注解加入了@ResponseBody
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/list")
	public Result list(){
		List<TestUser> data = userService.queryList();
		Result ret = new Result(ResultStatus.OK.value(),data);
		return ret;
	}
	
	@RequestMapping(value="/detail/{id}")
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
