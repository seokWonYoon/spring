/**
 * 
 */
package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;

/**
 * MemberService.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 18.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 18. "Y.S.W" 최초 생성
 *
 * </pre>
 */
public interface MemberServiceInf {
	/**
	 * 
	* Method : getMemberList
	* 최초작성일 : 2018. 5. 18.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @return
	* Method 설명 :회원리스트 조회
	 */
	List<MemberVO> getMemberList();
	MemberDaoInf getMemberDao();

}
