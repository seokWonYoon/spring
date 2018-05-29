/**
 * 
 */
package kr.or.ddit.spring.bean.convert;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * CustomDateEditor.java
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
public class CustomDateEditor implements Converter<String, Date> {
	/**
	 * 
	* Method : convert
	* 최초작성일 : 2018. 5. 21.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param arg0
	* @return
	* Method 설명 :
	 */
	@Override
	public Date convert(String source) {
		// 2018-05-21
		// date
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
