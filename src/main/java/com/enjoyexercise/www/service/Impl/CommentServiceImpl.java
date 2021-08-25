package com.enjoyexercise.www.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoyexercise.www.dao.CommentDAO;
import com.enjoyexercise.www.service.CommentService;
import com.enjoyexercise.www.vo.BoardVO;
import com.enjoyexercise.www.vo.CommentVO;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDAO commentDAO;

	@Override
	public List<CommentVO> getCommentList(BoardVO vo) {
		return commentDAO.getCommentList(vo);
	}
	@Override
	public List<CommentVO> getRecommentList(BoardVO vo) {
		return commentDAO.getRecommentList(vo);
	}
	@Override
	public void insertComment(CommentVO vo) {
		commentDAO.insertComment(vo);
	}
	@Override
	public void deleteComment(CommentVO vo) {
		commentDAO.deleteComment(vo);
	}
	@Override
	public void updateComment(CommentVO vo) {
		commentDAO.updateComment(vo);
	}


}
