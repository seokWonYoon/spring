/**
 * 
 */
package kr.or.ddit.spring.view.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/**
 * JsonViewController.java
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
@RequestMapping("/json")
@Controller
public class JsonViewController {
	Logger logger = LoggerFactory.getLogger(JsonViewController.class);
	
	
	@ModelAttribute
	public void lineRangers(Model model){
		List<String> lineRangers = new ArrayList<String>();
		lineRangers.add("brown");
		lineRangers.add("cony");
		lineRangers.add("sally");
		model.addAttribute("lineRangers", lineRangers);
	}
	
	//{lineRangers : ["brown","cony","sally"]}
	//localhost:8070/spring/json/pageJsonView
	@RequestMapping("/pageJsonView")
	public String pageJsonView(){
		return "pageJsonReport";
	}
	
	//localhost:8070/spring/json/pageJsonViewObject
	@RequestMapping("/pageJsonViewObject")
	public View pageJsonViewObject(){
		return new MappingJacksonJsonView();
	}
	
	//localhost:8070/spring/json/pageJsonViewMav
	@RequestMapping("/pageJsonViewMav")
	public ModelAndView pageJsonViewMav(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pageJsonReport");
		return mav;
	}
	
	//localhost:8070/spring/json/pageJsonViewMavView
	@RequestMapping("/pageJsonViewMavView")
	public ModelAndView pageJsonViewMavView(){
		ModelAndView mav = new ModelAndView();
		mav.setView(new MappingJacksonJsonView());
		return mav;
	}
	
	// localhost:8070/spring/json/responseBody
	@RequestMapping("/responseBody")
	@ResponseBody
	public List<String> responseBody(Model model){
		logger.debug("{}", model.asMap().get("lineRangers"));
		
		return (List<String>) model.asMap().get("lineRangers");
	}
	
	// localhost:8070/spring/json/requestBody/view
	@RequestMapping("/requestBody/view")
	public String requestBodyView(){
		
		return "mvc/json/view";
	}
	
	// localhost:8070/spring/json/requestBody/sendData
	@RequestMapping("/requestBody/sendData")
	@ResponseBody
	public List<String> sendData(@RequestBody List<String> receiveList){
		receiveList.add("JESICA");
		return receiveList;
	}
	
	
}



