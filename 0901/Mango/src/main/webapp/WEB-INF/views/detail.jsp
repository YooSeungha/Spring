<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" %>

    <style type="text/css">
    main {
        min-width: 1200px;
    }
    .image {
        height: 100%;
        width: 100%;
        max-height: 250px;
    }
    .info {
        max-width: 1000px !important;
        min-height: 650px;
        max-height: 750px;
        place-content: center;
    }
    
    .banner {
        min-height: 530px;
        background-image: url("/static/imgs/banner1.png");
        background-size: cover;
        background-repeat: no-repeat;
        width: 250px !important;
        height: 530px !important;
        margin-top: 5% !important;
    }

    canvas { 
        height: 180px;
        max-height: 180px;
    }
    
    .card-text, badge {
        font-size: 0.8rem;
        margin-bottom: 10px;
    }
    
    .center {
        text-align: -webkit-center;
    }
    
    .left {
        text-align: -webkit-left;
    }
    
    .point {
        font-size: 2rem;
        color: darkorange;
    }
    
    .favorite {
        background-image: url("/static/imgs/favorite0.png");
        background-size: cover;
        background-repeat: no-repeat;
        width: 30px;
        height: 30px !important;
    }
    
    .favorite-clicked {
        background-image: url("/static/imgs/favorite1.png");
        background-size: cover;
        background-repeat: no-repeat;
        width: 30px;
        height: 30px !important;
    }
    
    .title {
        display: flex;
        align-items: center;
        justify-content: flex-start;
        max-width: 800px;
    }
    
    .chart {
        margin-top: 5% !important;
    }
    
    .img-middle {
        place-self: center;
    }
    
    .res-img {
        background-image: url("/static/imgs/restaurant/생각보다맛있는집.jpg");
        background-size: cover;
        background-repeat: no-repeat;
        min-height: 280px;
        background-clip: content-box;
    }
    @media(max-width:768px){
        .info {
            max-height: 100%;
            max-width: 650px !important;
        }
        .banner {
            display: none !important;
        }
        main {
            min-width: 0px;
        }
    }
    @media(max-width:576px){
        .banner {
            display: none !important;
        }
        .info {
            max-width: 500px !important;
        }
    }
</style>
<title>망고플래닛 - 식당정보</title>
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
		        <main><!--  -->
					<div class="container-fluid px-4">
					    
					    <div class="row con-center my-2">
					        <div class="row col-sm-10 col-md-9 m-5 info">
					            <h3 class="title my-4"><button class="btn favorite me-2" onclick="click_favorite(this)"></button>생각보다맛있는집 <span class="point mx-2">4.0</span>
					        
					            </h3>
					            <div class="row px-0">
					                <div class="col-md-4 p-2 res-img">
					
					                </div>
					                <div class="col-md-8 px-2 py-2 left">
					                <p class="badge bg-secondary mb-1">주소</p> 
					                <p class="card-text">서울특별시 관악구 관악로 152 서량빌딩</p>
					                <p class="badge bg-secondary mb-1">가격대</p> 
					                <p class="card-text">만원미만</p>
					                <p class="badge bg-secondary mb-1">전화</p> 
					                <p class="card-text text-muted">02-877-5717</p>
					                <p class="badge bg-secondary mb-1">메뉴</p> 
					                <div class="row">
					                    <div class="col-md-4">
					                        <span class="card-text">아메리카노</span>
					                        <span class="card-text text-muted">10,000원</span>
					                    </div>
					                    <div class="col-md-4">
					                        <span class="card-text">하노이쌀국수 (M)</span>
					                        <span class="card-text text-muted">8,000원</span>
					                    </div>
					                </div>
					                <div class="row">
					                    <div class="col-md-4">
					                        <span class="card-text">하노이쌀국수 (M)</span> 
					                        <span class="card-text text-muted">15,000원</span>
					                    </div>
					                    <div class="col-md-4">
					                        <span class="card-text">하노이쌀국수 (M)</span>
					                        <span class="card-text text-muted">9,000원</span>
					                    </div>
					                    <div class="col-md-4">
					                        <span class="card-text">하노이쌀국수 (M)</span>
					                        <span class="card-text text-muted">5,000원</span>
					                    </div>
					                </div>
					            </div>
					            </div>
					            <div class="row px-0">
					                <div class="col-md-4 px-2 chart">
					                    <img src="{% static '/imgs/map.png' %}" class="img rounded-start image" alt="...">
					                </div>
					                <div class="col-md-4 px-2 chart">
					                <div class="card">
					                    <div class="card-header">
					                        <i class="fas fa-chart-bar me-1"></i>
					                        Bar Chart Example
					                    </div>
					                    <div class="card-body"><canvas id="myBarChart" width="100%" height="100%"></canvas></div>
					                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
					                </div>
					                </div>
					                <div class="col-md-4 px-2 chart">
					                    <div class="card">
					                        <div class="card-header">
					                            <i class="fas fa-chart-pie me-1"></i>
					                            Pie Chart Example
					                        </div>
					                        <div class="card-body"><canvas id="myPieChart" width="100%" height="100%"></canvas></div>
					                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
					                    </div>
					                </div>
					            </div>
					        </div>
					        <div class="row col-sm-0 col-md-2 ms-5 banner">
					        </div>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/js/scripts.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<link href="/css/styles.css" rel="stylesheet" />
<link href="/css/index.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>

<script src='/assets/demo/chart-bar-demo.js'></script>
<script src='/assets/demo/chart-pie-demo.js'></script>

