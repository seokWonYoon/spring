package kr.or.ddit.login.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; 

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.member.model.MemberVO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/spring/servlet-context.xml",
							 "classpath:kr/or/ddit/spring/application-context.xml"})
@WebAppConfiguration
public class LoginControllerTest {

	@Resource // @Autowired
	private WebApplicationContext ctx; // spring container
	private MockMvc mockMvc;
	
	@Resource(name="loginController")
	private LoginController loginController;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	/**
	 * 
	* Method : loginTest
	* 최초작성일 : 2018. 5. 24.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 로그인 폼 요청 테스트
	 */
	@Test
	public void loginTest() throws Exception{
		/***Given***/
		
		// localhost:8070/spring/login
		MvcResult result = mockMvc.perform(get("/login")).andReturn();
		
		/***When***/
		ModelAndView mav = result.getModelAndView();
		/***Then***/
		assertEquals("login/login", mav.getViewName());
	}
	
	/**
	 * 
	* Method : loginProcessTest
	* 최초작성일 : 2018. 5. 24.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 로그인 처리 테스트
	 */
	@Test
	public void loginProcessTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(post("/login").param("mem_id", "sally").param("mem_pass", "1234")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		MockHttpServletRequest request = result.getRequest();
		HttpSession session = request.getSession();
		
		Map<String, Object> model = mav.getModel();
		
		@SuppressWarnings("unchecked")
		List<BoardVO> boardList = (List<BoardVO>) model.get("boardList");
		
		MemberVO login_user = (MemberVO)session.getAttribute("LOGIN_USER");
		
		/***Then***/
		assertEquals(5, boardList.size());
		assertEquals("main/main", mav.getViewName());
		assertEquals("sally", login_user.getMem_id());
		assertEquals("44888", login_user.getMem_name());
		assertEquals("병아리", login_user.getMem_alias());
	}
}
