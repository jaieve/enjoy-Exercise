package com.enjoyexercise.www.service;

import java.util.List;

import com.enjoyexercise.www.vo.BoardVO;
import com.enjoyexercise.www.vo.CommentVO;

public interface CommentService {
	List<CommentVO> getCommentList(BoardVO vo);
	
	List<CommentVO> getRecommentList(BoardVO vo);
	
	void insertComment(CommentVO vo);
	
	void deleteComment(CommentVO vo);
	
	void updateComment(CommentVO vo);
	
}
