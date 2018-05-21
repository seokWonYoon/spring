/**
 * 
 */
package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.member.controller.MemberController;
import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.service.MemberServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AnnotationScanTest.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 21.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 21. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/bean/application-context-annobean.xml")
public class AnnotationScanTest {
	@Resource(name="memberDao")
	MemberDaoInf memberDao;
	
	@Resource(name="memberService")
	MemberServiceInf memberService;
	
	@Resource(name="memberController")
	MemberController memberController;
	
	

	/**
	 * Method : setUp
	 * 최초작성일 : 2018. 5. 21.
	 * 작성자 : "Y.S.W"
	 * 변경이력 :
	 * @throws java.lang.Exception
	 * Method 설명 :
	 */
	@Before
	public void setUp(){
	}

	//@Repository 어노테이션을 적용한 빈을 주입받아 정상적으로 생성되었는지 테스트(not null)
	@Test
	public void repositoryAnnotationBeanTest() {
		assertNotNull(memberDao);
	}
	
	
	//@Service 어노테이션을 적용한 빈을 주입받아 정상적으로 생성되었는지 테스트(not null)
	//memberService 객체가 정상적으로 생성되었는지
	//memberService.getMemberDao()를 통햇 memberDao가 정상적으로 주입되었는지.
	
	@Test
	public void serviceAnnotationBeanTest() {
		assertNotNull(memberService);
		assertEquals(memberDao,memberService.getMemberDao());
		
	}
	
	@Test
	public void memberControllerTest() {
		assertNotNull(memberController);
		assertEquals(memberService,memberController.getMemberServiceInf());
		
	}
	
	

}
