package kr.or.ddit.member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import kr.or.ddit.member.model.MemberVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;
/*
 * @Controller
 * @Service
 * @Repository = dao
 */
@Repository("memberDao")
public class MemberDao implements MemberDaoInf {
	private SqlSession sqlSession;
	private SqlSessionFactory sqlSessionFactory;
	
	public MemberDao() {
		String resource = "kr/or/ddit/db/mybatis/mybatisConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO dao()생성자들이 쓸 트라이캐치 구문을 완성하는 클래스 만들고 위임할 수 잇다
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> getMemberList() {
		sqlSession = sqlSessionFactory.openSession();
		List<MemberVO>	memberList = sqlSession.selectList("member.getMemberList");
		sqlSession.close();
		return memberList;
	}

	@Override
	public MemberVO getMember(MemberVO memberVO) {
		sqlSession = sqlSessionFactory.openSession();
		MemberVO memberVOResult = sqlSession.selectOne("member.getMember", memberVO);
		sqlSession.close();
		return memberVOResult;
	}
}
