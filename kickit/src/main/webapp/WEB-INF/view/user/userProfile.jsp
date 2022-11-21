<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${path}/resources/css/userProfile.css" rel="stylesheet"/>
<title>👶 개인 정보 수정 👶</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="http://localhost:8090/kickit/main"><img src="../resources/img/KicIcon.png" style="width:100px;"/> </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="d-flex">
         	<a href="http://localhost:8090/kickit/user/login"><i class="bi bi-person-fill"></i></a>
                <a href="http://localhost:8090/kickit/mypage"><i class="bi bi-cart-fill"></i></a>
            </div>
        </div>
    </nav>
	<div >
		<div >

			<div >
				<h2 class="title">Your Information</h2>
			</div>
			<hr class="line">

			<div class="popup-body">
				<form name="userContent" action="/kickit/userProfile" method="POST">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
											
					<div class="divfont">
					&nbsp;&nbsp;이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;비밀번호
					</div>
					<div style= 400px >
					<input type="text" name="name" class="firstbox" maxlength="40" value="${user.name}"  /> 
					<input type="password" name="password" class="scondbox" maxlength="40" value="${user.password}" /> 
					</div>
					<div class="divfont">
					&nbsp;&nbsp;이메일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;전화번호
					</div>
					</div>
					<input type="text" name="email" class="firstbox" maxlength="40" value="${user.email}" readonly/> 
					<input type="text" name="tel"  class="scondbox" maxlength="40" value="${user.tel}" /> 
					</div>
					<div class="divfont">
					&nbsp;&nbsp;주소
					</div>
					<input type="text" name="address" class="addressbox" maxlength="40" value="${user.address}" />
					


					<div class="popup-footer">
						<input class="btn btn-default" class="btn" type="submit" value="정보 수정" />
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>