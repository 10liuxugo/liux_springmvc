package com.liux.sys.idao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.liux.sys.dao.IUserDao;
import com.liux.sys.entity.UserVo;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Repository("UserDao")
public class UserDao implements IUserDao {


	 @Autowired  
	    @Qualifier("film-template")//鍚嶅瓧璺焫ml涓厤缃殑id瑕佷竴鑷�?  
	       /* 灏佽涓�涓狫dbcTemplate鐨勬ā鏉垮璞�? */    
	    private JdbcTemplate jdbcTemplate;    
	    
	    /* 閫氳繃set鏂规硶娉ㄥ叆杩涙潵鍗冲彲 */    
	    public JdbcTemplate getJdbcTemplate() {  
	        return jdbcTemplate;  
	    }  
	    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	        this.jdbcTemplate = jdbcTemplate;  
	    } 
	       
	    @Override  
	    public UserVo login(UserVo u) {  
	        String sql="select * from user where name=? and password=?";  
	        Object[] param = new Object[]{u.getName(),u.getPassword()};  
	        List<UserVo> la = jdbcTemplate.query(sql,param,new RowMapper<UserVo>() {  
	                    public UserVo mapRow(ResultSet rs, int i)  
	                            throws SQLException {  
	                        UserVo vo = new UserVo();  
	                        vo.setId(rs.getInt("id"));  
	                        vo.setName(rs.getString("name"));  
	                        vo.setPassword(rs.getString("password"));  
	                        return vo;  
	                    }  
	                });  
	        if(la!=null&&la.size()>0){  
	            return la.get(0);  
	        }else{  
	            return null;  
	        }  
	    }
		@Override
		public List<UserVo> GetUserList() {
		    List<UserVo> userMap = new ArrayList<UserVo>();
			String  sql ="select * from user";
		    //return jdbcTemplate.query(sql, new RowMapperResultReader(new UserRowMapper()));  
			//List<UserVo> list = jdbcTemplate.query(sql,  new rowMapper<UserVo>());
			
			
			 return getJdbcTemplate().query(sql, new BeanPropertyRowMapper(UserVo.class));  
			 
		
		}  
	    

}
