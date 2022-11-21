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
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">

</head>
<style>
	img{
		margin-left:5%;
		width:150px;
	}
	.purchaseName_div{
		float:right;
		margin-right:20%;
	}
	.content_div{
		margin-left:30px;
	}
	.content_div input{
		width:90%;
		border:none;

	}
	.subject_div{
		margin-left:5%;
		margin-top:3%;
	}
	textarea{
		width:90%;
		height:8em;
		border:none;
		resize: none;
	}
	.btn-outline-secondary{
		float:right;
		margin-right:10%;
		border-color:#FF8F52;
		color:#FF8F52;
	}
	.btn-outline-secondary:hover{
		background-color:#FF8F52;
		border-color:#FF8F52;
	}
</style>
<body>
	<div class="wrapper_div">
		<center>
			<div class="subject_div">
				<p><b>상품 리뷰 작성</b></p>
			</div>
		</center>
		<form action="/kickit/review?id=${POARDto.id}" enctype="multipart/form-data" method="POST">
			<div class="input_wrap">			
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<input type="hidden" name="itemCode" value="${POARDto.itemCode}"/>
				<img src="resources/img/${POARDto.file_name }"/>
				<div class="purchaseName_div"> 
					<h2><b>${POARDto.item}</b></h2>
					<p><b>가격 : ${POARDto.price }원</b></p>
					<div class="rating_div">
					<p><b>평점</b></p>
					<select name="star">
						<option value=1.0f>1.0</option>
						<option value=2.0f>2.0</option>
						<option value=3.0f>3.0</option>
						<option value=4.0f>4.0</option>
						<option value=5.0f>5.0</option>
					</select> 
				</div>
				</div>
				<br>

				<hr>

				<div class="content_div">
					<p><b>Review</b></p>
					<div class="input-group input-group-sm mb-3">
						<input type="text" name="title" placeholder="제목을 입력해주세요" value=""/>
					</div>
					<div class="content">
						<textarea name="content" placeholder="내용을 입력해주세요"></textarea>
					</div>
					<div class="mb-3">
						<input type="file" multiple="multiple" name="file" class="form-control" required id="file" />
					</div>
				</div>
				<input class="btn btn-outline-secondary" type="submit" value="리뷰 등록"/>
			</div>
		</form>
	</div>
</body>
</html>