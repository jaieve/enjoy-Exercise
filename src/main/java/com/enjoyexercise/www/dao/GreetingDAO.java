package com.enjoyexercise.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.enjoyexercise.www.vo.GreetingVO;

@Repository
public class GreetingDAO extends SqlSessionDaoSupport{
	private SqlSession mybatis = null;
	
	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
		mybatis = getSqlSession();
	}

	public List<GreetingVO> getGreetingList(GreetingVO vo) {
		return mybatis.selectList("GreetingDAO.getGreetingList",vo);
	}
	
	public void insertGreeting(GreetingVO vo) {
		mybatis.insert("GreetingDAO.insertGreeting", vo);
	}
	
	public void deleteGreeting(GreetingVO vo) {
		mybatis.delete("GreetingDAO.deleteGreeting",vo);
	}
	
	public void updateGreeting(GreetingVO vo) {
		mybatis.update("GreetingDAO.updateGreeting",vo);
	}
	
	public int getListCnt() {
		return mybatis.selectOne("GreetingDAO.getListCnt");
	}
}
