package com.jinyinmao.pay.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jinyinmao.pay.dao.UserAuthDao;
import com.jinyinmao.pay.domain.UserAuth;

public class App{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserAuthDao userAuthDao = (UserAuthDao) context.getBean("userAuthDao");
		UserAuth userAuth = new UserAuth();
		userAuth.setUserAuthId(17);
		userAuth.setSn("afafeee1414e22");
		userAuth.setMobileNo("18616803171");
		userAuthDao.insert(userAuth);
		UserAuth findUserAuth = userAuthDao.findBySn("afafeee1414e11");
		System.out.println(findUserAuth.getMobileNo());
	}
}