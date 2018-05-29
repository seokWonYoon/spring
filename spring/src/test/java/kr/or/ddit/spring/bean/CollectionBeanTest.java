package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 
* CollectionBeanTest.java
*
* @author "Y.S.W"
* @since 2018. 5. 18.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 5. 18. "Y.S.W" 최초 생성
*
* </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/bean/application-context-collection.xml")
public class CollectionBeanTest {
	@Resource(name="collectionBean")
	private CollectionBean collectionBean;

	@Before
	public void setUp(){
	}

	@Test
	public void collectionBeanMapTest() {
		/***Given***/
		
		/***When***/
		Map<String, String> map = collectionBean.getMap();
		
		/***Then***/
		assertEquals("brown", map.get("userId"));
		assertEquals("sally", map.get("alias"));
	}
	
	@Test
	public void collectionBeanListTest() {
		/***Given***/
		
		/***When***/
		List<String> list = collectionBean.getList();
		
		/***Then***/
		assertEquals("brown", list.get(0));
		assertEquals("sally", list.get(1));
		assertEquals("cony", list.get(2));
	}
	
	
	@Test
	public void collectionBeanSetTest() {
		/***Given***/
		
		/***When***/
		Set<String> set = collectionBean.getSet();
		
		/***Then***/
		assertTrue(set.contains("brown"));
		assertTrue(set.contains("sally"));
		assertTrue(set.contains("cony"));
	}
	
	
	@Test
	public void collectionBeanPropertiesTest() {
		/***Given***/
		
		/***When***/
		Properties properties = collectionBean.getProperties();
		
		/***Then***/
		assertEquals("brown", properties.get("userId"));
		assertEquals("sally", properties.get("alias"));
	}
	
	
}
