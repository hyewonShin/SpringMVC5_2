<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath }/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>미니 프로젝트</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<script>
//중복확인 버튼에 onclick이벤트로 checkUserIdExist메서드를 호출.
	function checkUserIdExist(){
		
		var user_id = $("#user_id").val()  //사용자가 입력한 아이디값 가져옴 
	
		if(user_id.length == 0){
			alert('아이디를 입력해주세요')
			return
		} 
	 
		$.ajax({
			url : '${root}user/checkUserIdExist/' + user_id,  //요청할 페이지 주소(RestApiController에서 매핑해둠)
			type : 'get',
			dataType : 'text',  //응답결과 타입 : 문자열
			success : function(result) {  //성공했을 때 요청할 함수
				if(result.trim() == 'true'){  //넘어오는 문자열값이 ture라면 
					alert('사용할 수 있는 아이디입니다')
					$("#userIdExist").val('true') //hidden:값은 담을 수 있지만,눈에는 보이지 않음.
				} else {
					alert('사용할 수 없는 아이디입니다')
					$("#userIdExist").val('false') 
				}
			}
		})
	}
	
	function resetUserIdExist(){
		$("#userIdExist").val('false')
	}
	//resetUserIdExist()는 중복확인 후 새로운 아이디 값을 넣으면 false가 되도록  reset하는 함수이다.
	
// ajax 통신이기 때문에 페이지는 바뀌지 않는다.
</script>  
<body>

<c:import url="/WEB-INF/views/include/top_menu.jsp"/>

<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
				<form:form action="${root }user/join_pro" method="post" modelAttribute="joinUserBean">
					<form:hidden path="userIdExist"/> <!-- 중복검사를 했는지 결과값을 보이지않게 담아서 보내기 위해 사용 -->
						<div class="form-group">
						<form:label path="user_name">이름</form:label>
						<form:input path="user_name" class="form-control"/>
						<form:errors path="user_name" style="color:red"/>
						</div>
						<div class="form-group">
							<form:label path="user_id">아이디</form:label>
							<div class="input-group">
								<form:input path="user_id" class="form-control" onkeypress="resetUserIdExist()"/>	
								<div class="input-group-append">
									<button type="button" class="btn btn-primary" onclick='checkUserIdExist()'>중복확인</button><br/>
								</div>
							</div>
							<form:errors path="user_id" style="color:red"/>
						</div>
						<div class="form-group">
							<form:label path="user_pw">비밀번호</form:label>
							<form:password path="user_pw" class="form-control"/>
							<form:errors path="user_pw" style="color:red"/>
						</div>
						<div class="form-group">
							<form:label path="user_pw2">비밀번호 확인</form:label>
							<form:password path="user_pw2" class="form-control"/>
							<form:errors path="user_pw2" style="color:red"/>
						</div>
						<div class="form-group">
							<div class="text-right">
								<form:button class="btn btn-primary">회원가입</form:button>
							</div>
						</div>
				</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>

<c:import url="/WEB-INF/views/include/bottom_info.jsp"></c:import>

</body>
</html>



<!-- onkeypress : 키보드에서 키를 눌었을때 이벤트 실행 -->




