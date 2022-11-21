<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
<c:set var="path" value="${pageContext.request.contextPath}" />
  <head>
    <meta charset="UTF-8">
    <!--<title> Login and Registration Form in HTML & CSS | CodingLab </title>-->
    <link href="${path}/resources/css/login.css" rel="stylesheet">
    <!-- Fontawesome CDN Link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
   </head>
   <!-- 배경 색 <body bgcolor="#FF8F52"> 인데 이상해서 흰색으로 함 -->
   <script type="text/javascript">   
	function sign_click(){
		const pass = document.getElementById('password');
		const passCk = document.getElementById('passwordCK');
		
		if (pass != passCk){
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			
		}
	}
</script>
<body>
<c:url value="/loginAction" var="loginUrl" />
  <div class="container">
    <input type="checkbox" id="flip">
    <div class="cover">
      <div class="front">
       <img src="${path}/resources/img/login.PNG" alt="">
        <!-- <div class="text">
          <span class="text-1">Every new friend is a <br> new adventure</span>
          <span class="text-2">Let's get connected</span>
        </div> -->
      </div>
      <div class="back">
        <%--  <img src="${path}/resources/img/starbucks.png" alt=""> --%>
        <!-- <div class="text">
          <span class="text-1">Complete miles of journey <br> with one step</span>
          <span class="text-2">Let's get started</span>
        </div> -->
      </div>
    </div>
    <div class="forms">
        <div class="form-content">
          <div class="login-form">
            <div class="title">Login</div>
         <form:form name="loginFrm" action="${loginUrl }" method="post">
            <div class="input-boxes">
              <div class="input-box">
                <i class="fas fa-envelope"></i>
                <input type="text" placeholder="Enter your email" name="email" id="email" required>
              </div>
              <div class="input-box">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Enter your password" name="password" id="password" required>
              </div>
              <c:if test="${param.error != null }">
								<div class="input-group">
									<i class='bx bxs-lock-alt'></i>
									<p>아이디 또는 비밀번호가 잘못되었습니다.</p>
								</div>
							</c:if>
              
              <div class="button input-box">
                <input type="submit" value="Sumbit">
              </div>
              <div class="text sign-up-text">Don't have an account? <label for="flip">Sigup now</label></div>
            </div>
        </form:form>
      </div>
      
      <!-- start signUp -->
        <div class="signup-form">
          <div class="title">Signup</div>
        <form action="join" method = "POST">
            <div class="input-boxes">
              <div class="input-box">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Enter your name" name = "name" id = "name" required>
              </div>
              <div class="input-box">
                <i class="fas fa-envelope"></i>
                <input type="text" placeholder="Enter your email" name = "email" id= "email" required>
              </div>
              <div class="input-box">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Enter your password" name = "password" id = "password" required>
              </div>
              <div class="input-box">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Enter your confirm password" id = "passwordCK" required>
              </div>
              <div class="input-box">
                <i class="fas fa-phone"></i>
                <input type="text" placeholder="Enter your Phone Number" id = "tel" name = "tel" required>
              </div>
              <div class="input-box">
              <i class="bi bi-house-fill"></i>
                <input type="text" placeholder="Enter your address" id = "address" name = "address" required>
              </div>
              <input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
              <div class="button input-box">
                <input type="submit" value="Sumbit" onclick="sign_click()" >
              </div>
              <div class="text sign-up-text">Already have an account? <label for="flip">Login now</label></div>
            </div>
      </form>
    </div>
    </div>
    </div>
  </div>
</body>
</html>
