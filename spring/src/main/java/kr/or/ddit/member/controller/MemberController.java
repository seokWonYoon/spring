/**
 * 
 */
package kr.or.ddit.member.controller;

import javax.annotation.Resource;

import kr.or.ddit.member.service.MemberServiceInf;

import org.springframework.stereotype.Controller;

/**
 * MemberController.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 21.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 21. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@Controller("memberController")
public class MemberController {
	@Resource(name="memberService")
	private MemberServiceInf memberService;
	// Controller : xxx를 속성으로 갖고있음
	// service :  dao 속성으로 갖고있음
	// dao : 빈으로 주입받을 만한 것이 없음(현재기준)
	public MemberServiceInf getMemberServiceInf() {
		return memberService;
	}

}
