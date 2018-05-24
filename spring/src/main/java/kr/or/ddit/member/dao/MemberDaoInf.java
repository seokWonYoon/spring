package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.model.MemberVO;

public interface MemberDaoInf {
/**
 * 
* Method : getMemberList
* 최초작성일 : 2018. 5. 18.
* 작성자 : "Y.S.W"
* 변경이력 :
* @return
* Method 설명 : 회원리스트 조회
 */
	List<MemberVO> getMemberList();

	MemberVO getMember(MemberVO memberVO);

}
