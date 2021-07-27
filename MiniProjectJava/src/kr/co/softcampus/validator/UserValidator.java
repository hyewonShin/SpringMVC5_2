package kr.co.softcampus.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.softcampus.beans.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) { //Validator가 검증할 수 있는 타입인지 확인한다.
		return UserBean.class.isAssignableFrom(clazz); //target을 검증한 후, 에러값이 있다면 errors에 담는다.
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserBean userBean = (UserBean)target;
		//유효성검사를 위해 target으로 넘어온 객체들을 Userbean으로 형변환해줌 
		
		if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
			errors.rejectValue("user_pw", "NotEquals");
			errors.rejectValue("user_pw2", "NotEquals");
		}
		
		//중복검사
		if(userBean.isUserIdExist() == false) {
			errors.rejectValue("user_id", "DontCheckUserIdExist");
		}
	}

}
