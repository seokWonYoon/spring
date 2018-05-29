/**
 * 
 */
package kr.or.ddit.mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * RequestPartController.java
 *
 * @author "Y.S.W"
 * @since 2018. 5. 25.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 25. "Y.S.W" 최초 생성
 *
 * </pre>
 */
@Controller
@RequestMapping("/requestPart")
public class RequestPartController {

	/**
	 * 
	 * Method : view 최초작성일 : 2018. 5. 25. 작성자 : "Y.S.W" 변경이력 :
	 * 
	 * @return Method 설명 : 첨부파일 업로드 화면 요청
	 */
	// localhost:8070/spring/requestPart/view
	// 테스트코드 : view 정보가 정상적으로 설정되어 오는지
	@RequestMapping("/view")
	public String view() {
		return "mvc/requestPart/view";
	}

	@RequestMapping("/upload")
//	public String upload(@RequestPart("file")MultipartFile multipartFile, Model model, HttpServletRequest request) {
	public String upload(MultipartHttpServletRequest multipartRequest, Model model, HttpServletRequest request) {
		MultipartFile multipartFile = multipartRequest.getFile("file");
		
		
		String uploadUrl = "/upload";
		String path = request.getServletContext().getRealPath("/upload");
		String name = multipartFile.getName();
		String originalFileName = multipartFile.getOriginalFilename();
		String filePath = path + File.separator +  originalFileName;
		
		model.addAttribute("uploadUrl", uploadUrl);
		model.addAttribute("path", path);
		model.addAttribute("name", name);
		model.addAttribute("originalFileName", originalFileName);
		model.addAttribute("filePath", filePath);
		
		//uploadUrl : /upload
		//originalFileName : brown.png
		//${uploadUrl}${originalFileName}
		
		try {
			// 파일전송
			multipartFile.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mvc/requestPart/uploadResult";
	}
	
	/**
	 * 
	* Method : pictureDownload
	* 최초작성일 : 2018. 5. 25.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* Method 설명 : 서버의 사진파일을 다운로드
	 * @throws IOException 
	 */
	
	// localhost:8070/spring/requestPart/pictureDownload?pictureName=brown.png
	@RequestMapping("/pictureDownload")
	public void pictureDownload(HttpServletResponse response, @RequestParam("pictureName")String pictureName, HttpServletRequest request) throws IOException {
		//mvc/requestPart/pictureDownload.jsp
		//<img src="contextPath(el로)/requestPart/pictureDownload?pictureName=brown.png>
		
		// /upload
		String uploadUrl = "/upload";
		String path = request.getServletContext().getRealPath(uploadUrl);		// 절대경로
		
//		D:\\A_TeachingMaterial\\7.JspSring\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring\\upload\\james.png 
		File file = new File(path + File.separator + pictureName);
		
		response.setHeader("Content-Disposition", "attachment;filename=" + pictureName);
		response.setContentType("application/octet-stream");
		response.setContentLength((int) file.length());

		FileInputStream fis = new FileInputStream(file);
		ServletOutputStream sos = response.getOutputStream();

		byte[] buffer = new byte[1024];
		int len = -1;

		while ((len = fis.read(buffer)) != -1) {
			sos.write(buffer, 0, len);

		}
		fis.close();
		sos.close();
		
	}
}
