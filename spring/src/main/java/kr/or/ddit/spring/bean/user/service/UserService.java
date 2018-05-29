/**
 * 
 */
package kr.or.ddit.spring.bean.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.spring.aop.AnnotaionAspect;
import kr.or.ddit.spring.bean.user.dao.UserDaoInf;

/**
 * UserService.java
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
public class UserService implements UserServiceInf {
	Logger logger = LoggerFactory.getLogger(AnnotaionAspect.class);
	
	@Resource(name="userDao")
	private UserDaoInf userDao;
	
	private List<MemberVO> userList; //저장소
//	private UserServiceInf userService;
	
	public UserService() {
		logger.debug("{}","public UserService()");
	}

	public void setUserDao(UserDaoInf userDao) {
		this.userDao = userDao;
	}

	public UserService(UserDaoInf userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<MemberVO> getUserList() {
		// TODO Auto-generated method stub
		return userList = userDao.getMemberList();
	}
	
	public UserDaoInf getUserDao() {
		return userDao;
	}




}
