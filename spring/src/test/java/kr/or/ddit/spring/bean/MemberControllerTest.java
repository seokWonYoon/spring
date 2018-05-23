package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; 

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.controller.MemberController;
import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/spring/servlet-context.xml",
							 "classpath:kr/or/ddit/spring/application-context.xml"})
@WebAppConfiguration // applicationcontext를 webapplicationcontext 웹기반으로 만들어준다
public class MemberControllerTest {

	@Resource // @Autowired
	private WebApplicationContext ctx; // spring container
	private MockMvc mockMvc;
	
	@Resource(name="memberController")
	private MemberController memberController;
	
	/**
	 * 
	* Method : test
	* 최초작성일 : 2018. 5. 23.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* Method 설명 : memberController bean 생성 테스트
	 */
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	@Test
	public void createTest() {
		/***Given***/
		

		/***When***/
		
		
		/***Then***/
		assertNotNull(memberController);
	}
	
	@Test
	public void WebApplicationContextTest() {
		/***Given***/
		

		/***When***/
		MemberDaoInf memberDao =ctx.getBean("memberDao", MemberDaoInf.class);
		List<MemberVO> memberList = memberDao.getMemberList();
		
		/***Then***/
		assertNotNull(memberDao);
		assertEquals(27, memberList.size());

	}
	
	/**
	 * 
	* Method : memberListTest
	* 최초작성일 : 2018. 5. 23.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* Method 설명 :
	 */
	@Test
	public void memberListTest(){
		/***Given***/
		MvcResult result = mockMvc.perform(get("/member/list")); 

		/***When***/
		
		
		/***Then***/

	}
}
