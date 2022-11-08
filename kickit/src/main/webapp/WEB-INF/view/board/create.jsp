<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
	<div class="controller">
	<div id="wriTitle"><b>밀키트 등록</b></div>
		<form action="create" method="post">
			<table>
				<tr>
					<td width="100px">카테고리</td>
					<td><select name="category" id="category" >
							<option>한식</option>
							<option>중식</option>
							<option>일식</option>
							<option>건강식</option>
					</select></td>
				</tr>
				<tr>
					<td>상품 이름</td>
					<td><input type="text" name="item" required id="item" />
					</td>
				</tr>
				<tr>
					<td>상품 가격</td>
					<td><input type="text" name="price" required id="price" />
					</td>
					<td>상품 수량</td>
					<td><input type="text" name="quantity" required id="quantity" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><textarea rows="12" cols="50"
							name="content" required id="content"></textarea></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="첨부파일" class="button"></td>
				</tr>
			</table>
		<div>
			<button>등록하기</button>
		</div>
		</form>
	</div>
</body>
</html>    