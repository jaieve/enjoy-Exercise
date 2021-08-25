package com.enjoyexercise.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SummernoteController {
	@RequestMapping("/summernote.do")
	public String summernote() {
		return "summernote";
	}
}