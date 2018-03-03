package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Repository;

import com.das.bo.UserBo;
import com.das.bo.UserBo1;

@Repository
public class PDF_EXCEL_DAO {

	public String USER_DETALS="SELECT USER_NM, PASSWORD_NM, ROLE_NM FROM USERS";
	
	 
		@Autowired
		public JdbcTemplate jtemplate;
	
	public List<UserBo1> regitionDetails() {
		
		return  jtemplate.query(USER_DETALS, new RowMapper<UserBo1>() {

			@Override
			public UserBo1 mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
                    UserBo1 u=new UserBo1();
				
					u.setUsername(rs.getString("USER_NM"));
					u.setPassword(rs.getString("PASSWORD_NM"));
					u.setRole(rs.getString("ROLE_NM"));
				
				return u;
			}

		 
			
		});
				
			 
			
		}}
				
				
		/*return jtemplate.query( USER_DETALS,new ResultSetExtractor<List<UserBo1>>() {

			@Override
			public List<UserBo1> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<UserBo1> users=new ArrayList<UserBo1>();
				UserBo1 u=new UserBo1();
				
				for(int i=0;rs.next();i++) {
					u.setUsername(rs.getString("USER_NM"));
					u.setPassword(rs.getString("PASSWORD_NM"));
					u.setRole(rs.getString("ROLE_NM"));
					users.add(u);
				
				
				
			}
				return users;
			
		
		}
	});*/
		
		 
		

		 
		
		/*	return jtemplate.execute(new GetAllProjectsStatementCallback());
		}

		private final class GetAllProjectsStatementCallback implements StatementCallback<List<UserBo>> {
		 

				 

			@Override
			public List<UserBo> doInStatement(Statement st) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<UserBo> users=new ArrayList<UserBo>();
				UserBo u=new UserBo();
				ResultSet rs = st.executeQuery(USER_DETALS);
				
				while(rs.next()) {
					u.setUsername(rs.getString("USER_NM"));
					u.setPassword("PASSWORD");
					u.setRole("ROLE");
					users.add(u);
				}
				return users;*/
			
