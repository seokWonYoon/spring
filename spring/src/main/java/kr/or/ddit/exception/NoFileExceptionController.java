/**
 * 
 */
package kr.or.ddit.exception;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * NoFileExceptionController.java
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
@Controller
public class NoFileExceptionController {
	
	// localhost:8070/spring/ioException
	@RequestMapping("/ioException")
	public String ioException() throws IOException{
		new ClassPathResource("kr/ir/ddit/db/mybatis/mybatisConfig2.xml").getInputStream();
		return "";
	}
	
	
	// localhost:8070/spring/noFileException
	@RequestMapping("/noFileException")
	public String noFileException() throws NoFileException{
		try {
			new ClassPathResource("kr/ir/ddit/db/mybatis/mybatisConfig2.xml").getInputStream();
		} catch (IOException e) {
			throw new NoFileException();
		}
		return "";
	}
	
	
}
