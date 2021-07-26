package kr.co.softcampus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.softcampus.beans.BoardInfoBean;

public interface TopMenuMapper {

	@Select("select * from board_info_table " + 
			"order by board_info_idx")
	List<BoardInfoBean> getTopMenuList();
	//select 쿼리의 결과를 getTopMenuList라는 List 메서드에 저장한다는 뜻.
}
