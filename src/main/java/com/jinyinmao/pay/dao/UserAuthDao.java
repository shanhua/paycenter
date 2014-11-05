package com.jinyinmao.pay.dao;
import com.jinyinmao.pay.model.UserAuth;

public interface UserAuthDao {
	public void insert(UserAuth userAuth);
	public UserAuth findBySn(String sn);
}