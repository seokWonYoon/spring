/**
 * 
 */
package kr.or.ddit.login.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * LoginService.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 24.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 24. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@Service("loginService")
public class LoginService implements LoginServiceInf {

	@Resource(name = "memberDao")
	MemberDaoInf memberDao;

	private SqlSession sqlSession;
	private SqlSessionFactory sqlSessionFactory;

	public LoginService() {
		String resource = "kr/or/ddit/db/mybatis/mybatisConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
		} catch (IOException e) {
			// TODO dao()생성자들이 쓸 트라이캐치 구문을 완성하는 클래스 만들고 위임할 수 잇다
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> loginProcess(MemberVO memberVO) {
		MemberVO resultVO = memberDao.getMember(memberVO);
		System.out.println("resultVO" + resultVO);
		Map<String, Object> resultMap = new HashMap<String, Object>();

		// 입력받은 비밀번호가 db값과 일치할 때
		if (resultVO == null) {
			resultMap.put("loginPassed", false);
			return resultMap;
		} else {
			boolean loginPassed = resultVO.passwordVerify(memberVO);
			resultMap.put("loginPassed", loginPassed);

			if (loginPassed) {
				resultMap.put("resultVO", resultVO);
			}
			return resultMap;
		}

	}
	
}
