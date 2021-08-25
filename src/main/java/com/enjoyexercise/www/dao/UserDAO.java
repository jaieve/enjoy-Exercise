package com.enjoyexercise.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.enjoyexercise.www.vo.UserVO;

@Repository
public class UserDAO extends SqlSessionDaoSupport {
	
	private SqlSession mybatis = null;
	
	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
		mybatis = getSqlSession();
	}
	//회원가입
	public void insertUser(UserVO vo) {
		System.out.println("mybatis/UserDAO - insertUser()");
		mybatis.update("UserDAO.insertUser", vo);
		System.out.println("기본정보 추가 완료");
	}
	
		
	//로그인
	public UserVO getUser(UserVO vo) {
		System.out.println("mybatis/UserDAO - getUser()");
		return (UserVO)mybatis.selectOne("UserDAO.getUser", vo);
	}
	
	
	//회원목록
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("mybatis/UserDAO - getUserList()");
		return mybatis.selectList("UserDAO.getUserList", vo);
	}
	
	//전체 회원수
	public int getTotalCnt(UserVO vo) {
		System.out.println("mybatis/UserDAO - getTotalCnt()");
		return mybatis.selectOne("UserDAO.getTotalCnt", vo);
	}
	//회원정보 수정
		public void updateUser(UserVO vo) {
			System.out.println("mybatis/UserDAO - updateUser()");
			mybatis.update("UserDAO.updateUser", vo);
		}
		public void updatePersonalInfo(UserVO vo) {
			System.out.println("mybatis/UserDAO - updatePersonalInfo()");
			mybatis.update("UserDAO.updatePersonalInfo", vo);
		}
	public void updatePhoto(UserVO vo) {
		System.out.println("mybatis/UserDAO - updatePhoto()");
		mybatis.update("UserDAO.updatePhoto", vo);
	}
	//탈퇴 - 회원정보 삭제
	public void deleteUser(UserVO vo) {
		System.out.println("mybatis/UserDAO - deleteUser()");
		mybatis.delete("UserDAO.deleteUser", vo);
	}
	
	public void updateBmi(UserVO vo) {
		System.out.println("mybatis/UserDAO - updateBmi()");
		mybatis.update("UserDAO.updateBmi", vo);
	}
}
	
