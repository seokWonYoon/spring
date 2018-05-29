/**
 * 
 */
package kr.or.ddit.spring.mvc.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 * RequestHeaderControllerTest.java
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:kr/or/ddit/spring/servlet-context.xml",
		"classpath:kr/or/ddit/spring/application-context.xml" })
@WebAppConfiguration
public class RequestHeaderControllerTest {
	Logger logger = LoggerFactory.getLogger(ModelAttributeControllerTest.class);

	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	/**
	 * Method : setUp
	 * 최초작성일 : 2018. 5. 25.
	 * 작성자 : "Y.S.W"
	 * 변경이력 :
	 * @throws java.lang.Exception
	 * Method 설명 :
	 */
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void requestHeaderTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("/requestHeader/view")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
//		String user_agent = (String) mav.getModelMap().get("user_agent");
		
		/***Then***/
//		assertNotNull(user_agent);
		assertEquals("mvc/requestHeader/view", mav.getViewName());

	}

}
