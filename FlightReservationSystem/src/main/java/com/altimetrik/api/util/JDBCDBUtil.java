package com.altimetrik.api.util;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCDBUtil {

	public static JDBCDBUtil getInstance() {
		return new JDBCDBUtil();
	}

	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		  dataSource.setUrl("jdbc:mysql://localhost:3306/flightdb");
		  dataSource.setUsername("altimetrik");
		  dataSource.setPassword("altimetrik-3355");	 

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate retBean = new JdbcTemplate(dataSource());
		return retBean;
	}
}