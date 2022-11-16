<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Homepage - Start Bootstrap Template</title>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${path}/resources/css/mainStyles.css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	var path = "${pageContext.request.contextPath }";
	// var qustr = "${searchVO.qustr}";

	$(function() {
		$('input:button[name=button]').on('click', function() {
			var category = $(this).val();
			var order = $('select[name=order]').val();
			$.ajax({
				url : path + "/main",
				type : "get",
				headers : {
					"cache-control" : "no-cache",
					"pragma" : "no-cache"
				},
				data : {
					"category" : category, // 버튼의 value값에 따라 작동합니다.
					"order" : order
				},
				success : function(data) {
					$('body').html(data);
				},
				error : function(data) {
					alert('error');
				}//error
			});
		});

		$('#searchButton').on('click', function() {
			var keyword = $('input:text[name=keyword]').val();
			$.ajax({
				url : path + "/main",
				type : "get",
				headers : {
					"cache-control" : "no-cache",
					"pragma" : "no-cache"
				},
				data : {
					"keyword" : keyword
				},
				success : function(data) {
					$('body').html(data);
				},
				error : function(data) {
					alert('error');
				}//error
			});
		});
	});
</script>
</head>
<body>
	<h1>나는 마이페이지</h1>
	<p>${userinfo.name}님,당신개인페이지에요</p>
	<div class="contiainer">
		<div class="form-group">
			<p>이름 : ${userinfo.name }</p>
			<p>아이디 : ${userinfo.email }</p>
			<p>전화번호 : ${userinfo.tel }</p>
			<p>주소 : ${userinfo.address }</p>
			<p>포인트 : ${userinfo.point }</p>
			<hr>
			<button
				onclick="window.open('http://localhost:8090/kickit/userProfile', 'userProfile', 'width=430, height=500, location=no, status=no, scrollbars=yes');">사용자
				정보</button>
		</div>
	</div>
	<hr>
	<div class="contiainer">
		<c:forEach var="cartList" items="${cartList}">
			<div class="form-group">
				<p>장바구니 목록</p>
				<p>상품이름 : ${cartList.item }</p>
				<p>수량 : ${cartList.quantity }</p>
				<p>가격 : ${cartList.price }</p>
<%-- 				<form name="deletecart"  action="/kickit/mypage/mypage2" method="get">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<input type="submit" name="deleteCart" value="${cartList.id}">
				</form> --%>
				<a href="http://localhost:8090/kickit/mypage/mypage2/deleteCart?id=${cartList.id }">삭제</a>
				<%-- <img src="${cartList[0].filename }" name="filename"> --%>
				<hr>
			</div>
		</c:forEach>
		<p>합계수량 : ${totalqauntity}</p>
		<p>합계가격 : ${totalPrice}</p>
		<form name="postPoint"  action="/kickit/mypage/mypage2" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="text" name = "point" placeholder="사용할 포인트를 입력하주세요" value="">
		<p>구매 금액 : ${totalPrice}</p>
		<input type="submit" value="포인트사용">
		</form>
	</div>
	<hr>
	<div class="contiainer">
		<c:forEach var="itemPuchase" items="${itemPuchase}">
			<div class="form-group">
				<p>구매한 상품 목록</p>
				<p>상품이름 : ${itemPuchase.item }</p>
				<p>구매수량 : ${itemPuchase.quantity }</p>
				<p>개당 가격 : ${itemPuchase.price }</p>
				<p>구매날짜 : ${itemPuchase.date }</p>
				<%-- <img src="${cartList[0].filename }" name="filename"> --%>
				<hr>
				<button
					onclick="window.open('http://localhost:8090/kickit/review?id=${itemPuchase.id}', 'registerReview', 'width=430, height=500, location=no, status=no, scrollbars=yes');">리뷰작성</button>
			</div>
		</c:forEach>
	</div>
</body>
</html>