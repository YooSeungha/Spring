<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <style type="text/css">
    table {
	    width: 100%;
	    border-top: 1px solid #663300;
	    border-collapse: collapse;
	    border-width:2px;
  		}
  	th{
  		background-color: #CCCCCC;
  	}
    th, td {
    	border-bottom: 1px solid #dddddd;
    	border-left: 1px solid #dddddd;
    	padding: 10px;
 		}
  		th:first-child, td:first-child {
    	border-left: none;
 	 	}
 	.ck-editor__editable { height: 500px; }
 	.ck-content { font-size: 12px; }
    </style>
    
    <!-- Title -->
    <title>책 4조 도서관</title>

    <!-- Required Meta Tags Always Come First -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    

    <!-- Favicon -->
    <link rel="shortcut icon" href="/img/favicon.png">
    
    <!-- 부트스트랩 아이콘 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">

    <!-- Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" rel="stylesheet">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="/font/flaticon.css">
    <link rel="stylesheet" href="/css/slick.css"/>
    <link rel="stylesheet" href="/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="/css/jquery.mCustomScrollbar.css">

    <!-- JS Front -->
    <link rel="stylesheet" href="/css/animate.css">
    <link rel="stylesheet" href="/css/hs.megamenu.css">

    <!-- CSS Bookworm Template -->
    <link rel="stylesheet" href="/css/theme.css">
 
    
</head>
<body>

    <!-- ===== HEADER CONTENT ===== -->
    <header id="site-header" class="site-header__v9 site-header__white-text">
        <div class="masthead">
            <div class="container pt-3 pt-md-4 pb-3 pb-md-5">
                <div class="d-flex align-items-center position-relative flex-wrap">
                    <div class="offcanvas-toggler mr-5">
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
                    
                    <!-- 위쪽 로고 -->
                    <div class="site-branding pr-7">
                        <a href="/" class="d-block mb-1">
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="170px" height="30px">
                                <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M166.225,28.691 L165.065,15.398 L160.598,28.691 L158.229,28.691 L153.762,15.398 L152.590,28.691 L148.928,28.691 L150.405,11.052 L155.629,11.052 L159.389,22.124 L163.198,11.052 L168.422,11.052 L169.875,28.691 L166.225,28.691 ZM142.641,28.691 L138.051,20.928 L136.989,20.928 L136.989,28.691 L133.327,28.691 L133.327,11.052 L139.724,11.052 C140.692,11.052 141.546,11.189 142.287,11.461 C143.028,11.734 143.620,12.112 144.063,12.596 C144.507,13.081 144.840,13.636 145.064,14.263 C145.288,14.889 145.400,15.577 145.400,16.326 C145.400,17.506 145.078,18.472 144.436,19.225 C143.793,19.978 142.869,20.484 141.665,20.745 L146.975,28.691 L142.641,28.691 ZM141.896,16.204 C141.896,15.544 141.673,15.028 141.225,14.653 C140.777,14.279 140.086,14.092 139.150,14.092 L136.989,14.092 L136.989,18.303 L139.150,18.303 C140.981,18.303 141.896,17.603 141.896,16.204 ZM125.570,27.831 C124.206,28.567 122.666,28.936 120.949,28.936 C119.224,28.936 117.680,28.567 116.317,27.831 C114.953,27.094 113.881,26.034 113.100,24.651 C112.319,23.267 111.928,21.672 111.928,19.866 C111.928,18.051 112.319,16.454 113.100,15.074 C113.881,13.695 114.953,12.639 116.317,11.907 C117.680,11.174 119.224,10.808 120.949,10.808 C122.674,10.808 124.217,11.174 125.576,11.907 C126.935,12.639 128.005,13.695 128.786,15.074 C129.567,16.454 129.958,18.051 129.958,19.866 C129.958,21.672 129.567,23.267 128.786,24.651 C128.005,26.034 126.933,27.094 125.570,27.831 ZM124.807,15.715 C123.797,14.690 122.512,14.177 120.949,14.177 C119.387,14.177 118.101,14.690 117.092,15.715 C116.083,16.741 115.578,18.124 115.578,19.866 C115.578,21.616 116.083,23.005 117.092,24.034 C118.101,25.064 119.387,25.579 120.949,25.579 C122.512,25.579 123.797,25.064 124.807,24.034 C125.816,23.005 126.320,21.616 126.320,19.866 C126.320,18.124 125.816,16.741 124.807,15.715 ZM66.872,28.691 L61.391,21.196 L60.097,21.196 L60.097,28.691 L56.435,28.691 L56.435,11.052 L60.097,11.052 L60.097,17.986 L61.342,17.986 L66.872,11.052 L71.340,11.052 L64.504,19.487 L71.547,28.691 L66.872,28.691 ZM48.677,27.831 C47.314,28.567 45.774,28.936 44.057,28.936 C42.332,28.936 40.788,28.567 39.425,27.831 C38.061,27.094 36.989,26.034 36.208,24.651 C35.427,23.267 35.036,21.672 35.036,19.866 C35.036,18.051 35.427,16.454 36.208,15.074 C36.989,13.695 38.061,12.639 39.425,11.907 C40.788,11.174 42.332,10.808 44.057,10.808 C45.782,10.808 47.324,11.174 48.684,11.907 C50.043,12.639 51.113,13.695 51.894,15.074 C52.675,16.454 53.066,18.051 53.066,19.866 C53.066,21.672 52.675,23.267 51.894,24.651 C51.113,26.034 50.040,27.094 48.677,27.831 ZM47.915,15.715 C46.905,14.690 45.620,14.177 44.057,14.177 C42.495,14.177 41.209,14.690 40.200,15.715 C39.191,16.741 38.686,18.124 38.686,19.866 C38.686,21.616 39.191,23.005 40.200,24.034 C41.209,25.064 42.495,25.579 44.057,25.579 C45.620,25.579 46.905,25.064 47.915,24.034 C48.924,23.005 49.428,21.616 49.428,19.866 C49.428,18.124 48.924,16.741 47.915,15.715 ZM28.487,27.831 C27.124,28.567 25.584,28.936 23.867,28.936 C22.141,28.936 20.597,28.567 19.234,27.831 C17.871,27.094 16.799,26.034 16.018,24.651 C15.236,23.267 14.846,21.672 14.846,19.866 C14.846,18.051 15.236,16.454 16.018,15.074 C16.799,13.695 17.871,12.639 19.234,11.907 C20.597,11.174 22.141,10.808 23.867,10.808 C25.592,10.808 27.134,11.174 28.493,11.907 C29.852,12.639 30.922,13.695 31.704,15.074 C32.485,16.454 32.875,18.051 32.875,19.866 C32.875,21.672 32.485,23.267 31.704,24.651 C30.922,26.034 29.850,27.094 28.487,27.831 ZM27.724,15.715 C26.715,14.690 25.429,14.177 23.867,14.177 C22.304,14.177 21.018,14.690 20.009,15.715 C19.000,16.741 18.496,18.124 18.496,19.866 C18.496,21.616 19.000,23.005 20.009,24.034 C21.018,25.064 22.304,25.579 23.867,25.579 C25.429,25.579 26.715,25.064 27.724,24.034 C28.733,23.005 29.238,21.616 29.238,19.866 C29.238,18.124 28.733,16.741 27.724,15.715 ZM11.672,27.367 C10.736,28.250 9.361,28.691 7.546,28.691 L0.283,28.691 L0.283,11.052 L5.996,11.052 C7.875,11.052 9.314,11.478 10.311,12.328 C11.308,13.178 11.806,14.365 11.806,15.886 C11.806,16.676 11.633,17.374 11.287,17.980 C10.941,18.586 10.431,19.052 9.755,19.377 C11.969,19.988 13.076,21.445 13.076,23.748 C13.076,25.278 12.608,26.484 11.672,27.367 ZM7.827,14.647 C7.420,14.277 6.821,14.092 6.032,14.092 L3.811,14.092 L3.811,18.242 L6.191,18.242 C6.940,18.242 7.501,18.047 7.875,17.656 C8.250,17.266 8.437,16.753 8.437,16.118 C8.437,15.508 8.233,15.018 7.827,14.647 ZM8.876,21.709 C8.445,21.278 7.749,21.062 6.789,21.062 L3.811,21.062 L3.811,25.554 L6.862,25.554 C7.782,25.554 8.455,25.347 8.883,24.932 C9.310,24.517 9.523,23.988 9.523,23.345 C9.523,22.686 9.308,22.140 8.876,21.709 Z"></path>
                                <path class="fill-primary" fill-rule="evenodd" d="M105.996,23.499 C105.995,26.752 103.950,29.265 100.748,29.950 C100.713,29.958 100.681,29.983 100.647,30.000 C100.588,30.000 100.529,30.000 100.471,30.000 C100.467,28.585 100.460,27.171 100.466,25.756 C100.467,25.675 100.550,25.565 100.626,25.518 C101.352,25.068 101.714,24.425 101.711,23.571 C101.707,22.020 101.710,20.469 101.710,18.892 C103.133,18.892 104.546,18.892 105.996,18.892 C105.996,18.989 105.996,19.093 105.996,19.196 C105.996,20.630 105.997,22.065 105.996,23.499 ZM101.715,17.089 C101.715,15.990 101.683,14.917 101.724,13.847 C101.767,12.679 102.761,11.806 103.931,11.838 C105.060,11.869 105.978,12.794 105.993,13.940 C106.005,14.954 105.995,15.969 105.995,16.983 C105.995,17.011 105.987,17.040 105.980,17.089 C104.569,17.089 103.157,17.089 101.715,17.089 ZM96.421,29.234 C94.322,27.983 93.199,26.136 93.155,23.703 C93.108,21.138 93.145,18.571 93.146,16.005 C93.146,15.957 93.153,15.910 93.159,15.841 C94.572,15.841 95.976,15.841 97.426,15.841 C97.426,15.948 97.426,16.060 97.426,16.172 C97.426,18.602 97.430,21.031 97.423,23.461 C97.421,24.364 97.757,25.066 98.548,25.540 C98.629,25.589 98.688,25.740 98.689,25.844 C98.699,27.122 98.695,28.401 98.696,29.679 C98.696,29.786 98.703,29.893 98.707,30.000 C98.648,30.000 98.590,30.000 98.531,30.000 C97.799,29.823 97.075,29.624 96.421,29.234 ZM93.145,14.043 C93.145,13.935 93.145,13.823 93.145,13.711 C93.145,11.318 93.137,8.926 93.149,6.534 C93.154,5.625 92.818,4.928 92.023,4.460 C91.961,4.424 91.894,4.332 91.894,4.265 C91.886,2.850 91.888,1.436 91.888,0.000 C93.423,0.232 94.703,0.889 95.731,2.009 C96.833,3.209 97.413,4.630 97.421,6.261 C97.433,8.791 97.426,11.319 97.427,13.849 C97.427,13.906 97.421,13.964 97.416,14.043 C96.005,14.043 94.599,14.043 93.145,14.043 ZM89.588,4.782 C89.034,5.128 88.866,5.768 88.868,6.431 C88.875,8.061 88.870,9.692 88.869,11.322 C88.869,12.143 88.869,12.963 88.867,13.783 C88.867,13.869 88.857,13.954 88.851,14.051 C87.434,14.051 86.035,14.051 84.587,14.051 C84.587,13.958 84.587,13.866 84.587,13.774 C84.588,11.294 84.579,8.814 84.590,6.334 C84.605,3.158 86.853,0.543 90.000,0.018 C90.028,0.013 90.058,0.017 90.125,0.017 C90.125,0.639 90.125,1.243 90.125,1.848 C90.125,2.405 90.109,2.962 90.130,3.518 C90.149,4.032 90.126,4.447 89.588,4.782 ZM84.585,15.837 C86.015,15.837 87.420,15.837 88.868,15.837 C88.868,15.951 88.868,16.065 88.868,16.179 C88.868,18.608 88.849,21.039 88.873,23.468 C88.908,27.007 86.358,29.493 83.589,29.955 C83.552,29.961 83.518,29.985 83.482,30.000 C83.424,30.000 83.365,30.000 83.306,30.000 C83.310,28.634 83.319,27.268 83.313,25.902 C83.311,25.691 83.376,25.580 83.559,25.467 C84.268,25.031 84.587,24.371 84.587,23.549 C84.587,21.099 84.586,18.650 84.585,16.201 C84.585,16.085 84.585,15.970 84.585,15.837 ZM81.366,30.000 C80.875,29.844 80.360,29.740 79.897,29.524 C77.435,28.380 76.120,26.440 76.027,23.732 C75.974,22.192 76.017,20.649 76.016,19.107 C76.016,19.040 76.016,18.973 76.016,18.886 C77.447,18.886 78.859,18.886 80.303,18.886 C80.303,19.000 80.303,19.104 80.303,19.209 C80.303,20.663 80.308,22.117 80.302,23.571 C80.298,24.427 80.666,25.065 81.387,25.518 C81.463,25.566 81.547,25.675 81.547,25.756 C81.553,27.171 81.546,28.585 81.542,30.000 C81.484,30.000 81.425,30.000 81.366,30.000 ZM76.017,17.097 C76.017,16.540 76.017,15.997 76.017,15.453 C76.017,14.965 76.012,14.478 76.017,13.990 C76.030,12.831 76.911,11.892 78.032,11.838 C79.203,11.781 80.217,12.619 80.282,13.797 C80.341,14.885 80.294,15.978 80.294,17.097 C78.857,17.097 77.452,17.097 76.017,17.097 Z"></path>
                            </svg>
                        </a>
                    </div>
                    <!-- 로고 끝 -->
                    
                    <div class="site-search ml-xl-0 ml-md-auto w-r-100 flex-grow-1 mr-md-5 mt-2 mt-md-0 order-1 order-md-0">
                        <form class="form-inline my-2 my-xl-0">
                            <div class="input-group input-group-borderless w-100">
                                <div class="input-group-prepend border-right mr-0 d-none d-xl-block">
                                    <select class="custom-select pr-7 pl-4 rounded-right-0 height-5 shadow-none border-0 text-dark bg-gray-200" id="inputGroupSelect01">
                                        <option selected>카테고리 선택</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </select>
                                </div>
                                <input type="text" class="form-control px-3 bg-gray-200 bg-focus__1" placeholder="찾고 싶은 책을 입력해 주세요" aria-label="Amount (to the nearest dollar)">
                                <div class="input-group-append">
                                    <button class="btn btn-primary px-3 py-2" type="submit"><i class="bi bi-search"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="d-flex align-items-center mt-lg-3 mt-xl-0">
                    
                        <!-- Account Sidebar Toggle Button -->
                        <a id="sidebarNavToggler" href="javascript:;" role="button"
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
                            <div class="d-flex align-items-center text-dark font-size-5 text-lh-sm">
                                <i class="bi bi-file-person-fill"></i>
                                <div class="ml-2 d-none d-lg-block">
                                    <span class="text-secondary-gray-1080 font-size-1">로그인</span>
                                    <div class="text-secondary-black-100 font-size-2">계정정보</div>
                                </div>
                            </div>
                        </a>
                        <!-- End Account Sidebar Toggle Button -->

                        <!-- Cart Sidebar Toggle Button -->
                        <a id="sidebarNavToggler1" href="javascript:;" role="button" class="ml-4 d-none d-lg-block"
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
                            <div class="d-flex align-items-center text-white font-size-2 text-lh-sm position-relative">
                                <span class="position-absolute width-16 height-16 rounded-circle d-flex align-items-center justify-content-center bg-dark-1 text-white font-size-n9 left-0 top-0 ml-n2 mt-n1">3</span>
                                <i class="flaticon-icon-126515 font-size-4 text-secondary-black-100"></i>
                                <div class="ml-2">
                                    <span class="text-secondary-gray-1080 font-size-1">장바구니</span>
                                    <div class="font-size-2 text-secondary-black-100">돈 표시</div>
                                </div>
                            </div>
                        </a>
                        <!-- End Cart Sidebar Toggle Button -->
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="bg-primary rounded-md d-none d-md-block">
                    <div class="d-flex align-items-center justify-content-center position-relative">
                        <div class="site-navigation mr-auto d-none d-xl-block">
                            <ul class="nav pl-xl-4">
                                <li class="nav-item dropdown">
                                    <a id="homeDropdownInvoker" href="#" class="dropdown-toggle nav-link link-black-100 mx-3 px-0 py-3 font-size-2 font-weight-medium d-flex align-items-center"
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
                                        메뉴1
                                    </a>
                                    <ul id="homeDropdownMenu" class="dropdown-unfold dropdown-menu font-size-2 rounded-0 border-gray-900" aria-labelledby="homeDropdownInvoker">
                                        <li><a href="../home/index.html" class="dropdown-item link-black-100">메뉴1-1</a></li>
                                        <li><a href="../home/home-v2.html" class="dropdown-item link-black-100">메뉴1-2</a></li>
                                        <li><a href="../home/home-v3.html" class="dropdown-item link-black-100">메뉴1-3</a></li>
                                        <li><a href="../home/home-v4.html" class="dropdown-item link-black-100">메뉴1-4</a></li>
                                        <li><a href="../home/home-v5.html" class="dropdown-item link-black-100">메뉴1-5</a></li>
                                        <li><a href="../home/home-v6.html" class="dropdown-item link-black-100">메뉴1-6</a></li>
                                        <li><a href="../home/home-v7.html" class="dropdown-item link-black-100">메뉴1-7</a></li>
                                        <li><a href="../home/home-v8.html" class="dropdown-item link-black-100">메뉴1-8</a></li>
                                    </ul>
                                </li>
                                <!-- <li class="nav-item"><a href="#" class="nav-link link-black-100 mx-3 px-0 py-3 font-size-2 font-weight-medium">Categories</a></li> 
                                <li class="nav-item dropdown">
                                    <a id="shopDropdownInvoker" href="#" class="dropdown-toggle nav-link link-black-100 mx-3 px-0 py-3 font-size-2 font-weight-medium d-flex align-items-center"
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
                                        메뉴2
                                    </a>-->
                                    <ul id="shopDropdownMenu" class="dropdown-unfold dropdown-menu font-size-2 rounded-0 border-gray-900" aria-labelledby="shopDropdownInvoker">
                                        <li class="position-relative">
                                            <a id="shopDropdownsubmenuoneInvoker" href="#" class="dropdown-toggle dropdown-item dropdown-item__sub-menu link-black-100 d-flex align-items-center justify-content-between"
                                                aria-haspopup="true"
                                                aria-expanded="false"
                                                data-unfold-event="hover"
                                                data-unfold-target="#shopDropdownsubMenuone"
                                                data-unfold-type="css-animation"
                                                data-unfold-duration="200"
                                                data-unfold-delay="100"
                                                data-unfold-hide-on-scroll="true"
                                                data-unfold-animation-in="slideInUp"
                                                data-unfold-animation-out="fadeOut">Shop List
                                            </a>
                                            <ul id="shopDropdownsubMenuone" class="dropdown-unfold dropdown-menu dropdown-sub-menu font-size-2 rounded-0 border-gray-900" aria-labelledby="shopDropdownsubmenuoneInvoker">
                                                <li><a href="../shop/v1.html" class="dropdown-item link-black-100">Shop List v1</a></li>
                                                <li><a href="../shop/v2.html" class="dropdown-item link-black-100">Shop List v2</a></li>
                                                <li><a href="../shop/v3.html" class="dropdown-item link-black-100">Shop List v3</a></li>
                                                <li><a href="../shop/v4.html" class="dropdown-item link-black-100">Shop List v4</a></li>
                                                <li><a href="../shop/v5.html" class="dropdown-item link-black-100">Shop List v5</a></li>
                                                <li><a href="../shop/v6.html" class="dropdown-item link-black-100">Shop List v6</a></li>
                                                <li><a href="../shop/v7.html" class="dropdown-item link-black-100">Shop List v7</a></li>
                                                <li><a href="../shop/v8.html" class="dropdown-item link-black-100">Shop List v8</a></li>
                                                <li><a href="../shop/v9.html" class="dropdown-item link-black-100">Shop List v9</a></li>
                                            </ul>
                                        </li>
                                        <li class="position-relative">
                                            <a id="shopDropdownsubmenutwoInvoker" href="#" class="dropdown-toggle dropdown-item dropdown-item__sub-menu link-black-100 d-flex align-items-center justify-content-between"
                                                aria-haspopup="true"
                                                aria-expanded="false"
                                                data-unfold-event="hover"
                                                data-unfold-target="#shopDropdownsubMenutwo"
                                                data-unfold-type="css-animation"
                                                data-unfold-duration="200"
                                                data-unfold-delay="100"
                                                data-unfold-hide-on-scroll="true"
                                                data-unfold-animation-in="slideInUp"
                                                data-unfold-animation-out="fadeOut">Single Product
                                            </a>
                                            <ul id="shopDropdownsubMenutwo" class="dropdown-unfold dropdown-menu dropdown-sub-menu font-size-2 rounded-0 border-gray-900" aria-labelledby="shopDropdownsubmenutwoInvoker">
                                                <li><a href="../shop/single-product-v1.html" class="dropdown-item link-black-100">Shop Single v1</a></li>
                                                <li><a href="../shop/single-product-v2.html" class="dropdown-item link-black-100">Shop Single v2</a></li>
                                                <li><a href="../shop/single-product-v3.html" class="dropdown-item link-black-100">Shop Single v3</a></li>
                                                <li><a href="../shop/single-product-v4.html" class="dropdown-item link-black-100">Shop Single v4</a></li>
                                                <li><a href="../shop/single-product-v5.html" class="dropdown-item link-black-100">Shop Single v5</a></li>
                                                <li><a href="../shop/single-product-v6.html" class="dropdown-item link-black-100">Shop Single v6</a></li>
                                                <li><a href="../shop/single-product-v7.html" class="dropdown-item link-black-100">Shop Single v7</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="../shop/cart.html" class="dropdown-item link-black-100">Shop cart</a></li>
                                        <li><a href="../shop/checkout.html" class="dropdown-item link-black-100">Shop checkout</a></li>
                                        <li><a href="../shop/my-account.html" class="dropdown-item link-black-100">Shop My Account</a></li>
                                        <li><a href="../shop/order-received.html" class="dropdown-item link-black-100">Shop Order Received</a></li>
                                        <li><a href="../shop/order-tracking.html" class="dropdown-item link-black-100">Shop Order Tracking</a></li>
                                        <li><a href="../shop/store-location.html" class="dropdown-item link-black-100">Shop Store Location</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item">
                                    <a id="featuresDropdownInvoker" href="#" class="dropdown-toggle nav-link link-black-100 mx-3 px-0 py-3 font-size-2 font-weight-medium d-flex align-items-center"
                                        aria-haspopup="true"
                                        aria-expanded="false"
                                        data-unfold-event="hover"
                                        data-unfold-target="#featuresDropdownMenu"
                                        data-unfold-type="css-animation"
                                        data-unfold-duration="200"
                                        data-unfold-delay="50"
                                        data-unfold-hide-on-scroll="true"
                                        data-unfold-animation-in="slideInUp"
                                        data-unfold-animation-out="fadeOut">
                                        메뉴2
                                    </a>
                                    <div id="featuresDropdownMenu" class="p-0 dropdown-unfold dropdown-menu megamenu font-size-2 rounded-0 border-gray-900" aria-labelledby="featuresDropdownInvoker" style="width:100%;">
                                        <div class="row no-gutters">
                                            <div class="col-8 px-1">
                                                <div class="px-5 py-2 pb-5">
                                                    <div class="row">
                                                        <div class="col-3">
                                                            <ul class="menu list-unstyled">
                                                                <li><span class=" d-block link-black-100 py-3 font-size-3 font-weight-medium">Home</span></li>
                                                                <li><a href="../home/index.html" class="d-block link-black-100 py-1">Home v1</a></li>
                                                                <li><a href="../home/home-v2.html" class="d-block link-black-100 py-1">Home v2</a></li>
                                                                <li><a href="../home/home-v3.html" class="d-block link-black-100 py-1">Home v3</a></li>
                                                                <li><a href="../home/home-v4.html" class="d-block link-black-100 py-1">Home v4</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-3">
                                                            <ul class="menu list-unstyled">
                                                                <li><span class=" d-block link-black-100 py-3 font-size-3 font-weight-medium">Single Product</span></li>
                                                                <li><a href="../shop/single-product-v1.html" class="d-block link-black-100 py-1">Single Product v1</a></li>
                                                                <li><a href="../shop/single-product-v2.html" class="d-block link-black-100 py-1">Single Product v2</a></li>
                                                                <li><a href="../shop/single-product-v3.html" class="d-block link-black-100 py-1">Single Product v3</a></li>
                                                                <li><a href="../shop/single-product-v4.html" class="d-block link-black-100 py-1">Single Product v4</a></li>
                                                                <li><span class=" d-block link-black-100 py-3 font-size-3 font-weight-medium">Shop Pages</span></li>
                                                                <li><a href="../shop/cart.html" class="d-block link-black-100 py-1">Shop cart</a></li>
                                                                <li><a href="../shop/checkout.html" class="d-block link-black-100 py-1">Shop checkout</a></li>
                                                                <li><a href="../shop/my-account.html" class="d-block link-black-100 py-1">Shop My Account</a></li>
                                                                <li><a href="../shop/order-received.html" class="d-block link-black-100 py-1">Shop Order Received</a></li>
                                                                <li><a href="../shop/order-tracking.html" class="d-block link-black-100 py-1">Shop Order Tracking</a></li>
                                                                <li><a href="../shop/store-location.html" class="d-block link-black-100 py-1">Shop Store Location</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-3">
                                                            <ul class="menu list-unstyled">
                                                                <li><span class=" d-block link-black-100 py-3 font-size-3 font-weight-medium">Shop List</span></li>
                                                                <li><a href="../shop/v1.html" class="d-block link-black-100 py-1">Shop List v1</a></li>
                                                                <li><a href="../shop/v2.html" class="d-block link-black-100 py-1">Shop List v2</a></li>
                                                                <li><a href="../shop/v3.html" class="d-block link-black-100 py-1">Shop List v3</a></li>
                                                                <li><a href="../shop/v4.html" class="d-block link-black-100 py-1">Shop List v4</a></li>
                                                                <li><span class=" d-block link-black-100 py-3 font-size-3 font-weight-medium">Blog</span></li>
                                                                <li><a href="../blog/blog-v1.html" class="d-block link-black-100 py-1">Blog v1</a></li>
                                                                <li><a href="../blog/blog-v2.html" class="d-block link-black-100 py-1">Blog v2</a></li>
                                                                <li><a href="../blog/blog-v3.html" class="d-block link-black-100 py-1">Blog v3</a></li>
                                                                <li><a href="../blog/blog-single.html" class="d-block link-black-100 py-1">Blog Single</a></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-3">
                                                            <ul class="menu list-unstyled">
                                                                <li><span class=" d-block link-black-100 py-3 font-size-3 font-weight-medium">Others</span></li>
                                                                <li><a href="../others/404.html" class="d-block link-black-100 py-1">404</a></li>
                                                                <li><a href="../others/about.html" class="d-block link-black-100 py-1">About Us</a></li>
                                                                <li><a href="../others/authors-list.html" class="d-block link-black-100 py-1">Authors List</a></li>
                                                                <li><a href="../others/authors-single.html" class="d-block link-black-100 py-1">Authors Single</a></li>
                                                                <li><a href="../others/coming-soon.html" class="d-block link-black-100 py-1">Coming Soon</a></li>
                                                                <li><a href="../others/contact.html" class="d-block link-black-100 py-1">Contact Us</a></li>
                                                                <li><a href="../others/faq.html" class="d-block link-black-100 py-1">FAQ</a></li>
                                                                <li><a href="../others/pricing-table.html" class="d-block link-black-100 py-1">Pricing Table</a></li>
                                                                <li><a href="../others/terms-conditions.html" class="d-block link-black-100 py-1">Terms Conditions</a></li>
                              <li><a href="../../documentation/index.html" class="btn btn-primary mb-3 mb-md-0 mb-xl-3 mt-4 font-size-2 btn-block">Documentation</a></li>
                              <li><a href="../../starter/index.html" class="btn btn-secondary font-size-2 btn-block mb-2">Starter</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-4 bg-gray-200">
                                                <div class="banner px-8 py-5">
                                                    <div class="banner__body">
                                                        <h3 class="banner_text m-0">
                                                            <span class="d-block mb-1 font-size-7 font-weight-regular">Deals in </span>
                                                            <span class="d-block mb-2 font-size-10 text-primary font-weight-bold">Books</span>
                                                        </h3>
                                                        <a href="#" class="d-block link-black-100 mb-6">Shop Now</a>
                                                        <div class="banner__image">
                                                            <img src="https://placehold.it/280x210" class="img-fluid" alt="image-description">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="nav-item dropdown">
                                    <a id="blogDropdownInvoker" href="#" class="dropdown-toggle nav-link link-black-100 mx-3 px-0 py-3 font-size-2 font-weight-medium d-flex align-items-center"
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
                                        메뉴3
                                    </a>
                                    <ul id="blogDropdownMenu" class="dropdown-unfold dropdown-menu font-size-2 rounded-0 border-gray-900" aria-labelledby="blogDropdownInvoker">
                                        <li><a href="../blog/blog-v1.html" class="dropdown-item link-black-100">메뉴3-1</a></li>
                                        <li><a href="../blog/blog-v2.html" class="dropdown-item link-black-100">메뉴3-2</a></li>
                                        <li><a href="../blog/blog-v3.html" class="dropdown-item link-black-100">메뉴3-3</a></li>
                                        <li><a href="../blog/blog-single.html" class="dropdown-item link-black-100">메뉴3-4</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown">
                                    <a id="pagesDropdownInvoker" href="#" class="dropdown-toggle nav-link link-black-100 mx-3 px-0 py-3 font-size-2 font-weight-medium d-flex align-items-center"
                                        aria-haspopup="true"
                                        aria-expanded="false"
                                        data-unfold-event="hover"
                                        data-unfold-target="#pagesDropdownMenu"
                                        data-unfold-type="css-animation"
                                        data-unfold-duration="200"
                                        data-unfold-delay="50"
                                        data-unfold-hide-on-scroll="true"
                                        data-unfold-animation-in="slideInUp"
                                        data-unfold-animation-out="fadeOut">
                                        Others
                                    </a>
                                    <ul id="pagesDropdownMenu" class="dropdown-unfold dropdown-menu font-size-2 rounded-0 border-gray-900" aria-labelledby="pagesDropdownInvoker">
                                        <li><a href="../others/404.html" class="dropdown-item link-black-100">404</a></li>
                                        <li><a href="../others/about.html" class="dropdown-item link-black-100">About Us</a></li>
                                        <li><a href="../others/authors-list.html" class="dropdown-item link-black-100">Authors List</a></li>
                                        <li><a href="../others/authors-single.html" class="dropdown-item link-black-100">Authors Single</a></li>
                                        <li><a href="../others/coming-soon.html" class="dropdown-item link-black-100">Coming Soon</a></li>
                                        <li><a href="../others/contact.html" class="dropdown-item link-black-100">Contact Us</a></li>
                                        <li><a href="../others/faq.html" class="dropdown-item link-black-100">FAQ</a></li>
                                        <li><a href="../others/pricing-table.html" class="dropdown-item link-black-100">Pricing Table</a></li>
                                        <li><a href="../others/terms-conditions.html" class="dropdown-item link-black-100">Terms Conditions</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>

                        <div class="secondary-navigation">
                            <ul class="nav pr-xl-4">
                                <li class="nav-item"><a href="#" class="nav-link text-white mx-2 px-0 py-3 font-size-2 font-weight-medium">오늘의 딜</a></li>
                                <li class="nav-item"><a href="#" class="nav-link text-white mx-2 px-0 py-3 font-size-2 font-weight-medium">베스트셀러</a></li>
                                <li class="nav-item"><a href="#" class="nav-link text-white mx-2 px-0 py-3 font-size-2 font-weight-medium">인기도서</a></li>
                            </ul>
                        </div>
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
                            <span aria-hidden="true">창 닫기 <i class="bi bi-caret-left-fill"></i></span>
                        </button>
                    </div>
                    <!-- End Toggle Button -->

                    <!-- Content  로그인 , 회원가입 -->
                    <div class="js-scrollbar u-sidebar__body">
                        <div class="u-sidebar__content u-header-sidebar__content">
                            <form class="">
                                <!-- Login -->
                                <div id="login" data-target-group="idForm">
                                    <!-- Title -->
                                    <header class="border-bottom px-4 px-md-6 py-4">
                                        <h2 class="font-size-3 mb-0 d-flex align-items-center"><i class="flaticon-user mr-3 font-size-5"></i>로그인</h2>
                                    </header>
                                    <!-- End Title -->

                                    <div class="p-4 p-md-6">
                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinEmailLabel" class="form-label" for="signinEmail">이메일</label>
                                                <input type="email" class="form-control rounded-0 height-4 px-4" name="email" id="signinEmail" placeholder="이메일 입력" aria-describedby="signinEmailLabel" required>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->

                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinPasswordLabel" class="form-label" for="signinPassword">비밀번호 *</label>
                                                <input type="password" class="form-control rounded-0 height-4 px-4" name="password" id="signinPassword" placeholder="비밀번호 입력" aria-label="" aria-describedby="signinPasswordLabel" required>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->

                                        <div class="d-flex justify-content-between mb-5 align-items-center">
                                            <!-- Checkbox -->
                                            <div class="js-form-message">
                                                <div class="custom-control custom-checkbox d-flex align-items-center text-muted">
                                                    <input type="checkbox" class="custom-control-input" id="termsCheckbox" name="termsCheckbox" required>
                                                    <label class="custom-control-label" for="termsCheckbox">
                                                        <span class="font-size-2 text-secondary-gray-700">
                                                            계정기억하기
                                                        </span>
                                                    </label>
                                                </div>
                                            </div>
                                            <!-- End Checkbox -->

                                            <a class="js-animation-link text-dark font-size-2 t-d-u link-muted font-weight-medium" href="javascript:;"
                                            data-target="#forgotPassword"
                                            data-link-group="idForm"
                                            data-animation-in="fadeIn">패스워드를 잊어버리셨나요?</a>
                                        </div>

                                        <div class="mb-4d75">
                                            <button type="submit" class="btn btn-block py-3 rounded-0 btn-dark">로그인</button>
                                        </div>

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

                                    <div class="p-4 p-md-6">
                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinEmailLabel1" class="form-label" for="signinEmail1">이메일 *</label>
                                                <input type="email" class="form-control rounded-0 height-4 px-4" name="email" id="signinEmail1" placeholder="이메일 입력" aria-describedby="signinEmailLabel1" required>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->

                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinPasswordLabel1" class="form-label" for="signinPassword1">비밀번호 *</label>
                                                <input type="password" class="form-control rounded-0 height-4 px-4" name="password" id="signinPassword1" placeholder="패스워드 입력" aria-describedby="signinPasswordLabel1" required>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->

                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signupConfirmPasswordLabel" class="form-label" for="signupConfirmPassword">핸드폰 *</label>
                                                <input type="tel" class="form-control rounded-0 height-4 px-4" name="phone" id="" placeholder="핸드폰 번호 입력" aria-describedby="signupConfirmPasswordLabel" required>
                                            </div>
                                        </div>
                                        <!-- End Input -->
                                         <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinEmailLabel1" class="form-label" for="signinEmail1">아이디 *</label>
                                                <input type="text" class="form-control rounded-0 height-4 px-4" name="id" id="signinEmail1" placeholder="아이디 입력" aria-describedby="signinEmailLabel1" required>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->
                                        
                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinEmailLabel1" class="form-label" for="signinEmail1">이름 *</label>
                                                <input type="text" class="form-control rounded-0 height-4 px-4" name="name" id="signinEmail1" placeholder="이름 입력" aria-describedby="signinEmailLabel1" required>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->

                                        <div class="mb-3">
                                            <button type="submit" class="btn btn-block py-3 rounded-0 btn-dark">계정 생성</button>
                                        </div>

                                        <div class="text-center mb-4">
                                            <span class="small text-muted">이미 계정이 있나요?</span>
                                            <a class="js-animation-link small" href="javascript:;"
                                                data-target="#login"
                                                data-link-group="idForm"
                                                data-animation-in="fadeIn">로그인
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!-- End Signup -->

                                <!-- Forgot Password 비밀번호 찾기 -->
                                <div id="forgotPassword" style="display: none; opacity: 0;" data-target-group="idForm">
                                    <!-- Title -->
                                    <header class="border-bottom px-4 px-md-6 py-4">
                                        <h2 class="font-size-3 mb-0 d-flex align-items-center"><i class="flaticon-question mr-3 font-size-5"></i>비밀번호 찾기</h2>
                                    </header>
                                    <!-- End Title -->

                                    <div class="p-4 p-md-6">
                                        <!-- Form Group -->
                                        <div class="form-group mb-4">
                                            <div class="js-form-message js-focus-state">
                                                <label id="signinEmailLabel3" class="form-label" for="signinEmail3">이메일 *</label>
                                                <input type="email" class="form-control rounded-0 height-4 px-4" name="email" id="signinEmail3" placeholder="이메일을 입력하세요" aria-describedby="signinEmailLabel3" required>
                                            </div>
                                        </div>
                                        <!-- End Form Group -->

                                        <div class="mb-3">
                                            <button type="submit" class="btn btn-block py-3 rounded-0 btn-dark">비밀번호 복구하기</button>
                                        </div>

                                        <div class="text-center mb-4">
                                            <span class="small text-muted">패스워드가 기억나셨나요?</span>
                                            <a class="js-animation-link small" href="javascript:;"
                                                data-target="#login"
                                                data-link-group="idForm"
                                                data-animation-in="fadeIn">로그인
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <!-- End Forgot Password -->
                            </form>
                        </div>
                    </div>
                    <!-- End Content -->
                </div>
            </div>
        </div>
    </aside>
    <!-- End Account Sidebar Navigation - Desktop -->

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
                            <span aria-hidden="true">Close <i class="bi bi-caret-left-fill"></i></span>
                        </button>
                    </div>
                    <!-- End Toggle Button -->

                    <!-- Content -->
                    <div class="u-sidebar__body">
                        <div class="u-sidebar__content u-header-sidebar__content">
                            <!-- Title -->
                            <header class="border-bottom px-4 px-md-6 py-4">
                                <h2 class="font-size-3 mb-0 d-flex align-items-center"><i class="flaticon-icon-126515 mr-3 font-size-5"></i>Your shopping bag (3)</h2>
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

                            <div class="px-4 py-5 px-md-6 border-bottom">
                                <div class="media">
                                    <a href="#" class="d-block"><img src="https://placehold.it/100x153" class="img-fluid" alt="image-description"></a>
                                    <div class="media-body ml-4d875">
                                        <div class="text-primary text-uppercase font-size-1 mb-1 text-truncate"><a href="#">Hard Cover</a></div>
                                        <h2 class="woocommerce-loop-product__title h6 text-lh-md mb-1 text-height-2 crop-text-2">
                                            <a href="#" class="text-dark">The Rural Diaries: Love, Livestock, and  Big Life Lessons Down</a>
                                        </h2>
                                        <div class="font-size-2 mb-1 text-truncate"><a href="#" class="text-gray-700">Hillary Burton</a></div>
                                        <div class="price d-flex align-items-center font-weight-medium font-size-3">
                                            <span class="woocommerce-Price-amount amount">2 x <span class="woocommerce-Price-currencySymbol">$</span>200</span>
                                        </div>
                                    </div>
                                    <div class="mt-3 ml-3">
                                        <a href="#" class="text-dark"><i class="fas fa-times"></i></a>
                                    </div>
                                </div>
                            </div>

                            <div class="px-4 py-5 px-md-6 border-bottom">
                                <div class="media">
                                    <a href="#" class="d-block"><img src="https://placehold.it/100x153" class="img-fluid" alt="image-description"></a>
                                    <div class="media-body ml-4d875">
                                        <div class="text-primary text-uppercase font-size-1 mb-1 text-truncate"><a href="#">Paperback</a></div>
                                        <h2 class="woocommerce-loop-product__title h6 text-lh-md mb-1 text-height-2 crop-text-2">
                                            <a href="#" class="text-dark">Russians Among Us: Sleeper Cells,  Ghost Stories, and the Hunt.</a>
                                        </h2>
                                        <div class="font-size-2 mb-1 text-truncate"><a href="#" class="text-gray-700">Gordon Corera</a></div>
                                        <div class="price d-flex align-items-center font-weight-medium font-size-3">
                                            <span class="woocommerce-Price-amount amount">6 x <span class="woocommerce-Price-currencySymbol">$</span>100</span>
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
    <aside id="sidebarContent2" class="u-sidebar u-sidebar__md u-sidebar--left" aria-labelledby="sidebarNavToggler2">
        <div class="u-sidebar__scroller js-scrollbar">
            <div class="u-sidebar__container">
                <div class="u-header-sidebar__footer-offset">
                    <!-- Content -->
                    <div class="u-sidebar__body">
                        <div class="u-sidebar__content u-header-sidebar__content">
                            <!-- Title -->
                            <header class="border-bottom px-4 px-md-5 py-4 d-flex align-items-center justify-content-between">
                                <h2 class="font-size-3 mb-0">SHOP BY CATEGORY</h2>

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
                                            <a href="#" data-submenu="off-pages">Pages</a>

                                            <div id="off-pages" class="submenu">
                                                <div class="submenu-header" data-submenu-close="off-pages">
                                                    <a href="#">Pages</a>
                                                </div>

                                                <ul>
                                                    <li class="has-submenu">
                                                        <a href="#" data-submenu="off-home">Home Pages</a>

                                                        <div id="off-home" class="submenu js-scrollbar">
                                                            <div class="submenu-header" data-submenu-close="off-home">
                                                                <a href="#">Home Pages</a>
                                                            </div>

                                                            <ul class="">
                                                                <li>
                                                                    <a href="../home/index.html">Home v1</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v2.html">Home v2</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v3.html">Home v2</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v3.html">Home v3</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v4.html">Home v4</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v5.html">Home v5</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v6.html">Home v6</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v7.html">Home v7</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v8.html">Home v8</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v9.html">Home v9</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v10.html">Home v10</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v11.html">Home v11</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v12.html">Home v12</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../home/home-v13.html">Home v13</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </li>

                                                    <li class="has-submenu">
                                                        <a href="#" data-submenu="off-single-product">Single Product</a>

                                                        <div id="off-single-product" class="submenu js-scrollbar">
                                                            <div class="submenu-header" data-submenu-close="off-single-product">
                                                                <a href="#">Single Product</a>
                                                            </div>

                                                            <ul class="">
                                                                <li>
                                                                    <a href="../shop/single-product-v1.html">Single Product v1</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/single-product-v2.html">Single Product v2</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/single-product-v3.html">Single Product v3</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/single-product-v4.html">Single Product v4</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/single-product-v5.html">Single Product v5</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/single-product-v6.html">Single Product v6</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/single-product-v7.html">Single Product v7</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </li>

                                                    <li class="has-submenu">
                                                        <a href="#" data-submenu="off-shop-pages">Shop Pages</a>

                                                        <div id="off-shop-pages" class="submenu js-scrollbar">
                                                            <div class="submenu-header" data-submenu-close="off-shop-pages">
                                                                <a href="#">Shop Pages</a>
                                                            </div>

                                                            <ul class="">
                                                                <li>
                                                                    <a href="../shop/cart.html">Shop cart</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/checkout.html">Shop checkout</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/my-account.html">Shop My Account</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/order-received.html">Shop Order Received</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/order-tracking.html">Shop Order Tracking</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/store-location.html">Shop Store Location</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </li>

                                                    <li class="has-submenu">
                                                        <a href="#" data-submenu="off-shop-list">Shop List</a>

                                                        <div id="off-shop-list" class="submenu js-scrollbar">
                                                            <div class="submenu-header" data-submenu-close="off-shop-list">
                                                                <a href="#">Shop List</a>
                                                            </div>

                                                            <ul class="">
                                                                <li>
                                                                    <a href="../shop/v1.html">Shop List v1</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/v2.html">Shop List v2</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/v3.html">Shop List v3</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/v4.html">Shop List v4</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/v5.html">Shop List v5</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/v6.html">Shop List v6</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/v7.html">Shop List v7</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/v8.html">Shop List v8</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../shop/v9.html">Shop List v9</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </li>

                                                    <li class="has-submenu">
                                                        <a href="#" data-submenu="off-blog">Blog</a>

                                                        <div id="off-blog" class="submenu js-scrollbar">
                                                            <div class="submenu-header" data-submenu-close="off-blog">
                                                                <a href="#">Blog</a>
                                                            </div>

                                                            <ul class="">
                                                                <li>
                                                                    <a href="../blog/blog-v1.html">Blog v1</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../blog/blog-v2.html">Blog v2</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../blog/blog-v3.html">Blog v3</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../blog/blog-single.html">Blog Single</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </li>

                                                    <li class="has-submenu">
                                                        <a href="#" data-submenu="off-others">Others</a>

                                                        <div id="off-others" class="submenu js-scrollbar">
                                                            <div class="submenu-header" data-submenu-close="off-others">
                                                                <a href="#">Others</a>
                                                            </div>

                                                            <ul class="">
                                                                <li>
                                                                    <a href="../others/404.html">404</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../others/about.html">About Us</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../others/authors-list.html">Authors List</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../others/authors-single.html">Authors Single</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../others/coming-soon.html">Coming Soon</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../others/contact.html">Contact Us</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../others/faq.html">FAQ</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../others/pricing-table.html">Pricing Table</a>
                                                                </li>

                                                                <li>
                                                                    <a href="../others/terms-conditions.html">Terms Conditions</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </li>

                                                    <li class="px-5">
                                                        <a href="../../documentation/index.html" class="btn btn-primary mb-3 mb-md-0 mb-xl-3 mt-4 font-size-2 btn-block">Documentation</a>
                                                    </li>

                                                    <li class="px-5 mb-4">
                                                        <a href="../../starter/index.html" class="btn btn-secondary font-size-2 btn-block mb-2">Starter</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="has-submenu">
                                            <a href="#" data-submenu="art-photo">Arts & Photography</a>

                                            <div id="art-photo" class="submenu">
                                                <div class="submenu-header" data-submenu-close="art-photo">
                                                    <a href="#">Arts & Photography</a>
                                                </div>

                                                <ul>
                                                    <li>
                                                        <a href="#">Architecture</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Business of Art</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Collections, Catalogs & Exhibitions</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Decorative Arts & Design</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Drawing</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Fashion</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Graphic Design</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="has-submenu">
                                            <a href="#" data-submenu="biography">Biographies & Memoirs</a>

                                            <div id="biography" class="submenu">
                                                <div class="submenu-header" data-submenu-close="biography">
                                                    <a href="#">Biographies & Memoirs</a>
                                                </div>

                                                <ul>
                                                    <li>
                                                        <a href="#">Istanbul</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Mardin</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Amed</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="has-submenu">
                                            <a href="#" data-submenu="children">Children's Books</a>

                                            <div id="children" class="submenu">
                                                <div class="submenu-header" data-submenu-close="children">
                                                    <a href="#">Children's Books</a>
                                                </div>

                                                <ul>
                                                    <li class="has-submenu">
                                                        <a href="#" data-submenu="electronics">Electronics</a>

                                                        <div id="electronics" class="submenu js-scrollbar">
                                                            <div class="submenu-header" data-submenu-close="electronics">
                                                                <a href="#">Electronics</a>
                                                            </div>

                                                            <ul class="">
                                                                <li>
                                                                    <a href="#">Camera & Photo</a>
                                                                </li>

                                                                <li>
                                                                    <a href="#">Home Audio</a>
                                                                </li>

                                                                <li>
                                                                    <a href="#">Tv & Video</a>
                                                                </li>

                                                                <li>
                                                                    <a href="#">Computers & Accessories</a>
                                                                </li>

                                                                <li>
                                                                    <a href="#">Car & Vehicle Electronics</a>
                                                                </li>

                                                                <li>
                                                                    <a href="#">Portable Audio & Video</a>
                                                                </li>

                                                                <li>
                                                                    <a href="#">Headphones</a>
                                                                </li>

                                                                <li>
                                                                    <a href="#">Accessories & Supplies</a>
                                                                </li>

                                                                <li>
                                                                    <a href="#">Video Projectors</a>
                                                                </li>

                                                                <li>
                                                                    <a href="#">Office Electronics</a>
                                                                </li>

                                                                <li>
                                                                    <a href="#">Wearable Technology</a>
                                                                </li>

                                                                <li>
                                                                    <a href="#">Service Plans</a>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </li>

                                                    <li>
                                                        <a href="#">Books</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Video Games</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Computers</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="has-submenu">
                                            <a href="#" data-submenu="computers">Computers & Technology</a>

                                            <div id="computers" class="submenu">
                                                <div class="submenu-header" data-submenu-close="computers">
                                                    <a href="#">Computers & Technology</a>
                                                </div>

                                                <ul>
                                                    <li>
                                                        <a href="#">Istanbul</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Mardin</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Amed</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="has-submenu">
                                            <a href="#" data-submenu="cookbook">Cookbooks, Food & Wine</a>

                                            <div id="cookbook" class="submenu">
                                                <div class="submenu-header" data-submenu-close="cookbook">
                                                    <a href="#">Cookbooks, Food & Wine</a>
                                                </div>

                                                <ul>
                                                    <li>
                                                        <a href="#">Istanbul</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Mardin</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Amed</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="has-submenu">
                                            <a href="#" data-submenu="education">Education & Teaching</a>

                                            <div id="education" class="submenu">
                                                <div class="submenu-header" data-submenu-close="education">
                                                    <a href="#">Education & Teaching</a>
                                                </div>

                                                <ul>
                                                    <li>
                                                        <a href="#">Istanbul</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Mardin</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Amed</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="has-submenu">
                                            <a href="#" data-submenu="health">Health, Fitness & Dieting</a>

                                            <div id="health" class="submenu">
                                                <div class="submenu-header" data-submenu-close="health">
                                                    <a href="#">Health, Fitness & Dieting</a>
                                                </div>

                                                <ul>
                                                    <li>
                                                        <a href="#">Istanbul</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Mardin</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Amed</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="has-submenu">
                                            <a href="#" data-submenu="history">History</a>

                                            <div id="history" class="submenu">
                                                <div class="submenu-header" data-submenu-close="history">
                                                    <a href="#">History</a>
                                                </div>

                                                <ul>
                                                    <li>
                                                        <a href="#">Istanbul</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Mardin</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Amed</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="has-submenu">
                                            <a href="#" data-submenu="romance">Romance</a>

                                            <div id="romance" class="submenu">
                                                <div class="submenu-header" data-submenu-close="romance">
                                                    <a href="#">Romance</a>
                                                </div>

                                                <ul>
                                                    <li>
                                                        <a href="#">Istanbul</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Mardin</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Amed</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="has-submenu">
                                            <a href="#" data-submenu="sports">Sports & Outdoors</a>

                                            <div id="sports" class="submenu">
                                                <div class="submenu-header" data-submenu-close="sports">
                                                    <a href="#">Sports & Outdoors</a>
                                                </div>

                                                <ul>
                                                    <li>
                                                        <a href="#">Istanbul</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Mardin</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Amed</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="has-submenu">
                                            <a href="#" data-submenu="travel">Travel</a>

                                            <div id="travel" class="submenu">
                                                <div class="submenu-header" data-submenu-close="travel">
                                                    <a href="#">Travel</a>
                                                </div>

                                                <ul>
                                                    <li>
                                                        <a href="#">Istanbul</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Mardin</a>
                                                    </li>

                                                    <li>
                                                        <a href="#">Amed</a>
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

                            <div class="px-4 px-md-5 py-5">
                                <select class="custom-select mb-4 rounded-0 pl-4 height-4 shadow-none text-dark">
                                    <option selected>English (United States)</option>
                                    <option value="1">English (UK)</option>
                                    <option value="2">Arabic (Saudi Arabia)</option>
                                    <option value="3">Deutsch</option>
                                </select>
                                <select class="custom-select mb-4 rounded-0 pl-4 height-4 shadow-none text-dark">
                                    <option selected>$ USD</option>
                                    <option value="1">₩ won</option>
                                    <option value="2">Â¥ CNY</option>
                                    <option value="3">â¬ EUR</option>
                                </select>
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
	<main id="content">
        <div class="container" style="padding:50px">
        		<div class="col-md-12">
        			<h3>알림</h3>
					  <ol class="breadcrumb" style="background-color:white">
					    <li class="breadcrumb-item"><a href="#">Home</a></li>
					    <li class="breadcrumb-item"><a href="#">Home</a></li>
					    <li class="breadcrumb-item active" aria-current="page">알림</li>
					  </ol>
        		</div>
        	<!-- <div class="container"style="padding:5px; text-align-last: right;">
        		<a href="#" class="btn btn-dark btn-sm">글쓰기</a>
        	</div> -->
        	<div class="container">
        <!-- ADD START -->
        <form id="frm" method="Post" action="del.do?pb_num=${board.pb_num}">
        <!-- ADD END -->
            <table class="board_detail">
                <colgroup>
                    <col width="15%"/>
                    <col width="35%"/>
                    <col width="15%"/>
                    <col width="35%"/>
                </colgroup>
                <tbody>
                    <tr>
                        <th scope="row">글 번호</th>
                        <td>${board.pb_num}</td>
                        <th scope="row">조회수</th>
                        <td>${board.pb_view }</td>
                    </tr>
                    <tr>
                        <th scope="row">작성자</th>
                        <td >${board.mem_num}</td>
                        <th scope="row">작성일</th>
                        <td >${board.pb_rdate}</td>
                    </tr>
                    <tr>
                        <th scope="row">제목</th>
                        <td>${board.pb_title}</td>
                         <th scope="row">첨부파일</th>
                       		<td><a href="download.do?pb_fName=${board.pb_fName}">${board.pb_rName}"</a>
							</td>
                    </tr>
                    <tr>
                        <td colspan="4" class="view_text" style="width:100px">
                            ${board.pb_content}
                        </td>
                    </tr>
                </tbody>
            </table>
            <!-- ADD START -->
            <input type="hidden" name="boardpb_num" value="${board.pb_num}">
            <td colspan='2' align='center'>
				<input type="button" value="목록" onclick="location.href='Board'">
				<input type="button" value="수정" onclick="location.href='Update?pb_num=${board.pb_num}'">
				<input type="submit" value="삭제">
			</td>
        </form>
        <!-- ADD END -->
    	</div>
		

        	
        	
		<!-- ---------------------------------------------------------------------- -->
        	
       	</div>
    </main>
    <!-- ====== END MAIN CONTENT ===== -->



    <!-- ===== END HEADER CONTENT ===== -->
	<footer class="site-footer_v8">
	
	        <div class="bg-dark space-2 space-lg-3">
	            <div class="container">
	                <div class="row">
	                    <div class="col-lg-4 mb-4 mb-md-0">
	                        <div class="pb-md-6">
	                            <a href="index.html" class="d-inline-block mb-5">
	                                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="170px" height="30px">
	                                    <path fill-rule="evenodd" fill="#fff" d="M166.225,28.691 L165.065,15.398 L160.598,28.691 L158.229,28.691 L153.762,15.398 L152.590,28.691 L148.928,28.691 L150.405,11.052 L155.629,11.052 L159.389,22.124 L163.198,11.052 L168.422,11.052 L169.875,28.691 L166.225,28.691 ZM142.641,28.691 L138.051,20.928 L136.989,20.928 L136.989,28.691 L133.327,28.691 L133.327,11.052 L139.724,11.052 C140.692,11.052 141.546,11.189 142.287,11.461 C143.028,11.734 143.620,12.112 144.063,12.596 C144.507,13.081 144.840,13.636 145.064,14.263 C145.288,14.889 145.400,15.577 145.400,16.326 C145.400,17.506 145.078,18.472 144.436,19.225 C143.793,19.978 142.869,20.484 141.665,20.745 L146.975,28.691 L142.641,28.691 ZM141.896,16.204 C141.896,15.544 141.673,15.028 141.225,14.653 C140.777,14.279 140.086,14.092 139.150,14.092 L136.989,14.092 L136.989,18.303 L139.150,18.303 C140.981,18.303 141.896,17.603 141.896,16.204 ZM125.570,27.831 C124.206,28.567 122.666,28.936 120.949,28.936 C119.224,28.936 117.680,28.567 116.317,27.831 C114.953,27.094 113.881,26.034 113.100,24.651 C112.319,23.267 111.928,21.672 111.928,19.866 C111.928,18.051 112.319,16.454 113.100,15.074 C113.881,13.695 114.953,12.639 116.317,11.907 C117.680,11.174 119.224,10.808 120.949,10.808 C122.674,10.808 124.217,11.174 125.576,11.907 C126.935,12.639 128.005,13.695 128.786,15.074 C129.567,16.454 129.958,18.051 129.958,19.866 C129.958,21.672 129.567,23.267 128.786,24.651 C128.005,26.034 126.933,27.094 125.570,27.831 ZM124.807,15.715 C123.797,14.690 122.512,14.177 120.949,14.177 C119.387,14.177 118.101,14.690 117.092,15.715 C116.083,16.741 115.578,18.124 115.578,19.866 C115.578,21.616 116.083,23.005 117.092,24.034 C118.101,25.064 119.387,25.579 120.949,25.579 C122.512,25.579 123.797,25.064 124.807,24.034 C125.816,23.005 126.320,21.616 126.320,19.866 C126.320,18.124 125.816,16.741 124.807,15.715 ZM66.872,28.691 L61.391,21.196 L60.097,21.196 L60.097,28.691 L56.435,28.691 L56.435,11.052 L60.097,11.052 L60.097,17.986 L61.342,17.986 L66.872,11.052 L71.340,11.052 L64.504,19.487 L71.547,28.691 L66.872,28.691 ZM48.677,27.831 C47.314,28.567 45.774,28.936 44.057,28.936 C42.332,28.936 40.788,28.567 39.425,27.831 C38.061,27.094 36.989,26.034 36.208,24.651 C35.427,23.267 35.036,21.672 35.036,19.866 C35.036,18.051 35.427,16.454 36.208,15.074 C36.989,13.695 38.061,12.639 39.425,11.907 C40.788,11.174 42.332,10.808 44.057,10.808 C45.782,10.808 47.324,11.174 48.684,11.907 C50.043,12.639 51.113,13.695 51.894,15.074 C52.675,16.454 53.066,18.051 53.066,19.866 C53.066,21.672 52.675,23.267 51.894,24.651 C51.113,26.034 50.040,27.094 48.677,27.831 ZM47.915,15.715 C46.905,14.690 45.620,14.177 44.057,14.177 C42.495,14.177 41.209,14.690 40.200,15.715 C39.191,16.741 38.686,18.124 38.686,19.866 C38.686,21.616 39.191,23.005 40.200,24.034 C41.209,25.064 42.495,25.579 44.057,25.579 C45.620,25.579 46.905,25.064 47.915,24.034 C48.924,23.005 49.428,21.616 49.428,19.866 C49.428,18.124 48.924,16.741 47.915,15.715 ZM28.487,27.831 C27.124,28.567 25.584,28.936 23.867,28.936 C22.141,28.936 20.597,28.567 19.234,27.831 C17.871,27.094 16.799,26.034 16.018,24.651 C15.236,23.267 14.846,21.672 14.846,19.866 C14.846,18.051 15.236,16.454 16.018,15.074 C16.799,13.695 17.871,12.639 19.234,11.907 C20.597,11.174 22.141,10.808 23.867,10.808 C25.592,10.808 27.134,11.174 28.493,11.907 C29.852,12.639 30.922,13.695 31.704,15.074 C32.485,16.454 32.875,18.051 32.875,19.866 C32.875,21.672 32.485,23.267 31.704,24.651 C30.922,26.034 29.850,27.094 28.487,27.831 ZM27.724,15.715 C26.715,14.690 25.429,14.177 23.867,14.177 C22.304,14.177 21.018,14.690 20.009,15.715 C19.000,16.741 18.496,18.124 18.496,19.866 C18.496,21.616 19.000,23.005 20.009,24.034 C21.018,25.064 22.304,25.579 23.867,25.579 C25.429,25.579 26.715,25.064 27.724,24.034 C28.733,23.005 29.238,21.616 29.238,19.866 C29.238,18.124 28.733,16.741 27.724,15.715 ZM11.672,27.367 C10.736,28.250 9.361,28.691 7.546,28.691 L0.283,28.691 L0.283,11.052 L5.996,11.052 C7.875,11.052 9.314,11.478 10.311,12.328 C11.308,13.178 11.806,14.365 11.806,15.886 C11.806,16.676 11.633,17.374 11.287,17.980 C10.941,18.586 10.431,19.052 9.755,19.377 C11.969,19.988 13.076,21.445 13.076,23.748 C13.076,25.278 12.608,26.484 11.672,27.367 ZM7.827,14.647 C7.420,14.277 6.821,14.092 6.032,14.092 L3.811,14.092 L3.811,18.242 L6.191,18.242 C6.940,18.242 7.501,18.047 7.875,17.656 C8.250,17.266 8.437,16.753 8.437,16.118 C8.437,15.508 8.233,15.018 7.827,14.647 ZM8.876,21.709 C8.445,21.278 7.749,21.062 6.789,21.062 L3.811,21.062 L3.811,25.554 L6.862,25.554 C7.782,25.554 8.455,25.347 8.883,24.932 C9.310,24.517 9.523,23.988 9.523,23.345 C9.523,22.686 9.308,22.140 8.876,21.709 Z"></path>
	                                    <path fill-rule="evenodd" fill="#fff" d="M105.996,23.499 C105.995,26.752 103.950,29.265 100.749,29.950 C100.713,29.958 100.681,29.983 100.647,30.000 C100.588,30.000 100.529,30.000 100.471,30.000 C100.467,28.585 100.460,27.170 100.466,25.756 C100.467,25.675 100.550,25.565 100.626,25.518 C101.352,25.067 101.714,24.425 101.711,23.571 C101.707,22.020 101.710,20.468 101.710,18.891 C103.133,18.891 104.546,18.891 105.996,18.891 C105.996,18.989 105.996,19.092 105.996,19.196 C105.996,20.630 105.997,22.064 105.996,23.499 ZM101.715,17.089 C101.715,15.990 101.684,14.917 101.724,13.847 C101.767,12.679 102.761,11.806 103.931,11.838 C105.060,11.869 105.978,12.794 105.993,13.940 C106.005,14.954 105.995,15.968 105.995,16.983 C105.995,17.011 105.987,17.040 105.980,17.089 C104.569,17.089 103.157,17.089 101.715,17.089 ZM96.421,29.234 C94.322,27.983 93.199,26.136 93.155,23.703 C93.108,21.137 93.145,18.571 93.146,16.004 C93.146,15.957 93.153,15.909 93.159,15.840 C94.572,15.840 95.976,15.840 97.426,15.840 C97.426,15.948 97.426,16.060 97.426,16.172 C97.426,18.601 97.430,21.031 97.423,23.461 C97.421,24.363 97.757,25.065 98.548,25.540 C98.629,25.588 98.688,25.740 98.689,25.844 C98.699,27.122 98.695,28.400 98.696,29.679 C98.696,29.786 98.703,29.893 98.707,30.000 C98.648,30.000 98.590,30.000 98.531,30.000 C97.799,29.823 97.075,29.624 96.421,29.234 ZM93.145,14.043 C93.145,13.935 93.145,13.823 93.145,13.710 C93.145,11.318 93.137,8.926 93.149,6.534 C93.154,5.624 92.818,4.927 92.023,4.460 C91.961,4.423 91.894,4.331 91.894,4.264 C91.886,2.850 91.888,1.435 91.888,-0.000 C93.423,0.231 94.703,0.889 95.731,2.008 C96.833,3.208 97.413,4.629 97.421,6.261 C97.433,8.790 97.427,11.319 97.427,13.848 C97.427,13.906 97.421,13.964 97.416,14.043 C96.005,14.043 94.600,14.043 93.145,14.043 ZM89.588,4.782 C89.034,5.128 88.866,5.768 88.869,6.431 C88.876,8.061 88.870,9.692 88.869,11.322 C88.869,12.142 88.869,12.962 88.867,13.783 C88.867,13.868 88.857,13.954 88.851,14.051 C87.434,14.051 86.035,14.051 84.588,14.051 C84.588,13.957 84.588,13.865 84.588,13.774 C84.588,11.294 84.579,8.813 84.590,6.333 C84.605,3.158 86.853,0.542 90.000,0.017 C90.029,0.012 90.058,0.017 90.125,0.017 C90.125,0.639 90.125,1.243 90.125,1.848 C90.125,2.404 90.109,2.961 90.130,3.517 C90.149,4.031 90.126,4.446 89.588,4.782 ZM84.585,15.837 C86.015,15.837 87.420,15.837 88.868,15.837 C88.868,15.951 88.868,16.065 88.868,16.178 C88.868,18.608 88.849,21.038 88.873,23.468 C88.908,27.007 86.358,29.492 83.589,29.955 C83.552,29.961 83.518,29.984 83.482,30.000 C83.424,30.000 83.365,30.000 83.306,30.000 C83.310,28.634 83.319,27.268 83.313,25.902 C83.312,25.691 83.376,25.579 83.559,25.467 C84.268,25.030 84.587,24.370 84.587,23.548 C84.587,21.099 84.586,18.650 84.585,16.200 C84.585,16.085 84.585,15.970 84.585,15.837 ZM81.366,30.000 C80.875,29.844 80.361,29.739 79.898,29.524 C77.435,28.380 76.120,26.440 76.027,23.732 C75.974,22.192 76.017,20.649 76.016,19.107 C76.016,19.040 76.016,18.973 76.016,18.886 C77.447,18.886 78.859,18.886 80.303,18.886 C80.303,19.000 80.303,19.104 80.303,19.209 C80.303,20.662 80.308,22.116 80.302,23.570 C80.298,24.426 80.666,25.064 81.387,25.518 C81.463,25.566 81.547,25.675 81.547,25.756 C81.553,27.170 81.546,28.585 81.542,30.000 C81.484,30.000 81.425,30.000 81.366,30.000 ZM76.017,17.096 C76.017,16.539 76.017,15.996 76.017,15.453 C76.017,14.965 76.012,14.477 76.018,13.990 C76.030,12.831 76.911,11.892 78.032,11.838 C79.203,11.781 80.217,12.619 80.282,13.797 C80.341,14.884 80.294,15.978 80.294,17.096 C78.857,17.096 77.452,17.096 76.017,17.096 Z"></path>
	                                </svg>
	                            </a>
	                            <address class="font-size-2 mb-5">
	                                <span class="mb-2 font-weight-normal text-white">
	                                    1418 River Drive, Suite 35 Cottonhall, CA 9622 <br> United States
	                                </span>
	                            </address>
	                            <div class="mb-4">
	                                <a href="mailto:sale@bookworm.com" class="font-size-2 d-block text-white mb-1">sale@bookworm.com</a>
	                                <a href="tel:+1246-345-0695" class="font-size-2 d-block text-white">+1 246-345-0695</a>
	                            </div>
	                            <ul class="list-unstyled mb-0 d-flex">
	                                <li class="btn pl-0">
	                                    <a class="text-white" href="#">
	                                        <span class="fab fa-instagram"></span>
	                                    </a>
	                                </li>
	                                <li class="btn">
	                                    <a class="text-white" href="#">
	                                        <span class="fab fa-facebook-f"></span>
	                                    </a>
	                                </li>
	                                <li class="btn">
	                                    <a class="text-white" href="#">
	                                        <span class="fab fa-youtube"></span>
	                                    </a>
	                                </li>
	                                <li class="btn">
	                                    <a class="text-white" href="#">
	                                        <span class="fab fa-twitter"></span>
	                                    </a>
	                                </li>
	                                <li class="btn">
	                                    <a class="text-white" href="#">
	                                        <span class="fab fa-pinterest"></span>
	                                    </a>
	                                </li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="col-lg-2 mb-5 mb-md-0">
	                        <h4 class="font-size-3 font-weight-medium mb-2 mb-xl-5 pb-xl-1 text-gray-500">Explore</h4>
	                        <ul class="list-unstyled mb-0">
	                            <li class="pb-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">About as</a>
	                            </li>
	                            <li class="py-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Sitemap</a>
	                            </li>
	                            <li class="py-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Bookmarks</a>
	                            </li>
	                            <li class="pt-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Sign in/Join</a>
	                            </li>
	                        </ul>
	                    </div>
	                    <div class="col-lg-2 mb-5 mb-md-0">
	                        <h4 class="font-size-3 font-weight-medium mb-2 mb-xl-5 pb-xl-1 text-gray-500">Customer Service</h4>
	                        <ul class="list-unstyled mb-0">
	                            <li class="pb-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Help Center</a>
	                            </li>
	                            <li class="py-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Returns</a>
	                            </li>
	                            <li class="py-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Product Recalls</a>
	                            </li>
	                            <li class="py-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Accessibility</a>
	                            </li>
	                            <li class="py-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Contact Us</a>
	                            </li>
	                            <li class="pt-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Store Pickup</a>
	                            </li>
	                        </ul>
	                    </div>
	                    <div class="col-lg-2 mb-5 mb-md-0">
	                        <h4 class="font-size-3 font-weight-medium mb-2 mb-xl-5 pb-xl-1 text-gray-500">Policy</h4>
	                        <ul class="list-unstyled mb-0">
	                            <li class="pb-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Return Policy</a>
	                            </li>
	                            <li class="py-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Terms Of Use</a>
	                            </li>
	                            <li class="py-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Security</a>
	                            </li>
	                            <li class="pt-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Privacy</a>
	                            </li>
	                        </ul>
	                    </div>
	                    <div class="col-lg-2 mb-5 mb-md-0">
	                        <h4 class="font-size-3 font-weight-medium mb-2 mb-xl-5 pb-xl-1 text-gray-500">Categories</h4>
	                        <ul class="list-unstyled mb-0">
	                            <li class="pb-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Action</a>
	                            </li>
	                            <li class="py-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Comedy</a>
	                            </li>
	                            <li class="py-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Drama</a>
	                            </li>
	                            <li class="py-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Horror</a>
	                            </li>
	                            <li class="py-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Kids</a>
	                            </li>
	                            <li class="pt-2">
	                                <a class="font-size-2 text-white widgets-hover transition-3d-hover" href="#">Romantic Comedy</a>
	                            </li>
	                        </ul>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </footer>
	    <!-- ========== END FOOTER ========== -->
	    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	    <script src="/js/jquery.min.js"></script>
	    <script src="/js/jquery-migrate.min.js"></script>
	    <script src="/js/popper.min.js"></script>
	    <script src="/js/bootstrap.min.js"></script>
	    <script src="/js/slick.min.js"></script>
	    <script src="/js/jquery.zeynep.js"></script>
	    <script src="/js/hs.megamenu.js"></script>
	    <script src="/js/bootstrap-select.min.js"></script>
	    <script src="/js/jquery.mCustomScrollbar.concat.min.js"></script>
	
	    <!-- JS HS Components -->
	    <script src="/js/other.js"></script>
	    <script src="/js/hs.core.js"></script>
	    <script src="/js/components/hs.unfold.js"></script>
	    <script src="/js/components/hs.malihu-scrollbar.js"></script>
	    <script src="/js/components/hs.slick-carousel.js"></script>
	    <script src="/js/components/hs.selectpicker.js"></script>
	    <script src="/js/components/hs.show-animation.js"></script>
	
	    <!-- JS Bookworm -->
	    <!-- <script src="../../assets/js/bookworm.js"></script> -->
	    <script>
	        $(document).on('ready', function () {
	            // initialization of unfold component
	            $.HSCore.components.HSUnfold.init($('[data-unfold-target]'));
	
	            // initialization of select picker
	            $.HSCore.components.HSSelectPicker.init('.js-select');
	
	            // initialization of slick carousel
	            $.HSCore.components.HSSlickCarousel.init('.js-slick-carousel');
	
	            // initialization of malihu scrollbar
	            $.HSCore.components.HSMalihuScrollBar.init($('.js-scrollbar'));
	
	            // initialization of show animations
	            $.HSCore.components.HSShowAnimation.init('.js-animation-link');
	
	            // init zeynepjs
	            var zeynep = $('.zeynep').zeynep({
	                onClosed: function () {
	                    // enable main wrapper element clicks on any its children element
	                    $("body main").attr("style", "");
	
	                    console.log('the side menu is closed.');
	                },
	                onOpened: function () {
	                    // disable main wrapper element clicks on any its children element
	                    $("body main").attr("style", "pointer-events: none;");
	
	                    console.log('the side menu is opened.');
	                }
	            });
	
	            // handle zeynep overlay click
	            $(".zeynep-overlay").click(function () {
	                zeynep.close();
	            });
	
	            // open side menu if the button is clicked
	            $(".cat-menu").click(function () {
	                if ($("html").hasClass("zeynep-opened")) {
	                    zeynep.close();
	                } else {
	                    zeynep.open();
	                }
	            });
	        });
	    </script>
</body>
</html>