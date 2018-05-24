/**
 * 
 */
package kr.or.ddit.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PathVariableController.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 24.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 24. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@RequestMapping("/pathVariable")
@Controller
public class PathVariableController {
	
	/**
	 * 
	* Method : pathVariable
	* 최초작성일 : 2018. 5. 24.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param userId
	* @param model
	* @return
	* Method 설명 : pathVariable test
	 */
	@RequestMapping("/path/{userId}")
	public String pathVariable(@PathVariable("userId")String userId, Model model) {
		model.addAttribute("userId", userId);
		return "mvc/pathVariable/pathVariable";
	}
}
