package com.enjoyexercise.www.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoyexercise.www.dao.GreetingDAO;
import com.enjoyexercise.www.service.GreetingService;
import com.enjoyexercise.www.vo.GreetingVO;

@Service("greetingService")
public class GreetingServiceImpl implements GreetingService{
	@Autowired
	private GreetingDAO greetingDAO;

	@Override
	public List<GreetingVO> getGreetingList(GreetingVO vo) {
		return greetingDAO.getGreetingList(vo);
	}

	@Override
	public void insertGreeting(GreetingVO vo) {
		greetingDAO.insertGreeting(vo);
	}

	@Override
	public void deleteGreeting(GreetingVO vo) {
		greetingDAO.deleteGreeting(vo);
	}

	@Override
	public void updateGreeting(GreetingVO vo) {
		greetingDAO.updateGreeting(vo);
	}

	@Override
	public int getListCnt() {
		return greetingDAO.getListCnt();
	}
	
	
}
