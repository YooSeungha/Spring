<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
    <style type="text/css">
            html {
                height: 100%;
            }
            body {
                height: 100%;
            }
            .topbg {
                background-color: #0f5836 !important;
            }
            .menubg {
                background-color: #416049 !important;
            }
            .footbg {
                background-color: #0d3a25 !important;
            }
            .sub-title {
                font-size: 1rem;
                margin-left: 10px;
                color: gray;
            }
            .con-center {
                place-content: center;
            }
            .card-height {
                max-height: 120px !important;
            }
            @media(max-width:768px){
                .card-height {
                    max-height: 400px !important;
                }
            }
            @media(max-width:576px){
            }
            #wrap{
            	min-height: 100%;
            	position: relative;
            	padding-bottom: 60px;
            }
            footer{
           		position: relative; (absolute -> relative)
           		transform: translatY(-100%);
            }
        </style>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        
        <title>망고플래닛</title>

        
        <link rel="preconnect" href="https://fonts.googleapis.com">
    	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    	<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="/css/styles.css" rel="stylesheet" />
        <link href="/css/index.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
	<body class="sb-nav-fixed">
		<nav class="sb-topnav navbar navbar-expand navbar-dark topbg">
		    <!-- Navbar Brand-->
		    <a class="navbar-brand ps-3 mango-logo" href="/">
		        <span><img src="{% static '/imgs/logo.png' %}" alt="logo" width="30" height="24"/>
		            <span class="mango-text">망고플래닛</span>
		        </span>
	    	</a>
    	<!-- Sidebar Toggle-->
    	<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
            class="fas fa-bars"></i></button>
    	<!-- Navbar Search-->
	    <form class="d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0 center"
	          method="GET" action="">
	        <div class="input-group mango-search">
	            <input class="form-control" type="text" placeholder="검색" aria-label="검색"
	                   aria-describedby="btnNavbarSearch" name="key"/>
	            <button class="btn btn-warning" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
	        </div>
	    </form>
	    <!-- Navbar-->
	    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
	        <li class="nav-item dropdown">
	            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
	               aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
	            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
	                <li>
	                    <hr class="dropdown-divider"/>
	                </li>
	                <li><a class="dropdown-item" href="{% url 'chart:favors' %}">즐겨찾기</a></li>
	                <li><a class="dropdown-item" href="{% url 'member:logout' %}">로그아웃</a></li>
	                <li><a class="dropdown-item" href="{% url 'member:login' %}">로그인</a></li>
	            </ul>
	        </li>
	    </ul>
		</nav>
		<div id="layoutSidenav">
		    <div id="layoutSidenav_nav">
		        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
		            <div class="sb-sidenav-menu menubg">
		                <div class="nav">
		                    <div class="sb-sidenav-menu-heading">list</div>
		                    <a class="nav-link enlarge" href="{% url 'chart:index' %}">
		                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
		                       	 식당목록
		                    </a>
		                    <a class="nav-link enlarge" href="{% url 'chart:guide' %}">
		                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
		                        	이용가이드
		                    </a>
		                    <div class="sb-sidenav-menu-heading">Member Only</div>
		                    <a class="nav-link enlarge" href="{% url 'chart:favors' %}">
		                        <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
		                        	즐겨찾기
		                    </a>
		                    <a class="nav-link enlarge" href="{% url 'member:opinion' %}">
		                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
		                        	문의하기
		                    </a>
		                </div>
		            </div>
		       </nav>
		   </div>
		    <div id="layoutSidenav_content">
		        <main>
		            <div class="container-fluid p-0 col-xl-10">
		                <div class="row con-center">
		                    <div class="row m-5">
		                        <ul class=" justify-content-center m-0 p-3 pb-0">
		                            <h3 class="mt-4 mb-0 ms-2"style="text-align: center">식당목록<span class="sub-title">Restaurant List</span></h3>
		                        </ul>
		                    </div>
		                </div>

		             <div class="row p-4 g-3 m-0">
                           <c:forEach var="i" begin="1" end="12" step="1">
                            <div class="col-6 col-lg-4">
                                <a href="detail.do" class="row p-0 mx-0 border h-100 link-none">
                                    <div class="col-md-4 px-0">
                                       <!--  <img src="{% get_static_prefix %}imgs/restaurant/{{name}}.jpg"
                                             class="img-fluid rounded-start card-height" alt="..." style="height:100%" onerror="this.src='/static/imgs/no-image.png'"> -->
                                    </div>
                                    <div class="col-md-8">
                                        <div class="card-body px-2 py-1 align-middle">
                                            <h5 class="card-title m-0 pt-2 pb-1
                                                               ">식당이름</h5>
                                            <p class="card-text py-1">식당주소</p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            </c:forEach>
                        </div>
                     </div> 
		        </main>
		         <footer class="py-4 mt-auto topbg">
		            <div class="container-fluid px-4">
		                <div class="d-flex align-items-center justify-content-between small">
		                    <div class="text-white">Copyright &copy; Mango Planet 2022</div>
		                </div>	
		            </div>
		        </footer>	
		    </div>
		  </div>
		 </body>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
		<script src="/js/scripts.js"></script>

		</html>