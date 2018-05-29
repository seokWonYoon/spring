/**
 * 
 */
package kr.or.ddit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * NoFileException.java
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
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoFileException extends Exception {

}
