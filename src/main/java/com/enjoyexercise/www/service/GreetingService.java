package com.enjoyexercise.www.service;

import java.util.List;

import com.enjoyexercise.www.vo.GreetingVO;

public interface GreetingService {

	//Method

	List<GreetingVO> getGreetingList(GreetingVO vo);
	
	void insertGreeting(GreetingVO vo);
	
	void deleteGreeting(GreetingVO vo);
	
	void updateGreeting(GreetingVO vo);
	
	int getListCnt();
}
