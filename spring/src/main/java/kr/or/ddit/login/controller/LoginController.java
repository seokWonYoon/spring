package kr.or.ddit.login.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.login.service.LoginServiceInf;
import kr.or.ddit.member.model.MemberVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "loginService")
	private LoginServiceInf loginService;

	/**
	 * 
	 * Method : login 최초작성일 : 2018. 5. 24. 작성자 : "Y.S.W" 변경이력 :
	 * 
	 * @return Method 설명 : 로그인 폼 요청
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session) {
		return "login/login";
	}

	/**
	 * 
	 * Method : login 최초작성일 : 2018. 5. 24. 작성자 : "Y.S.W" 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 로그인 처리
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, MemberVO memberVO, Model model) {
		Map<String, Object> resultMap = loginService.loginProcess(memberVO);

		boolean loginPassed = (boolean) resultMap.get("loginPassed");
		// login 성공
		if (loginPassed) {
			session.setAttribute("LOGIN_USER", resultMap.get("resultVO"));
			// session.setAttribute("LOGIN_USER", memberVO);
			model.addAttribute("boardList", makeTempBoardList());
			
			return "main/main";
			// login 실패
		} else {

			return "login/login";
		}

	}

	/**
	 * 
	 * Method : loginProcessWithMav 최초작성일 : 2018. 5. 24. 작성자 : "Y.S.W" 변경이력 :
	 * 
	 * @return Method 설명 :
	 */
	@RequestMapping(value = "/loginMav", method = RequestMethod.POST)
	public ModelAndView loginMav(HttpSession session, MemberVO memberVO) {
		logger.debug("{}", "loginMav()");

		Map<String, Object> resultMap = loginService.loginProcess(memberVO);
		boolean loginPassed = (boolean) resultMap.get("loginPassed");

		// new ModelAndView(viewName)
		ModelAndView mav = new ModelAndView("login/login");
		mav.addObject("boardList", makeTempBoardList());
		// USER_AUTH / ADMIN

		// login 성공
		if (loginPassed) {
			session.setAttribute("LOGIN_USER", resultMap.get("resultVO"));
			mav.setViewName("main/main");
			return mav;
			// login 실패
		}
		return mav;
	}

	private List<BoardVO> makeTempBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList.add(new BoardVO(1, "1번째 글", "1번째 내용", "brown", new Date()));
		boardList.add(new BoardVO(2, "2번째 글", "2번째 내용", "jesica", new Date()));
		boardList.add(new BoardVO(3, "3번째 글", "3번째 내용", "james", new Date()));
		boardList.add(new BoardVO(4, "4번째 글", "4번째 내용", "sally", new Date()));
		boardList.add(new BoardVO(5, "5번째 글", "5번째 내용", "cony", new Date()));
		return boardList;

	}
}
