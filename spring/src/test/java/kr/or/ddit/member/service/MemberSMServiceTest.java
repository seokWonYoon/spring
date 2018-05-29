/**
 * 
 */
package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.spring.test.TestInit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * MemberSMServiceTest.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 29.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 29. "Y.S.W" 최초 생성
 *
 * </pre>
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//		"classpath:kr/or/ddit/spring/application-context.xml",
//		"classpath:kr/or/ddit/spring/context-datasource.xml",
//		"classpath:kr/or/ddit/spring/context-transaction.xml" })
public class MemberSMServiceTest extends TestInit {
	
	@Resource(name="memberSMService")
	private MemberSMServiceInf memberSMService;
	
	/**
	 * Method : setUp
	 * 최초작성일 : 2018. 5. 29.
	 * 작성자 : "Y.S.W"
	 * 변경이력 :
	 * @throws java.lang.Exception
	 * Method 설명 :
	 */

	@Test
	public void insertMemberTest() {
		/***Given***/
		 MemberVO memberVO = new MemberVO("brown","1234","브라운","대전 중구 중앙로 76","영민빌딩","34940","곰");

		/***When***/
		 int insertCnt = memberSMService.insertMember(memberVO);
		 
		/***Then***/
		  assertEquals(2, insertCnt);
	}

}
