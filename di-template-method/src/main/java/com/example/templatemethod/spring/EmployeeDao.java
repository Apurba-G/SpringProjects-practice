package com.example.templatemethod.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Template method: execute() handles connection, statement, cleanup.
	public void createTable() {
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS employee (id INT PRIMARY KEY, name VARCHAR(50))");
	}

	public void insertEmployee(int id, String name) {
		// update() is a template method – it manages statement creation,
		// parameter binding, and resource closing.
		jdbcTemplate.update("INSERT INTO employee (id, name) VALUES (?, ?)", id, name);
	}

	@SuppressWarnings("deprecation")
	public String getEmployeeName(int id) {
		// queryForObject() is a template method – it loops over ResultSet,
		// invokes the RowMapper callback for each row, and returns the result.
		return jdbcTemplate.queryForObject("SELECT name FROM employee WHERE id = ?", new Object[] { id },
				(rs, rowNum) -> rs.getString("name") // RowMapper callback
		);
	}

}
