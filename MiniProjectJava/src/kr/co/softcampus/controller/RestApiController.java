package kr.co.softcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.softcampus.service.UserService;

@RestController
public class RestApiController {
//데이터값만 전달할 경우 RestController사용 
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/checkUserIdExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		
		boolean chk = userService.checkUserIdExist(user_id);
		
		return chk + "";
		
	}
}

//@PathVariable :URL 경로에 변수를 넣어줌 
