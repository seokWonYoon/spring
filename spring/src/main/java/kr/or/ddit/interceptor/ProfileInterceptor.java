/**
 * 
 */
package kr.or.ddit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * ProfileInterceptor.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 28.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 28. "Y.S.W" 최초 생성
 *
 * </pre>
 */
public class ProfileInterceptor extends HandlerInterceptorAdapter {
	Logger logger = LoggerFactory.getLogger(ProfileInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		long START_TIME = System.currentTimeMillis();
		request.setAttribute("START_TIME", START_TIME);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		long START_TIME = (long) request.getAttribute("START_TIME");
		long END_TIME = System.currentTimeMillis();
		long DURATION = END_TIME - START_TIME;
		logger.debug("{} : {}", "DURATION", DURATION );
	}
	
}
