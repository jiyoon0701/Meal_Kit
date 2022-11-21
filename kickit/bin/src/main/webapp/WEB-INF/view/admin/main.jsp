<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js" integrity="sha512-ElRFoEQdI5Ht6kZvyzXhYG9NqjtkmlkfYk0wr6wHxU9JEHakS7UJZNeml5ALk+8IKlU6jDgMabC3vkumRokgJA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
	<h1>admin/main 관리자 페이지</h1>
	<h3>매출</h3>
	<div style="width:75%;">
	    <canvas id="revenue canvas"></canvas>
	</div>
	<h3>재고</h3>
	<div style="width:75%;">
	    <canvas id="quantity canvas"></canvas>
	</div>
	<h3>상품</h3>
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
			    	<td><a href="http://localhost:8090/kickit/admin/main/deleteItem?itemCode=${item.itemCode }">삭제</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	 </div>
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
			    borderColor: 'rgb(75, 192, 192)',
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
			    data: data2,
			    fill: false,
			    borderColor: 'rgb(75, 192, 192)',
			    tension: 0.1
		  }]
		}
	});
</script>
</html>