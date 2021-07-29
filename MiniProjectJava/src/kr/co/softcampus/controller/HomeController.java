package kr.co.softcampus.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.softcampus.beans.UserBean;

@Controller
public class HomeController {

	//이름으로 주입받을때는 Resource 어노테이션을 사용한다.
	//RootAppContext에서 정의해준 UserBean 메서드 사용
	//앞으로 loginBean이 필요할 때는 이런방식으로 주입받아서 사용.
	
	//@Resource(name= "loginUserBean")
	//private UserBean loginUserBean;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		//System.out.println(loginUserBean);
		return "redirect:/main";
	}
}

