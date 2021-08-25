package com.enjoyexercise.www.service;

import java.util.List;

import com.enjoyexercise.www.vo.UserVO;

public interface UserService {
	//Method
	void insertUser(UserVO vo);
	
	UserVO getUser(UserVO vo);
	
	List<UserVO> getUserList(UserVO vo);
	
	int getTotalCnt(UserVO vo);
	
	void updateUser(UserVO vo);
	
	void updatePhoto(UserVO vo);

	void updatePersonalInfo(UserVO vo);
	
	void deleteUser(UserVO vo);
	
	void updateBmi(UserVO vo);
}
