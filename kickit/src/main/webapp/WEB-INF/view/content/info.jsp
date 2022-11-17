<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>

<html lang="en">
<head>
<%-- <sec:csrfMetaTags /> 또는 --%>
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta name="_csrf" content="${_csrf.token}" />
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Item - Start Bootstrap Template</title>
<!-- Favicon-->
<!--  <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${path}/resources/css/itemInfo.css" rel="stylesheet"
	rel="stylesheet" />
<meta charset="EUC-KR">
<title>상품 상세 페이지</title>

</head>
<body>
	<h2>사용자 로그인</h2>
	<div id="apibtn">카카오페이</div>
</head>
<body>
	<c:set var="path" value="${pageContext.request.contextPath}" />
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="#!">Start Bootstrap</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#!">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#!">About</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#!">All Products</a></li>
							<li><hr class="dropdown-divider" /></li>
							<li><a class="dropdown-item" href="#!">Popular Items</a></li>
							<li><a class="dropdown-item" href="#!">New Arrivals</a></li>
						</ul></li>
				</ul>
				<form class="d-flex">
					<button class="btn btn-outline-dark" type="submit">
						<i class="bi-cart-fill me-1"></i> Cart <span
							class="badge bg-dark text-white ms-1 rounded-pill">0</span>
					</button>
				</form>
			</div>
		</div>
	</nav>

	<!-- Product section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0"
						src="${path}/resources/img/${items.file_name}" alt="..." />
				</div>
				<div class="col-md-6">
					<div>
						<img src="${path}/resources/img/star.png" style="float: left"
							width="100px" />
						<h2>5/5</h2>
					</div>
					<h1 class="display-5 fw-bolder">${items.item}</h1>
					<div class="fs-5 mb-5">
						<span>가격 : ${items.price}</span>
					</div>
					<div class="fs-5 mb-5">
						<span>남은 수량 : ${items.quantity}</span>
					</div>
					<!-- 	<h1 class="lead">간략하게 한 줄 소개 ..?</h1> -->
					<div class="d-flex">
						<%-- <form name="cartForm" action="cart" method="POST"> --%>

						<input class="form-control text-center me-3" id="quantity"
							name="quantity" type="num" value="1" style="max-width: 3rem" />
						<input type="hidden" value="${items.itemCode}" name="itemCode"
							id="itemCode" /> <input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" />
						<button class="btn btn-outline-dark flex-shrink-0"
							id="purchaseBtn">
							<i class="bi-cart-fill me-1"></i> 장바구니 담기
						</button>
						<%-- 	</form> --%>

					</div>

				</div>
			</div>
			<div>
				<h1 style="margin-top: 100px;">${items.content}</h1>
				<c:forEach var="picture" items="${pictures}">
					<div class="form-group">
						<c:if test="${picture != 'null'}">
							<img src="${path}/resources/img/${picture}" name="filename">
							<br><br><br><br>
						</c:if>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<!-- Comments section-->
	<section class="mb-5">

		<div class="card bg-light">

			<div class="card-body">
				<h2 style="padding-bottom: 20px;">후기</h2>
				<c:forEach var="review" items="${Review}" varStatus="status">

					<div class="d-flex mb-4">
						<!-- Parent comment-->
						<div class="flex-shrink-0">
							<img class="rounded-circle"
								src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..."
								width="240px" />
						</div>
						<div class="ms-3">
							<div class="fw-bold">${review.id}</div>
							<img style="" src="${path}/resources/img/star.png" width="100px" />
							<p>${review.content }</p>
						</div>

					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2022</p>
		</div>

	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="${path}/resources/js/itemInfo.js" rel="stylesheet"></script>


</body>
 <meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
 <meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">	
$(document).ready(function (){
	var token = $("meta[name='_csrf']").attr("content");
	 var header = $("meta[name='_csrf_header']").attr("content");
	 $("#purchaseBtn").click(function(){
		const quantity = $("#quantity").val();
		const totalQuantity = ${items.quantity};
		if (quantity > totalQuantity) {
			alert("수량 초과");
		}else { 			
			$.ajax({
				type : 'POST',
				url:'/kickit/content/cart',
				dataType: "json",
				data :{
					Quantity : quantity,
					itemCode : ${items.itemCode}
				},
				success : function(data){
					// 흐음..
				},
				error : function(error){
					if (error.status == 200){
						alert("장바구니 담기 완료");
					}
				},beforeSend : function(xhr){
					xhr.setRequestHeader(header, token);
				}
			}) 
		}
			});
});
</script>
</html>
