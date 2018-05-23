/**
 * 
 */
package kr.or.ddit.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AnnotaionAspect.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 23.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 23. "Y.S.W" 최초 생성
 *
 * </pre>
 */

@Aspect
public class AnnotaionAspect {
	Logger logger = LoggerFactory.getLogger(AnnotaionAspect.class);
	
	@Pointcut("execution(* kr.or.ddit..*Service.*(..))")
	public void dummy(){
	}
	
	@Before("dummy()")
	public void beforeMethod(){
		logger.debug("{}", "AnnotaionAspect.beforeMethod()");
	}
	
	@After("dummy()")
	public void afterMethod(){
		logger.debug("{}", "AnnotaionAspect.afterMethod()");
	}

	@Around("dummy()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		//before
		logger.debug("{}","around-before");
		long startTime = System.currentTimeMillis();

		Object result = joinPoint.proceed(joinPoint.getArgs());
		// after
		logger.debug("{}","around-after");
		long endTime = System.currentTimeMillis();
		
		logger.debug("{}:{} {}","duration", endTime-startTime, "ms");
		return result;
	}
	
}
