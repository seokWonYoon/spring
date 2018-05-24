/**
 * 
 */
package kr.or.ddit.member.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * MemberVOTest.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 24.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 24. "Y.S.W" 최초 생성
 *
 * </pre>
 */

public class MemberVOTest {

	/**
	 * Method : setUp 최초작성일 : 2018. 5. 24. 작성자 : "Y.S.W" 변경이력 :
	 * 
	 * @throws java.lang.Exception
	 *             Method 설명 :
	 */

	@Test
	public void passwordVerifyTest() {
		/***Given***/
		// 사용자가 입력한 값을 가지고 있는 vo (mem_id, mem_pass)
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_id("sally");
		memberVO.setMem_pass("1234");
		
		//memberDao에 의해 조회된 결과 vo
		MemberVO resultVO = new MemberVO();
		resultVO.setMem_id("sally");
		resultVO.setMem_pass("1234");

		/***When***/
		boolean loginPassed = resultVO.passwordVerify(memberVO);
		
		/***Then***/
		assertEquals(true, loginPassed);
	}

}
