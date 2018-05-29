/**
 * 
 */
package kr.or.ddit.spring.test;

import static org.junit.Assert.*;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Ttest.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 29.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 29. "Y.S.W" 최초 생성
 *
 * </pre>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:kr/or/ddit/spring/application-context.xml",
		"classpath:kr/or/ddit/spring/context-datasource.xml",
		"classpath:kr/or/ddit/spring/context-transaction.xml" })
public class TestInit {

	/**
	 * Method : setUp
	 * 최초작성일 : 2018. 5. 29.
	 * 작성자 : "Y.S.W"
	 * 변경이력 :
	 * @throws java.lang.Exception
	 * Method 설명 :
	 */
	@Before
	public void setUp() throws Exception {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("kr/or/ddit/db/initDb.sql"));
		populator.setContinueOnError(false);
		
		BasicDataSource datasource = new BasicDataSource();

		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		
		//********************************테스트 계정인지 반드시 확인할 것 ******************************//
		//********************************실수하면 한강******************************//
		datasource.setUsername("pc02");
		datasource.setPassword("java");
		//********************************테스트 계정인지 반드시 확인할 것 ******************************//
		//********************************실수하면 한강******************************//
		DatabasePopulatorUtils.execute(populator, datasource);
	}


}
