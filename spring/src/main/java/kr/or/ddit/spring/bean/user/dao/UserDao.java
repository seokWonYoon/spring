package kr.or.ddit.spring.bean.user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import kr.or.ddit.member.model.MemberVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDao implements UserDaoInf {
	private SqlSession sqlSession;
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDao() {
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
		List<MemberVO>	memberList = 	sqlSession.selectList("member.getMemberList");
		sqlSession.close();
		return memberList;
	}

	@Override
	public UserDaoInf getUserDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUserDao() {
		// TODO Auto-generated method stub
		
	}
}
