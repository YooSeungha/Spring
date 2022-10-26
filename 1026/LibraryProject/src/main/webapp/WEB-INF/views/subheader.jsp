<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <!-- 부트스트랩 아이콘 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
     	
	<script src="https://kit.fontawesome.com/d894d6e4a2.js" crossorigin="anonymous"></script>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   
    
   <!-- CSS Implementing Plugins -->
   <link rel="stylesheet" href="/vendor/font-awesome/css/fontawesome-all.min.css">
   <link rel="stylesheet" href="/vendor/flaticon/font/flaticon.css">
   <link rel="stylesheet" href="/vendor/animate.css/animate.css">
   <link rel="stylesheet" href="/vendor/bootstrap-select/dist/css/bootstrap-select.min.css">
   <link rel="stylesheet" href="/vendor/slick-carousel/slick/slick.css"/>
   <link rel="stylesheet" href="/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">

   <!-- CSS Bookworm Template -->
   <link rel="stylesheet" href="/css/theme.css">
   
   <!-- JQuery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="http://code.jquery.com/jquery-1.9.1.js" type="text/javascript"></script>

 	 <!-- CSS Bookworm Template -->
  <link rel="stylesheet" href="/css/theme.css">
</head>
   <!--===== HEADER CONTENT =====-->
<body>
   <header id="site-header" class="site-header__v1">
        <div class="topbar border-bottom d-none d-md-block">
            <div class="container-fluid px-2 px-md-5 px-xl-8d75">
                <div class="topbar__nav d-md-flex justify-content-between align-items-center">
                    <ul class="topbar__nav--left nav ml-md-n3">
                        <li class="nav-item"><a href="#" class="nav-link link-black-100"><i class="glph-icon flaticon-question mr-2"></i>도움이 필요하십니까?</a></li>
                        <li class="nav-item"><a href="tel:+010-6555-7022" class="nav-link link-black-100"><i class="glph-icon flaticon-phone mr-2"></i>+82 010-6555-7022</a></li>
                    </ul>
                    <ul class="topbar__nav--right nav mr-md-n3">
                        <!-- <li class="nav-item"><a href="#" class="nav-link link-black-100"><i class="glph-icon flaticon-pin"></i></a></li>
                        <li class="nav-item"><a href="#" class="nav-link link-black-100"><i class="glph-icon flaticon-switch"></i></a></li>
                        <li class="nav-item"><a href="#" class="nav-link link-black-100"><i class="glph-icon flaticon-heart"></i></a></li> -->
 
                        <c:choose>
	                        <c:when test="${empty member}">
		                        <li class="nav-item">
		                            <!-- Account Sidebar Toggle Button -->
		                            <a id="sidebarNavToggler" href="javascript:;" role="button" onclick="loginNaver()" class="nav-link link-black-100"
		                                aria-controls="sidebarContent"
		                                aria-haspopup="true"
		                                aria-expanded="false"
		                                data-unfold-event="click"
		                                data-unfold-hide-on-scroll="false"
		                                data-unfold-target="#sidebarContent"
		                                data-unfold-type="css-animation"
		                                data-unfold-overlay='{
		                                    "className": "u-sidebar-bg-overlay",
		                                    "background": "rgba(0, 0, 0, .7)",
		                                    "animationSpeed": 500
		                                }'
		                                data-unfold-animation-in="fadeInRight"
		                                data-unfold-animation-out="fadeOutRight"
		                                data-unfold-duration="500">
		                                <i class="glph-icon flaticon-user"></i>
		                            </a>
		                            <!-- End Account Sidebar Toggle Button -->
		                        </li>
	                        </c:when>
		                    <c:otherwise>
		                    	 <li class="nav-item">
		                            <!-- Account Sidebar Toggle Button -->
		                            <a id="sidebarNavToggler" href="javascript:;" role="button" class="nav-link link-black-100"
		                                aria-controls="sidebarContent"
		                                aria-haspopup="true"
		                                aria-expanded="false"
		                                data-unfold-event="click"
		                                data-unfold-hide-on-scroll="false"
		                                data-unfold-target="#sidebarMypage"
		                                data-unfold-type="css-animation"
		                                data-unfold-overlay='{
		                                    "className": "u-sidebar-bg-overlay",
		                                    "background": "rgba(0, 0, 0, .7)",
		                                    "animationSpeed": 500
		                                }'
		                                data-unfold-animation-in="fadeInRight"
		                                data-unfold-animation-out="fadeOutRight"
		                                data-unfold-duration="500">
		                                <!-- <i class="glph-icon flaticon-user"></i> -->
		                                <i class="fa-regular fa-user" style="color:#0e306c;font-size:20px;"></i>
		                            </a>
		                            <!-- End Account Sidebar Toggle Button -->
		                        </li>
		                    
		                    </c:otherwise>
	                    </c:choose>
                        <li class="nav-item">
                            <!-- Cart Sidebar Toggle Button -->
                            <a id="sidebarNavToggler1" href="javascript:;" role="button" class="nav-link link-black-100 position-relative"
                                aria-controls="sidebarContent1"
                                aria-haspopup="true"
                                aria-expanded="false"
                                data-unfold-event="click"
                                data-unfold-hide-on-scroll="false"
                                data-unfold-target="#sidebarContent1"
                                data-unfold-type="css-animation"
                                data-unfold-overlay='{
                                    "className": "u-sidebar-bg-overlay",
                                    "background": "rgba(0, 0, 0, .7)",
                                    "animationSpeed": 500
                                }'
                                data-unfold-animation-in="fadeInRight"
                                data-unfold-animation-out="fadeOutRight"
                                data-unfold-duration="500">
                                <!-- <span class="position-absolute bg-dark width-16 height-16 rounded-circle d-flex align-items-center justify-content-center text-white font-size-n9 right-0">3</span> -->
                                <!-- <i class="glph-icon flaticon-heart"></i> -->
                                <i class="fa-sharp fa-solid fa-heart" style="color:#0e306c;font-size:20px;"></i>
                            </a>
                            <!-- End Cart Sidebar Toggle Button -->
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        
        	
        	
        <div class="masthead border-bottom position-relative" style="margin-bottom: -1px;">
            <div class="container-fluid px-3 px-md-5 px-xl-8d75 py-2 py-md-0">
                <div class="d-flex align-items-center position-relative flex-wrap">
                    <c:choose>
        				<c:when test="${member.mem_grade<2 }">
		                    <div class="offcanvas-toggler mr-4 mr-lg-8">
		                        <a id="sidebarNavToggler2" href="javascript:;" role="button" class="cat-menu"
		                        aria-controls="sidebarContent2"
		                        aria-haspopup="true"
		                        aria-expanded="false"
		                        data-unfold-event="click"
		                        data-unfold-hide-on-scroll="false"
		                        data-unfold-target="#sidebarContent2"
		                        data-unfold-type="css-animation"
		                        data-unfold-overlay='{
		                            "className": "u-sidebar-bg-overlay",
		                            "background": "rgba(0, 0, 0, .7)",
		                            "animationSpeed": 100
		                        }'
		                        data-unfold-animation-in="fadeInLeft"
		                        data-unfold-animation-out="fadeOutLeft"
		                        data-unfold-duration="100">
		                            <svg width="20px" height="18px">
		                                <path fill-rule="evenodd"  fill="rgb(25, 17, 11)" d="M-0.000,-0.000 L20.000,-0.000 L20.000,2.000 L-0.000,2.000 L-0.000,-0.000 Z"/>
		                                <path fill-rule="evenodd"  fill="rgb(25, 17, 11)" d="M-0.000,8.000 L15.000,8.000 L15.000,10.000 L-0.000,10.000 L-0.000,8.000 Z"/>
		                                <path fill-rule="evenodd"  fill="rgb(25, 17, 11)" d="M-0.000,16.000 L20.000,16.000 L20.000,18.000 L-0.000,18.000 L-0.000,16.000 Z"/>
		                            </svg>
		                        </a>
		                    </div>
			        	</c:when>
			        	<c:otherwise>
			        		<div class="offcanvas-toggler mr-4 mr-lg-8">
		                        <a id="sidebarNavToggler3" href="javascript:;" role="button" class="cat-menu"
		                        aria-controls="sidebarContent2"
		                        aria-haspopup="true"
		                        aria-expanded="false"
		                        data-unfold-event="click"
		                        data-unfold-hide-on-scroll="false"
		                        data-unfold-target="#sidebarContent3"
		                        data-unfold-type="css-animation"
		                        data-unfold-overlay='{
		                            "className": "u-sidebar-bg-overlay",
		                            "background": "rgba(0, 0, 0, .7)",
		                            "animationSpeed": 100
		                        }'
		                        data-unfold-animation-in="fadeInLeft"
		                        data-unfold-animation-out="fadeOutLeft"
		                        data-unfold-duration="100">
		                            <svg width="20px" height="18px">
		                                <path fill-rule="evenodd"  fill="rgb(25, 17, 11)" d="M-0.000,-0.000 L20.000,-0.000 L20.000,2.000 L-0.000,2.000 L-0.000,-0.000 Z"/>
		                                <path fill-rule="evenodd"  fill="rgb(25, 17, 11)" d="M-0.000,8.000 L15.000,8.000 L15.000,10.000 L-0.000,10.000 L-0.000,8.000 Z"/>
		                                <path fill-rule="evenodd"  fill="rgb(25, 17, 11)" d="M-0.000,16.000 L20.000,16.000 L20.000,18.000 L-0.000,18.000 L-0.000,16.000 Z"/>
		                            </svg>
		                        </a>
		                    </div>
			        	</c:otherwise>
			        </c:choose>
                    
                    
                    
                    
                    <div class="site-branding pr-md-4">
                        <a href="/" class="d-block mb-1">
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="170px" height="30px">
                                <path fill-rule="evenodd" fill="rgb(25, 17, 11)"
                                d="M166.225,28.691 L165.065,15.398 L160.598,28.691 L158.229,28.691 L153.762,15.398 L152.590,28.691 L148.928,28.691 L150.405,11.052 L155.629,11.052 L159.389,22.124 L163.198,11.052 L168.422,11.052 L169.875,28.691 L166.225,28.691 ZM142.641,28.691 L138.051,20.928 L136.989,20.928 L136.989,28.691 L133.327,28.691 L133.327,11.052 L139.724,11.052 C140.692,11.052 141.546,11.189 142.287,11.461 C143.028,11.734 143.620,12.112 144.063,12.596 C144.507,13.081 144.840,13.636 145.064,14.263 C145.288,14.889 145.400,15.577 145.400,16.326 C145.400,17.506 145.078,18.472 144.436,19.225 C143.793,19.978 142.869,20.484 141.665,20.745 L146.975,28.691 L142.641,28.691 ZM141.896,16.204 C141.896,15.544 141.673,15.028 141.225,14.653 C140.777,14.279 140.086,14.092 139.150,14.092 L136.989,14.092 L136.989,18.303 L139.150,18.303 C140.981,18.303 141.896,17.603 141.896,16.204 ZM125.570,27.831 C124.206,28.567 122.666,28.936 120.949,28.936 C119.224,28.936 117.680,28.567 116.317,27.831 C114.953,27.094 113.881,26.034 113.100,24.651 C112.319,23.267 111.928,21.672 111.928,19.866 C111.928,18.051 112.319,16.454 113.100,15.074 C113.881,13.695 114.953,12.639 116.317,11.907 C117.680,11.174 119.224,10.808 120.949,10.808 C122.674,10.808 124.217,11.174 125.576,11.907 C126.935,12.639 128.005,13.695 128.786,15.074 C129.567,16.454 129.958,18.051 129.958,19.866 C129.958,21.672 129.567,23.267 128.786,24.651 C128.005,26.034 126.933,27.094 125.570,27.831 ZM124.807,15.715 C123.797,14.690 122.512,14.177 120.949,14.177 C119.387,14.177 118.101,14.690 117.092,15.715 C116.083,16.741 115.578,18.124 115.578,19.866 C115.578,21.616 116.083,23.005 117.092,24.034 C118.101,25.064 119.387,25.579 120.949,25.579 C122.512,25.579 123.797,25.064 124.807,24.034 C125.816,23.005 126.320,21.616 126.320,19.866 C126.320,18.124 125.816,16.741 124.807,15.715 ZM66.872,28.691 L61.391,21.196 L60.097,21.196 L60.097,28.691 L56.435,28.691 L56.435,11.052 L60.097,11.052 L60.097,17.986 L61.342,17.986 L66.872,11.052 L71.340,11.052 L64.504,19.487 L71.547,28.691 L66.872,28.691 ZM48.677,27.831 C47.314,28.567 45.774,28.936 44.057,28.936 C42.332,28.936 40.788,28.567 39.425,27.831 C38.061,27.094 36.989,26.034 36.208,24.651 C35.427,23.267 35.036,21.672 35.036,19.866 C35.036,18.051 35.427,16.454 36.208,15.074 C36.989,13.695 38.061,12.639 39.425,11.907 C40.788,11.174 42.332,10.808 44.057,10.808 C45.782,10.808 47.324,11.174 48.684,11.907 C50.043,12.639 51.113,13.695 51.894,15.074 C52.675,16.454 53.066,18.051 53.066,19.866 C53.066,21.672 52.675,23.267 51.894,24.651 C51.113,26.034 50.040,27.094 48.677,27.831 ZM47.915,15.715 C46.905,14.690 45.620,14.177 44.057,14.177 C42.495,14.177 41.209,14.690 40.200,15.715 C39.191,16.741 38.686,18.124 38.686,19.866 C38.686,21.616 39.191,23.005 40.200,24.034 C41.209,25.064 42.495,25.579 44.057,25.579 C45.620,25.579 46.905,25.064 47.915,24.034 C48.924,23.005 49.428,21.616 49.428,19.866 C49.428,18.124 48.924,16.741 47.915,15.715 ZM28.487,27.831 C27.124,28.567 25.584,28.936 23.867,28.936 C22.141,28.936 20.597,28.567 19.234,27.831 C17.871,27.094 16.799,26.034 16.018,24.651 C15.236,23.267 14.846,21.672 14.846,19.866 C14.846,18.051 15.236,16.454 16.018,15.074 C16.799,13.695 17.871,12.639 19.234,11.907 C20.597,11.174 22.141,10.808 23.867,10.808 C25.592,10.808 27.134,11.174 28.493,11.907 C29.852,12.639 30.922,13.695 31.704,15.074 C32.485,16.454 32.875,18.051 32.875,19.866 C32.875,21.672 32.485,23.267 31.704,24.651 C30.922,26.034 29.850,27.094 28.487,27.831 ZM27.724,15.715 C26.715,14.690 25.429,14.177 23.867,14.177 C22.304,14.177 21.018,14.690 20.009,15.715 C19.000,16.741 18.496,18.124 18.496,19.866 C18.496,21.616 19.000,23.005 20.009,24.034 C21.018,25.064 22.304,25.579 23.867,25.579 C25.429,25.579 26.715,25.064 27.724,24.034 C28.733,23.005 29.238,21.616 29.238,19.866 C29.238,18.124 28.733,16.741 27.724,15.715 ZM11.672,27.367 C10.736,28.250 9.361,28.691 7.546,28.691 L0.283,28.691 L0.283,11.052 L5.996,11.052 C7.875,11.052 9.314,11.478 10.311,12.328 C11.308,13.178 11.806,14.365 11.806,15.886 C11.806,16.676 11.633,17.374 11.287,17.980 C10.941,18.586 10.431,19.052 9.755,19.377 C11.969,19.988 13.076,21.445 13.076,23.748 C13.076,25.278 12.608,26.484 11.672,27.367 ZM7.827,14.647 C7.420,14.277 6.821,14.092 6.032,14.092 L3.811,14.092 L3.811,18.242 L6.191,18.242 C6.940,18.242 7.501,18.047 7.875,17.656 C8.250,17.266 8.437,16.753 8.437,16.118 C8.437,15.508 8.233,15.018 7.827,14.647 ZM8.876,21.709 C8.445,21.278 7.749,21.062 6.789,21.062 L3.811,21.062 L3.811,25.554 L6.862,25.554 C7.782,25.554 8.455,25.347 8.883,24.932 C9.310,24.517 9.523,23.988 9.523,23.345 C9.523,22.686 9.308,22.140 8.876,21.709 Z" />
                                <path class="fill-primary" fill-rule="evenodd"
                                d="M105.996,23.499 C105.995,26.752 103.950,29.265 100.748,29.950 C100.713,29.958 100.681,29.983 100.647,30.000 C100.588,30.000 100.529,30.000 100.471,30.000 C100.467,28.585 100.460,27.171 100.466,25.756 C100.467,25.675 100.550,25.565 100.626,25.518 C101.352,25.068 101.714,24.425 101.711,23.571 C101.707,22.020 101.710,20.469 101.710,18.892 C103.133,18.892 104.546,18.892 105.996,18.892 C105.996,18.989 105.996,19.093 105.996,19.196 C105.996,20.630 105.997,22.065 105.996,23.499 ZM101.715,17.089 C101.715,15.990 101.683,14.917 101.724,13.847 C101.767,12.679 102.761,11.806 103.931,11.838 C105.060,11.869 105.978,12.794 105.993,13.940 C106.005,14.954 105.995,15.969 105.995,16.983 C105.995,17.011 105.987,17.040 105.980,17.089 C104.569,17.089 103.157,17.089 101.715,17.089 ZM96.421,29.234 C94.322,27.983 93.199,26.136 93.155,23.703 C93.108,21.138 93.145,18.571 93.146,16.005 C93.146,15.957 93.153,15.910 93.159,15.841 C94.572,15.841 95.976,15.841 97.426,15.841 C97.426,15.948 97.426,16.060 97.426,16.172 C97.426,18.602 97.430,21.031 97.423,23.461 C97.421,24.364 97.757,25.066 98.548,25.540 C98.629,25.589 98.688,25.740 98.689,25.844 C98.699,27.122 98.695,28.401 98.696,29.679 C98.696,29.786 98.703,29.893 98.707,30.000 C98.648,30.000 98.590,30.000 98.531,30.000 C97.799,29.823 97.075,29.624 96.421,29.234 ZM93.145,14.043 C93.145,13.935 93.145,13.823 93.145,13.711 C93.145,11.318 93.137,8.926 93.149,6.534 C93.154,5.625 92.818,4.928 92.023,4.460 C91.961,4.424 91.894,4.332 91.894,4.265 C91.886,2.850 91.888,1.436 91.888,0.000 C93.423,0.232 94.703,0.889 95.731,2.009 C96.833,3.209 97.413,4.630 97.421,6.261 C97.433,8.791 97.426,11.319 97.427,13.849 C97.427,13.906 97.421,13.964 97.416,14.043 C96.005,14.043 94.599,14.043 93.145,14.043 ZM89.588,4.782 C89.034,5.128 88.866,5.768 88.868,6.431 C88.875,8.061 88.870,9.692 88.869,11.322 C88.869,12.143 88.869,12.963 88.867,13.783 C88.867,13.869 88.857,13.954 88.851,14.051 C87.434,14.051 86.035,14.051 84.587,14.051 C84.587,13.958 84.587,13.866 84.587,13.774 C84.588,11.294 84.579,8.814 84.590,6.334 C84.605,3.158 86.853,0.543 90.000,0.018 C90.028,0.013 90.058,0.017 90.125,0.017 C90.125,0.639 90.125,1.243 90.125,1.848 C90.125,2.405 90.109,2.962 90.130,3.518 C90.149,4.032 90.126,4.447 89.588,4.782 ZM84.585,15.837 C86.015,15.837 87.420,15.837 88.868,15.837 C88.868,15.951 88.868,16.065 88.868,16.179 C88.868,18.608 88.849,21.039 88.873,23.468 C88.908,27.007 86.358,29.493 83.589,29.955 C83.552,29.961 83.518,29.985 83.482,30.000 C83.424,30.000 83.365,30.000 83.306,30.000 C83.310,28.634 83.319,27.268 83.313,25.902 C83.311,25.691 83.376,25.580 83.559,25.467 C84.268,25.031 84.587,24.371 84.587,23.549 C84.587,21.099 84.586,18.650 84.585,16.201 C84.585,16.085 84.585,15.970 84.585,15.837 ZM81.366,30.000 C80.875,29.844 80.360,29.740 79.897,29.524 C77.435,28.380 76.120,26.440 76.027,23.732 C75.974,22.192 76.017,20.649 76.016,19.107 C76.016,19.040 76.016,18.973 76.016,18.886 C77.447,18.886 78.859,18.886 80.303,18.886 C80.303,19.000 80.303,19.104 80.303,19.209 C80.303,20.663 80.308,22.117 80.302,23.571 C80.298,24.427 80.666,25.065 81.387,25.518 C81.463,25.566 81.547,25.675 81.547,25.756 C81.553,27.171 81.546,28.585 81.542,30.000 C81.484,30.000 81.425,30.000 81.366,30.000 ZM76.017,17.097 C76.017,16.540 76.017,15.997 76.017,15.453 C76.017,14.965 76.012,14.478 76.017,13.990 C76.030,12.831 76.911,11.892 78.032,11.838 C79.203,11.781 80.217,12.619 80.282,13.797 C80.341,14.885 80.294,15.978 80.294,17.097 C78.857,17.097 77.452,17.097 76.017,17.097 Z" />
                            </svg>
                        </a>
                    </div>
                    <div class="site-navigation mr-auto d-none d-xl-block">
                        <ul class="nav">
                            <li class="nav-item dropdown">
                                <a id="homeDropdownInvoker" href="#" class="dropdown-toggle nav-link link-black-100 mx-4 px-0 py-5 font-weight-medium d-flex align-items-center"
                                    aria-haspopup="true"
                                    aria-expanded="false"
                                    data-unfold-event="hover"
                                    data-unfold-target="#homeDropdownMenu"
                                    data-unfold-type="css-animation"
                                    data-unfold-duration="200"
                                    data-unfold-delay="50"
                                    data-unfold-hide-on-scroll="true"
                                    data-unfold-animation-in="slideInUp"
                                    data-unfold-animation-out="fadeOut">
                                    열람실&nbsp;<i class="fa-solid fa-chevron-down"></i>
                                </a>
                                <ul id="homeDropdownMenu" class="dropdown-unfold dropdown-menu font-size-2 rounded-0 border-gray-900" aria-labelledby="homeDropdownInvoker">
                                    <li><a href="javascript:void(0);" class="dropdown-item link-black-100" onclick="rezSave()">예약</a></li>
                                    <script>
                                     	var rezSave = () => {
                                     		if(${!empty member}){
                                     			location.href= "/rez"
                                     		}else {
                                     			alert("로그인이 필요한 서비스 입니다.")
                                     			//location.href="/"
                                     		}
                                     	}
                                    </script>
                                    <!-- <li><a href="../home/home-v2.html" class="dropdown-item link-black-100">Home v2</a></li>
                                    <li><a href="../home/home-v3.html" class="dropdown-item link-black-100">Home v3</a></li> -->
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a id="shopDropdownInvoker" href="#" class="dropdown-toggle nav-link link-black-100 mx-4 px-0 py-5 font-weight-medium d-flex align-items-center"
                                    aria-haspopup="true"
                                    aria-expanded="false"
                                    data-unfold-event="hover"
                                    data-unfold-target="#shopDropdownMenu"
                                    data-unfold-type="css-animation"
                                    data-unfold-duration="200"
                                    data-unfold-delay="50"
                                    data-unfold-hide-on-scroll="true"
                                    data-unfold-animation-in="slideInUp"
                                    data-unfold-animation-out="fadeOut">
                                    도서&nbsp;<i class="fa-solid fa-chevron-down"></i>
                                </a>
                                <ul id="shopDropdownMenu" class="dropdown-unfold dropdown-menu font-size-2 rounded-0 border-gray-900" aria-labelledby="shopDropdownInvoker">
                                    <li><a href="/library/category/book?catgoId=0&page=1&show=12" class="dropdown-item link-black-100">전체</a></li>
                                        <li><a href="/library/category/book?catgoId=1&page=1&show=12" class="dropdown-item link-black-100">소설(국내)</a></li>
                                        <li><a href="/library/category/book?catgoId=2&page=1&show=12" class="dropdown-item link-black-100">에세이(국내)</a></li>
                                        <li><a href="/library/category/book?catgoId=3&page=1&show=12" class="dropdown-item link-black-100">과학(국내)</a></li>
                                        <li><a href="/library/category/book?catgoId=4&page=1&show=12" class="dropdown-item link-black-100">인문학(국내)</a></li>
                                        <li><a href="/library/category/book?catgoId=5&page=1&show=12" class="dropdown-item link-black-100">예술/대중문화(국내)</a></li>
                                        <li><a href="/library/category/book?catgoId=6&page=1&show=12" class="dropdown-item link-black-100">소설(외국)</a></li>
                                        <li><a href="/library/category/book?catgoId=7&page=1&show=12" class="dropdown-item link-black-100">어린이(외국)</a></li>
                                        <li><a href="/library/category/book?catgoId=8&page=1&show=12" class="dropdown-item link-black-100">일본도서(외국)</a></li>
                                        <li><a href="/library/category/book?catgoId=9&page=1&show=12" class="dropdown-item link-black-100">과학(외국)</a></li>
                                        <li><a href="/library/category/book?catgoId=10&page=1&show=12" class="dropdown-item link-black-100">예술/대중문화(외국)</a></li>
                                        <li><a href="/library/category/dvd?page=1&show=12" class="dropdown-item link-black-100">DVD</a></li>
                                </ul>
                            </li>
                            
                            <li class="nav-item dropdown">
                                <a id="blogDropdownInvoker" href="#" class="dropdown-toggle nav-link link-black-100 mx-4 px-0 py-5 font-weight-medium d-flex align-items-center"
                                    aria-haspopup="true"
                                    aria-expanded="false"
                                    data-unfold-event="hover"
                                    data-unfold-target="#blogDropdownMenu"
                                    data-unfold-type="css-animation"
                                    data-unfold-duration="200"
                                    data-unfold-delay="50"
                                    data-unfold-hide-on-scroll="true"
                                    data-unfold-animation-in="slideInUp"
                                    data-unfold-animation-out="fadeOut">
                                    게시판&nbsp;<i class="fa-solid fa-chevron-down"></i>
                                </a>
                                <ul id="blogDropdownMenu" class="dropdown-unfold dropdown-menu font-size-2 rounded-0 border-gray-900" aria-labelledby="blogDropdownInvoker">
                                    <li><a href="/others/PBoard" class="dropdown-item link-black-100">공지사항</a></li>
                                    <li><a href="/others/read.do" class="dropdown-item link-black-100">자유게시판</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>

                    <ul class="d-md-none nav mr-md-n3 ml-auto">
                        <li class="nav-item">
                            <!-- Account Sidebar Toggle Button - Mobile -->
                            <a id="sidebarNavToggler9" href="javascript:;" role="button" class="px-2 nav-link link-black-100"
                                aria-controls="sidebarContent9"
                                aria-haspopup="true"
                                aria-expanded="false"
                                data-unfold-event="click"
                                data-unfold-hide-on-scroll="false"
                                data-unfold-target="#sidebarContent9"
                                data-unfold-type="css-animation"
                                data-unfold-overlay='{
                                    "className": "u-sidebar-bg-overlay",
                                    "background": "rgba(0, 0, 0, .7)",
                                    "animationSpeed": 500
                                }'
                                data-unfold-animation-in="fadeInRight"
                                data-unfold-animation-out="fadeOutRight"
                                data-unfold-duration="500">
                                <i class="glph-icon flaticon-user"></i>
                            </a>
                            <!-- End Account Sidebar Toggle Button - Mobile -->
                        </li>
                    </ul>
                    
                    <script>
						jQuery(function($) {
							$("#search").keydown(function(e) {		// 메인 페이지 중간 검색어 입력박스 엔터-키 처리
								if (e.keyCode == 13) {
									$("#search_button").trigger( "click" );
								}
							});
							$("#search_button").click(function(e) {					// 메인 페이지 검색어 입력박스 옆 전송버튼 클릭시
								let terms = $("#search").val().trim();								
								if (terms == '') {
									alert("검색어를 입력하세요.");
									return false;
								}
								var show = sessionStorage.getItem("show");
								if(sessionStorage.getItem("show")==null){
									show = 12;
								}
								$(location).attr('href', "/search/book?&type=1&keyword="+terms+"&page=1");
								return false;
							});
						});
					</script>

                    <div class="site-search ml-xl-0 ml-md-auto w-r-100 my-2 my-xl-0">
                        <form class="form-inline">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <i class="glph-icon flaticon-loupe input-group-text py-2d75 bg-white-100 border-white-100"></i>
                                </div>
                                <input id="search" class="form-control bg-white-100 min-width-380 py-2d75 height-4 border-white-100" type="search" placeholder="통합검색 - 검색어를 입력하세요" aria-label="Search" autocomplete="off">
                            </div>
                            <button id="search_button" class="btn btn-outline-success my-2 my-sm-0 sr-only" type="submit">검색</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </header>


    <!-- Account Sidebar Navigation - Desktop -->
    <aside id="sidebarContent" class="u-sidebar u-sidebar__lg" aria-labelledby="sidebarNavToggler">
        <div class="u-sidebar__scroller">
            <div class="u-sidebar__container">
                <div class="u-header-sidebar__footer-offset">
                     <!-- Toggle Button -->
                    <div class="d-flex align-items-center position-absolute top-0 right-0 z-index-2 mt-5 mr-md-6 mr-4">
                        <button type="button" class="close ml-auto"
                            aria-controls="sidebarContent"
                            aria-haspopup="true"
                            aria-expanded="false"
                            data-unfold-event="click"
                            data-unfold-hide-on-scroll="false"
                            data-unfold-target="#sidebarContent"
                            data-unfold-type="css-animation"
                            data-unfold-animation-in="fadeInRight"
                            data-unfold-animation-out="fadeOutRight"
                            data-unfold-duration="500">
                            <span aria-hidden="true">닫기 <i class="bi bi-caret-left-fill"></i></span>
                        </button>
                    </div>
                    <!-- End Toggle Button -->

                     <!-- Content  로그인 , 회원가입 -->
                    <div class="js-scrollbar u-sidebar__body">
                        <div class="u-sidebar__content u-header-sidebar__content">
                            <form class="" action="/login.do" method="post">
                                <!-- Login -->
                                <div id="login" data-target-group="idForm">
                                    <!-- Title -->
                                    <header class="border-bottom px-4 px-md-6 py-4">
                                        <h2 class="font-size-3 mb-0 d-flex align-items-center"><i class="fa-solid fa-key"></i> &nbsp;로그인</h2>
                                    </header>
                                    <!-- End Title -->

                                    <div class="p-4 p-md-6">
                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinEmailLabel" class="form-label" for="signinEmail">이메일 *</label>
                                                <input type="email" class="form-control rounded-0 height-4 px-4" name="mem_email" id="signinEmail" placeholder="이메일 입력" aria-describedby="signinEmailLabel" required>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->

                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinPasswordLabel" class="form-label" for="signinPassword">비밀번호 *</label>
                                                <input type="password" class="form-control rounded-0 height-4 px-4" name="mem_pass" id="signinPassword" placeholder="비밀번호 입력" aria-describedby="signinPasswordLabel" required>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->

                                        <div class="d-flex justify-content-between mb-5 align-items-center">
                                            <a class="js-animation-link text-dark font-size-2 t-d-u link-muted font-weight-medium" href="javascript:;"
                                            data-target="#forgotEmail"
                                            data-link-group="idForm"
                                            data-animation-in="fadeIn"><span class="material-icons" style="vertical-align: -6px; font-size:22px;" >person_search</span>계정 찾기</a>
                                            
                                            <a class="js-animation-link text-dark font-size-2 t-d-u link-muted font-weight-medium" href="javascript:;"
                                            data-target="#forgotPassword"
                                            data-link-group="idForm"
                                            data-animation-in="fadeIn"><i class="fa-solid fa-magnifying-glass-arrow-right"></i>비밀번호 찾기</a>
                                            
                                        </div>

                                        <div class="mb-4d75">
                                            <button type="submit" class="btn btn-block py-3 rounded-0 btn-dark">로그인</button>
                                        </div>
										</form>
										<!-- 카카오톡 로그인 -->
										<!-- <div class="mb-2" style="background-color: yellow">
											<a href="https://kauth.kakao.com/oauth/authorize?client_id=adff65a3815f057d4e72c8f56cbfebb3&redirect_uri=http://localhost:8080&response_type=code"
											class="btn btn-block py-3 rounded-0">카카오톡 로그인</a>
										</div> -->
										<!-- 카카오톡 로그인 끝 -->
										
										<!-- 네이버 로그인  -->
										<div class="mb-4d75">
											<a href="${naveraccessurl}" onclick="loginNaver1()" class="js-animation-link btn btn-block rounded-0 font-weight-medium"
											style="border-color:#53bb48;"><img width="30px" height="30px" alt="" src="/img/naver.png">
											네이버 로그인</a>
										</div>
										
										
										<!-- 네이버 로그인 끝 -->
										
                                        <div class="mb-2">
                                            <a href="javascript:;" class="js-animation-link btn btn-block py-3 rounded-0 btn-outline-dark font-weight-medium"
                                            data-target="#signup"
                                            data-link-group="idForm"
                                            data-animation-in="fadeIn">회원가입</a>
                                        </div>
                                    </div>
                                </div>

                                <!-- Signup 회원가입-->
                                <div id="signup" style="display: none; opacity: 0;" data-target-group="idForm">
                                    <!-- Title -->
                                    <header class="border-bottom px-4 px-md-6 py-4">
                                        <h2 class="font-size-3 mb-0 d-flex align-items-center"><i class="flaticon-resume mr-3 font-size-5"></i>계정 생성</h2>
                                    </header>
                                    <!-- End Title -->
									<form class="" action="/signup.do" method="post" id="singUpForm" onsubmit="return false;">
                                    <div class="p-4 p-md-6">
                                        <!-- Form Group -->
                                        <div class="form-group">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinEmailLabel1" class="form-label" for="signinEmail1">이메일 *</label>
                                                <input type="email" class="form-control rounded-0 height-4 px-4" name="mem_email" id="signinEmail1" placeholder="이메일 입력" aria-describedby="signinEmailLabel1" required oninput = "email_check()">                                            
                                                <p id="email_ok" style="font-size:12px; padding-top: 10px; display: inline;">&nbsp;</p>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->

                                        <!-- Form Group -->
                                        <div class="form-group">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinPasswordLabel1" class="form-label" for="signinPassword1">비밀번호 *</label>
                                                <input type="password" class="form-control rounded-0 height-4 px-4" name="mem_pass" id="signinPassword1" placeholder="패스워드 입력" aria-describedby="signinPasswordLabel1" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$" required title = "최소 8자리에서 최대 16자리까지 숫자, 영문, 특수문자 각 1개 이상 포함" >
                                            	<div style="color:gray;font-size:12px;text-align:center;">※ 8자리에서 최대 16자리까지 숫자,영문,특수문자 각 1개 이상 포함 ※</div>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->

                                        <!-- Form Group -->
                                        <div class="form-group">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signupConfirmPasswordLabel" class="form-label" for="signupConfirmPassword">핸드폰 *</label>
                                                <input type="tel" class="form-control rounded-0 height-4 px-4" name="mem_phone" id="signinphone" placeholder="핸드폰 번호 입력" minlength="10" pattern="^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$" required title="10-11개의 숫자를 입력하세요!" oninput = "phone_check()" onkeyup="mobile_keyup(this)">
                                            	<p id="phone_ok" style="font-size:12px; padding-top: 10px; display: inline;">&nbsp;</p>
                                                <input type="button" id="memberPhoneCheck" onclick="memberPhoneChecks()" value="인증">   
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <div class="js-form-message js-focus-state">
                                            	<input type="text" name="memberPhoneCertify" class="phoneauth" style="width:70px;height:30px;border: 1px solid #dfdcd7; font-size: 0.875rem; font-weight: 400;" required>
												<input type="button" id="certifyCheck" value="인증확인">
												<p id="phone_auth" style="font-size:12px; padding-top: 10px; display: block;">&nbsp;</p>
                                            </div>
                                        </div>
                                        <!-- End Input -->
                                         <!-- Form Group -->
                                        <div class="form-group">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinEmailLabel1" class="form-label" for="signinEmail1">아이디 *</label>
                                                <input type="text" class="form-control rounded-0 height-4 px-4" name="mem_id" id="signinid" placeholder="아이디 입력"  oninput = "id_checks()" required />
                                            	<p id="id_ok" style="font-size:12px; padding-top: 10px; display: inline;">&nbsp;</p>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->
                                        
                                        <!-- Form Group -->
                                        <div class="form-group">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinEmailLabel1" class="form-label" for="signinEmail1">이름 *</label>
                                                <input type="text" class="form-control rounded-0 height-4 px-4" name="mem_name" placeholder="이름 입력" aria-describedby="signinEmailLabel1" required>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->
										
                                        <div class="mb-3">
                                            <button type="submit" class="btn btn-block py-3 rounded-0 btn-dark" id="singupCheck" onclick="signup_check()">계정 생성</button>
                                        </div>
                                        
										</form>
										
										<c:if test="${singup == true}">
								          	<script>
								          		alert("※Congraturation※\n회원가입 성공");
								          	</script>
								        </c:if>
								        <c:if test="${loginFail == false}">
								          	<script>
								          		alert("※ Login - Fail ※\n로그인 실패");
								          	</script>
								        </c:if>
								        <c:if test="${loginOk == true}">
								          	<script>
								          		alert("※ Login - OK ※\n로그인 성공");
								          	</script>
								        </c:if>
								        <c:if test="${naverloginOk == true}">
								          	<script>
								          		alert("※ Login - OK ※\n[네이버 소셜]로그인 성공");
								          	</script>
								        </c:if>
                                        <div class="text-center mb-4">
                                            <span class="small text-muted">로그인 하러 가기</span>
                                            <a class="js-animation-link small" href="javascript:;"
                                                data-target="#login"
                                                data-link-group="idForm"
                                                data-animation-in="fadeIn">로그인
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!-- End Signup -->

                                <!-- 계정 찾기 -->
                                <div id="forgotEmail" style="display: none; opacity: 0;" data-target-group="idForm">
                                    <!-- Title -->
                                    <header class="border-bottom px-4 px-md-6 py-4">
                                        <h2 class="font-size-3 mb-0 d-flex align-items-center"><span class="material-icons">person_search</span>계정 찾기</h2>
                                    </header>
                                    <!-- End Title findphonecheck.do -->

                                    <div class="p-4 p-md-6">
                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signupConfirmPasswordLabel" class="form-label" for="signupConfirmPassword">핸드폰 *</label>
                                                <input type="tel" class="form-control rounded-0 height-4 px-4" name="mem_phone" id="findphone" placeholder="핸드폰 번호 입력" minlength="10" pattern="^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$" required title="10-11개의 숫자를 입력하세요!" oninput = "find_phone_check()" onkeyup="mobile_keyup(this)">
                                            	<!-- <p class="find_phone_ok" style="font-size:12px; padding-top: 10px; color:#ef4949; display: none;">※ 존재하지 않는 핸드폰 번호 입니다. 회원가입을 진행해주세요</p> -->
                                        		<p id="find_phone_ok" style="font-size:12px; padding-top: 12px;display:inline;">&nbsp;</p>
                                                <input type="button" id="find_phone_btn" onclick="find_phone_btn()" value="인 증">   
                                            </div>
                                        </div>
                                        
                                        <!-- End Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                            	<label id="signupConfirmPasswordLabel" class="form-label" for="signupConfirmPassword">인증번호 *</label>
                                            	<input type="text" id="findphoneauth" name="phoneoauthcheck" class="find_phoneauth rounded-0 height-4" placeholder="인증번호 입력" required>
												<input type="button" id="phoneoauthchecking" onclick="findphoneauth()" value="인증확인">
												<p id="find_phone_auth" style="font-size:12px; padding-top: 10px; display: inline;">&nbsp;</p>
                                            </div>
                                        </div>
                                        
										<div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                            <label id="signupConfirmPasswordLabel" class="form-label" for="signupConfirmPassword">확인 된 이메일<i class="fa-solid fa-caret-down" style="color:#969fa9;"></i></label>
											<p id="lookemail_ok" style="font-size:14px;font-weight:bold;border-bottom: 2px double #c5c5c5;">&nbsp;</p>
											</div>
                                        </div>
										<!-- <strong id="lookemail_fail" style="disply:none;">존재안함 or 인증확인 바람</strong> -->
                                        <div class="mb-3">
                                            <button type="submit" id="findphonebtn" onclick="findaccount_check()" class="btn btn-block py-3 rounded-0 btn-dark">확인</button>
                                        </div>
										
                                        <div class="text-center mb-4">
                                            <a class="js-animation-link small" href="javascript:;"
                                                data-target="#login"
                                                data-link-group="idForm"
                                                data-animation-in="fadeIn"><i class="fa-solid fa-circle-left"></i>&nbsp;뒤로가기
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!-- End Forgot Password -->

                            <!-- 계정 찾기 (비밀번호) -->
                                <div id="forgotPassword" style="display: none; opacity: 0;" data-target-group="idForm">
                                    <!-- Title -->
                                    <header class="border-bottom px-4 px-md-6 py-4">
                                        <h2 class="font-size-3 mb-0 d-flex align-items-center"><span class="material-icons">password</span>&nbsp비밀번호 찾기</h2>
                                    </header>
                                    <!-- End Title findphonecheck.do -->
									<!-- <form action="passCheck.do" method="post"> -->
                                    <div class="p-4 p-md-6">
                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinEmailLabel1" class="form-label" for="signinEmail1">이메일 *</label>
                                                <input type="email" class="form-control rounded-0 height-4 px-4" name="mem_email" id="find_email" placeholder="이메일 입력" aria-describedby="signinEmailLabel1" onkeyup="find_password_check()">
                                                <p id="find_email_ok" style="font-size:12px; padding-top: 12px; display: inline;">&nbsp;</p>
                                            	<input type="button" id="find_email_btn"  onclick="find_email_btn()" value="인증">
                                            </div>
                                        </div>
                                        <!-- End Form Group -->
                                        <!-- </form> -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                            	<label id="signupConfirmPasswordLabel" class="form-label" for="signupConfirmPassword">인증번호 *</label>
                                            	<input type="text" id="finedpassauth" name="find_pass" class="find_pass_input rounded-0 height-4" required>
												<input type="button" id="find_pass_input_check"  onclick="find_pass_input_check()" value="인증확인">
												<p id="find_pass_auth" style="font-size:12px; padding-top: 10px; display: inline;">&nbsp;</p>
                                            </div>
                                        </div>
										
										<label id="signupConfirmPasswordLabel" class="form-label" for="signupConfirmPassword">확인 된 패스워드<i class="fa-solid fa-caret-down" style="color:#969fa9;"></i></label>
										<p id="lookpass" style="font-size:14px;font-weight:bold;border-bottom: 2px double #c5c5c5;">&nbsp;</p>
                                        <div class="mb-3">
                                            <button type="submit" id="findpassbtn" onclick="find_pass_check()" class="btn btn-block py-3 rounded-0 btn-dark">확인</button>
                                        </div>
										
                                        <div class="text-center mb-4">
                                            <a class="js-animation-link small" href="javascript:;"
                                                data-target="#login"
                                                data-link-group="idForm"
                                                data-animation-in="fadeIn"><i class="fa-solid fa-circle-left"></i>&nbsp;뒤로가기
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!-- End Forgot Password -->
                        </div>
                    </div>
                    <!-- End Content -->
                </div>
            </div>
        </div>
    </aside>
    <!-- End Account Sidebar Navigation - Desktop -->


<!--  -->

	 <!-- 마이페이지 -->
    <aside id="sidebarMypage" class="u-sidebar u-sidebar__lg" aria-labelledby="sidebarNavToggler">
        <div class="u-sidebar__scroller">
            <div class="u-sidebar__container">
                <div class="u-header-sidebar__footer-offset">
                    <!-- Toggle Button -->
                    <div class="d-flex align-items-center position-absolute top-0 right-0 z-index-2 mt-5 mr-md-6 mr-4">
                        <button type="button" class="close ml-auto"
                            aria-controls="sidebarMypage"
                            aria-haspopup="true"
                            aria-expanded="false"
                            data-unfold-event="click"
                            data-unfold-hide-on-scroll="false"
                            data-unfold-target="#sidebarMypage"
                            data-unfold-type="css-animation"
                            data-unfold-animation-in="fadeInRight"
                            data-unfold-animation-out="fadeOutRight"
                            data-unfold-duration="500" >
                            <span aria-hidden="true">닫기 <i class="bi bi-caret-left-fill"></i></span>
                        </button>
                    </div>
                    <!-- End Toggle Button -->

                    <!-- Content  마이페이지 -->
                    <div class="js-scrollbar u-sidebar__body">
                        <div class="u-sidebar__content u-header-sidebar__content">
                                <!-- 마이페이지  -->
                                <div id="mypage" data-target-group="idForm">
                                    <!-- Title -->
                                    <header class="border-bottom px-4 px-md-6 py-4">
                                        <h2 class="font-size-3 mb-0 d-flex align-items-center"><strong>${member.mem_name}</strong>님의 마이페이지</h2>
                                    </header>
                                    <!-- End Title -->

                                    <div class="p-4 p-md-6">
                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinEmailLabel" class="form-label" for="signinEmail"><i class="bi bi-envelope"></i> ${member.mem_email}</label>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->
										
										<!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinPasswordLabel" class="form-label" for="signinPassword"><i class="bi bi-phone"></i> ${member.mem_phone}</label>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->
										
										<!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinPasswordLabel" class="form-label" for="signinPassword"><i class="bi bi-file-person"></i> ${member.mem_name}</label>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->
                                       <!-- Form Group -->
                                        
                                                <label id="signinPasswordLabel" class="form-label" for="signinPassword"><i class="bi bi-file-person"></i> 당일 좌석 예약시간:</label>
                                           <c:if test="${rez != null}">
                                           <div class="form-group mb-2">
                                            <div class="js-form-message js-focus-state">
                                                	<input type="button" id="certifyCheck" value="예약 수정" onclick="updateRez()">
                                                	<input type="button" id="certifyCheck" value="취소 하기" onclick="deleteRez()">
                                                
                                                
                                                <script type="text/javascript">
                                                	var updateRez = () => {
                                                		location.href="/rezUpdate";
                                                		alert("수정하기");
                                                	}
                                                	var deleteRez = () => {
                                                		location.href="/rezDelete";
                                                		alert("삭제완료");
                                                	}
                                                </script>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->  
                                        <table class="table">
						        			<colgroup>
						        				<col style="width:20%">
						        				<col style="width:40%">
						        				<col style="width:40%">
						        				
						        			</colgroup>
						        			<thead class="top">
						        				<tr>
						        					<th style="text-align:center">좌석</th>
						        					<th style="text-align:center">예약시작시간</th>
						        					<th style="text-align:center">예약종료시간</th>
						        				</tr>
						        			</thead>
						        			<tbody>
						        			
						        				<tr>
						        					<td style="text-align:center">${fNum}열람실${seatNum}번</td>
							        				<td style="text-align:center">${rez.res_start}</td>
							        				<td style="text-align:center">${rez.res_end}</td>
							        			</tr>
						        			</tbody>
						        			</table>
                                        <br/>
                                        </c:if>
                                        <c:if test="${rez == null}">
                                        	<h7>  예약된 정보가 없습니다.</h7>
                                        	<br/>
                                        	<br/>
                                        	
                                        </c:if>
                                        <!-- <div class="mb-4d75">
                                            <button type="submit" class="btn btn-block py-3 rounded-0 btn-dark">로그인</button>
                                        </div> -->
                                        <div class="mb-2">
                                        	<a href="../logout.do" class="mypageA" id="logout"><span style="font-size:18px;" class="material-icons">logout 로그아웃</span></a>
                                        </div>
                                        <!-- 찜 목록 페이지 버튼 -->
                                        <div class="mb-2">
											<a href="javascript:;" class="js-animation-link"
											data-target="#favorite"
											data-link-group="idForm"
											data-animation-in="fadeIn"><span style="font-size:18px;" class="material-icons">favorite_border 찜 목록</span></a>
										</div>
										<!-- 찜 목록 페이지 버튼 끝-->
										
										<!-- 내 활동 이력 버튼 -->
                                         <div class="mb-2">
											<a href="javascript:;" class="js-animation-link"
											data-target="#mylog"
											data-link-group="idForm"
											data-animation-in="fadeIn"><span style="font-size:18px;" class="material-icons">ballot 활동이력</span></a>
										</div>
                                        <!-- 내 활동 이력 버튼 끝 -->
                                        
                                        <!-- 대출 이력 버튼 -->
                                         <div class="mb-2">
											<a href="javascript:;" class="js-animation-link"
											data-target="#myrental"
											data-link-group="idForm"
											data-animation-in="fadeIn"><span style="font-size:18px;" class="material-icons">menu_book 대출이력</span></a>
										</div>
                                        <!-- 대출 이력 버튼 끝 -->
                                        
                                        
                                        <!-- 내 프로필 수정 -->
                                        
	                                        <c:if test="${member.mem_sns == 'normal'}">	<!-- 도서관 전용 회원탈퇴 -->
		                                         <div class="mb-2">
													<a href="javascript:;" class="js-animation-link"
													data-target="#updateMember"
													data-link-group="idForm"
													data-animation-in="fadeIn"><span style="font-size:18px;" class="material-icons">construction 회원정보수정</span></a>
												</div>
											</c:if>
										
									
                                        <!-- 내 프로필 수정 끝 -->
                                        
                                        <!-- 회원탈퇴 -->
                                        <c:choose>
	                                        <c:when test="${member.mem_sns == 'normal'}">	<!-- 도서관 전용 회원탈퇴 -->
	                                         <div class="mb-2">
												<a href="" class="js-animation-link"
												data-target="#deleteMember"
												data-link-group="idForm"
												data-animation-in="fadeIn"><span style="font-size:18px;" class="material-icons">person_off 회원탈퇴</span></a>
											</div>
											</c:when>
											<c:otherwise>	<!-- 네이버 전용 회원탈퇴(도서관까지 같이)탈퇴되는 걸로 아직 otherwise로 함-->
												<div class="mb-2">
													<a href="javascript:;" class="js-animation-link"
													data-target="#deleteMember"
													data-link-group="idForm"
													data-animation-in="fadeIn"><span style="font-size:18px;" class="material-icons">person_off 회원탈퇴 [네이버 전용]</span></a>
												</div>
											</c:otherwise>
										</c:choose>
                                        <!-- 회원탈퇴 끝 -->
                                        
                                    </div>
                                </div>
                                <!-- 찜 목록 페이지 화면 -->
                                <div id="favorite" style="display: none; opacity: 0;" data-target-group="idForm">
											<!-- Title -->
											<header class="border-bottom px-4 px-md-6 py-4">
												<h2 class="font-size-3 mb-0 d-flex align-items-center"><span style="font-size:18px;" class="material-icons">favorite_border </span>찜 목록</h2>
											</header>
											<!-- End Title -->
											<c:forEach items="${member.bookFavorite}" var="list">
											<div class="px-4 py-5 px-md-6 border-bottom">
				                                <div class="media">
				                                    <a href="#" class="d-block"><img width="100px" height="100px" src="${list.libraryBook.book_img}" class="img-fluid" alt="image-description"></a>
				                                    <div class="media-body ml-4d875">
				                                        <div class="text-primary text-uppercase font-size-1 mb-1 text-truncate"><a href="#">${list.libraryBook.book_title}</a></div>
				                                        <h2 class="woocommerce-loop-product__title h6 text-lh-md mb-1 text-height-2 crop-text-2">
				                                            <a href="#" class="text-dark">${list.libraryBook.book_writer}</a>
				                                        </h2>
				                                        <div class="font-size-2 mb-1 text-truncate"><a href="#" class="text-gray-700">${list.libraryBook.book_publisher}</a></div>
				                                    </div>
				                                </div>				                                
				                            </div>
											</c:forEach>															                           
				                            <div class="text-center mb-4">
	                                            <a class="js-animation-link small" href="javascript:;"
	                                                data-target="#mypage"
	                                                data-link-group="idForm"
	                                                data-animation-in="fadeIn"><span style="display:block;" class="material-icons">arrow_circle_left</span>뒤로가기
	                                            </a>
	                                        </div>
								<!-- 찜 목록 페이지 끝 -->
								
                        </div>
                        <!-- 내 활동이력 화면 -->
	                              <div id="mylog" style="display: none; opacity: 0;" data-target-group="idForm">
										<!-- Title -->
										<header class="border-bottom px-4 px-md-6 py-4">
											<h2 class="font-size-3 mb-0 d-flex align-items-center"><span style="font-size:18px;" class="material-icons">ballot</span>활동이력</h2>
										</header>
										<!-- End Title -->
										
										<table>
										<colgroup>
											<col width="15%"/>
											<col width="20%"/>
											<col width="55%"/>
											<col width="10%"/>
										</colgroup>
										
										<thead>
											<tr>
												<th>종류</th>
												<th>제목</th>
												<th>내용</th>
												<th>날짜</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>어떤 게시판인지</td>
												<td>제목입니다</td>
												<td>내용내용내용내용내용내용내용내용</td>
												<td>2022-09-25</td>
											</tr>
										</tbody>
										</table>
										
			                            <div class="text-center mb-4">
	                                           <a class="js-animation-link small" href="javascript:;"
	                                               data-target="#mypage"
	                                               data-link-group="idForm"
	                                               data-animation-in="fadeIn"><span style="display:block;" class="material-icons">arrow_circle_left</span>뒤로가기
	                                           </a>
	                                       </div>
							<!-- 내 활동이력 페이지 끝 -->		
                    </div>
                    
                    <!-- 대출이력 화면 -->
	                              <div id="myrental" style="display: none; opacity: 0;" data-target-group="idForm">
										<!-- Title -->
										<header class="border-bottom px-4 px-md-6 py-4">
											<h2 class="font-size-3 mb-0 d-flex align-items-center"><span style="font-size:18px;" class="material-icons">menu_book</span>대출이력</h2>
										</header>
										<!-- End Title -->
										
										<table>
										<colgroup>
											<col width="40%"/>
											<col width="20%"/>
											<col width="20%"/>
											<col width="20%"/>
										</colgroup>
										
										<thead>
											<tr>
												<th>제목</th>
												<th>저자</th>
												<th>대출상태</th>												
												<th>반납날짜</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${mem_rental}" var="list">
											<tr>
												<td>${list.book.book_title}</td>
												<td>${list.book.book_writer}</td>
												<c:choose>
													<c:when test="${list.ren_stat==0}">
														<td><span style="color:red;">예약준비중</span></td>	
													</c:when>
													<c:when test="${list.ren_stat==1}">
														<td><span style="color:orange;">대출중</span></td>	
													</c:when>
													<c:otherwise>
														<td><span style="color:green;">반납완료</span></td>
													</c:otherwise>
												</c:choose>																						
												<td>${list.ren_return}</td>
											</tr>
											</c:forEach>
										</tbody>
										</table>
										<hr>
										
			                            <div class="text-center mb-4">
	                                           <a class="js-animation-link small" href="javascript:;"
	                                               data-target="#mypage"
	                                               data-link-group="idForm"
	                                               data-animation-in="fadeIn"><span style="display:block;" class="material-icons">arrow_circle_left</span>뒤로가기
	                                           </a>
	                                       </div>
	                              </div>
							<!-- 대출이력 페이지 끝 -->
                    
                    
                    <!-- 회원정보 수정 화면 -->
	                              <div id="updateMember" style="display: none; opacity: 0;" data-target-group="idForm">
										<!-- Title -->
										<header class="border-bottom px-4 px-md-6 py-4">
											<h2 class="font-size-3 mb-0 d-flex align-items-center"><span style="font-size:18px;" class="material-icons">construction</span>&nbsp회원정보수정</h2>
										</header>
										<!-- End Title -->
										
										<div class="p-4 p-md-6">
                                        <!-- Form Group -->
                                        <form method="post" action="updatemember.do" onsubmit="return false;" id="updateForm">
                                        <input type=hidden name="mem_email" value="${member.mem_email}"/>
	                                        <div class="form-group mb-4">
	                                            <div class="js-form-message js-focus-state">
	                                                <label id="signinPasswordLabel1" class="form-label" for="signinPassword1">변경 할 패스워드 *</label>
	                                                <input type="password" class="form-control rounded-0 height-4 px-4" name="mem_pass" id="updatePass1" aria-describedby="signinPasswordLabel1" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$" required title = "최소 8자리에서 최대 16자리까지 숫자, 영문, 특수문자 각 1개 이상 포함">
	                                            	<div style="color:gray;font-size:13px;text-align:center;">※ 8자리에서 최대 16자리까지 숫자,영문,특수문자 각 1개 이상 포함 ※</div>
	                                            </div>
	                                        </div>
	                                        <!-- End Form Group -->
	
	                                        <!-- Form Group -->
	                                        <div class="form-group mb-4">
	                                            <div class="js-form-message js-focus-state">
	                                                <label id="signupConfirmPasswordLabel" class="form-label" for="signupConfirmPassword">패스워드 확인 *</label>
	                                                <input type="password" class="form-control rounded-0 height-4 px-4" name="confirmPassword" id="updatePass2" aria-describedby="signupConfirmPasswordLabel" pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$" required title = "최소 8자리에서 최대 16자리까지 숫자, 영문, 특수문자 각 1개 이상 포함">
	                                            	<div style="color:gray;font-size:13px;text-align:center;display:none;" id="passwarning">※ 패스워드가 일치하지 않습니다 다시 입력해주세요 ※</div>
	                                            </div>
	                                        </div>
	                                        <!-- End Input -->
	                                        
	                                        <div class="mb-3">
	                                            <button type="submit" class="btn btn-block py-3 rounded-0 btn-dark" onclick="update_pass()">확인</button>
	                                        </div>
                                        </form>
                                        
										<div class="text-center mb-4">
	                                           <a class="js-animation-link small" href="javascript:;"
	                                               data-target="#mypage"
	                                               data-link-group="idForm"
	                                               data-animation-in="fadeIn"><span style="display:block;" class="material-icons">arrow_circle_left</span>뒤로가기
	                                           </a>
	                                       </div>
                                    </div>
 
							<!-- 회원정보 수정 페이지 끝 -->
							<c:if test="${updateFAIL == false}">
					          	<script>
					          		alert("※ Update - Fail ※\n업데이트 실패");
					          	</script>
					        </c:if>
					        <c:if test="${updateOK == true}">
					          	<script>
					          		alert("※ Update - OK ※\n업데이트 성공");
					          	</script>
					        </c:if>

                    <!-- End Content 마이페이지 -->
                </div>
                <c:choose>
                	<c:when test="${member.mem_sns == 'normal'}">
                <!-- 회원탈퇴 화면 -->
	                           <div id="deleteMember" style="display: none; opacity: 0;" data-target-group="idForm">
							<!-- Title -->
							<header class="border-bottom px-4 px-md-6 py-4">
								<h2 class="font-size-3 mb-0 d-flex align-items-center"><span style="font-size:18px;" class="material-icons">person_off</span>&nbsp회원탈퇴</h2>
							</header>
							<!-- End Title -->
							 <!-- Form Group -->
							 <form id="deleteForm1" method="post" action="deletenormal.do" onsubmit="return false;">
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state" style="text-align:center;font-size:20px;margin-top:15%;">
                                                <label class="form-label" for="signinEmail"><span class="material-icons">mail</span> ${member.mem_email}</label>
                                                <input type=hidden class="form-control rounded-0 height-4 px-4" name="mem_email" id="deleteEmail"  value="${member.mem_email}"/>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->

                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state" style="text-align:center;">
                                                <label id="signinPasswordLabel" class="form-label" for="signinPassword">비밀번호 확인 *</label>
                                                <input type="password" class="form-control rounded-0 height-4 px-4" name="mem_pass" id="deleteCheckPass" style="width:45%; margin-left:27%;" placeholder="비밀번호 확인" aria-describedby="signinPasswordLabel" required oninput = "pass_check()" >
                                            	<div id="pass_ok" style="text-align:center;display:none;">※ 비밀번호가 맞습니다</div>
                                            	<div id="pass_fail" style="text-align:center;display:none;">※ 비밀번호가 틀립니다</div>
                                            </div>
                                        </div>
										<!-- End Form Group -->
										
										<div class="mb-3" >
                                            <button type="submit" id="deleteBtn1" onclick="deleteBtns()" class="btn btn-block py-3 rounded-0 btn-dark" style="margin-left:35%;width:30%;">회원탈퇴 </button>
                                        </div>
							</form>
	                           <div class="text-center mb-4">
	                                        <a class="js-animation-link small" href="javascript:;"
	                                            data-target="#mypage"
	                                            data-link-group="idForm"
	                                            data-animation-in="fadeIn"><span style="display:block;" class="material-icons">arrow_circle_left</span>뒤로가기
	                                        </a>
	                                    </div>
				<!-- 회원탈퇴 페이지 끝 -->
					</c:when>
					<c:otherwise>
						<!-- 회원탈퇴 화면 -->
	                           <div id="deleteMember" style="display: none; opacity: 0;" data-target-group="idForm">
							<!-- Title -->
							<header class="border-bottom px-4 px-md-6 py-4">
								<h2 class="font-size-3 mb-0 d-flex align-items-center"><span style="font-size:18px;" class="material-icons">person_off</span>&nbsp네이버회원탈퇴</h2>
							</header>
							<!-- End Title -->
							 <!-- Form Group -->
							 <form id="deleteForm2" method="post" action="deletenaver.do" onsubmit="return false;">
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state" style="text-align:center;font-size:20px;margin-top:15%;">
                                                <label class="form-label" for="signinEmail"><span class="material-icons">mail</span> ${member.mem_email}</label>
                                                <input type=hidden class="form-control rounded-0 height-4 px-4" name="mem_email" id="deleteEmail"  value="${member.mem_email}"/>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->
										<div class="mb-3" >
                                            <button type="submit" id="deleteBtn2" onclick="go()" class="btn btn-block py-3 rounded-0 btn-dark" style="margin-left:35%;width:30%;">회원탈퇴</button>
                                        </div>
							</form>
	                           <div class="text-center mb-4">
	                                        <a class="js-animation-link small" href="javascript:;"
	                                            data-target="#mypage"
	                                            data-link-group="idForm"
	                                            data-animation-in="fadeIn"><span style="display:block;" class="material-icons">arrow_circle_left</span>뒤로가기
	                                        </a>
	                                    </div>
				<!-- 회원탈퇴 페이지 끝 -->
					</c:otherwise>
				</c:choose>
            </div>
        </div>
    </aside>
<!-- 마이페이지 끝 -->

	<!-- 관리자 페이지  -->
    <aside id="sidebarContent2" class="u-sidebar u-sidebar__md u-sidebar--left" aria-labelledby="sidebarNavToggler2">
        <div class="u-sidebar__scroller js-scrollbar">
            <div class="u-sidebar__container">
                <div class="u-header-sidebar__footer-offset">
                    <!-- Content -->
                    <div class="u-sidebar__body">
                        <div class="u-sidebar__content u-header-sidebar__content">
                            <!-- Title -->
                            <header class="border-bottom px-4 px-md-5 py-4 d-flex align-items-center justify-content-between">
                                <h2 class="font-size-3 mb-0">도서관 관리</h2>

                                <!-- Toggle Button -->
                                <div class="d-flex align-items-center">
                                    <button type="button" class="close ml-auto"
                                        aria-controls="sidebarContent2"
                                        aria-haspopup="true"
                                        aria-expanded="false"
                                        data-unfold-event="click"
                                        data-unfold-hide-on-scroll="false"
                                        data-unfold-target="#sidebarContent2"
                                        data-unfold-type="css-animation"
                                        data-unfold-animation-in="fadeInLeft"
                                        data-unfold-animation-out="fadeOutLeft"
                                        data-unfold-duration="500">
                                        <span aria-hidden="true"><i class="bi bi-caret-left-fill"></i></span>
                                    </button>
                                </div>
                                <!-- End Toggle Button -->
                            </header>
                            <!-- End Title -->

                            <div class="border-bottom">
                                <div class="zeynep pt-4">
                                    <ul>
                                        <li class="has-submenu">
                                            <a href="/admin/book/search" data-submenu="off-pages">도서관리</a>
                                        </li>

                                        <li class="has-submenu">
                                            <a href="/admin/rental/manage" data-submenu="art-photo">대출도서관리</a>                                                                                      
                                        </li>
                                        
                                        <li class="has-submenu">
                                            <a href="/admin/request/manage" data-submenu="art-photo">신청도서관리</a>                                                                                      
                                        </li>

                                        <li class="has-submenu">
                                            <a href="#" data-submenu="biography">DVD관리</a>

                                            <div id="biography" class="submenu">
                                                <div class="submenu-header" data-submenu-close="biography">
                                                    <a href="#">DVD관리</a>
                                                </div>

                                                <ul>
                                                    <li>
                                                        <a href="/admin/dvd/search">DVD검색</a>
                                                    </li>

                                                    <li>
                                                        <a href="/admin/dvd/add">DVD추가</a>
                                                    </li>

                                                    <li>
                                                        <a href="/admin/dvd/update">DVD수정</a>
                                                    </li>
                                                    <li>
                                                        <a href="/admin/dvd/del">DVD삭제</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <div class="px-4 px-md-5 pt-5 pb-4 border-bottom">
                                <h2 class="font-size-3 mb-3">HELP & SETTINGS </h2>
                                <ul class="list-group list-group-flush list-group-borderless">
                                    <li class="list-group-item px-0 py-2 border-0"><a href="#" class="h-primary">Your Account</a></li>
                                    <li class="list-group-item px-0 py-2 border-0"><a href="#" class="h-primary">Help</a></li>
                                    <li class="list-group-item px-0 py-2 border-0"><a href="#" class="h-primary">Sign In</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- End Content -->
                </div>
            </div>
        </div>
    </aside>
	
	<!-- 관리자 페이지 끝 -->


    <!-- Cart Sidebar Navigation -->
    <aside id="sidebarContent1" class="u-sidebar u-sidebar__xl" aria-labelledby="sidebarNavToggler1">
        <div class="u-sidebar__scroller js-scrollbar">
            <div class="u-sidebar__container">
                <div class="u-header-sidebar__footer-offset">
                    <!-- Toggle Button -->
                    <div class="d-flex align-items-center position-absolute top-0 right-0 z-index-2 mt-5 mr-md-6 mr-4">
                        <button type="button" class="close ml-auto"
                            aria-controls="sidebarContent1"
                            aria-haspopup="true"
                            aria-expanded="false"
                            data-unfold-event="click"
                            data-unfold-hide-on-scroll="false"
                            data-unfold-target="#sidebarContent1"
                            data-unfold-type="css-animation"
                            data-unfold-animation-in="fadeInRight"
                            data-unfold-animation-out="fadeOutRight"
                            data-unfold-duration="500">
                            <span aria-hidden="true">닫기 <i class="fas fa-times ml-2"></i></span>
                        </button>
                    </div>
                    <!-- End Toggle Button -->

                    <!-- Content -->
                    <div class="u-sidebar__body">
                        <div class="u-sidebar__content u-header-sidebar__content">
                            <!-- Title -->
                            <header class="border-bottom px-4 px-md-6 py-4">
                                <h2 class="font-size-3 mb-0 d-flex align-items-center"><i class="flaticon-icon-126515 mr-3 font-size-5"></i>Your shopping bag (1)</h2>
                            </header>
                            <!-- End Title -->

                            <div class="px-4 py-5 px-md-6 border-bottom">
                                <div class="media">
                                    <a href="#" class="d-block"><img src="https://placehold.it/100x153" class="img-fluid" alt="image-description"></a>
                                    <div class="media-body ml-4d875">
                                        <div class="text-primary text-uppercase font-size-1 mb-1 text-truncate"><a href="#">Hard Cover</a></div>
                                        <h2 class="woocommerce-loop-product__title h6 text-lh-md mb-1 text-height-2 crop-text-2">
                                            <a href="#" class="text-dark">The Ride of a Lifetime: Lessons Learned  from 15 Years as CEO</a>
                                        </h2>
                                        <div class="font-size-2 mb-1 text-truncate"><a href="#" class="text-gray-700">Robert Iger</a></div>
                                        <div class="price d-flex align-items-center font-weight-medium font-size-3">
                                            <span class="woocommerce-Price-amount amount">1 x <span class="woocommerce-Price-currencySymbol">$</span>125.30</span>
                                        </div>
                                    </div>
                                    <div class="mt-3 ml-3">
                                        <a href="#" class="text-dark"><i class="fas fa-times"></i></a>
                                    </div>
                                </div>
                            </div>


                            <div class="px-4 py-5 px-md-6 d-flex justify-content-between align-items-center font-size-3">
                                <h4 class="mb-0 font-size-3">Subtotal:</h4>
                                <div class="font-weight-medium">$750.00</div>
                            </div>

                            <div class="px-4 mb-8 px-md-6">
                                <button type="submit" class="btn btn-block py-4 rounded-0 btn-outline-dark mb-4">View Cart</button>
                                <button type="submit" class="btn btn-block py-4 rounded-0 btn-dark">Checkout</button>
                            </div>
                        </div>
                    </div>
                    <!-- End Content -->
                </div>
            </div>
        </div>
    </aside>
    <!-- End Cart Sidebar Navigation -->

    <!-- Categories Sidebar Navigation -->
    <aside id="sidebarContent3" class="u-sidebar u-sidebar__md u-sidebar--left" aria-labelledby="sidebarNavToggler2">
        <div class="u-sidebar__scroller js-scrollbar">
            <div class="u-sidebar__container">
                <div class="u-header-sidebar__footer-offset">
                    <!-- Content -->
                    <div class="u-sidebar__body">
                        <div class="u-sidebar__content u-header-sidebar__content">
                            <!-- Title -->
                            <header class="border-bottom px-4 px-md-5 py-4 d-flex align-items-center justify-content-between">
                                <h2 class="font-size-3 mb-0">메뉴</h2>

                                <!-- Toggle Button -->
                                <div class="d-flex align-items-center">
                                    <button type="button" class="close ml-auto"
                                        aria-controls="sidebarContent3"
                                        aria-haspopup="true"
                                        aria-expanded="false"
                                        data-unfold-event="click"
                                        data-unfold-hide-on-scroll="false"
                                        data-unfold-target="#sidebarContent3"
                                        data-unfold-type="css-animation"
                                        data-unfold-animation-in="fadeInLeft"
                                        data-unfold-animation-out="fadeOutLeft"
                                        data-unfold-duration="500">
                                        <span aria-hidden="true"><i class="fas fa-times ml-2"></i></span>
                                    </button>
                                </div>
                                <!-- End Toggle Button -->
                            </header>
                            <!-- End Title -->

                             <div class="border-bottom">
                                <div class="zeynep pt-4" >
                                    <ul>
                                        <li class="dropdown-content">
                                            <a id="toc-toggle" onclick="openCloseToc_one()">열람실</a>
	                                            <ul id="toc-content">
		                                            <li><a href="/rez">열람실 예약</a></li>
		                                            <!-- <li><a href="#">열람실 메뉴2</a></li>
		                                            <li><a href="#">열람실 메뉴3</a></li> -->
	                                            </ul>
                                        </li>
 
                                        <li class="dropdown-content">
                                            <a id="toc-toggle" onclick="openCloseToc_two()">도서</a>
												<ul id="toc-contenttwo">
		                                            <li><a href="/library/category/book?catgoId=0&page=1&show=12">전체</a></li>
		                                            <li><a href="/library/category/book?catgoId=1&page=1&show=12">소설(국내)</a></li>
		                                            <li><a href="/library/category/book?catgoId=2&page=1&show=12">에세이(국내)</a></li>
		                                            <li><a href="/library/category/book?catgoId=3&page=1&show=12">과학(국내)</a></li>
		                                            <li><a href="/library/category/book?catgoId=4&page=1&show=12">인문학(국내)</a></li>
		                                            <li><a href="/library/category/book?catgoId=5&page=1&show=12">예술/대중문화(국내)</a></li>
		                                            <li><a href="/library/category/book?catgoId=6&page=1&show=12">소설(외국)</a></li>
		                                            <li><a href="/library/category/book?catgoId=7&page=1&show=12">어린이(외국)</a></li>
		                                            <li><a href="/library/category/book?catgoId=8&page=1&show=12">일본도서(외국)</a></li>
		                                            <li><a href="/library/category/book?catgoId=9&page=1&show=12">과학(외국)</a></li>
		                                            <li><a href="/library/category/book?catgoId=10&page=1&show=12">예술/대중문화(외국)</a></li>
		                                            <li><a href="/library/category/dvd?page=1&show=12">DVD</a></li>
	                                            </ul>
                                        </li>

                                        <li class="dropdown-content">
                                            <a id="toc-toggle" onclick="openCloseToc_three()">게시판</a>
                                            	<ul id="toc-contentthree">
		                                            <li><a href="/others/PBoard">공지사항</a></li>
		                                            <li><a href="/others/read.do">자유게시판</a></li>
	                                            </ul>
                                        </li>

                                        <li class="dropdown-content">
                                            <a id="toc-toggle" href="http://localhost:3000" data-submenu="computers">독서클럽</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                           

                            <div class="px-4 px-md-5 py-5">
                                <!-- Social Networks -->
                                <ul class="list-inline mb-0">
                                    <li class="list-inline-item">
                                        <a class="h-primary pr-2 font-size-2" href="#">
                                            <span class="fab fa-facebook-f btn-icon__inner"></span>
                                        </a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a class="h-primary pr-2 font-size-2" href="#">
                                            <span class="fab fa-google btn-icon__inner"></span>
                                        </a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a class="h-primary pr-2 font-size-2" href="#">
                                            <span class="fab fa-twitter btn-icon__inner"></span>
                                        </a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a class="h-primary pr-2 font-size-2" href="#">
                                            <span class="fab fa-github btn-icon__inner"></span>
                                        </a>
                                    </li>
                                </ul>
                                <!-- End Social Networks -->
                            </div>
                        </div>
                    </div>
                    <!-- End Content -->
                </div>
            </div>
        </div>
    </aside>
    <!-- End Categories Sidebar Navigation -->
    
     <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="/vendor/jquery/dist/jquery.min.js"></script>
    <script src="/vendor/jquery-migrate/dist/jquery-migrate.min.js"></script>
    <script src="/vendor/popper.js/dist/umd/popper.min.js"></script>
    <script src="/vendor/bootstrap/bootstrap.min.js"></script>
    <script src="/vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
    <script src="/vendor/slick-carousel/slick/slick.min.js"></script>
    <script src="/vendor/multilevel-sliding-mobile-menu/dist/jquery.zeynep.js"></script>

    <!-- JS HS Components -->
    <script src="/js/hs.core.js"></script>
    <script src="/js/components/hs.unfold.js"></script>
    <script src="/js/components/hs.malihu-scrollbar.js"></script>
    <script src="/js/components/hs.header.js"></script>
    <script src="/js/components/hs.slick-carousel.js"></script>
    <script src="/js/components/hs.selectpicker.js"></script>
    <script src="/js/components/hs.show-animation.js"></script>

    <script src="/js/login.js" type="text/javascript"></script> 
    <script src="/js/headerplus.js" type="text/javascript"></script>
    </body>
    </html>
    

    <!--===== END HEADER CONTENT =====-->
   
