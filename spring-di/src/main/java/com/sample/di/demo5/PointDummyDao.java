package com.sample.di.demo5;

public class PointDummyDao implements PointDao {

	public void updatePoint(String id, int point) {
		// TODO Auto-generated method stub
		System.out.println("아이디 : " + id);
		System.out.println("포인트 : " + point);
		System.out.println("포인트 변경완료");
	}
}
