package kr.co.softcampus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.dao.UserDao;

@Service
public class UserService {

	//DAO로부터 넘겨부터 값이 NULL인지 판단하여 사용여부를 확인함.
	@Autowired
	private UserDao userDao;
	
	public boolean checkUserIdExist(String user_id) {
		
		String user_name = userDao.checkUserIdExist(user_id);
		
		if(user_name == null) {
			return true;
		} else {
			return false;
		}
	} 
}
