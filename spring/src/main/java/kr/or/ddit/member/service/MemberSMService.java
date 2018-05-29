/**
 * 
 */
package kr.or.ddit.member.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.dao.MemberSMDaoInf;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.spring.aop.AnnotaionAspect;

/**
 * MemberService.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 18.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 18. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@Service("memberSMService")
public class MemberSMService implements MemberSMServiceInf {
	Logger logger = LoggerFactory.getLogger(AnnotaionAspect.class);

	@Resource(name = "memberSMDao")
	private MemberSMDaoInf memberSMDao;

	private List<MemberVO> memberList; // 저장소

	public MemberSMService() {
		logger.debug("{}", "public MemberService() : 생성자 ");
	}

	public MemberSMService(MemberSMDaoInf memberSMDao) {
		this.memberSMDao = memberSMDao;
	}

	@Override
	public List<MemberVO> getMemberList() {
		// TODO Auto-generated method stub
		return memberList = memberSMDao.getMemberList();
	}

	/**
	 * Method : insertMember 최초작성일 : 2018. 5. 29. 작성자 : "Y.S.W" 변경이력 :
	 * 
	 * @param memberVO
	 * @return Method 설명 : 회원정보 입력
	 */
	@Override
	public int insertMember(MemberVO memberVO) {
		int insertCnt = 0;

		insertCnt += memberSMDao.insertMember(memberVO);
		
		if(true) { throw new RuntimeException();}
		
		memberVO.setMem_id("brown222");
		insertCnt += memberSMDao.insertMember(memberVO);
		return insertCnt;
	}

}
