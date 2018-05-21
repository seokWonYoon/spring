/**
 * 
 */
package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * BeanTypeConvertTest.java
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
@ContextConfiguration("classpath:kr/or/ddit/spring/bean/application-context-typeconvert.xml")
public class BeanTypeConvertTest {
	Logger logger = LoggerFactory.getLogger(BeanTypeConvertTest.class);
	@Resource(name="boardVo")
	private BoardVO boardVo;

	/**
	 * Method : setUp
	 * 최초작성일 : 2018. 5. 21.
	 * 작성자 : "Y.S.W"
	 * 변경이력 :
	 * @throws java.lang.Exception
	 * Method 설명 :
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		/***Given***/
		

		/***When***/
		/***Then***/
		assertNotNull(boardVo);
		assertEquals(1,boardVo.getBoard_seq().intValue());
//		assertEquals(1,boardVo.getBoard_seq().intValue());
		assertEquals("title", boardVo.getTitle());
		assertEquals("contents", boardVo.getContents());
		assertEquals("brown", boardVo.getReg_id());
		assertEquals(1234, boardVo.getReadCnt());

		Calendar calentdar = Calendar.getInstance();
		calentdar.set(2018, 4, 21, 0, 0, 0);
//		calentdar.setTime(new Date());
		logger.debug("{} : {}", "calentdar.getTime().toString()", calentdar.getTime().toString());
		assertEquals(calentdar.getTime().toString(), boardVo.getReg_date().toString());
	}

}
