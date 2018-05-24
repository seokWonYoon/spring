/**
 * 
 */
package kr.or.ddit.login.service;

import java.util.Map;

import kr.or.ddit.member.model.MemberVO;

/**
 * LoginServiceInf.java
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
public interface LoginServiceInf {

	Map<String, Object> loginProcess(MemberVO memberVO);
	
}
