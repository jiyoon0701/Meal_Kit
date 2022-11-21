<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<c:set var="path" value="${pageContext.request.contextPath}" />
<link href="${path}/resources/css/mypage.css" rel="stylesheet">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Homepage - Start Bootstrap Template</title>

<c:choose>
	<c:when test="${success eq 'true'}">
		<script>alert("결제 성공");</script>
	</c:when>
	<c:when test="${success eq 'false'}">
		<script>alert("결제 실패");</script>
	</c:when>
	<c:when test="${success eq 'cancle'}">
		<script>alert("결제 취소");</script>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>

</head>
<body>
	<!--navigation start-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand"
				href="http://localhost:8090/kickit/main"><img
				src="${path}/resources/img/KicIcon.png" style="width: 100px;" /> </a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div>
				<a href="http://localhost:8090/kickit/user/login"><i
					class="fas fa-user"></i></a> <a
					href="http://localhost:8090/kickit/content/list"><i
					class="bi bi-cart-fill"></i></a>
			</div>
		</div>
	</nav>
	<!--navigation end-->
	<div class="container" role="main">
		<h3 style="text-align: center;">MY PROFILE</h3>
		<div class="mb-3">
			<label for="title">Name</label> <input type="text"
				class="form-control" maxlength="30" value="${userinfo.name }"
				readonly>
		</div>
		<div class="mb-3">
			<label for="title">Email</label> <input type="text"
				class="form-control" maxlength="30" value="${userinfo.email }"
				readonly>
		</div>
		<div class="mb-3">
			<label for="title">Tel</label> <input type="text"
				class="form-control" maxlength="30" value="${userinfo.tel }"
				readonly>
		</div>
		<div class="mb-3">
			<label for="title">Address</label> <input type="text"
				class="form-control" maxlength="30" value="${userinfo.address }"
				readonly>
		</div>
		<div class="mb-3">
			<label for="title">Point</label> <input type="text"
				class="form-control" maxlength="30" value="${userinfo.point}"
				readonly>
		</div>
		<div class="float-right" style="display: flex;justify-content: end;"> 
			<input onclick="window.open('http://localhost:8090/kickit/userProfile', 'userProfile', 'width=430, height=500, location=no, status=no, scrollbars=yes');" class="btn" type="submit"
				value="정보 수정" />
		</div>
	</div>
	
	<hr>
	<div class="container" role="main">
		<h3 style="text-align: center;">CART LIST</h3>
	<table class="table table-striped table-horizontal table-bordered mt-3">
	<thead><tr>
	<th>상품명</th>
	<th>담은 수량</th>
	<th>상품 가격</th>
	<th>장바구니 삭제</th>
	</tr>
	</thead>
	<c:forEach var="cartList" items="${cartList}">
	<tbody>
	<tr>
	<td>${cartList.item }</td>
	<td>${cartList.quantity }</td>
	<td>${cartList.price }</td>
	<td><a
					href="http://localhost:8090/kickit/mypage/deleteCart?id=${cartList.id}">삭제</a></td>
	</tr>
	</tbody>
	</c:forEach>
	</table>
		<p>합계수량 : ${totalqauntity}</p>
		<p>합계가격 : ${totalPrice}</p>
		<input type="text" name="point" id="point" value =0 placeholder="사용할 포인트 입력"> 
		<input type="button" id="apibtn" class="btn" value="구매하기">
	</div>
	

	<!-- 이전 장바구니 -->	
	
	
	<hr>

	
	<div class="container" role="main">
		<h3 style="text-align: center;">PURCHASED ITEM LIST</h3>
	<table class="table">
	<thead><tr>
	<th>상품명</th>
	<th>구매 수량</th>
	<th>상품 가격</th>
	<th>구매 날짜</th>
	</tr>
	</thead>
	<c:forEach var="itemPuchase" items="${itemPuchase}">
	<tbody>
	<tr>
	<td>${itemPuchase.item }</td>
	<td>${itemPuchase.quantity }</td>
	<td>${itemPuchase.price }</td>
	<td>${itemPuchase.date }</td>
	<td>
	<button onclick="window.open('http://localhost:8090/kickit/review?id=${itemPuchase.id}', 'registerReview', 'width=430, height=500, location=no, status=no, scrollbars=yes');">리뷰작성</button></td>
	</tr>
	</tbody>
	</c:forEach>
	</table>

	</div>

</body>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">	

	$(document).on("click", "#apibtn", function(){
		const point = $("#point").val();
		if(point > ${userinfo.point }){
			alert("보유 포인트가 부족합니다.");
		}else{
		$.ajax({
			type : 'get',
			url:'/kickit/kakao/kakaopay',
			dataType: "json",
			data :{
				totalPrice : ${totalPrice},
				points : point
			},
			success : function(data){
				window.open(data.next_redirect_pc_url);
			},
			error : function(error){
				alert(error);
			}
	})}
		});
</script>
</html>