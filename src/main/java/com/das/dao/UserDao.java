package com.das.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.das.bo.UserBo;

@Repository
public class UserDao {

	private final String SQL_GET_USER_BY_NM ="SELECT USER_NM, PASSWORD_NM, ROLE_NM FROM USERS WHERE USER_NM = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserBo findUserByName(String userName) {
		return jdbcTemplate.queryForObject(SQL_GET_USER_BY_NM, new RowMapper<UserBo>() {
			@Override
			public UserBo mapRow(ResultSet rs, int row) throws SQLException {
				UserBo bo = new UserBo();
				bo.setUsername(rs.getString("USER_NM"));
				bo.setPassword(rs.getString("PASSWORD_NM"));
				bo.setRole(rs.getString("ROLE_NM"));

				return bo;
			}
		}, new Object[] { userName });
	}

}
