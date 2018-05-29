/**
 * 
 */
package kr.or.ddit.login.service;

import static org.junit.Assert.*;

import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * LoginServiceTest.java
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/spring/servlet-context.xml",
"classpath:kr/or/ddit/spring/application-context.xml"})
public class LoginServiceTest {
	@Resource(name="loginService")
	LoginServiceInf loginService;
	
	

	/**
	 * Method : setUp
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "Y.S.W"
	 * 변경이력 :
	 * @throws java.lang.Exception
	 * Method 설명 : 로그인 성공 테스트
	 */
	@Test
	public void loginServiceSuccessTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_id("sally");
		memberVO.setMem_pass("1234");

		/***When***/
		
		Map<String, Object> resultMap = loginService.loginProcess(memberVO);
		boolean loginPassed = (boolean) resultMap.get("loginPassed");
		MemberVO resultVO = (MemberVO) resultMap.get("resultVO");
		
		
		/***Then***/
		assertEquals(true, loginPassed);
		assertEquals("sally", resultVO.getMem_id());
		assertEquals("1234", resultVO.getMem_pass());

	}

	@Test
	public void loginServiceFailTest() {
		/***Given***/
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_id("sally2134");
		memberVO.setMem_pass("4321");
		
		/***When***/
		
		Map<String, Object> resultMap = loginService.loginProcess(memberVO);
		boolean loginPassed = (boolean) resultMap.get("loginPassed");
		MemberVO resultVO = (MemberVO) resultMap.get("resultVO");
		
		
		/***Then***/
		assertEquals(false, loginPassed);
		assertNull(resultVO);
		
	}
	
}
