/**
 * 
 */
package kr.or.ddit.spring.bean.user.service;

import java.util.List;

import kr.or.ddit.member.model.MemberVO;
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
public interface UserServiceInf {
	/**
	 * 
	* Method : getUserList
	* 최초작성일 : 2018. 5. 18.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @return
	* Method 설명 :회원리스트 조회
	 */
	List<MemberVO> getUserList();
	UserDaoInf getUserDao();
	void setUserDao(UserDaoInf userDao);

}
