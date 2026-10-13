package com.example.springedu.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	 private String createTableSql="CREATE TABLE IF NOT EXIST users(id INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(50),email VARCHAR(50))";
	 private String saveDataSql="INSERT INTO users(name,email) VALUES(?,?)";
	 private String findAll="SELECT * FROM users";
	 // NEW SQL
	    private String deleteAllSql =
	        "DELETE FROM users";
	 public void createTable() {jdbcTemplate.execute(createTableSql);}
	 public void save(User user) {jdbcTemplate.update(saveDataSql,user.getName(),user.getEmail());}
	 public List<User> findAll() {return jdbcTemplate.query(findAll, new BeanPropertyRowMapper<>(User.class));}
	  // NEW METHOD
	    public void deleteAll() {
	        jdbcTemplate.update(deleteAllSql);
	    }
	
	
	
	
}
