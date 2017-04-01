package com.liux.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liux.sys.entity.UserVo;
import com.liux.sys.idao.UserDao;
import com.liux.sys.iservice.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserVo login(UserVo u) {
		// TODO Auto-generated method stub
		u = new UserVo();
		u.setName("name");
		u.setPassword("pwd");
		u = userDao.login(u);


		return u;
	}

	@Override
	public List<UserVo> GetUserList() {
		// TODO Auto-generated method stub
		List<UserVo> list = new  ArrayList<UserVo>();
		list =	userDao.GetUserList();
		return list;
	}

}
