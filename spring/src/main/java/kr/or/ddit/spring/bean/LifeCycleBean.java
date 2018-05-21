package kr.or.ddit.spring.bean;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 * 
* LifeCycleBean.java
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
public class LifeCycleBean implements BeanNameAware, BeanFactoryAware, ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware, InitializingBean{ 
	//slf4j : 실제구현체는 logback 을 사용한다
	Logger logger = LoggerFactory.getLogger(LifeCycleBean.class);
	
	public LifeCycleBean(){
		logger.debug("{} {}", "LifeCycleBean","생성자");
	}

	@Override
	public void setBeanName(String arg0) {
		logger.debug("{} arg0  : {}", "setBeanName",arg0);
		
		
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		logger.debug("{} {}", "setApplicationContext",arg0);
		
	}

	@Override
	public void setMessageSource(MessageSource arg0) {
		logger.debug("{} {}", "setMessageSource",arg0);
		
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		logger.debug("{} {}", "setApplicationEventPublisher",arg0);
		
	}

	@Override
	public void setResourceLoader(ResourceLoader arg0) {
		logger.debug("{} {}", "setResourceLoader",arg0);
		
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		logger.debug("{} {}", "setBeanFactory",beanFactory);
	}
	
	@PostConstruct
	public void postConstructor(){
		logger.debug("{}", "postConstructor");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug("{}", "afterPropertiesSet");
	} 
	
	public void initMethod() {
	}
}
