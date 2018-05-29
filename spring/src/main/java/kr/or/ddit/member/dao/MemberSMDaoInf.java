/**
 * 
 */
package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.model.MemberVO;

/**
 * MemberSMDaoInf.java
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
public interface MemberSMDaoInf {
	List<MemberVO> getMemberList();

	MemberVO getMember(MemberVO memberVO);

	/**
	* Method : insertMember
	* 최초작성일 : 2018. 5. 29.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param memberVO
	* @return
	* Method 설명 :
	*/
	int insertMember(MemberVO memberVO);

}
