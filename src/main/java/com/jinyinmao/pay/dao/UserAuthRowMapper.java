package com.jinyinmao.pay.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jinyinmao.pay.model.UserAuth;

public class UserAuthRowMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserAuth userAuth = new UserAuth();
		userAuth.setUserAuthId(rs.getInt("USER_AUTH_ID"));
		userAuth.setSn(rs.getString("SN"));
		userAuth.setMobileNo(rs.getString("MOBILE_NO"));
		return userAuth;
	}
}