package com.tang.web.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tang.core.Constants;
import com.tang.web.po.User;
import com.tang.web.security.PermissionSign;
import com.tang.web.security.RoleSign;
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
		List<User> data = userService.queryList();
		Result ret = new Result(ResultStatus.OK.value(),data);
		return ret;
	}
	
	@RequestMapping(value="/detail/{id}")
	@ResponseBody
	public Result detail(@PathVariable Long id){
		User data = userService.get(id);
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
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@Valid User user,BindingResult result,Model model,HttpServletRequest request){
		try {
			Subject subject = SecurityUtils.getSubject();
			if (subject.isAuthenticated()) {
				return "redirect:/index";
			}
			if (result.hasErrors()) {
				model.addAttribute("error", "参数错误！");
				return "login";
			}
			// 身份验证
			subject.login(new UsernamePasswordToken(user.getUname(), user.getPwd()));
			User authUser = userService.selectByUsername(user.getUname());
			request.getSession().setAttribute(Constants.SESSION_USER, authUser);
		} catch (AuthenticationException e) {
			// 身份验证失败
			model.addAttribute("error", "用户名或密码错误 ！");
			return "login";
		}
		return "redirect:/index";
		
	}
	
    /**
     * 用户登出
     * 
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute(Constants.SESSION_USER);
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
    
    @RequestMapping(value="/admin")
    @ResponseBody
    @RequiresRoles(value=RoleSign.ADMIN)
    public String admin(){
    	return "拥有admin角色";
    }
    
    @RequestMapping(value="/create")
    @ResponseBody
    @RequiresPermissions(value=PermissionSign.USER_CREATE)
    public String create(){
    	return "拥有创建用户user:create权限";
    }
	
}
