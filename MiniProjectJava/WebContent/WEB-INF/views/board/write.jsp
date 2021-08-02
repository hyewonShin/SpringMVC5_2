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
<body>


<c:import url="/WEB-INF/views/include/top_menu.jsp"/>

<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<form:form action="${root }board/write_pro" method='post' modelAttribute="writeContentBean" enctype="multipart/form-data">
					<form:hidden path="content_board_idx"/>
					<div class="form-group">
						<label for="board_subject">제목</label>
						<form:label path="content_subject"></form:label>
						<form:input path="content_subject" class='form-control'/>
						<form:errors path="content_subject" style='color:red'/>
					</div>
					<div class="form-group">
						<form:label path="content_text">내용</form:label>		
						<form:textarea path="content_text" class="form-control" rows="10" style="resize:none"/>
						<form:errors path="content_text" style='color:red'/>
					</div>
					<div class="form-group">
						<form:label path="upload_file">첨부 이미지</form:label>
						<form:input type='file' path="upload_file" class="form-control" accept="image/*"/>
					</div>
					<div class="form-group">
						<div class="text-right">
							<form:button class="btn btn-primary">작성하기</form:button>
						</div>
					</div>
				</form:form>					
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>

<c:import url="/WEB-INF/views/include/bottom_info.jsp"/>

</body>
</html>

<!-- enctype="multipart/form-data" : 문자열 이외에도 모든 타입의 데이터를 클라이언트에서 서버로 전달할 수 있다. -->
