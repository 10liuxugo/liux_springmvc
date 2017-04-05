package com.liux.sys.web;

import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.record.formula.functions.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liux.sys.entity.UserVo;
import com.liux.sys.service.UserService;

import jdk.nashorn.internal.runtime.linker.JavaAdapterFactory;

@Controller
public class UserController {

	private static Log runLog = LogFactory.getLog("runLogger");// 运行日志
	private static Log interfaceLog = LogFactory.getLog("interfaceLogger");// 接口日志

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String login(ModelMap modelMap) {

		interfaceLog.info("====>>请求");
		runLog.info("请求02");
		UserVo u = new UserVo();
		u = userService.login(u);

		modelMap.addAttribute("msg", u.getName() + "||" + u.getId() + "||" + u.getPassword());

		System.out.println("dddddddddddddddddd");

		List<UserVo> list = userService.GetUserList();
		return "test";
	}

}
