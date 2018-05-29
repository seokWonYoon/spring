/**
 * 
 */
package kr.or.ddit.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ExceptionController.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 28.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 28. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@Controller
public class ExceptionController {
	@RequestMapping("/exception/view")
	public void view(){
		throw new ArithmeticException();
	}
	
	@ExceptionHandler({ArithmeticException.class})
	public String exceptionHandler(){
		return "exception/arithmeticException";
	}
}
