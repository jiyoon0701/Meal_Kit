<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>

<html lang="UTF-8">
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

	.bi-person-fill,.bi-cart-fill{
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
<body>
   <c:set var="path" value="${pageContext.request.contextPath}" />
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="http://localhost:8090/kickit/main"><img src="../resources/img/KicIcon.png" style="width:100px;"/> </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="d-flex">
         	<a href="http://localhost:8090/kickit/user/login"><i class="bi bi-person-fill"></i></a>
                <a href="http://localhost:8090/kickit/mypage"><i class="bi bi-cart-fill"></i></a>
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
               
               
               <div class="fs-5 mb-5">
               <h1 class="display-5 fw-bolder">${items.item}</h1>
               <h1>가격 : ${items.price}</h1>
               </div>
               <div class="fs-5 mb-5">
                  <span>남은 수량 : ${items.quantity}</span>
               </div>
               <!--    <h1 class="lead">간략하게 한 줄 소개 ..?</h1> -->
               <div class="d-flex">
                  <%-- <form name="cartForm" action="cart" method="POST"> --%>

                  <input class="form-control text-center me-3" id="quantity"
                     name="quantity" type="num" value="1" style="max-width: 3rem" />
                  <input type="hidden" value="${items.itemCode}" name="itemCode"
                     id="itemCode" /> <input type="hidden"
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
                  <button class="btn btn-outline-secondary" id="purchaseBtn">
                     <i class="bi-cart-fill me-1"></i> 장바구니 담기
                  </button>
               
                  <%--    </form> --%>

               </div>
               &nbsp;
                  <div>
                  <p style = "float:left">  고객 리뷰 : </p> <img src="${path}/resources/img/star2.png" style="float: left"
                     width="150px" />  4.5  <!-- &nbsp; <h3>5/5</h3>  -->
               </div>

            </div>

         </div>
         <hr>
         <div>
            <h1 style="margin-top: 40px;">${items.content}</h1>
            <c:forEach var="picture" items="${pictures}">
               <div class="form-group">
                  <c:if test="${picture != 'null'}">
                     <img src="${path}/resources/img/${picture}" name="filename">
                     <br>
                     <br>
                     <br>
                     <br>
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
                  <div class="box" style="background: #BDBDBD;">
                     <img class="profile" src="${path}/resources/img/person.png"
                        alt="..." />
                  </div>
                  <!-- Parent comment-->

                  <div class="ms-3">
                     <img style="" src="${path}/resources/img/star2.png" width="150px" class = "star"/>
                     <div class="fw-bold"><h4>${review.title}</h4></div>

                     <p>${review.content }</p>
                     <br>

                     <div class="flex-shrink-0">
                        <img class="rounded-circle"
                           src="${path}/resources/img/${review.picture}" alt="..."
                           width="240px" />
                     </div>
                  </div>

               </div>
               <hr>
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
<meta id="_csrf" name="_csrf" content="${_csrf.token}" />
<meta id="_csrf_header" name="_csrf_header"
   content="${_csrf.headerName}" />
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