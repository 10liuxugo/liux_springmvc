package com.liux.sys.iservice;

import java.util.List;

import com.liux.sys.entity.UserVo;

public interface IUserService {
	public UserVo login(UserVo u);
	public List<UserVo> GetUserList();
	public UserVo selectByPrimaryKey(String id);
}
