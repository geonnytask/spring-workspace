package com.sample.di.demo5;

public class UserService {

	private PointDao pointDao;
	public void setPointDao(PointDao pointDao) {
		this.pointDao = pointDao;
	}
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void addNewUser(String name, String id, String password) {
		userDao.insertUser(name, id, password);
		pointDao.updatePoint(id, 10);
		// 신규 회원 등록 기능
		// 신규 회원의 포인트를 10으로 변경하는 기능
	}
}
