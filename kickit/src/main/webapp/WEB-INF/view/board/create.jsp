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
		<div id="wriTitle">
			<b>밀키트 등록</b>
		</div>
		<form name="fileForm" action="create" method="POST" enctype="multipart/form-data">
			<table>
				<tr>
					<td width="100px">카테고리</td>
					<td><select name="category" id="category">
							<option>한식</option>
							<option>중식</option>
							<option>일식</option>
							<option>건강식</option>
					</select></td>
				</tr>
				<tr>
					<td>상품 이름</td>
					<td><input type="text" name="item" required id="item" /></td>
				</tr>
				<tr>
					<td>상품 가격</td>
					<td><input type="text" name="price" required id="price" /></td>
					<td>상품 수량</td>
					<td><input type="text" name="quantity" required id="quantity" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><textarea rows="12" cols="50" name="content"
							required id="content"></textarea></td>
				</tr>
				
				<tr>
					<td bgcolor="orange" width="70">대표 사진 업로드(단일)</td>
					<td align="left">
					<input type="file"  multiple="multiple" name="file" id="file" required="required"/>
					</td>
					
				</tr>
				
				<tr>
					<td bgcolor="orange" width="70">상세 사진 업로드(다중)</td>
					<td align="left"><input multiple="multiple" type="file" name="files" id="files" required="required"/></td>
					
				</tr>
			</table>
			<div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					 <input type="submit" value="등록하기" />
			</div>
		</form>
	</div>
</body>
</html>
