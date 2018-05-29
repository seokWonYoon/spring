package kr.or.ddit.member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
/*
 * @Controller
 * @Service
 * @Repository = dao
 */
@Repository("memberSMDao")
public class MemberSMDao implements MemberSMDaoInf {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberSMDao() {
	}

	/**
	 * 
	* Method : getMemberList
	* 최초작성일 : 2018. 5. 29.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @return
	* Method 설명 :
	 */
	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO>	memberList = sqlSessionTemplate.selectList("member.getMemberList");
		return memberList;
	}

	/**
	 * 
	* Method : getMember
	* 최초작성일 : 2018. 5. 29.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param memberVO
	* @return
	* Method 설명 :
	 */
	@Override
	public MemberVO getMember(MemberVO memberVO) {
		MemberVO memberVOResult = sqlSessionTemplate.selectOne("member.getMember", memberVO);
		return memberVOResult;
	}

	/**
	* Method : insertMember
	* 최초작성일 : 2018. 5. 29.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param memberVO
	* @return
	* Method 설명 :
	*/
	@Override
	public int insertMember(MemberVO memberVO) {
		int insertCnt = sqlSessionTemplate.insert("member.insertMember", memberVO);
		return insertCnt;
	}
}
