package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInjectionTest {
	ApplicationContext container;
	@Before
	public void setUp() {
		// spring container(IOC 컨테이너) 생성
		container = new ClassPathXmlApplicationContext("kr/or/ddit/spring/bean/application-context-beanInjection.xml");
	}

	@Test
	public void beanInjectionDaoTest() {
		/***Given***/
		MemberDaoInf memberDao = container.getBean("memberDao",MemberDaoInf.class);
//		MemberDaoInf memberDao = (MemberDaoInf)container.getBean("memberDao"); 같은 구문이다

		/***When***/
		List<MemberVO> memberList = memberDao.getMemberList();
		
		/***Then***/
		assertEquals(27, memberList.size());

	}
	@Test
	public void beanInjectionServiceTest() {
		/***Given***/
		// container.getBean("설정파일에서 선언한 bean id")
		MemberServiceInf memberService = container.getBean("memberService", MemberServiceInf.class);
		
		/***When***/
//		List<MemberVO> memberList = memberService.getMemberList();
		
		/***Then***/
		assertNotNull(memberService);
		
	}


}
