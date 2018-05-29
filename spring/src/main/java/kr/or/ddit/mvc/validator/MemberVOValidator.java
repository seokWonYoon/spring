/**
 * 
 */
package kr.or.ddit.mvc.validator;

import kr.or.ddit.member.model.MemberVO;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * MemberVOValidator.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 25.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 25. "Y.S.W" 최초 생성
 *
 * </pre>
 */
public class MemberVOValidator implements Validator {
	/**
	 * 
	* Method : supports
	* 최초작성일 : 2018. 5. 25.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param clazz
	* @return
	* Method 설명 :
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		MemberVO.class.isInstance(clazz);
		return MemberVO.class.isAssignableFrom(clazz);
	}

	/**
	* Method : validate
	* 최초작성일 : 2018. 5. 25.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param target
	* @param errors
	* Method 설명 :
	*/
	@Override
	public void validate(Object target, Errors errors) {
		MemberVO memberVO = (MemberVO) target;
//		if ((memberVO.getMem_id() == null || memberVO.getMem_id().trim().equals(""))||
//				(memberVO.getMem_pass() == null || memberVO.getMem_pass().trim().equals(""))) {
		if (memberVO.getMem_id() == null || memberVO.getMem_id().trim().equals("")){
			errors.rejectValue("mem_id", "required");
		} else if (memberVO.getMem_id().length() <= 3) {
			errors.rejectValue("mem_id", "size");
		}
		if (memberVO.getMem_pass() == null || memberVO.getMem_pass().trim().equals("")){
			errors.rejectValue("mem_pass", "required");
		} else if (memberVO.getMem_pass().length() <= 3) {
			errors.rejectValue("mem_pass", "size");
		}

	}
	
}
