package com.enjoyexercise.www.controller;

import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.enjoyexercise.www.service.GreetingService;
import com.enjoyexercise.www.vo.GreetingVO;
import com.enjoyexercise.www.vo.PagingVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@SessionAttributes("greeting")
public class GreetingController {
	@Autowired
	private GreetingService greetingService;

	@RequestMapping(value="/getGreetingList.do", method=RequestMethod.POST)
	@ResponseBody
	public Object getGreetingListMain(GreetingVO vo,Model model
			,@RequestParam(defaultValue="1") int curPage,
			@RequestParam(defaultValue="1") int range) {
		System.out.println("GreetingController-getGreetingListMain()");

		System.out.println("curPage =>>>>>" + curPage);
		System.out.println("Ragne(구간) =>>>>>" + range);

		int listCnt = greetingService.getListCnt();
		PagingVO paging = new PagingVO();
		paging.setListSize(10);
		paging.pageInfo(curPage, range, listCnt);
		vo.setStartList(paging.getStartList());
		vo.setEndList(paging.getEndList());
		//System.out.println(paging);

		Map<String,Object> greetingMap = new HashMap<String, Object>();

		List<GreetingVO> greetingList = greetingService.getGreetingList(vo);
		greetingMap.put("greetingList", greetingList);
		greetingMap.put("paging", paging);

		return greetingMap;
	}

	@RequestMapping(value="/getGreetingList.do", method=RequestMethod.GET)
	public String getGreetingListGet(GreetingVO vo,Model model,
			@RequestParam(defaultValue="1") int curPage
			,@RequestParam(defaultValue="1") int range) {
		System.out.println("GreetingController-getGreetingListGet()");
		System.out.println("curPage =>>>>>" + curPage);
		System.out.println("Ragne(구간) =>>>>>" + range);
		int listCnt = greetingService.getListCnt();
		PagingVO paging = new PagingVO();
		paging.setListSize(10);
		paging.pageInfo(curPage, range, listCnt);
		vo.setStartList(paging.getStartList());
		vo.setEndList(paging.getEndList());
		
		Map<String,Object> greetingMap = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String greetingList = mapper.writeValueAsString(greetingService.getGreetingList(vo));
			String pagingStr = mapper.writeValueAsString(paging);
			greetingMap.put("greetingList", greetingList);
			greetingMap.put("paging", pagingStr);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		model.addAttribute("greetingMap",greetingMap);
		return "Greeting.jsp";
	}

	//controller에서 ajax로 값 받기 검색해서 완성하기
	//	@RequestMapping(value="/getGreetingListJson.do")
	//	@ResponseBody	
	//	public String getGreetingListJson(GreetingVO vo, HttpServletRequest request, HttpServletResponse response) {
	//		System.out.println("GreetingController - gerGreetingListJson()");
	//		List<GreetingVO> greetingList = greetingService.getGreetingList(vo);
	//		
	//		PrintWriter out = response.getWriter();
	//		
	//		
	//		
	//		Map<String, List<GreetingVO>> map = new HashMap<String,List<GreetingVO>>();
	//		map.put("greetingList", greetingService.getGreetingList(vo));
	//		
	////		List<GreetingVO> greetingList = greetingService.getGreetingList(vo);
	////		GreetingVO test = greetingList.get(0);
	//		
	//		return null;
	//	}
	//	

	@RequestMapping(value="/insertGreeting.do")
	@ResponseBody
	public String insertGreeting(GreetingVO vo,Model model) {
		System.out.println("GreetingController-insertGreeting()");
		//test
		System.out.println(vo.toString());
		greetingService.insertGreeting(vo);

		return "Greeting.jsp";
	}

	@RequestMapping(value="/deleteGreeting.do")
	@ResponseBody
	public String deleteGreeting(GreetingVO vo,Model model) {
		System.out.println("GreetingController-deleteGreeting()");
		//test
		//HashMap<String, String> map = new HashMap<String, String>();
		//map.put("greeting_id", vo.getGreeting_id());
		greetingService.deleteGreeting(vo);
		model.addAttribute("greeting", new GreetingVO());
		return "Greeting.jsp";
	}

	@RequestMapping(value="/updateGreeting.do")
	@ResponseBody
	public String updateGreeting(GreetingVO vo, Model model) {
		System.out.println("GreetingController-updateGreeting()");

		greetingService.updateGreeting(vo);

		return "Greeting.jsp";
	}
}
