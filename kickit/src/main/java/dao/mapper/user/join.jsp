<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container">
    <form action="user/join" method="post">
        <div class="form-group">
            <label for="name">이름</label>ㄴ
            <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
            <label for="email">아이디</label>
            <input type="text" id="email" name="email" placeholder="이메일을 입력하세요">
            <label for="id">비밀번호</label>
            <input type="text" id="password" name="password" placeholder="비밀번호를 입력하세요">
            <label for="id">전화번호</label>
            <input type="text" id="tel" name="tel" placeholder="전화번호를 입력하세요"> 
            <label for="id">주소</label>
            <input type="text" id="address" name="address" placeholder="주소를 입력하세요"> </div>
        <button type="submit">등록</button>
    </form>
</div>
</body>
</html>