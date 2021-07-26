package kr.co.softcampus.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.softcampus.beans.BoardInfoBean;
import kr.co.softcampus.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{

	/*
	 * @Autowired 
	 * private TopMenuService topMenuService;
	 * ->인터셉터에서는 자동주입으로 빈을 주입받지 못한다.
	   ->인터셉터를 등록한 곳에서 빈을 주입받은 다음에 생성자로 넘겨서 작업해줘된다.
	 */
	
	//TopMenuService 생성자
	private TopMenuService topMenuService;
	
	//TopMenuInterceptor 생성자에 TopMenuService 객체(생성자) 넣음. 
	public TopMenuInterceptor(TopMenuService topMenuService) {
		this.topMenuService = topMenuService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList",topMenuList);
		//list를 request영역에 topMunuList라는 이름으로 저장함.
		//controller로 연결됌 

		
		return true;
	}
}
