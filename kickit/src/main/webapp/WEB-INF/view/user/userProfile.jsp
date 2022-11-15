<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<div class="popup">
		<div class="popup_content">
		
			<div class="popup-header">
				<h4 class="popup-title">내 정보</h4>
			</div>
						
			<div class="popup-body">
				<form name="userContent"  action="/kickit/userProfile" method="POST">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				
					<table class="table_view">
						<colgroup>
							<col class="width0p"/>
						</colgroup>
						<tbody>
							
							<tr>
								<th><input type="text" name="email" value="${user.email}" readonly/></th>
							</tr>
							
							<tr><th>Password</th></tr>
							<tr>
								<td><input type="password" name="password" maxlength="40" value="${user.password}"/></td>
							</tr>
							<tr><th>Name</th></tr>
							<tr>
								<td><input type="text" name="name" maxlength="40" value="${user.name}"/></td>
							</tr>
 							
							<tr><th>Tel</th></tr>
							<tr>
								<td><input type="text" name="tel" maxlength="40" value="${user.tel}"/></td>
							</tr>
							<tr><th>Address</th></tr>
							<tr>
								<td><input type="text" name="address" maxlength="40" value="${user.address}"/></td>
							</tr>
						
						</tbody>
					</table>
					
								
					<div class="popup-footer">
		         		<input class="btn btn-default" type="submit" value="정보 수정"/>
		        	</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>