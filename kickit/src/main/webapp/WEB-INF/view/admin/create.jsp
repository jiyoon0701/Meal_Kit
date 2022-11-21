<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<c:set var="path" value="${pageContext.request.contextPath}" />
<link href="${path}/resources/css/create.css" rel="stylesheet">

<head>
<meta charset="UTF-8">
<title>상품 등록</title>
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
	<!--navigation end-->

	<div class="container" role="main">
		<form action="create" enctype="multipart/form-data" method="post">
			<h3 style="text-align: center;">상품 등록</h3>
			<div class="mb-3">
				<label for="title">상품명</label> <input type="text" name="item"
					required id="item" class="form-control" placeholder="상품 이름을 입력하세요."
					maxlength="50">
			</div>
			<div class="mb-3">
				<label for="title">상품 가격</label> <input type="text"
					class="form-control" placeholder="상품 가격을 입력해주세요" name="price"
					required id="price" maxlength="20">
			</div>
			<div class="mb-3">
				<label for="title">상품 수량</label> <input type="text"
					class="form-control" placeholder="상품 수량을 입력해주세요" name="quantity"
					required id="quantity" maxlength="20">
			</div>
			<div class="mb-3">
				<label for="title">상품 설명</label>
				<textarea rows="12" cols="50" class="form-control"
					placeholder="상품 설명을 입력해주세요" name="content" required id="content">
						</textarea>
			</div>
			<div class="mb-3">
				<label for="title">카테고리</label> <select name="category"
					id="category" class="form-control">
					<option value="" disabled selected>카테고리를 선택하세요</option>
					<option>한식</option>
					<option>중식-일식</option>
					<option>베트남식</option>
					<option>양식</option>
					<option>일식</option>
					<option>건강한 식사</option>
					<option>기타</option>
				</select>

			</div>
			<div class="mb-3">
				<label for="title">썸네일 사진</label> <input type="file" multiple="multiple"
					name="file" class="form-control" required id="file" />
			</div>
			<div class="mb-3">
				<label for="title">본문 사진</label> <input multiple="multiple"
					type="file" name="files" id="files" class="form-control"
					required="required" />
			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="submit"
				class="btn btn-primary form-control" value="등록하기">
		</form>
	</div>


	<!-- Footer-->
	<section>
		<div class="wrapper">
			<p class="m-0 text-center text-black">Copyright &copy; Kickit</p>
			<p class="m-0 text-center text-black">Tel) 02.538.3644</p>
			<p class="m-0 text-center text-black">Address) 28-5, Teheran-ro
				1-gil, Gangnam-gu, Seoul, Republic of Korea</p>
			<p class="m-0 text-center text-black">Member) Yong-min Kang,
				il-kwon Yoon, ji-yoon Lee, So-yeong Park</p>
		</div>
	</section>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>
