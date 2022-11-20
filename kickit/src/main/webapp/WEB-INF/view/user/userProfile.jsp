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