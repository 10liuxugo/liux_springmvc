package com.liux.sys.idao;
import java.util.List;

import com.liux.sys.entity.UserVo;

public interface IUserDao {

	public UserVo login(UserVo u);
	public List<UserVo> GetUserList();	
	public UserVo selectByPrimaryKey(String id);
}
