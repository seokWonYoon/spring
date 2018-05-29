/**
 * 
 */
package kr.or.ddit.spring.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TilesController.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 28.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 28. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@RequestMapping("/tiles")
@Controller
public class TilesController {

	// localhost:8070/spring/tiles/hello
	@RequestMapping("/hello")
	public String hello(){
		// beanNameViewResolver : json --> pageJsonReport (bean name)
		// internalResourceViewResolver : jsp --> /WEB-INF/views + 문자열 + .jsp
		// tilesViewResolver : tiles 설정으로 연결 문자열 = tilesDefinition
		
//		<definition name="helloTiles" extends="basic.layout">
//		<put-attribute name="title" value="hello Tiles" />
//		<put-attribute name="footer" value="/WEB-INF/views/tiles/helloTiles.jsp" />
//		</definition>
		return "helloTiles";
	}
}
