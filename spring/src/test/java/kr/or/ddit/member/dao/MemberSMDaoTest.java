/**
 * 
 */
package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.spring.test.TestInit;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * MemberSMDaoTest.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 29.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 29. "Y.S.W" 최초 생성
 *
 * </pre>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:kr/or/ddit/spring/application-context.xml",
		"classpath:kr/or/ddit/spring/context-datasource.xml",
		"classpath:kr/or/ddit/spring/context-transaction.xml" })
public class MemberSMDaoTest extends TestInit {

	@Resource(name = "memberSMDao")
	MemberSMDaoInf memberSMDao;

	@Test
	public void memberDaoBeanCreateTest() {
		/*** Given ***/

		/*** When ***/

		/*** Then ***/
		assertNotNull(memberSMDao);

	}

	/**
	 * 
	 * Method : getMemberListTest 최초작성일 : 2018. 5. 24. 작성자 : "Y.S.W" 변경이력 :
	 * Method 설명 : 회원 전체 정보 조회 테스트
	 */
	@Test
	public void getMemberListTest() {
		/*** Given ***/

		/*** When ***/
		List<MemberVO> memberList = memberSMDao.getMemberList();

		/*** Then ***/
		assertEquals(27, memberList.size());

	}

	/*
	 * 사용자화면에서 mem_id, mem_pass,
	 */
	@Test
	public void getMember() {
		/*** Given ***/
		MemberVO memberVOTest = new MemberVO();
		memberVOTest.setMem_id("sally");
		memberVOTest.setMem_pass("1234");
		/*** When ***/
		MemberVO memberVOResult = memberSMDao.getMember(memberVOTest);

		/*** Then ***/
		assertNotNull(memberVOResult);
		assertEquals("44888", memberVOResult.getMem_name());
		assertEquals("영민빌딩 2층", memberVOResult.getMem_add2());

	}
	
	@Test
	public void insertMemberTest(){
		/***Given***/
		 MemberVO memberVO = new MemberVO("brown","1234","브라운","대전 중구 중앙로 76","영민빌딩","34940","곰");

		/***When***/
		 int insertCnt = memberSMDao.insertMember(memberVO);
		 
		/***Then***/
		 assertEquals(1, insertCnt);

	}
}
