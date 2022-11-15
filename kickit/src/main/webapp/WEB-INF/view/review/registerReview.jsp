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
	<div class="wrapper_div">
		<div class="subject_div">
			리뷰 등록
		</div>
		<form action="/kickit/review?id=${POARDto.id}" method="POST">
			<div class="input_wrap">			
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<input type="hidden" name="itemCode" value="${POARDto.itemCode}"/>
				<div class="purchaseName_div"> 
					<img src="${POARDto.item }"/>
					<h2>${POARDto.item}</h2>
					<p>${POARDto.price }</p>
				</div>
				<div class="rating_div">
					<h4>평점</h4>
				<select name="star">
						<option value=0.5f>0.5</option>
						<option value=1.0f>1.0</option>
						<option value=1.5f>1.5</option>
						<option value=2.0f>2.0</option>
						<option value=2.5f>2.5</option>
						<option value=3.0f>3.0</option>
						<option value=3.5f>3.5</option>
						<option value=4.0f>4.0</option>
					</select> 
				</div>
				<div class="content_div">
					<h4>리뷰</h4>
					<div class="content_title">
						<input type="text" name="title" placeholder="제목을 입력해주세요" value=""/>
					</div>
					<div class="content">
						<textarea name="content" placeholder="내용을 입력해주세요"></textarea>
					</div>
				</div>
				<input class="btn btn-default" type="submit" value="리뷰 등록"/>
			</div>
		</form>
	</div>
</body>
</html>