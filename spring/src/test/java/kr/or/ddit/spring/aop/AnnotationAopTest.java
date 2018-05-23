/**
 * 
 */
package kr.or.ddit.spring.aop;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceInf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AnnotationAopTest.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 23.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 23. "Y.S.W" 최초 생성
 *
 * </pre>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/aop/application-context-annoaop.xml")
public class AnnotationAopTest {
	
	@Resource(name="memberService")
	private MemberServiceInf memberService;
	
	
	@Resource(name="memberDao")
	private MemberDaoInf memberDao;
	
	

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
