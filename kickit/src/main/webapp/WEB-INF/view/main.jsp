
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${path}/resources/css/mainStyles.css" rel="stylesheet" />
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script type="text/javascript">

			var path = "${pageContext.request.contextPath }";
			// var qustr = "${searchVO.qustr}";
	
			$(function(){
				$('input:button[name=button]').on('click',function(){
					var category = $(this).val();
					var order = $('select[name=order]').val();
					$.ajax({
						url : path+"/main",
						type:"get",
						headers: {"cache-control":"no-cache", "pragma": "no-cache"},
						data : {
			                "category":category,    // 버튼의 value값에 따라 작동합니다.
			                "order":order
			            },
			            success : function(data){
			                $('body').html(data);
			            },
			            error : function(data){
			                alert('error');
			            }//error
					});
				});
				
				$('#searchButton').on('click',function(){
					var keyword = $('input:text[name=keyword]').val();
					$.ajax({
						url : path+"/main",
						type:"get",
						headers: {"cache-control":"no-cache", "pragma": "no-cache"},
						data : {
			                "keyword":keyword
			            },
			            success : function(data){
			                $('body').html(data);
			            },
			            error : function(data){
			                alert('error');
			            }//error
					});
				});
			});
		</script>
		<style type="text/css">
		   .categoryButton{
	  			background-color:transparent;
	  			outline: 0;
	  			border: 0;
	  			margin-left: 30px;
  			}
  			section.py-5{
  				width: 1140px;
  				margin:0 auto
  			}
  			#search{
  				float:right;
  			}
  			#search input[name=keyword]{
  				width:300px;
  				border: 1px solid ;
  				border-radius: 30px;
  			}	
  			#searchBar{
  				padding-bottom: 20px;
  			}
  			select{
  				float:right;
  			}
  			.d-flex{
  				float:right;
  			}
  			.bi-person-fill,.bi-cart-fill,.bi-box-arrow-right{
	  			font-size: 30px;
	  			line-height: 30px; 
	  			color:#FF8F52;
	  			margin-right:20px;
  			}
		</style>
	</head>
	<body>
	        <!-- Navigation-->
	        <nav class="navbar navbar-expand-lg navbar-light bg-light">
	            <div class="container px-4 px-lg-5">
	                <a class="navbar-brand" href="http://localhost:8090/kickit/main"><img src="resources/img/KicIcon.png" style="width:100px;"/> </a>
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
	        <!-- Header-->
	        <header>
	            	<img src="resources/img/banner.jpg" style="width:100%"/>
	        </header>
	        <!-- Section-->
	        <section class="py-5">

	        	<div class="form-inline" id="searchBar">
					<input type="button" name="button" value="전체" class="categoryButton"/>
	                <input type="button" name="button" value="한식" class="categoryButton"/>
	                <input type="button" name="button" value="중식-일식" class="categoryButton"/>
	                <input type="button" name="button" value="베트남식" class="categoryButton"/>
	                <input type="button" name="button" value="양식" class="categoryButton"/>
	                <input type="button" name="button" value="건강한 식사" class="categoryButton"/>
	                <input type="button" name="button" value="기타" class="categoryButton"/>
	                <div class="form-inline" id="search">
		                <input type="text" name="keyword" value="">
		                <input type="button" id="searchButton" value="검색" class="btn btn btn-outline-dark mr-2"/>
	                </div>
	            </div>

	            <select class="form-select" name="order" style="width:150px;">
				    <option value="none">=== 선택 ===</option>
				    <option value="star desc">별점 구매순</option>
				    <option value="buy desc">최다 구매순</option>
				    <option value="rvCount desc">리뷰 많은 순</option>
				    <option value="price">가격이 낮은순</option>
				    <option value="price desc">가격이 높은순</option>
				</select>
	            <div class="container px-4 px-lg-5 mt-5">
	                <div id = "board" class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
	                    <c:forEach var="item" items="${items}">
		                    <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Product image-->
		                            <img class="card-img-top" src="resources/img/${item.file_name}" alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder"><c:out value="${item.item }"/></h5>
		                                    <!-- Product price-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
	                                   		</div>
		                                    <p><c:out value="${item.price}"/>원</p>
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
		                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="http://localhost:8090/kickit/content/info?item=${item.itemCode}">더보기</a></div>
		                            </div>
		                        </div>
		                    </div>
	                    </c:forEach>

	                </div>
	            </div>
	        </section>
	        <!-- Footer-->
	        <footer class="py-5 bg-dark">
	            <div class="container">
	            	<p class="m-0 text-center text-white">Copyright &copy; Kickit</p>
	            	<p class="m-0 text-center text-white">Tel) 02.538.3644</p>
	            	<p class="m-0 text-center text-white">Address) 28-5, Teheran-ro 1-gil, Gangnam-gu, Seoul, Republic of Korea</p>
	            	<p class="m-0 text-center text-white">Member) Yong-min Kang, il-kwon Yoon, ji-ji Yoon, So-yeong Park</p>
	            	</div>
	        </footer>
	        <!-- Bootstrap core JS-->
	        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	        <!-- Core theme JS-->
	        <script src="${path}/resources//js/mainScripts.js"></script>
	</body>
</html>