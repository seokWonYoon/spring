package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVO {
	private Integer seq;
	private String title;
	private String content;
	private String regId;
	private Date regDt;
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	/**
	 * 
	 * @param seq
	 * @param title
	 * @param content
	 * @param regId
	 * @param regDt
	 */
	public BoardVO(Integer seq, String title, String content, String regId,
			Date regDt) {
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.regId = regId;
		this.regDt = regDt;
	}
	public BoardVO() {
	}
	
	
	
}
