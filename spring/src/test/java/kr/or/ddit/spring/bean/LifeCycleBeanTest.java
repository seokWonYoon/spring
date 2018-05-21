/**
 * 
 */
package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * LifeCycleBeanTest.java
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/bean/application-context-lifecycle.xml")
public class LifeCycleBeanTest {
	@Resource(name="lifeCycleBean")
	private	LifeCycleBean lifeCycleBean;
	
	/**
	 * Method : setUp
	 * 최초작성일 : 2018. 5. 21.
	 * 작성자 : "Y.S.W"
	 * 변경이력 :
	 * @throws java.lang.Exception
	 * Method 설명 :
	 */
	@Before
	public void setUp(){
	}

	//spring bean lifecycle 테스트
	//테스트 메소드 작명
	@Test
	public void SpringBeanLifeCycleTest() {
		/***Given***/
		

		/***When***/
		/***Then***/
		assertNotNull(lifeCycleBean);
	}

}
