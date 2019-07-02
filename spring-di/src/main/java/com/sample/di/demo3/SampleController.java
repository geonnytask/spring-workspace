package com.sample.di.demo3;

public class SampleController {

	private SampleDao sampleDao;
	
	public void setSampleDao(SampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}
	
	public void add(String id, String password) {
		// 등록작업 처리
		// SampleDao의 insert기능 사용한다.
		
	}
}

