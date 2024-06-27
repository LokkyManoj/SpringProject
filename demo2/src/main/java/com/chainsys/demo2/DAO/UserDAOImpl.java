package com.chainsys.demo2.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.chainsys.demo2.model.User;
import com.chainsys.demo2.mapper.UserDetailsMapper;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public void insertUser(User user)  {
		String save="insert into user(name,age,mobile_no,gender,address) values(?,?,?,?,?)";
		Object[] params= {user.getUserName(),user.getAge(),user.getMobileNo(),user.getGender(),user.getAddress()};
		int rows=jdbcTemplate.update(save, params);
		System.out.println("Rows Affected:"+rows);
	}

	public List<User> listUsers(){
		String view="select id,name,age,mobile_no,gender,address from user where is_active=0";
		List<User> list=jdbcTemplate.query(view,new UserDetailsMapper());
		return list;
		
	}
	
	public void deleteUser(int id) {
        String delete = "update user set is_active=1 where id=?";
        jdbcTemplate.update(delete, id);
    }

	 public User findUserById(int id) {
	        String query = "select id,name,age,mobile_no,gender,address from user where id = ?";
	        return jdbcTemplate.queryForObject(query, new UserDetailsMapper(), id);
	    }

    public void updateUser(User user){
        String update = "update user set name = ?, age = ?, gender = ?, address = ? ,mobile_no=? where id = ?";
        Object[] params = {user.getUserName(), user.getAge(), user.getGender(), user.getAddress(), user.getMobileNo(),user.getId()};
        jdbcTemplate.update(update, params);
    }
	
    public List<User> findUsersByName(String name){
        String query = "select id,name,age,mobile_no,gender,address from user where name like ?";
        List<User> users = jdbcTemplate.query(query,new UserDetailsMapper(), "%" + name + "%" );
        return users;
    }
    
    
}
