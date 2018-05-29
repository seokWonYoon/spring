package kr.or.ddit.mvc.validator;

import javax.validation.Valid;

import kr.or.ddit.member.model.Jsr303MemberVO;
import kr.or.ddit.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * ValidatorController.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 25.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 25. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@RequestMapping("/validator")
@Controller
public class ValidatorController {
	/**
	 * 
	 * Method : view 최초작성일 : 2018. 5. 25. 작성자 : "Y.S.W" 변경이력 :
	 * 
	 * @return Method 설명 : 값 전송 테스트 화면
	 */
	@RequestMapping("/view")
	public String view() {
		return "mvc/validator/view";
	}

	/**
	 * 
	 * Method : origin 최초작성일 : 2018. 5. 25. 작성자 : "Y.S.W" 변경이력 :
	 * 
	 * @return Method 설명 : validator 를 사용하지 않고 검증
	 */
	@RequestMapping("/origin")
	public String origin(MemberVO memberVO,
			@RequestParam("mem_id") String mem_id, Model model) {

		if ((memberVO.getMem_id() == null || memberVO.getMem_id().trim().equals(""))||
				(memberVO.getMem_pass() == null || memberVO.getMem_pass().trim().equals(""))) {
			return "mvc/validator/view";
		} else {
			return "mvc/validator/result";

		}
	}
	
	// BindingResult 객체는 검증하고자 하는 form(vo)객체 바로 뒤에 위치해야한다.
		@RequestMapping("/validator")
		public String validator(MemberVO memberVO, BindingResult result){
			new MemberVOValidator().validate(memberVO, result);
		if(result.hasErrors()){
			return "mvc/validator/view";
		} else {
			return "mvc/validator/result";
		}
	}
		
		// BindingResult 객체는 검증하고자 하는 form(vo)객체 바로 뒤에 위치해야한다.
		@RequestMapping("/jsr303validator")
		public String validator(@Valid Jsr303MemberVO jsr303memberVO, BindingResult result){
			if(result.hasErrors()){
				return "mvc/validator/view";
			} else {
				return "mvc/validator/result";
			}
		}
}
