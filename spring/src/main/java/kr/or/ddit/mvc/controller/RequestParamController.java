/**
 * 
 */
package kr.or.ddit.mvc.controller;

import kr.or.ddit.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/requestParam")
@Controller
public class RequestParamController {
	
	// localhost:8070/spring/requestParam/view?member_id=brown&mem_alias=
	// requestParamControllerTest 코드 작성
	// 1. view 이름이 정상적으로ㅓ 설정 되었는지
	// 2. model 객체에 memberVO 속성이 존재하는지 테스트
	// **** controller method는 아래에서 수정하지 않음
	@RequestMapping("/view")
	public String view(MemberVO memberVO, Model model){
//		public String view(MemberVO memberVO, @RequestParam("mem_id")String mem_id, Model model){
		model.addAttribute("memberVO", memberVO);
//		model.addAttribute("mem_id", mem_id);
		return "mvc/requestParam/view";
	}
}
