/**
 * 
 */
package kr.or.ddit.spring.bean;

/**
 * DbProperties.java
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
public class DbProperties {
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}