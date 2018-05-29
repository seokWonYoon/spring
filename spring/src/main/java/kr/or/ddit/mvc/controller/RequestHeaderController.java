/**
 * 
 */
package kr.or.ddit.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RequestHeaderController.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 25.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 25. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@RequestMapping("/requestHeader")
@Controller
public class RequestHeaderController {
	
	/**
	 * 
	* Method : view
	* 최초작성일 : 2018. 5. 25.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @return
	* Method 설명 :
	 */
	@RequestMapping("/view")
	public String view(@RequestHeader(value="user-agent", required=false) String user_agent, Model model){
		model.addAttribute("user_agent", user_agent);
		return "mvc/requestHeader/view";
	}
}
