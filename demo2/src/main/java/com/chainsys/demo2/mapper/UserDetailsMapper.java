package com.chainsys.demo2.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.demo2.model.User;

public class UserDetailsMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user= new User();
		 user.setId(rs.getInt("id"));
		user.setUserName(rs.getString("name"));
		user.setAge(rs.getInt("age"));
		user.setMobileNo(rs.getString("mobile_no"));
		user.setGender(rs.getString("gender"));
		user.setAddress(rs.getString("address"));
		return user;
	}

	
}
