package kr.co.softcampus.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserBean {
	private int user_idx;
	
	//유효성 검사 세팅
	@Size(min=2, max=4) //한글만 사용 
	@Pattern(regexp = "[가-힣]*")
	private String user_name;
	
	@Size(min=4, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*") //영어,숫자만 사용 
	private String user_id;
	
	@Size(min=4, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw;
	
	@Size(min=4, max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw2;
	
	//중복검사를 했는지 확인하는 객체(join.jsp에서 hidden으로 사용)
	private boolean userIdExist;
	
	//로그인 여부값을 담고있는 객체
	// true = 로그인 한 것 
	// false = 로그인 안한것
	private boolean userLogin;
	
	public UserBean() {
		this.userIdExist = false;
		this.userLogin = false;
	}
	
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_pw2() {
		return user_pw2;
	}
	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}
	
	//boolean 타입은 set메서드에서 앞에 is를 붙여서 생성된다.
	public boolean isUserIdExist() {
		return userIdExist;
	}

	public void setUserIdExist(boolean userIdExist) {
		this.userIdExist = userIdExist;
	}


	public boolean isUserLogin() {
		return userLogin;
	}


	public void setUserLogin(boolean userLogin) {
		this.userLogin = userLogin;
	}
	
	
	
}
