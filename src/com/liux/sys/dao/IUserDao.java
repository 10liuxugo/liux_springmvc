package com.liux.sys.dao;

import java.util.List;

import com.liux.sys.entity.UserVo;

public interface IUserDao {

	public UserVo login(UserVo u);
	public List<UserVo> GetUserList();
}
