<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<c:set var="path" value="${pageContext.request.contextPath}" />
<link href="${path}/resources/css/mypage.css" rel="stylesheet">
<!-- Bootstrap icons-->
	<link
	   href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	   rel="stylesheet" />
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Homepage - Start Bootstrap Template</title>
<style>
	.box {
	   width: 150px;
	   height: 150px;
	   border-radius: 70%;
	   overflow: hidden;
	}
	
	.profile {
	   width: 100%;
	   height: 100%;
	   object-fit: cover;
	}

	.bi-person-fill,.bi-cart-fill,.bi-box-arrow-right{
		font-size: 30px;
		line-height: 30px; 
		color:#FF8F52;
		margin-right:20px;
	}

	.btn-outline-secondary{
		border-color:#FF8F52;
		color:#FF8F52;
	}
	.btn-outline-secondary:hover{
		background-color:#FF8F52;
		border-color:#FF8F52;
	}
	.btn-outline-secondary:hover .bi-cart-fill{
		color:#FFFFFF;
	}
	
	</style>
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
	  <!-- Navigation-->
	        <nav class="navbar navbar-expand-lg navbar-light bg-light">
	            <div class="container px-4 px-lg-5">
	                <a class="navbar-brand" href="http://localhost:8090/kickit/main"><img src="${path}/resources/img/KicIcon.png" style="width:100px;"/> </a>
	                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
	                <div class="d-flex">
	                  <c:if test = "${email eq null }">
		            	<a href="http://localhost:8090/kickit/user/login"><i class="bi bi-person-fill"></i></a>
		            </c:if>
		            <c:if test = "${email ne null }">
	                    <a href="http://localhost:8090/kickit/mypage"><i class="bi bi-cart-fill"></i></a>
	                    <a href="http://localhost:8090/kickit/user/logout"><i class="bi bi-box-arrow-right"></i></a>
	                </c:if>
	                </div>
	            </div>
	        </nav>
   <!-- Product section-->
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
		<div class="float-right" style="display: flex; justify-content: end;">
			<input
				onclick="window.open('http://localhost:8090/kickit/userProfile', 'userProfile', 'width=430, height=500, location=no, status=no, scrollbars=yes');"
				class="btn" type="submit" value="정보 수정" />
		</div>
	</div>

	<hr>
	<div class="container" role="main">
		<h3 style="text-align: center; margin-bottom: 10px;">CART LIST</h3>
		<table class="table table-striped table-horizontal  mt-3">
			<thead class="table-warning">
				<tr>
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

		<div class="mb-3">
			<div style="display: inline-block">
				<label for="title">포인트 사용</label> <input type="text"
					class="form-point" name="point" id="point" value=0
					placeholder="사용할 포인트 입력" style="margin-top:10px">
			</div>
			<div style="display: inline-block">
				<input type="button" id="apibtn" class="btn" value="구매하기">
			</div>


		</div>
	</div>


	<!-- 이전 장바구니 -->


	<hr>

	<!-- 구매 목록 -->

	<div class="container" role="main">
		<h3 style="text-align: center; margin-bottom: 10px;">PURCHASED
			ITEM LIST</h3>
		<table class="table table-striped table-horizontal mt-3">
			<thead class="table-warning">
				<tr>
					<th>상품명</th>
					<th>구매 수량</th>
					<th>상품 가격</th>
					<th>구매 날짜</th>
					<th>리뷰작성</th>
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
							<button
								onclick="window.open('http://localhost:8090/kickit/review?id=${itemPuchase.id}', 'registerReview', 'width=430, height=500, location=no, status=no, scrollbars=yes');"
								class="reviewbtn">리뷰작성</button>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>

	<!-- 이전 구매 목록 -->



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