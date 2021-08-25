package com.enjoyexercise.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.enjoyexercise.www.vo.BoardVO;
import com.enjoyexercise.www.vo.CommentVO;

@Repository
public class CommentDAO extends SqlSessionDaoSupport{
	private SqlSession mybatis = null;
	
	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
		mybatis = getSqlSession();
	}
	
	//게시글의 댓글들 가져오기 : 게시글의 id로 가져와야해서 변수는 BoardVO)
	public List<CommentVO> getCommentList(BoardVO vo) {
		System.out.println("mybatis/CommentDAO-getCommentList()");
		return mybatis.selectList("CommentDAO.getCommentList", vo);
	}
	
	public List<CommentVO> getRecommentList(BoardVO vo) {
		System.out.println("mybatis/CommentDAO-getRecommentList()");
		return mybatis.selectList("CommentDAO.getRecommentList", vo);
	}
	
	public void insertComment(CommentVO vo) {
		System.out.println("mybatis/CommentDAO-insertComment()");
		mybatis.insert("CommentDAO.insertComment",vo);
	}
	
	public void deleteComment(CommentVO vo) {
		System.out.println("mybatis/CommentDAO-deleteComment()");
		mybatis.delete("CommentDAO.deleteComment", vo);
	}
	public void updateComment(CommentVO vo) {
		System.out.println("mybatis/CommentDAO-updateComment()");
		mybatis.update("CommentDAO.updateComment", vo);
	}
}
