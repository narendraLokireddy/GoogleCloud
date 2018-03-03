package com.das.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.das.bo.UserBo;
import com.das.dao.UserDao;
import com.das.security.dto.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserBo userBo = null;
		UserDetails userDetails = null;

		userBo = userDao.findUserByName(username);
		userDetails = new UserDetailsImpl(userBo.getUsername(), userBo.getPassword(), userBo.getRole());

		return userDetails;
	}

}
