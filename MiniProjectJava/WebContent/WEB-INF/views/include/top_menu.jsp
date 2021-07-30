<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- context path를 포함함 절대경로를 칮아준다. -->
<c:set var='root' value="${pageContext.request.contextPath }/"/>

<!-- 상단 메뉴 부분 -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top shadow-lg">
	<a class="navbar-brand" href="${root }main">SoftCampus</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
	        data-target="#navMenu">
		<span class="navbar-toggler-icon"></span>        
	</button>
	<div class="collapse navbar-collapse" id="navMenu">
		<ul class="navbar-nav">
		
			<c:forEach var="obj" items="${topMenuList }">
			<li class="nav-item">
				<a href="${root }board/main?board_info_idx=${obj.board_info_idx}" class="nav-link">${obj.board_info_name }</a>
			</li> 
			</c:forEach>
			
			<!-- 위에서 데이터베이스에서 게시판 이름 가져오도록 설정했기 때문에 수정시 아래와같이 수동으로 하나씩 할 필요가 없다.   -->
			<%-- <li class="nav-item">
				<a href="${root }board/main" class="nav-link">자유게시판</a>
			</li>
			<li class="nav-item">
				<a href="${root }board/main" class="nav-link">유머게시판</a>
			</li>
			<li class="nav-item">
				<a href="${root }board/main" class="nav-link">정치게시판</a>
			</li>
			<li class="nav-item">
				<a href="${root }board/main" class="nav-link">스포츠게시판</a>
			</li> --%>
		
		</ul>
		
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${loginUserBean.userLogin == true }">
				<li class="nav-item">
						<a href="${root }user/modify" class="nav-link">정보수정</a>
					</li>
					<li class="nav-item">
						<a href="${root }user/logout" class="nav-link">로그아웃</a>
					</li>
				</c:when>
				<c:otherwise> 
				<li class="nav-item">
						<a href="${root }user/login" class="nav-link">로그인</a>
					</li>
					<li class="nav-item">
						<a href="${root }user/join" class="nav-link">회원가입</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>