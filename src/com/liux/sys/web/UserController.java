package com.liux.sys.web;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liux.sys.entity.UserVo;
import com.liux.sys.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String login(ModelMap modelMap) {

		UserVo u = new UserVo();
		u = userService.login(u);

		modelMap.addAttribute("msg", u.getName() + "||" + u.getId() + "||" + u.getPassword());

		System.out.println("dddddddddddddddddd");

		List<UserVo> list = userService.GetUserList();
		return "test";
	}

}
