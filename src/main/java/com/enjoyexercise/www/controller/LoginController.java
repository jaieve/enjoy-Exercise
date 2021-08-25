package com.enjoyexercise.www.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.enjoyexercise.www.service.UserService;
import com.enjoyexercise.www.vo.UserVO;


@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	private UserService userService; // Service 추가

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession httpSession) {
		System.out.println("LoginController - login()");
		
		if(vo.getId() == null || vo.getId().equals("")) {
	        throw new IllegalArgumentException("login() - id not found");
	    }
		UserVO user = userService.getUser(vo);
		if(user == null) {
			return "login.jsp";
		} 
		//회원이 맞으면 개인정보도 db에서 가졍오기 personalInfoService
		
		httpSession.setAttribute("user", user);
		return "redirect:main.jsp";
	}

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView() {
		System.out.println("LoginController - loginView()");

		return "login.jsp";

	}
}