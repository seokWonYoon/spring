/**
 * 
 */
package kr.or.ddit.spring.bean;

import static org.junit.Assert.*; 

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.AssertThrows;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * BeanInjectionTest.java
 *
 * @author SEM
 * @since 2018. 5. 18.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 18. Y.S.W 최초 생성
 *
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/bean/application-context-beaninjection.xml")
public class BeanInjectionJunitRunnerTest {
	
	// <bean id>, singleton
	@Resource(name="memberDao")
	private MemberDaoInf memberDao;
	
	@Resource(name="memberDao")
	private MemberDaoInf memberDao2;
	
	//proto
	@Resource(name="memberDaoProto")
	private MemberDaoInf memberDaoProto;
	
	@Resource(name="memberDaoProto")
	private MemberDaoInf memberDaoProto2;
	
	// <bean id>
	@Resource(name="memberService")
	private MemberServiceInf memberService;
	
	@Resource(name="memberServiceSec")
	private MemberServiceInf memberServiceSec;

	@Resource(name="memberServiceSingle")
	private MemberServiceInf memberServiceSingle;
	
	
	
	
	@Before
	public void setup(){
	}
	
	@Test
	public void beanInjectionTest() {
		/***Given***/
		
		/***When***/
		List<MemberVO> memberList = memberDao.getMemberList();

		/***Then***/
		assertEquals(27, memberList.size());
	}
	
	@Test
	public void beanInjectionServiceTest() {
		/***Given***/
		
		/***When***/
		List<MemberVO> memberList= memberService.getMemberList();

		/***Then***/
		assertNotNull(memberService);
		assertEquals(27, memberList.size());
	}
	
	@Test
	public void memberServiceSecTest(){
		/***Given***/
		
		/***When***/
		List<MemberVO> memberList = memberServiceSec.getMemberList();

		/***Then***/
		assertNotNull(memberServiceSec);
		assertEquals(27, memberList.size());
	}
	
	//design pattern singleton : getInstance() --> 해당 클래스의 객체를 하나만 만드는 메소드
	//							(jvm 상에 해당 클래스의 객체는 하나)  
	//spring singleton : bean id당 하나의 객체
	//<bean id="memberService" class="kr.or.ddit.member.service.MemberService">
	//<bean id="memberServiceSec" class="kr.or.ddit.member.service.MemberService">
	
	//spirng singleton 테스트
	//spring memberDao bean을 서로다른 두개의 객체로 주입
	//memberDao, memberDao2
	//두개의 객체가 서로 같은지 확인
	@Test
	public void singletonEqualsTest() throws Exception {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertEquals(memberDao, memberDao2);
	}
	
	//spring singleton 테스트
	//memberService과 memberServiceSec 객체가 서로 다른지 테스트
	@Test
	public void singletonTest(){
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotEquals(memberService, memberServiceSec);
	}
	
	//spring prototype 테스트
	//prototype : 객체를 요청 할 때마다 새로운 객체를 반환
	//singleton 빈과 prototype 빈이 서로 달라야함
	//빈 생성 설명서에 MemberDao 객체를 prototype 속성으로 하나 추가합니다(id="memberDaoProto")
	//기존에 생성한 bean(id="memberDao", singleton)객체와 다른지 테스트
	@Test
	public void prototypeTest(){
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotEquals(memberDao, memberDaoProto);
	}
	
	//spring prototype 테스트
	//prototype memberDao bean : memberDaoProto 빈을 서로 다른 이름으로 주입 받는다.
	// memberDaoProto(기존 주입받음) / memberDaoProto2(신규 생성) 
	//주입받은 두개의 빈이 서로 다른지 테스트
	@Test
	public void prototypeEqualTest(){
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotEquals(memberDaoProto, memberDaoProto2);
	}
	
//	<!-- id = memberServiceSingle (scope:singleton)
//		 id = memberDaoProto(scope:prototype)
//			 memberServiceSingle bean에 memberDaoProto bean을 주입
//			 memberServiceSingle.getMemberDao()를 호출하여 리턴받은 memberDao객체는 
//			 prototype scope를 유지하는가?
//		 -->
	
	@Test
	public void memberServiceSingleTest() {
		/***Given***/
		

		/***When***/
		MemberDaoInf test=memberServiceSingle.getMemberDao();
		MemberDaoInf test2=memberServiceSingle.getMemberDao();
		
		/***Then***/
		
		//prototype 빈은 요청시마다 새로운 객체를 반환해야 하지만
		//singleton 빈 안에서의 prototype 빈은 정상적으로 동작하지 않는다.
		
//		assertNotEquals(test, test2); ==> 실패
		assertEquals(test, test2);
		

	}
	
	
	
}







	






