package kr.or.ddit.spring.aop;

import kr.or.ddit.spring.bean.user.dao.UserDao;
import kr.or.ddit.spring.bean.user.dao.UserDaoInf;
import kr.or.ddit.spring.bean.user.service.UserService;
import kr.or.ddit.spring.bean.user.service.UserServiceInf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;

/**
 * 
 * AopJavaConfig.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 23.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 23. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@Configuration
@ComponentScan(basePackages = { "kr.or.ddit" }, includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = org.aspectj.lang.annotation.Aspect.class))
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopJavaConfig {
	
	@Bean(name="userDao")
	public UserDaoInf userDao(){
		UserDaoInf userDao = new UserDao();
		return userDao;
	}
	
	@Bean(name="userService")
	public UserServiceInf userService(){
		UserServiceInf userService = new UserService();
		userService.setUserDao(userDao());
		return userService;
	}
}
