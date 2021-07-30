package kr.co.softcampus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.softcampus.beans.UserBean;

public class CheckLoginInteceptor implements HandlerInterceptor{
	
	//interceptor에서는 자동주입을 받지 못해서 생성자로 bean을 주입받아준다.
	private UserBean loginUserBean;
	
	public CheckLoginInteceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(loginUserBean.isUserLogin() == false) {  //로그인되지 않은 경우
			String contextPath = request.getContextPath();
			//user에서 not_login.jsp로 요청하게 함.
			response.sendRedirect(contextPath + "/user/not_login"); 
			return false;  //false로 하면 다음단계로 이동하지 않고 여기에서 끝난다.
		}
		return true; //로그인 됐다면 다음단계인 controller로 이동됌.
	}
}
