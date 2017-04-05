package com.liux.sys.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import com.liux.sys.entity.UserVo;
import com.liux.sys.service.UserService;



@Controller
public class UserController {

	private static Log runLog = LogFactory.getLog("runLogger");// 运行日志
	private static Log interfaceLog = LogFactory.getLog("interfaceLogger");// 接口日志
	

	//slf4j
    private Logger logtest = LoggerFactory.getLogger(UserController.class);
    

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String login(ModelMap modelMap) {

		
		logtest.info("slf4j gogogogo");
		
		
		logtest.error("slf4j errorslf4j errorslf4j errorslf4j errorslf4j error");
/*		interfaceLog.info("====>>请求");
		runLog.info("请求02");*/
		UserVo u = new UserVo();
		u = userService.login(u);

		modelMap.addAttribute("msg", u.getName() + "||" + u.getId() + "||" + u.getPassword());

		System.out.println("dddddddddddddddddd");

		List<UserVo> list = userService.GetUserList();
		return "test";
	}

}
