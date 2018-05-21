/**
 * 
 */
package kr.or.ddit.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Aspect.java
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
public class Aspect {
	Logger logger = LoggerFactory.getLogger(Aspect.class);
	public void before(JoinPoint joinPoint) {
		logger.debug("{}.{} {}",  joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), "before()");
		
	}
	
	public void after(JoinPoint joinPoint) {
		logger.debug("{}.{} {}",  joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), "after()");
		
	}
	
	public void around(JoinPoint joinPoint) {
		logger.debug("{}.{} {}",  joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), "after()");
		
	}
	
}
