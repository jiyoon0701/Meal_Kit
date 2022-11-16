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
				<a
					href="http://localhost:8090/kickit/mypage/deleteCart?id=${cartList.id }">삭제</a>
				<p>
					체크 <input type="checkbox" name="checkItem"
						value="${cartList.itemCode}" checked />
				</p>

				<%-- <img src="${cartList[0].filename }" name="filename"> --%>
				<hr>
			</div>
		</c:forEach>
		<p>합계수량 : ${totalqauntity}</p>
		<p>합계가격 : ${totalPrice}</p>
		<input type="text" name="point" id="point"> <input
			type="button" id="apibtn">구매하기

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
			</div>
		</c:forEach>

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