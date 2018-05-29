/**
 * 
 */
package kr.or.ddit.spring.mvc.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;

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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:kr/or/ddit/spring/servlet-context.xml",
		"classpath:kr/or/ddit/spring/application-context.xml" })
@WebAppConfiguration
public class RequestParamControllerTest {
	Logger logger = LoggerFactory.getLogger(ModelAttributeControllerTest.class);

	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	// localhost:8070/spring/requestParam/view?member_id=brown&mem_alias=sally
	// requestParamControllerTest 코드 작성
	// 1. view 이름이 정상적으로 설정 되었는지
	// 2. model 객체에 memberVO 속성이 존재하는지 테스트
	// **** controller method는 아래에서 수정하지 않음
	@Test
	public void requestHeaderTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("/requestParam/view").param("mem_id", "brown").param("mem_alias", "sally")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		MemberVO memberVOResult = (MemberVO) mav.getModel().get("memberVO");
		
		/***Then***/
		assertEquals("mvc/requestParam/view", mav.getViewName());
		assertNotNull(memberVOResult);
		
		assertEquals(memberVOResult.getMem_id(), mav.getModel().get("mem_id"));
		
		assertEquals("brown", memberVOResult.getMem_id());
		assertEquals("sally", memberVOResult.getMem_alias());
		assertEquals(null, memberVOResult.getMem_name());
	}

}
