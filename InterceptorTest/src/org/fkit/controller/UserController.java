package org.fkit.controller;

import javax.servlet.http.HttpSession;

import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	/**
	 * 处理login请求
	 */
	@RequestMapping(value="login")
	public ModelAndView login(String loginname,String password,
								ModelAndView mv,HttpSession session) {
		//模拟数据库根据用户名和密码查找用户， 判断用户登录
		if(loginname !=null && loginname.equals("fkit")
				&&password!=null && password.equals("123456")) {
			//创建模拟用户
			User user = new User();
			user.setLoginname(loginname);
			user.setPassword(password);
			user.setUsername("管理员");
			//登录成功，将user对象设置到HTTPSession作用域
			session.setAttribute("user", user);
			//转发到main请求
			mv.setViewName("redirect:main");
		}else {
			//登录失败，设置直白提示信息，并跳转到登录页面
			mv.addObject("message", "登录名或密码错误,请重新输入");
			mv.setViewName("loginForm");
		}
		return mv;
	}
	
	@RequestMapping(value="{formName}")
	public String loginForm(@PathVariable String formName) {
		return formName;
	}
}
