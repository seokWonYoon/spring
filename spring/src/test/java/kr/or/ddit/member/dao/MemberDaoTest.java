package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/spring/servlet-context.xml",
							 "classpath:kr/or/ddit/spring/application-context.xml"})
public class MemberDaoTest {

	@Resource(name="memberDao")
	MemberDaoInf memberDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void memberDaoBeanCreateTest() {
		/***Given***/

		/***When***/
		
		/***Then***/
		assertNotNull(memberDao);

	}
	
	/**
	 * 
	* Method : getMemberListTest
	* 최초작성일 : 2018. 5. 24.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* Method 설명 : 회원 전체 정보 조회 테스트
	 */
	@Test
	public void getMemberListTest() {
		/***Given***/
		

		/***When***/
		List<MemberVO> memberList = memberDao.getMemberList();
		
		/***Then***/
		assertEquals(27, memberList.size());

	}

	/*
	 * 사용자화면에서 mem_id, mem_pass,
	 */
	@Test
	public void getMember() {
		/***Given***/
		MemberVO memberVOTest= new MemberVO();
		memberVOTest.setMem_id("sally");
		memberVOTest.setMem_pass("1234");
		/***When***/
		MemberVO memberVOResult = memberDao.getMember(memberVOTest);
		
		/***Then***/
		assertNotNull(memberVOResult);
		assertEquals("44888", memberVOResult.getMem_name());
		assertEquals("영민빌딩 2층", memberVOResult.getMem_add2());

		
	}
}
