package kr.co.softcampus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.softcampus.beans.UserBean;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration
public class RootAppContext {

	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
	}
	
	
}

//다양한 목적으로 사용하기 위해 이 클래스에서 정의해줌.
// 데이터를 저장하거나 관리하는 bean들은 RootAppContext에 저장함.
