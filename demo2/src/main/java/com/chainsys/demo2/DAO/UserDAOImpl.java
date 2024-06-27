package com.chainsys.demo2.DAO;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.chainsys.demo2.model.User;
import com.chainsys.demo2.mapper.UserDetailsMapper;

@Repository
public class UserDAOImpl {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public void insertUser(User user) throws ClassNotFoundException,SQLException {
		String save="insert into user(name,age,mobile_no,gender,address) values(?,?,?,?,?)";
		Object[] params= {user.getUserName(),user.getAge(),user.getMobileNo(),user.getGender(),user.getAddress()};
		int rows=jdbcTemplate.update(save, params);
		System.out.println("Rows Affected:"+rows);
	}

	public List<User> listUsers(){
		String view="select*from user";
		List<User> list=jdbcTemplate.query(view,new UserDetailsMapper());
		return list;
		
	}
	
	public void deleteUser(int id) throws SQLException {
        String delete = "delete from user where id = ?";
        jdbcTemplate.update(delete, id);
    }

	 public User findUserById(int id) throws SQLException {
	        String query = "select * from user where id = ?";
	        return jdbcTemplate.queryForObject(query, new UserDetailsMapper(), id);
	    }

    public void updateUser(User user) throws SQLException {
        String update = "update user set name = ?, age = ?, gender = ?, address = ? where mobile_no = ?";
        Object[] params = {user.getUserName(), user.getAge(), user.getGender(), user.getAddress(), user.getMobileNo()};
        jdbcTemplate.update(update, params);
    }
	
    public List<User> findUsersByName(String name) throws SQLException {
        String query = "select * from user where name like ?";
        List<User> users = jdbcTemplate.query(query, new Object[]{"%" + name + "%"}, new UserDetailsMapper());
        return users;
    }
}
