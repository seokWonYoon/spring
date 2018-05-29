/**
 * 
 */
package kr.or.ddit.spring.global;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * GlobalController.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 29.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 29. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@Controller
@RequestMapping("/global")
public class GlobalController {
	Logger logger = LoggerFactory.getLogger(GlobalController.class);
	
	@ModelAttribute
	public void languageMap(Model model){
		Map<String, String> languageMap = new HashMap<String, String>();
		languageMap.put("en", "english");
		languageMap.put("ja", "japan");
		languageMap.put("ko", "korean");
		model.addAttribute("languageMap", languageMap);
	}
	
	// modelattribute를 사용하여 보는 RequestMapping을 적용한 메소드가 실행될때마다 Map<String, String> languageMap = new HashMap<String, String>();
	// languageMap key : 언어코드(ex : en ja ko) / value : 표시명칭(ex. english, japan, korean)
	
	// localhost:8070/spring/global/view
	@RequestMapping("/view")
	public String view(@RequestParam(value="language", required=false) String language, Model model){
		logger.debug("{}, {}", "view()" ,language);
		
		language = language==null?"ko":language;
		model.addAttribute("language", language);
		return "global/view";
	}
	
}
