package kr.co.softcampus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.dao.TopMenuDao;

//DAO 에서 받아온 정보로 필요한 처리를 해주는 역할
@Service
public class TopMenuService {

	@Autowired
	private TopMenuDao topMenuDao;
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList = topMenuDao.getTopMenuList();
		return topMenuList;
	}
	
}
