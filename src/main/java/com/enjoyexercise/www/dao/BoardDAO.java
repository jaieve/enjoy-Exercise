package com.enjoyexercise.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.enjoyexercise.www.vo.BoardVO;
import com.enjoyexercise.www.vo.UserVO;

@Repository
public class BoardDAO extends SqlSessionDaoSupport{
	private SqlSession mybatis = null;
	
	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
		mybatis = getSqlSession();
	}
	
	public List<BoardVO> getNoticeList(BoardVO notice) {
		System.out.println("mybatis/BoardDAO-getNoticeList()");
		return mybatis.selectList("BoardDAO.getNoticeList", notice);
	}
	
	public List<BoardVO> getInfoList(BoardVO info) {
		System.out.println("mybatis/BoardDAO-getNoticeList()");
		return mybatis.selectList("BoardDAO.getInfoList", info);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("mybatis/BoardDAO-getBoard()");
		return mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	
	public int getBoardCnt(BoardVO vo) {
		System.out.println("mybatis/BoardDAO-getBoardCnt()");
		return mybatis.selectOne("BoardDAO.getBoardCnt",vo);
	}
	
	public void updateBoardCnt(BoardVO vo) {
		System.out.println("mybatis/BoardDAO-updateBoardCnt()");
		mybatis.update("BoardDAO.updateBoardCnt", vo);
	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("mybatis/BoardDAO-insertBoard()");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("mybatis/BoardDAO-updateBoard()");
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	public void updateBoardFile(BoardVO vo) {
		System.out.println("mybatis/BoardDAO-updateBoard()");
		mybatis.update("BoardDAO.updateBoardFile", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("mybatis/BoardDAO-deleteBoard()");
		mybatis.update("BoardDAO.deleteBoard", vo);
	}
}
