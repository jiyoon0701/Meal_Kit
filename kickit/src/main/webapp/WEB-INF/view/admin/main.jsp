<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager DashBoard</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js" integrity="sha512-ElRFoEQdI5Ht6kZvyzXhYG9NqjtkmlkfYk0wr6wHxU9JEHakS7UJZNeml5ALk+8IKlU6jDgMabC3vkumRokgJA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
</head>
<style>
	.d-md-inline-block{ width: 40%}
	.btn-dark{
		background-color: #FF8F52 !important;
	}
	.bi-person-fill,.bi-cart-fill{
		font-size: 30px;
		line-height: 30px; 
		color:#FF8F52;
		margin-right:20px;
	}
	
</style>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="http://localhost:8090/kickit/main"><img src="../resources/img/KicIcon.png" style="width:100px;"/> </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="d-flex">
         	<a href="http://localhost:8090/kickit/user/login"><i class="bi bi-person-fill"></i></a>
        </div>
    </nav>
    <center>
    <div style="width:80%">
	<h3><b>Manager DashBoard</b></h3>
	<center>
		<div>
			<div class="d-md-inline-block">
				<h5><b>매출</b></h5>
			    <canvas id="revenue canvas"></canvas>
			</div>
			<div class="d-md-inline-block">
				<h5><b>재고</b></h5>
			    <canvas id="quantity canvas"></canvas>
			</div>
		</div>
		</center>
		<br>
		<br>
		<br>
		<h5><b>상품</b></h5>
		<div style="overflow:auto; width:1500px; height:400px;">
			<table style = "border= 1; width:1200px;">
				<thead>
				<tr>
					<th>상품</th>
					<th>가격</th>
					<th>이미지</th>
					<th>수량</th>
					<th>카테고리</th>
					<th>추천</th>
					<th>판매량</th>
					<th>별점</th>
					<th>삭제</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${itemList}">
					<tr>
						<td><c:out value="${item.item }"/></td>
				  		<td><c:out value="${item.price }"/></td>
				   		<td><c:out value="${item.file_name }"/></td>
				    	<td><c:out value="${item.quantity }"/></td>
				    	<td><c:out value="${item.category }"/></td>
				    	<td><c:out value="${item.recommend }"/></td>
				    	<td><c:out value="${item.buy }"/></td>
				    	<td><c:out value="${item.star }"/></td>
				    	<td><a href="http://localhost:8090/kickit/admin/main/deleteItem?itemCode=${item.itemCode }" class = "btn btn-dark">삭제</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		 </div>
	</div>
	</center>

	<!-- Footer-->
     <footer class="py-5 bg-dark">
         <div class="container">
         	<p class="m-0 text-center text-white">Copyright &copy; Kickit</p>
         	<p class="m-0 text-center text-white">Tel) 02.538.3644</p>
         	<p class="m-0 text-center text-white">Address) 28-5, Teheran-ro 1-gil, Gangnam-gu, Seoul, Republic of Korea</p>
         	<p class="m-0 text-center text-white">Member) Yong-min Kang, il-kwon Yoon, ji-ji Yoon, So-yeong Park</p>
         	</div>
     </footer>
</body>
<script>
	const revenueCtx = document.getElementById('revenue canvas');
	const labels = [];
	const itemPurchaseList = ${itemPurchaseList}
	var data = []
	for (itemPurchase of itemPurchaseList){
		labels.push(itemPurchase.date);
		data.push(itemPurchase.price);
	}
	new Chart(revenueCtx, {
		type: 'line',
		data: {
		  labels: labels,
		  datasets: [{
			    label: '매출',
			    data: data,
			    fill: false,
			    borderColor: '#FF8F52',
			    tension: 0.1
		  }]
		}
	});
	
	const quantityCtx = document.getElementById('quantity canvas');
	const quantities = ${quantities};
	const labels2 = Object.keys(quantities);
	var data2 = Object.values(quantities);
	new Chart(quantityCtx, {
		type: 'bar',
		data: {
		  labels: labels2,
		  datasets: [{
			    label: '재고',
			    data: data2
		  }]
		}
	});
</script>
</html>