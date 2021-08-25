package com.enjoyexercise.www.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.enjoyexercise.www.service.UserService;
import com.enjoyexercise.www.vo.UserVO;

@Controller
@SessionAttributes("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//회원가입
	@RequestMapping(value="/insertUser.do", method=RequestMethod.POST)
	public String insertUser(UserVO vo,Model model) {
		System.out.println("UserController-insertUser()");
		
		if(vo == null) {
			return "redirect:join.jsp";
		}
		userService.insertUser(vo);
		
		return "redirect:login.jsp";
	}
	
	@RequestMapping(value="/updateUser.do", method=RequestMethod.POST)
	public String updateUser(UserVO vo, HttpSession session, Model model) {
		System.out.println("UserController-updateUser()");
		//비밀번호 확인
		UserVO originalVO = userService.getUser(vo);
		String password = vo.getPassword();
		if(!password.equals(originalVO.getPassword())) {
			System.out.println("비밀번호 틀린경우");
			String wrong = "<br>비밀번호가 틀렸습니다<br>다시 입력하세요";
			model.addAttribute("message", wrong);
			//return "updateUser.jsp"; //404
			return "mypage/updateUser.jsp"; //되긴 된다! 
			//return "redirect:updateUser.jsp"; //404
			//return "redirect:mypage/updateUser.jsp"; //페이지로 돌아오긴 하지만 String wrong을 못가지고 오네...
		}
		System.out.println("요청된 정보" + vo.toString());		
		userService.updateUser(vo);
		userService.updatePersonalInfo(vo);
		System.out.println("db에 저장된 정보" + userService.getUser(vo).toString());
		model.addAttribute("user", userService.getUser(vo));
		return "redirect:mypage/myPage.jsp";
	}
	
	@RequestMapping(value="/updatePhoto.do", method=RequestMethod.POST)
	public String updatePhoto(Model model, UserVO vo) {
		System.out.println("UserController-updatePhoto()");
		
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String filePath = "E:/bigdata210128_workspace/Spring/EnjoyExercise/src/main/webapp/images/profileImg/";
			String fileName = uploadFile.getOriginalFilename();
			System.out.println(uploadFile.getContentType());
			vo.setFilename(fileName);
			try {
				uploadFile.transferTo(new File(filePath+fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		userService.updatePhoto(vo);
		model.addAttribute("user", userService.getUser(vo));
		return "redirect:mypage/myPage.jsp";
	}
	
	@RequestMapping(value="/deleteUser.do")
	public String deleteUser(UserVO vo, HttpSession session) {
		System.out.println("UserController-deleteUser()");
		System.out.println(vo.toString());
		
		userService.deleteUser(vo);
		session.removeAttribute("user");
		return "main.jsp";
	}
	@RequestMapping(value="/updateBmi.do")
	@ResponseBody
	public String updateBmi(UserVO vo) {
		System.out.println("UserController-updateBmi()");
		
		userService.updateBmi(vo);
		
		return "Greeting.jsp";
	}
	
	@RequestMapping(value="/getUser.do")
	@ResponseBody
	public UserVO getUser(UserVO vo) {
		System.out.println("UserController-getUser()");
		
		UserVO loginuser = userService.getUser(vo);
		System.out.println(loginuser.toString());
		return loginuser;
	}
}
