package kr.or.ddit.spring.aop;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceInf;
import kr.or.ddit.spring.bean.user.dao.UserDaoInf;
import kr.or.ddit.spring.bean.user.service.UserServiceInf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopJavaConfig.class)
public class AopJavaConfigTest {
	
	@Resource(name="memberService")
	private MemberServiceInf memberService;
	
	
	@Resource(name="memberDao")
	private MemberDaoInf memberDao;
	
	
	@Resource(name="userDao")
	private UserDaoInf userDao;
	
	
	@Resource(name="userService")
	private UserServiceInf userService;
	
	
	
	@Test
	public void userDaoBeanCreateTest(){
		/***Given***/
		

		/***When***/
		List<MemberVO> memberList = userDao.getMemberList();
		
		/***Then***/
		assertNotNull(userDao);
		assertEquals(27, memberList.size());
	}
	
	
	@Test
	public void userServiceBeanCreateTest(){
		/***Given***/
		
		
		/***When***/
		List<MemberVO> memberList = userService.getUserList();
		
		/***Then***/
		assertNotNull(userDao);
		assertEquals(27, memberList.size());
	}
	
	

	/**
	 * 
	* Method : annotationAopTest
	* 최초작성일 : 2018. 5. 23.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* Method 설명 :annotation방식의 aop 테스트
	 */
	@Test
	public void annotationAopTest() {
		/***Given***/
		List<MemberVO> memberList = null;

		/***When***/
		memberList = memberService.getMemberList();

		
		/***Then***/
		assertNotNull(memberDao);
		assertNotNull(memberService);
		assertEquals(memberDao, memberService.getMemberDao());
		assertEquals(27, memberList.size());
	}
}
