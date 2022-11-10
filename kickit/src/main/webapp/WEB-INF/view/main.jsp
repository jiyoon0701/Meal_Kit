<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
			                "category":category,    // ��ư�� value���� ���� �۵��մϴ�.
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
	</head>
	<body>
	        <!-- Navigation-->
	        <nav class="navbar navbar-expand-lg navbar-light bg-light">
	            <div class="container px-4 px-lg-5">
	                <a class="navbar-brand" href="#!">Start Bootstrap</a>
	                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
	                <div class="collapse navbar-collapse" id="navbarSupportedContent">
	                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
	                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
	                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
	                        <li class="nav-item dropdown">
	                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
	                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	                                <li><a class="dropdown-item" href="#!">All Products</a></li>
	                                <li><hr class="dropdown-divider" /></li>
	                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
	                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
	                            </ul>
	                        </li>
	                    </ul>
	                    <form class="d-flex">
	                    	<ul class="user-area_menu">
	                    		<li>
		                    		<a href="http://localhost:8090/kickit/users/login">�α���</a>
		                    	</li>
		                    	<li>
		                    		<a href="http://localhost:8090/kickit/users/signup">ȸ������</a>
	                    		</li>
	                    	</ul>
	                        <button class="btn btn-outline-dark" type="submit">
	                            <i class="bi-cart-fill me-1"></i>
	                            Cart
	                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
	                        </button>
	                    </form>
	                </div>
	            </div>
	        </nav>
	        <!-- Header-->
	        <header class="bg-dark py-5">
	            <div class="container px-4 px-lg-5 my-5">
	                <div class="text-center text-white">
	                    <h1 class="display-4 fw-bolder">Shop in style</h1>
	                    <p class="lead fw-normal text-white-50 mb-0">With this shop hompeage template</p>
	                </div>
	            </div>
	        </header>
	        <!-- Section-->
	        <section class="py-5">
	        	<div class="form-inline">
					<input type="button" name="button" value="��ü" class="btn btn btn-primary btn-bg"/>
	                <input type="button" name="button" value="�ѽ�" class="btn btn btn-primary btn-bg"/>
	                <input type="button" name="button" value="�߽�-�Ͻ�" class="btn btn btn-primary btn-bg"/>
	                <input type="button" name="button" value="��Ʈ����" class="btn btn btn-primary btn-bg"/>
	                <input type="button" name="button" value="���" class="btn btn btn-primary btn-bg"/>
	                <input type="button" name="button" value="�ǰ��� �Ļ�" class="btn btn btn-primary btn-bg"/>
	                <input type="button" name="button" value="��Ÿ" class="btn btn btn-primary btn-bg"/>
	            </div>
	            <div class="form-inline">
	            	<input type="text" name="keyword" value="">
	                <input type="button" id="searchButton" value="�˻�" class="btn btn btn-outline-primary mr-2"/>
	            </div>
	            
	            <div class="container px-4 px-lg-5 mt-5">
		            <select name="order" >
						    <option value="none">=== ���� ===</option>
						    <option value="star desc">���� ���ż�</option>
						    <option value="buy desc">�ִ� ���ż�</option>
						    <option value="rvCount desc">���� ���� ��</option>
						    <option value="price">������ ������</option>
						    <option value="price desc">������ ������</option>
					</select>
	                <div id = "board" class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
	                    <c:forEach var="item" items="${items}">
		                    <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Product image-->
		                            <img class="card-img-top" src="${item.file_name}" alt="..." />
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
		                                    <p><c:out value="${item.price}"/>��</p>
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
		                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="http://localhost:8090/kickit/content/info?item=${item.itemCode}">������</a></div>
		                            </div>
		                        </div>
		                    </div>
	                    </c:forEach>

	                </div>
	            </div>
	        </section>
	        <!-- Footer-->
	        <footer class="py-5 bg-dark">
	            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Kickit</p></div>
	        </footer>
	        <!-- Bootstrap core JS-->
	        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	        <!-- Core theme JS-->
	        <script src="${path}/resources//js/mainScripts.js"></script>
	</body>
	

</html>