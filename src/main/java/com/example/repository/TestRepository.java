package com.example.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Order;

@Repository
public class TestRepository {

	@Autowired
	private DataSource dataSource;

	public void insert() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Order order = new Order();
		order.setUserId(1);
		
		String sql = "INSERT INTO orders (id, user_id) VALUES (cast(to_char(CURRENT_TIMESTAMP, 'yyyymmdd')||to_char(nextval('customer_code_seq'),'FM000000') as bigint), ?) RETURNING id";
		
		Integer userId = order.getUserId();
		long id = jdbcTemplate.queryForObject(sql, long.class,userId);
		
		System.out.println("id");
		System.out.println(id);
	}
}
