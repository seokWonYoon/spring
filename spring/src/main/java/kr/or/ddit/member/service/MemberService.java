/**
 * 
 */
package kr.or.ddit.member.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
@Service("memberService")
public class MemberService implements MemberServiceInf {
	@Resource(name="memberDao")
	private MemberDaoInf memberDao;
	
	private List<MemberVO> memberList; //저장소
//	private MemberServiceInf memberService;
	
	public MemberService() {
	}

	public void setMemberDao(MemberDaoInf memberDao) {
		this.memberDao = memberDao;
	}

	public MemberService(MemberDaoInf memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public List<MemberVO> getMemberList() {
		// TODO Auto-generated method stub
		return memberList = memberDao.getMemberList();
	}
	
	
	
	public MemberDaoInf getMemberDao() {
		return memberDao;
	}





}
