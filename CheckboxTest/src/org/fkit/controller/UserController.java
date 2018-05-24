package org.fkit.controller;

import java.util.ArrayList;
import java.util.List;

import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@RequestMapping(value="/checkboxForm",method=RequestMethod.GET)
	public String registerForm(Model model) {
		User user = new User();
		//设置Boolean变量reader的值为true，页面的checkbox复选框被选中
		user.setReader(true);
		//为集合变量courses添加“JAVAEE”和“Spring”，页面的checkbox复选框会被选中
		List<String> list = new ArrayList<String>();
		list.add("JAVAEE");
		list.add("Spring");
		user.setCourses(list);
		//model中添加属性user，值是user对象
		model.addAttribute("user",user);
		return "checkboxForm";
	}
}
