package kr.or.ddit.mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.spring.mvc.controller.ModelAttributeControllerTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

//@SessionAttributes("")
@RequestMapping("/modelAttribute")
@Controller
public class ModelAttributeController {
	
	Logger logger = LoggerFactory.getLogger(ModelAttributeController.class);
	/*
	 * modelAttribute - method 적용시
	 * 해당 컨트롤러의 requestMapping이 적용된 method 실행전 model 객체에 method의 리턴값을 설정
	 * 단, modelAttribute annotation이 적용된 메소드에는 requestMapping 을 설정하지 않음
	 */
	@ModelAttribute("boardList")
	public List<String> getBoardList(){
		
		logger.debug("{}","getBoardList()");
		List<String> boardList = new ArrayList<String>();
		
		boardList.add("공지사항");
		boardList.add("자유게시판");
		boardList.add("Q&A");
		boardList.add("F&Q");
		return boardList;
	}
	
	@RequestMapping(value="/methodA")
	public String methodA(){
		return "mvc/modelAttribute/methodA";
	}
	
//	@RequestMapping(value = "/methodA", method = RequestMethod.POST)
//	public String methodA(HttpSession session) {
//		List<String> boardList = getBoardList();
//		session.setAttribute("boardList", boardList);
//		return "mvc/model/attribute/methodA";
//		
//	}
	
	
	@RequestMapping(value="/methodB")
	public String methodB(){
		return "methodB";
	}
	
	@RequestMapping(value="/methodC")
	public String methodC(){
		return "methodC";
	}
	
}
