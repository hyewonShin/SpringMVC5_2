package kr.co.softcampus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.softcampus.beans.UserBean;

public interface UserMapper {

	@Select("select user_name" + 
			" from user_table" + 
			" where user_id = #{user_id}")
	String checkUserIdExist(String user_id);
	//아랫줄로 내린 경우 꼭!! 한 칸씩 띄어주기(안 띄어주면 쿼리문 오류라고 에러남)


	@Insert("insert into user_table (user_idx, user_name, user_id, user_pw) " +
			"values (user_seq.nextval, #{user_name}, #{user_id}, #{user_pw})")
	void addUserInfo(UserBean joinUserBean);
	
}	
	
	
//Mapper는 Interpace클래스로 만들고, Servlet에  bean으로 Mapper 등록해준다.