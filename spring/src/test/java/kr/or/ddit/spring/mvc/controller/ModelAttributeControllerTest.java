/**
 * 
 */
package kr.or.ddit.spring.mvc.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

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
 * ModelAttributeControllerTest.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 24.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 24. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:kr/or/ddit/spring/servlet-context.xml",
		"classpath:kr/or/ddit/spring/application-context.xml" })
@WebAppConfiguration
public class ModelAttributeControllerTest {
	Logger logger = LoggerFactory.getLogger(ModelAttributeControllerTest.class);

	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	/**
	 * Method : setUp 최초작성일 : 2018. 5. 24. 작성자 : "Y.S.W" 변경이력 :
	 * 
	 * @throws java.lang.Exception
	 *             Method 설명 :
	 */
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	/**
	 * 
	 * Method : methodAModleAttributeTest 최초작성일 : 2018. 5. 24. 작성자 : "Y.S.W"
	 * 변경이력 : Method 설명 : methodA 실행시 modelAttribute 설정 속성 확인 테스트
	 * 
	 * @throws Exception
	 */
	@Test
	public void methodAModleAttributeTest() throws Exception {
		/*** Given ***/
		MvcResult result = mockMvc.perform(get("/modelAttribute/methodA")).andReturn();

		/*** When ***/
		ModelAndView mav = result.getModelAndView();
		List<String> boardList = (List<String>) mav.getModel().get("boardList");

		/*** Then ***/
		assertEquals(4, boardList.size());
		assertEquals("공지사항", boardList.get(0));
		assertEquals("자유게시판", boardList.get(1));
		assertEquals("Q&A", boardList.get(2));
		assertEquals("F&Q", boardList.get(3));
	}
	
	@Test
	public void methodBModleAttributeTest() throws Exception {
		/*** Given ***/
		MvcResult result = mockMvc.perform(get("/modelAttribute/methodB"))
				.andReturn();
		
		/*** When ***/
		ModelAndView mav = result.getModelAndView();
		List<String> boardList = (List<String>) mav.getModel().get("boardList");
		
		/*** Then ***/
		assertEquals(4, boardList.size());
		assertEquals("공지사항", boardList.get(0));
		assertEquals("자유게시판", boardList.get(1));
		assertEquals("Q&A", boardList.get(2));
		assertEquals("F&Q", boardList.get(3));
	}
	@Test
	public void methodCModleAttributeTest() throws Exception {
		/*** Given ***/
		MvcResult result = mockMvc.perform(get("/modelAttribute/methodC"))
				.andReturn();
		
		/*** When ***/
		ModelAndView mav = result.getModelAndView();
		List<String> boardList = (List<String>) mav.getModel().get("boardList");
		
		/*** Then ***/
		assertEquals(4, boardList.size());
		assertEquals("공지사항", boardList.get(0));
		assertEquals("자유게시판", boardList.get(1));
		assertEquals("Q&A", boardList.get(2));
		assertEquals("F&Q", boardList.get(3));
	}

}
