package com.enjoyexercise.www.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoyexercise.www.dao.UserDAO;
import com.enjoyexercise.www.service.UserService;
import com.enjoyexercise.www.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		return userDAO.getUserList(vo);
	}

	@Override
	public int getTotalCnt(UserVO vo) {
		return userDAO.getTotalCnt(vo);
	}

	@Override
	public void deleteUser(UserVO vo) {
		userDAO.deleteUser(vo);
	}

	
	@Override
	public void updateUser(UserVO vo) {
		userDAO.updateUser(vo);
	}
	
	@Override
	public void updatePhoto(UserVO vo) {
		userDAO.updatePhoto(vo);
	}

	@Override
	public void updatePersonalInfo(UserVO vo) {
		userDAO.updatePersonalInfo(vo);
	}

	@Override
	public void updateBmi(UserVO vo) {
		userDAO.updateBmi(vo);
	}
}
