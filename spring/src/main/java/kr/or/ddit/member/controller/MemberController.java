/**
 * 
 */
package kr.or.ddit.member.controller;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * MemberController.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 21.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 21. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@RequestMapping("/member")
@Controller("memberController")
public class MemberController {
	Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="memberService")
	private MemberServiceInf memberService;
	
	
	// controller의 return type은 
	// 1. ModelAndView객체
	// 2. String 객체 : view 이름
	
//	/WEB-INF/views/member/memberList.jsp
	// localhost:8070/spring/member/list url에 대해 처리하는 controller method
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String memberList(Model model){
		logger.debug("{}","memberList()");
		
		//1. service에서 데이터 조회
		List<MemberVO> memberList = memberService.getMemberList();
		
		//2.request.setAttribute(이름,값)
		model.addAttribute("memberList", memberList);
		
		//3 view 전달 : request.getParameter
		return "member/memberList";
	}
	
	//사용자 상세정보 조회
	// localhost:8070/spring/member/detail url에 대해 처리하는 controller method
	@RequestMapping("/detail")
	public ModelAndView memberDetail(){
		return null;
		
	}
	
	
	//사용자 등록화면(form)
	// get - 사용자 등록화면 전달
	// post - 사용자 등록을 처리
	// localhost:8070/spring/member/form url에 대해 처리하는 controller method
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelAndView memberForm(){
		return null;
		
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public ModelAndView memberForm(MemberVO memverVO){
		return null;
		
	}
	
	
	
	// Controller : xxx를 속성으로 갖고있음
	// service :  dao 속성으로 갖고있음
	// dao : 빈으로 주입받을 만한 것이 없음(현재기준)
	public MemberServiceInf getMemberServiceInf() {
		return memberService;
	}

}
