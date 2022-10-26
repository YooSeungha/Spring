<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Title -->
    <title>Shop v1 | Bookworm</title>

    <!-- Required Meta Tags Always Come First -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Favicon -->
    <link rel="shortcut icon" href="/img/favicon.png">

    <!-- Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" rel="stylesheet">

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
</head>
<body class="left-sidebar">
    <!--===== HEADER CONTENT =====-->
    <%@ include file="/WEB-INF/views/subheader.jsp" %>
    <!--===== END HEADER CONTENT =====-->

    <!-- ====== MAIN CONTENT ====== -->
    <div class="page-header border-bottom mb-8">
        <div class="container">
            <div class="d-md-flex justify-content-between align-items-center py-4">
                <h1 class="page-title font-size-3 font-weight-medium m-0 text-lh-lg">${catgo} - ${catgosub}</h1>                
            </div>
        </div>
    </div>
    <div class="site-content space-bottom-3" id="content">
        <div class="container">
            <div class="row">
                <div id="primary" class="content-area order-2">
                    <div class="shop-control-bar d-lg-flex justify-content-between align-items-center mb-5 text-center text-md-left">
                        <div class="shop-control-bar__left mb-4 m-lg-0">
                            <c:if test="${listResult.cp == listResult.totalPageCount}">
                            <p class="woocommerce-result-count m-0">총 검색결과 ${listResult.totalCount}건 중 현재페이지 ${listResult.cp*listResult.ps-(listResult.ps-1)}-${listResult.totalCount} </p>
                            </c:if>
                            <c:if test="${listResult.cp != listResult.totalPageCount}">
                            <p class="woocommerce-result-count m-0">총 검색결과 ${listResult.totalCount}건 중 현재페이지 ${listResult.cp*listResult.ps-(listResult.ps-1)}-${listResult.cp*listResult.ps} </p>
                            </c:if>
                        </div>
                        <div class="shop-control-bar__right d-md-flex align-items-center">
                            <form class="woocommerce-ordering mb-4 m-md-0" method="get">
                                <!-- Select -->
                                <select class="js-select selectpicker dropdown-select orderby" name="orderby"
                                data-style="border-bottom shadow-none outline-none py-2" onchange="select_qtype(this.value)"
                                id="qtype">
                                    <option value="1">신간 전체 리스트</option>
                                    <option value="2" selected="selected">주목할 만한 신간 리스트</option>
                                    <option value="3">편집자 추천 리스트</option>
                                    <option value="4">베스트셀러</option>                               
                                </select>
                                <!-- End Select -->
                            </form>

                            <form class="number-of-items ml-md-4 mb-4 m-md-0 d-none d-xl-block" method="get">
                                <!-- Select -->
                                <select class="js-select selectpicker dropdown-select orderby" name="orderby"
                                data-style="border-bottom shadow-none outline-none py-2"
                                data-width="fit" id="selected_show" onchange="select_show(this.value)">
                                    <option value="10">10개</option>
                                    <option value="12" selected="selected">12개</option>
                                    <option value="15">15개</option>
                                    <option value="20">20개</option>
                                    <option value="30">30개</option>
                                </select>
                                
                                <script>                                                               
                                var para = document.location.href.split("?");			
								var subPageStart = para[1].indexOf('=', para[1].indexOf('page'))+1;
								var subPageEnd = para[1].indexOf('&', para[1].indexOf('page'));	
								if(subPageEnd==-1){
									var page = para[1].substring(subPageStart);
								}else{
									var page = para[1].substring(subPageStart, subPageEnd);
								}								
				                    function select_show(num) {				                    	
										console.log("#num: " + num);
				                    	sessionStorage.setItem("show", num);				                    	
				                    	clickPage(1);
				                    }
				                    function select_qtype(type){
				                    	var qtype = type;
				                    	sessionStorage.setItem("qtype", qtype);					                    	
				                    	clickPage(1, qtype);
				                    }
			                    </script>
                                <!-- End Select -->
                            </form>

                            <ul class="nav nav-tab ml-lg-4 justify-content-center justify-content-md-start ml-md-auto" id="pills-tab" role="tablist">
                                <li class="nav-item border">
                                    <a class="nav-link p-0 height-38 width-38 justify-content-center d-flex align-items-center active" id="pills-one-example1-tab" data-toggle="pill" href="#pills-one-example1" onclick="clickTab(true);" role="tab" aria-controls="pills-one-example1" aria-selected="true">
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="17px" height="17px">
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M-0.000,0.000 L3.000,0.000 L3.000,3.000 L-0.000,3.000 L-0.000,0.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M7.000,0.000 L10.000,0.000 L10.000,3.000 L7.000,3.000 L7.000,0.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M14.000,0.000 L17.000,0.000 L17.000,3.000 L14.000,3.000 L14.000,0.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M-0.000,7.000 L3.000,7.000 L3.000,10.000 L-0.000,10.000 L-0.000,7.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M7.000,7.000 L10.000,7.000 L10.000,10.000 L7.000,10.000 L7.000,7.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M14.000,7.000 L17.000,7.000 L17.000,10.000 L14.000,10.000 L14.000,7.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M-0.000,14.000 L3.000,14.000 L3.000,17.000 L-0.000,17.000 L-0.000,14.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M7.000,14.000 L10.000,14.000 L10.000,17.000 L7.000,17.000 L7.000,14.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M14.000,14.000 L17.000,14.000 L17.000,17.000 L14.000,17.000 L14.000,14.000 Z" />
                                        </svg>
                                    </a>
                                </li>
                                <li class="nav-item border">
                                    <a class="nav-link p-0 height-38 width-38 justify-content-center d-flex align-items-center" id="pills-two-example1-tab" data-toggle="pill" href="#pills-two-example1" onclick="clickTab(false);" role="tab" aria-controls="pills-two-example1" aria-selected="false">
                                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="23px" height="17px">
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M-0.000,0.000 L3.000,0.000 L3.000,3.000 L-0.000,3.000 L-0.000,0.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M7.000,0.000 L23.000,0.000 L23.000,3.000 L7.000,3.000 L7.000,0.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M-0.000,7.000 L3.000,7.000 L3.000,10.000 L-0.000,10.000 L-0.000,7.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M7.000,7.000 L23.000,7.000 L23.000,10.000 L7.000,10.000 L7.000,7.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M-0.000,14.000 L3.000,14.000 L3.000,17.000 L-0.000,17.000 L-0.000,14.000 Z" />
                                            <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M7.000,14.000 L23.000,14.000 L23.000,17.000 L7.000,17.000 L7.000,14.000 Z" />
                                        </svg>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>


                    <!-- Tab Content -->
                    <div class="tab-content" id="pills-tabContent">
                        <div class="tab-pane fade show active" id="pills-one-example1" role="tabpanel" aria-labelledby="pills-one-example1-tab">
                            <!-- Mockup Block -->
                            <ul class="products list-unstyled row no-gutters row-cols-2 row-cols-lg-3 row-cols-wd-4 border-top border-left mb-6">
                                <c:forEach items="${listResult.items}" var="book">
                                <li class="product col">
                                    <div class="product__inner overflow-hidden p-3 p-md-4d875">
                                        <div class="woocommerce-LoopProduct-link woocommerce-loop-product__link d-block position-relative">
                                            <div class="woocommerce-loop-product__thumbnail">
                                                <a href="/detail/book?isbn=${book.isbn}" class="d-block"><img src="${book.img}" class="img-fluid d-block mx-auto attachment-shop_catalog size-shop_catalog wp-post-image img-fluid" alt="image-description"></a>
                                            </div>
                                            <div class="woocommerce-loop-product__body product__body pt-3 bg-white">
                                                <div class="text-uppercase font-size-1 mb-1 text-truncate"><a href="/detail/book?isbn=${book.isbn}">${book.publisher}</a></div>
                                                <h2 class="woocommerce-loop-product__title product__title h6 text-lh-md mb-1 text-height-2 crop-text-2 h-dark"><a href="/detail/book?isbn=${book.isbn}">${book.title}</a></h2>
                                                <div class="font-size-2  mb-1 text-truncate"><a href="../others/authors-single.html" class="text-gray-700">${book.writer}</a></div>
                                                <div class="price d-flex align-items-center font-weight-medium font-size-3">
                                                    <span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol"></span>${book.catgo}</span>
                                                </div>
                                            </div>
                                            <div class="product__hover d-flex align-items-center">
                                                <a href="javascript:openPop('${book.isbn}')" class="text-uppercase text-dark h-dark font-weight-medium mr-auto" data-toggle="tooltip" data-placement="right" title="" data-original-title="대출예약" >
                                                    <span class="product__add-to-cart">대출예약</span>
                                                    <span class="product__add-to-cart-icon font-size-4"><i class="flaticon-icon-126515"></i></span>
                                                </a>
                                                <c:set var="loop_flag" value="false" />  
                                                  <c:choose>
                                                  <c:when test="${not empty member}">
                                                  <c:choose>
                                                  <c:when test="${not empty member.bookFavorite}">
                                                     <c:forEach items="${member.bookFavorite}" var="list" varStatus="status">    
                                                     <c:if test="${not loop_flag }">      
                                                   <c:choose>
                                                           <c:when test="${list.libraryBook.book_isbn == book.isbn}">
                                                              <a href="javascript:addFav('${book.isbn}')" class="h-p-bg btn btn-outline-primary border-0 ${book.isbn}" id="${book.isbn}" style="display: inline-flex;">                                            
                                                                  <svg class="heart-fill" role="img" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="-2 -2 26 26" fill="#f75454" stroke="#161619" stroke-width="1.5" stroke-linecap="square" stroke-linejoin="miter">          
                                                          <path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z"></path>
                                                        </svg>
                                                              </a>
                                                              <c:set var="loop_flag" value="true" />
                                                           </c:when>                                                  
                                                           <c:otherwise>
                                                              <c:if test="${status.last}">
                                                                 <a href="javascript:addFav('${book.isbn}')" class="h-p-bg btn btn-outline-primary border-0 ${book.isbn}" id="${book.isbn}" style="display: inline-flex;">                                            
                                                                        <svg class="heart-empty" role="img" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="-2 -2 26 26" fill="white" stroke="#161619" stroke-width="1.5" stroke-linecap="square" stroke-linejoin="miter">          
                                                                <path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z"></path>
                                                              </svg>
                                                                    </a>                                                                                                                   
                                                              </c:if>
                                                           </c:otherwise>
                                                        </c:choose>
                                                     </c:if>  
                                                    </c:forEach>
                                                  </c:when>
                                                  <c:otherwise>
                                                     <a href="javascript:addFav('${book.isbn}')" class="h-p-bg btn btn-outline-primary border-0 ${book.isbn}" id="${book.isbn}" style="display: inline-flex;">                                            
                                                         <svg class="heart-empty" role="img" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="-2 -2 26 26" fill="white" stroke="#161619" stroke-width="1.5" stroke-linecap="square" stroke-linejoin="miter">          
                                                 <path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z"></path>
                                               </svg>
                                                     </a>
                                                  </c:otherwise>
                                                  </c:choose>                                                                 
                                              </c:when>
                                             <c:otherwise>
                                                   <a href="javascript:login()" class="h-p-bg btn btn-outline-primary border-0 ${book.isbn}" id="${book.isbn}" style="display: inline-flex;">
                                                                <svg class="heart-empty" role="img" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="-2 -2 26 26" fill="white" stroke="#161619" stroke-width="1.5" stroke-linecap="square" stroke-linejoin="miter">          
                                                       <path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z"></path>
                                                     </svg>
                                                            </a>   
                                             </c:otherwise>
                                           </c:choose>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                </c:forEach>                               
                            </ul>
                            <!-- End Mockup Block -->
                        </div>
                        <div class="tab-pane fade" id="pills-two-example1" role="tabpanel" aria-labelledby="pills-two-example1-tab">
                            <!-- Mockup Block -->
                            <ul class="products list-unstyled mb-6">
                            <c:forEach items="${listResult.items}" var="book">
                                <li class="product product__list">
                                    <div class="product__inner overflow-hidden p-3 p-md-4d875">
                                        <div class="woocommerce-LoopProduct-link woocommerce-loop-product__link row position-relative">
                                            <div class="col-md-auto woocommerce-loop-product__thumbnail mb-3 mb-md-0">
                                                <a href="/detail/book?isbn=${book.isbn}" class="d-block"><img src="${book.img}" class="img-fluid d-block mx-auto attachment-shop_catalog size-shop_catalog wp-post-image img-fluid" alt="image-description"></a>
                                            </div>
                                            <div class="col-md woocommerce-loop-product__body product__body pt-3 bg-white mb-3 mb-md-0">
                                                <div class="text-uppercase font-size-1 mb-1 text-truncate"><a href="/detail/book?isbn=${book.isbn}">${book.publisher}</a></div>
                                                <h2 class="woocommerce-loop-product__title product__title h6 text-lh-md mb-1 crop-text-2 h-dark"><a href="/detail/book?isbn=${book.isbn}" tabindex="0">${book.title}</a></h2>
                                                <div class="font-size-2  mb-2 text-truncate"><a href="../others/authors-single.html" class="text-gray-700">${book.writer}</a></div>
                                                <p class="font-size-2 mb-2 crop-text-2">${book.description}</p>
                                                <div class="price d-flex align-items-center font-weight-medium font-size-3">
                                                    <span class="woocommerce-Price-amount amount"><span class="woocommerce-Price-currencySymbol"></span>${book.catgo}</span>
                                                </div>
                                            </div>
                                            <div class="col-md-auto d-flex align-items-center">
                                                <a href="javascript:openPop('${book.isbn}')" class="text-uppercase text-dark h-dark font-weight-medium mr-4" data-toggle="tooltip" data-placement="right" title="" data-original-title="대출예약">
                                                    <span class="product__add-to-cart">대출예약</span>
                                                    <span class="product__add-to-cart-icon font-size-4"><i class="flaticon-icon-126515"></i></span>
                                                </a>
                                                <c:set var="loop_flag" value="false" />  
                                                  <c:choose>
                                                  <c:when test="${not empty member}">
                                                  <c:choose>
                                                  <c:when test="${not empty member.bookFavorite}">
                                                     <c:forEach items="${member.bookFavorite}" var="list" varStatus="status">    
                                                     <c:if test="${not loop_flag }">      
                                                   <c:choose>
                                                           <c:when test="${list.libraryBook.book_isbn == book.isbn}">
                                                              <a href="javascript:addFav('${book.isbn}')" class="h-p-bg btn btn-outline-primary border-0 ${book.isbn}" id="${book.isbn}" style="display: inline-flex;">                                            
                                                                  <svg class="heart-fill" role="img" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="-2 -2 26 26" fill="#f75454" stroke="#161619" stroke-width="1.5" stroke-linecap="square" stroke-linejoin="miter">          
                                                          <path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z"></path>
                                                        </svg>
                                                              </a>
                                                              <c:set var="loop_flag" value="true" />
                                                           </c:when>                                                  
                                                           <c:otherwise>
                                                              <c:if test="${status.last}">
                                                                 <a href="javascript:addFav('${book.isbn}')" class="h-p-bg btn btn-outline-primary border-0 ${book.isbn}" id="${book.isbn}" style="display: inline-flex;">                                            
                                                                        <svg class="heart-empty" role="img" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="-2 -2 26 26" fill="white" stroke="#161619" stroke-width="1.5" stroke-linecap="square" stroke-linejoin="miter">          
                                                                <path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z"></path>
                                                              </svg>
                                                                    </a>                                                                                                                   
                                                              </c:if>
                                                           </c:otherwise>
                                                        </c:choose>
                                                     </c:if>  
                                                    </c:forEach>
                                                  </c:when>
                                                  <c:otherwise>
                                                     <a href="javascript:addFav('${book.isbn}')" class="h-p-bg btn btn-outline-primary border-0 ${book.isbn}" id="${book.isbn}" style="display: inline-flex;">                                            
                                                         <svg class="heart-empty" role="img" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="-2 -2 26 26" fill="white" stroke="#161619" stroke-width="1.5" stroke-linecap="square" stroke-linejoin="miter">          
                                                 <path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z"></path>
                                               </svg>
                                                     </a>
                                                  </c:otherwise>
                                                  </c:choose>                                                                 
                                              </c:when>
                                             <c:otherwise>
                                                   <a href="javascript:login()" class="h-p-bg btn btn-outline-primary border-0 ${book.isbn}" id="${book.isbn}" style="display: inline-flex;">
                                                                <svg class="heart-empty" role="img" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="-2 -2 26 26" fill="white" stroke="#161619" stroke-width="1.5" stroke-linecap="square" stroke-linejoin="miter">          
                                                       <path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z"></path>
                                                     </svg>
                                                            </a>   
                                             </c:otherwise>
                                           </c:choose>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                </c:forEach>
                            </ul>
                            <!-- End Mockup Block -->
                        </div>
                    </div>
                    <!-- End Tab Content -->
                    <script>	
					//인기, 판매량, 별점 순  세션					
						function clickPage(page, qtype){
							//현재 type, keyword 저장해서 링크로 만듦
						    var para = document.location.href.split("?");
							var subCatgoStart = para[1].indexOf('=', para[1].indexOf('catgo'))+1;
							var subCatgoEnd = para[1].indexOf('&', para[1].indexOf('catgo'));
							if(subCatgoEnd==-1){
								var catgo = para[1].substring(subCatgoStart);
							}else{
								var catgo = para[1].substring(subCatgoStart, subCatgoEnd);
							}
							var subIdStart = para[1].indexOf('=', para[1].indexOf('catgoId'))+1;
							var subIdEnd = para[1].indexOf('&', para[1].indexOf('catgoId'));
							if(subIdEnd==-1){
								var Id = para[1].substring(subIdStart);
							}else{
								var Id = para[1].substring(subIdStart, subIdEnd);
							}
							if(typeof qtype=="undefined"){
								qtype = sessionStorage.getItem("qtype");							
							}
							var show = sessionStorage.getItem("show");							
							$(location).attr('href', "/category/book?catgo="+catgo+"&catgoId="+Id+"&page="+page+"&show="+show+"&qtype="+qtype);
						}
						//탭 박스클릭시 유지 로직
						function clickTab(click){
							sessionStorage.setItem("option", click);						
						}
						var option = sessionStorage.getItem("option");						
						if(option=="true"){
							$("#pills-one-example1-tab").attr("class", "nav-link p-0 height-38 width-38 justify-content-center d-flex align-items-center active");
							$("#pills-one-example1-tab").attr("aria-selected", "true");
							$("#pills-one-example1").attr("class", "tab-pane fade show active");
							$("#pills-two-example1-tab").attr("class", "nav-link p-0 height-38 width-38 justify-content-center d-flex align-items-center");
							$("#pills-two-example1-tab").attr("aria-selected", "false");
							$("#pills-two-example1").attr("class", "tab-pane fade");							
						}else{
							$("#pills-one-example1-tab").attr("class", "nav-link p-0 height-38 width-38 justify-content-center d-flex align-items-center");
							$("#pills-one-example1-tab").attr("aria-selected", "false");
							$("#pills-one-example1").attr("class", "tab-pane fade");
							$("#pills-two-example1-tab").attr("class", "nav-link p-0 height-38 width-38 justify-content-center d-flex align-items-center active");
							$("#pills-two-example1-tab").attr("aria-selected", "true");
							$("#pills-two-example1").attr("class", "tab-pane fade show active");
						}						
						$('#selected_show').val("${listResult.ps}").prop("selected", true);
						$('#qtype').val("${listResult.qtype}").prop("selected", true);
						sessionStorage.setItem("qtype", $("#qtype option:selected").val());
					</script>

                    <nav aria-label="Page navigation example">
                        <ul class="pagination pagination__custom justify-content-md-center flex-nowrap flex-md-wrap overflow-auto overflow-md-visble">
                            <c:if test="${listResult.startpaging != 1 }">
                        			<li class="flex-shrink-0 flex-md-shrink-1 page-item"><a class="page-link" href="javascript:void(0);" onclick="clickPage(${listResult.startpaging});">Previous</a></li>
							</c:if>
						    <c:forEach begin="${listResult.startpaging }" end="${listResult.endpaging }" var="i">
						        <a href="list.do?ps=${ps}&cp=${i}">
						   			<c:choose>
						   			    <c:when test="${i==listResult.cp}">
						   			    	<li class="flex-shrink-0 flex-md-shrink-1 page-item active" aria-current="page"><a class="page-link" href="javascript:void(0);" onclick="clickPage(${i});">${i}</a></li>						                	
						                </c:when>
						                <c:otherwise>
						                    <li class="flex-shrink-0 flex-md-shrink-1 page-item"><a class="page-link" href="javascript:void(0);" onclick="clickPage(${i});">${i}</a></li>
						                </c:otherwise>
									</c:choose>				
						    </c:forEach>
						    <c:if test="${listResult.endpaging != listResult.totalPageCount}">						
									<li class="flex-shrink-0 flex-md-shrink-1 page-item"><a class="page-link" href="javascript:void(0);" onclick="clickPage(${listResult.endpaging+1});">Next</a></li>
							</c:if>
                        </ul>
                    </nav>
                </div>
                
                <script>
                	function clickcatgo(catgo, selected){
                		var show = sessionStorage.getItem("show");
                		if(catgo==1){//국내도서
                			//1소설, 2에세이, 3참고서, 4인문학, 5예술/대중문화                			
                			$(location).attr('href', "/category/book?catgo=kor&catgoId="+selected+"&page=1&show="+show);
                		}else if(catgo==2){//외국도서
                			//1소설, 2어린이, 3일본도서, 4중국도서, 5예술/대중문화
                			$(location).attr('href', "/category/book?catgo=for&catgoId="+selected+"&page=1&show="+show);
                		}
                	}
                </script>
                
                <div id="secondary" class="sidebar widget-area order-1" role="complementary">
                    <div id="widgetAccordion">
                        <div id="woocommerce_product_categories-2" class="widget p-4d875 border woocommerce widget_product_categories">
                            <div id="widgetHeadingOne" class="widget-head">
                                <a class="d-flex align-items-center justify-content-between text-dark" href="#"
                                    data-toggle="collapse"
                                    data-target="#widgetCollapseOne"
                                    aria-expanded="true"
                                    aria-controls="widgetCollapseOne">

                                    <h3 class="widget-title mb-0 font-weight-medium font-size-3">국내도서</h3>

                                    <svg class="mins" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="15px" height="2px">
                                        <path fill-rule="evenodd" fill="rgb(22, 22, 25)" d="M0.000,-0.000 L15.000,-0.000 L15.000,2.000 L0.000,2.000 L0.000,-0.000 Z" />
                                    </svg>

                                    <svg class="plus" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="15px" height="15px">
                                        <path fill-rule="evenodd" fill="rgb(22, 22, 25)" d="M15.000,8.000 L9.000,8.000 L9.000,15.000 L7.000,15.000 L7.000,8.000 L0.000,8.000 L0.000,6.000 L7.000,6.000 L7.000,-0.000 L9.000,-0.000 L9.000,6.000 L15.000,6.000 L15.000,8.000 Z" />
                                    </svg>
                                </a>
                            </div>
                            <div id="widgetCollapseOne" class="mt-3 widget-content collapse show"
                                aria-labelledby="widgetHeadingOne"
                                data-parent="#widgetAccordion">
                                <ul class="product-categories">
                                    <li class="cat-item cat-item-9 cat-parent"><a href="javascript:void(0);" onclick="clickcatgo(1,1);">소설</a></li>
                                    <li class="cat-item cat-item-69 cat-parent"><a href="javascript:void(0);" onclick="clickcatgo(1,2);">에세이</a></li>
                                    <li class="cat-item cat-item-65 cat-parent"><a href="javascript:void(0);" onclick="clickcatgo(1,3);">과학</a></li>
                                    <li class="cat-item cat-item-11 cat-parent"><a href="javascript:void(0);" onclick="clickcatgo(1,4);">인문학</a></li>
                                    <li class="cat-item cat-item-12"><a href="javascript:void(0);" onclick="clickcatgo(1,5);">예술/대중문화</a></li>                                    
                                </ul>
                            </div>
                        </div>
                        
                        <div id="Format" class="widget p-4d875 border">
                            <div id="widgetHeading23" class="widget-head">
                                <a class="d-flex align-items-center justify-content-between text-dark collapsed" href="#" data-toggle="collapse" data-target="#widgetCollapse23" aria-expanded="false" aria-controls="widgetCollapse23">

                                    <h3 class="widget-title mb-0 font-weight-medium font-size-3">외국도서</h3>

                                    <svg class="mins" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="15px" height="2px">
                                        <path fill-rule="evenodd" fill="rgb(22, 22, 25)" d="M0.000,-0.000 L15.000,-0.000 L15.000,2.000 L0.000,2.000 L0.000,-0.000 Z"></path>
                                    </svg>

                                    <svg class="plus" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="15px" height="15px">
                                        <path fill-rule="evenodd" fill="rgb(22, 22, 25)" d="M15.000,8.000 L9.000,8.000 L9.000,15.000 L7.000,15.000 L7.000,8.000 L0.000,8.000 L0.000,6.000 L7.000,6.000 L7.000,-0.000 L9.000,-0.000 L9.000,6.000 L15.000,6.000 L15.000,8.000 Z"></path>
                                    </svg>
                                </a>
                            </div>

                            <div id="widgetCollapse23" class="mt-3 widget-content collapse" aria-labelledby="widgetHeading23" data-parent="#widgetAccordion" style="">
                                <ul class="product-categories">
                                    <li class="cat-item cat-item-9 cat-parent"><a href="javascript:void(0);" onclick="clickcatgo(2,1);">소설</a></li>
                                    <li class="cat-item cat-item-69 cat-parent"><a href="javascript:void(0);" onclick="clickcatgo(2,2);">어린이</a></li>
                                    <li class="cat-item cat-item-65 cat-parent"><a href="javascript:void(0);" onclick="clickcatgo(2,3);">일본도서</a></li>
                                    <li class="cat-item cat-item-65 cat-parent"><a href="javascript:void(0);" onclick="clickcatgo(2,4);">중국도서</a></li>
                                    <li class="cat-item cat-item-11 cat-parent"><a href="javascript:void(0);" onclick="clickcatgo(2,5);">예술/대중문화</a></li>                                    
                                </ul>
                            </div>
                        </div>
                        
                        <script>
						jQuery(function($) {
							$("#author").keydown(function(e) {		// 메인 페이지 중간 검색어 입력박스 엔터-키 처리
								if (e.keyCode == 13) {
									$("#author_button").trigger( "click" );
								}
							});
							$("#author_button").click(function(e) {					// 메인 페이지 검색어 입력박스 옆 전송버튼 클릭시
								let terms = $("#author").val().trim();								
								if (terms == '') {
									alert("검색어를 입력하세요.");
									return false;
								}
								var show = sessionStorage.getItem("show");
								if(sessionStorage.getItem("show")==null){
									show = 12; //페이지 초기값 지정
								}
								$(location).attr('href', "/search/book?&type=3&keyword="+terms+"&page=1");
								return false;
							});
						});
					</script>

                        <div id="Authors" class="widget widget_search widget_author p-4d875 border">
                            <div id="widgetHeading21" class="widget-head">
                                <a class="d-flex align-items-center justify-content-between text-dark" href="#"
                                    data-toggle="collapse"
                                    data-target="#widgetCollapse21"
                                    aria-expanded="true"
                                    aria-controls="widgetCollapse21">

                                    <h3 class="widget-title mb-0 font-weight-medium font-size-3">작가검색</h3>

                                    <svg class="mins" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="15px" height="2px">
                                        <path fill-rule="evenodd" fill="rgb(22, 22, 25)" d="M0.000,-0.000 L15.000,-0.000 L15.000,2.000 L0.000,2.000 L0.000,-0.000 Z" />
                                    </svg>

                                    <svg class="plus" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="15px" height="15px">
                                        <path fill-rule="evenodd" fill="rgb(22, 22, 25)" d="M15.000,8.000 L9.000,8.000 L9.000,15.000 L7.000,15.000 L7.000,8.000 L0.000,8.000 L0.000,6.000 L7.000,6.000 L7.000,-0.000 L9.000,-0.000 L9.000,6.000 L15.000,6.000 L15.000,8.000 Z" />
                                    </svg>
                                </a>
                            </div>

                            <div id="widgetCollapse21" class="mt-4 widget-content collapse show"
                                aria-labelledby="widgetHeading21"
                                data-parent="#widgetAccordion">
                                <form class="form-inline my-2 overflow-hidden">
                                    <div class="input-group flex-nowrap w-100">
                                        <div class="input-group-prepend">
                                            <i class="glph-icon flaticon-loupe py-2d75 bg-white-100 border-white-100 text-dark pl-3 pr-0 rounded-0"></i>
                                        </div>
                                        <input id="author" class="form-control bg-white-100 py-2d75 height-4 border-white-100 rounded-0" type="search" placeholder="작가검색" aria-label="Search" autocomplete="off">
                                    </div>
                                    <button id="author_button" class="btn btn-outline-success my-2 my-sm-0 sr-only" type="submit">검색</button>
                                </form>                                
                            </div>
                        </div>                                                          
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ====== END MAIN CONTENT ====== -->

    <!-- ========== FOOTER ========== -->
    <footer>
        <div class="border-top space-top-3">
            <div class="border-bottom pb-5 space-bottom-lg-3">
                <div class="container">
                    <!-- Newsletter -->
                    <div class="space-bottom-2 space-bottom-md-3">
                        <div class="text-center mb-5">
                            <h5 class="font-size-7 font-weight-medium">Join Our Newsletter</h5>
                            <p class="text-gray-700">Signup to be the first to hear about exclusive deals, special offers and upcoming collections</p>
                        </div>
                        <!-- Form Group -->
                        <div class="form-row justify-content-center">
                            <div class="col-md-5 mb-3 mb-md-2">
                                <div class="js-form-message">
                                    <div class="input-group">
                                        <input type="text" class="form-control px-5 height-60 border-dark" name="name" id="signupSrName" placeholder="Enter email for weekly newsletter." aria-label="Your name" required="" data-msg="Name must contain only letters." data-error-class="u-has-error" data-success-class="u-has-success">
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-2 ml-md-2">
                                <button type="submit" class="btn btn-dark rounded-0 btn-wide py-3 font-weight-medium">Subscribe
                                </button>
                            </div>
                        </div>
                        <!-- End Form Group -->
                    </div>
                    <!-- End  Newsletter -->
                    <div class="row">
                        <div class="col-lg-4 mb-6 mb-lg-0">
                            <div class="pb-6">
                                <a href="../home/index.html" class="d-inline-block mb-5">
                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="170px" height="30px">
                                        <path fill-rule="evenodd" fill="rgb(25, 17, 11)" d="M166.225,28.691 L165.065,15.398 L160.598,28.691 L158.229,28.691 L153.762,15.398 L152.590,28.691 L148.928,28.691 L150.405,11.052 L155.629,11.052 L159.389,22.124 L163.198,11.052 L168.422,11.052 L169.875,28.691 L166.225,28.691 ZM142.641,28.691 L138.051,20.928 L136.989,20.928 L136.989,28.691 L133.327,28.691 L133.327,11.052 L139.724,11.052 C140.692,11.052 141.546,11.189 142.287,11.461 C143.028,11.734 143.620,12.112 144.063,12.596 C144.507,13.081 144.840,13.636 145.064,14.263 C145.288,14.889 145.400,15.577 145.400,16.326 C145.400,17.506 145.078,18.472 144.436,19.225 C143.793,19.978 142.869,20.484 141.665,20.745 L146.975,28.691 L142.641,28.691 ZM141.896,16.204 C141.896,15.544 141.673,15.028 141.225,14.653 C140.777,14.279 140.086,14.092 139.150,14.092 L136.989,14.092 L136.989,18.303 L139.150,18.303 C140.981,18.303 141.896,17.603 141.896,16.204 ZM125.570,27.831 C124.206,28.567 122.666,28.936 120.949,28.936 C119.224,28.936 117.680,28.567 116.317,27.831 C114.953,27.094 113.881,26.034 113.100,24.651 C112.319,23.267 111.928,21.672 111.928,19.866 C111.928,18.051 112.319,16.454 113.100,15.074 C113.881,13.695 114.953,12.639 116.317,11.907 C117.680,11.174 119.224,10.808 120.949,10.808 C122.674,10.808 124.217,11.174 125.576,11.907 C126.935,12.639 128.005,13.695 128.786,15.074 C129.567,16.454 129.958,18.051 129.958,19.866 C129.958,21.672 129.567,23.267 128.786,24.651 C128.005,26.034 126.933,27.094 125.570,27.831 ZM124.807,15.715 C123.797,14.690 122.512,14.177 120.949,14.177 C119.387,14.177 118.101,14.690 117.092,15.715 C116.083,16.741 115.578,18.124 115.578,19.866 C115.578,21.616 116.083,23.005 117.092,24.034 C118.101,25.064 119.387,25.579 120.949,25.579 C122.512,25.579 123.797,25.064 124.807,24.034 C125.816,23.005 126.320,21.616 126.320,19.866 C126.320,18.124 125.816,16.741 124.807,15.715 ZM66.872,28.691 L61.391,21.196 L60.097,21.196 L60.097,28.691 L56.435,28.691 L56.435,11.052 L60.097,11.052 L60.097,17.986 L61.342,17.986 L66.872,11.052 L71.340,11.052 L64.504,19.487 L71.547,28.691 L66.872,28.691 ZM48.677,27.831 C47.314,28.567 45.774,28.936 44.057,28.936 C42.332,28.936 40.788,28.567 39.425,27.831 C38.061,27.094 36.989,26.034 36.208,24.651 C35.427,23.267 35.036,21.672 35.036,19.866 C35.036,18.051 35.427,16.454 36.208,15.074 C36.989,13.695 38.061,12.639 39.425,11.907 C40.788,11.174 42.332,10.808 44.057,10.808 C45.782,10.808 47.324,11.174 48.684,11.907 C50.043,12.639 51.113,13.695 51.894,15.074 C52.675,16.454 53.066,18.051 53.066,19.866 C53.066,21.672 52.675,23.267 51.894,24.651 C51.113,26.034 50.040,27.094 48.677,27.831 ZM47.915,15.715 C46.905,14.690 45.620,14.177 44.057,14.177 C42.495,14.177 41.209,14.690 40.200,15.715 C39.191,16.741 38.686,18.124 38.686,19.866 C38.686,21.616 39.191,23.005 40.200,24.034 C41.209,25.064 42.495,25.579 44.057,25.579 C45.620,25.579 46.905,25.064 47.915,24.034 C48.924,23.005 49.428,21.616 49.428,19.866 C49.428,18.124 48.924,16.741 47.915,15.715 ZM28.487,27.831 C27.124,28.567 25.584,28.936 23.867,28.936 C22.141,28.936 20.597,28.567 19.234,27.831 C17.871,27.094 16.799,26.034 16.018,24.651 C15.236,23.267 14.846,21.672 14.846,19.866 C14.846,18.051 15.236,16.454 16.018,15.074 C16.799,13.695 17.871,12.639 19.234,11.907 C20.597,11.174 22.141,10.808 23.867,10.808 C25.592,10.808 27.134,11.174 28.493,11.907 C29.852,12.639 30.922,13.695 31.704,15.074 C32.485,16.454 32.875,18.051 32.875,19.866 C32.875,21.672 32.485,23.267 31.704,24.651 C30.922,26.034 29.850,27.094 28.487,27.831 ZM27.724,15.715 C26.715,14.690 25.429,14.177 23.867,14.177 C22.304,14.177 21.018,14.690 20.009,15.715 C19.000,16.741 18.496,18.124 18.496,19.866 C18.496,21.616 19.000,23.005 20.009,24.034 C21.018,25.064 22.304,25.579 23.867,25.579 C25.429,25.579 26.715,25.064 27.724,24.034 C28.733,23.005 29.238,21.616 29.238,19.866 C29.238,18.124 28.733,16.741 27.724,15.715 ZM11.672,27.367 C10.736,28.250 9.361,28.691 7.546,28.691 L0.283,28.691 L0.283,11.052 L5.996,11.052 C7.875,11.052 9.314,11.478 10.311,12.328 C11.308,13.178 11.806,14.365 11.806,15.886 C11.806,16.676 11.633,17.374 11.287,17.980 C10.941,18.586 10.431,19.052 9.755,19.377 C11.969,19.988 13.076,21.445 13.076,23.748 C13.076,25.278 12.608,26.484 11.672,27.367 ZM7.827,14.647 C7.420,14.277 6.821,14.092 6.032,14.092 L3.811,14.092 L3.811,18.242 L6.191,18.242 C6.940,18.242 7.501,18.047 7.875,17.656 C8.250,17.266 8.437,16.753 8.437,16.118 C8.437,15.508 8.233,15.018 7.827,14.647 ZM8.876,21.709 C8.445,21.278 7.749,21.062 6.789,21.062 L3.811,21.062 L3.811,25.554 L6.862,25.554 C7.782,25.554 8.455,25.347 8.883,24.932 C9.310,24.517 9.523,23.988 9.523,23.345 C9.523,22.686 9.308,22.140 8.876,21.709 Z"></path>
                                        <path class="fill-primary" fill-rule="evenodd" d="M105.996,23.499 C105.995,26.752 103.950,29.265 100.748,29.950 C100.713,29.958 100.681,29.983 100.647,30.000 C100.588,30.000 100.529,30.000 100.471,30.000 C100.467,28.585 100.460,27.171 100.466,25.756 C100.467,25.675 100.550,25.565 100.626,25.518 C101.352,25.068 101.714,24.425 101.711,23.571 C101.707,22.020 101.710,20.469 101.710,18.892 C103.133,18.892 104.546,18.892 105.996,18.892 C105.996,18.989 105.996,19.093 105.996,19.196 C105.996,20.630 105.997,22.065 105.996,23.499 ZM101.715,17.089 C101.715,15.990 101.683,14.917 101.724,13.847 C101.767,12.679 102.761,11.806 103.931,11.838 C105.060,11.869 105.978,12.794 105.993,13.940 C106.005,14.954 105.995,15.969 105.995,16.983 C105.995,17.011 105.987,17.040 105.980,17.089 C104.569,17.089 103.157,17.089 101.715,17.089 ZM96.421,29.234 C94.322,27.983 93.199,26.136 93.155,23.703 C93.108,21.138 93.145,18.571 93.146,16.005 C93.146,15.957 93.153,15.910 93.159,15.841 C94.572,15.841 95.976,15.841 97.426,15.841 C97.426,15.948 97.426,16.060 97.426,16.172 C97.426,18.602 97.430,21.031 97.423,23.461 C97.421,24.364 97.757,25.066 98.548,25.540 C98.629,25.589 98.688,25.740 98.689,25.844 C98.699,27.122 98.695,28.401 98.696,29.679 C98.696,29.786 98.703,29.893 98.707,30.000 C98.648,30.000 98.590,30.000 98.531,30.000 C97.799,29.823 97.075,29.624 96.421,29.234 ZM93.145,14.043 C93.145,13.935 93.145,13.823 93.145,13.711 C93.145,11.318 93.137,8.926 93.149,6.534 C93.154,5.625 92.818,4.928 92.023,4.460 C91.961,4.424 91.894,4.332 91.894,4.265 C91.886,2.850 91.888,1.436 91.888,0.000 C93.423,0.232 94.703,0.889 95.731,2.009 C96.833,3.209 97.413,4.630 97.421,6.261 C97.433,8.791 97.426,11.319 97.427,13.849 C97.427,13.906 97.421,13.964 97.416,14.043 C96.005,14.043 94.599,14.043 93.145,14.043 ZM89.588,4.782 C89.034,5.128 88.866,5.768 88.868,6.431 C88.875,8.061 88.870,9.692 88.869,11.322 C88.869,12.143 88.869,12.963 88.867,13.783 C88.867,13.869 88.857,13.954 88.851,14.051 C87.434,14.051 86.035,14.051 84.587,14.051 C84.587,13.958 84.587,13.866 84.587,13.774 C84.588,11.294 84.579,8.814 84.590,6.334 C84.605,3.158 86.853,0.543 90.000,0.018 C90.028,0.013 90.058,0.017 90.125,0.017 C90.125,0.639 90.125,1.243 90.125,1.848 C90.125,2.405 90.109,2.962 90.130,3.518 C90.149,4.032 90.126,4.447 89.588,4.782 ZM84.585,15.837 C86.015,15.837 87.420,15.837 88.868,15.837 C88.868,15.951 88.868,16.065 88.868,16.179 C88.868,18.608 88.849,21.039 88.873,23.468 C88.908,27.007 86.358,29.493 83.589,29.955 C83.552,29.961 83.518,29.985 83.482,30.000 C83.424,30.000 83.365,30.000 83.306,30.000 C83.310,28.634 83.319,27.268 83.313,25.902 C83.311,25.691 83.376,25.580 83.559,25.467 C84.268,25.031 84.587,24.371 84.587,23.549 C84.587,21.099 84.586,18.650 84.585,16.201 C84.585,16.085 84.585,15.970 84.585,15.837 ZM81.366,30.000 C80.875,29.844 80.360,29.740 79.897,29.524 C77.435,28.380 76.120,26.440 76.027,23.732 C75.974,22.192 76.017,20.649 76.016,19.107 C76.016,19.040 76.016,18.973 76.016,18.886 C77.447,18.886 78.859,18.886 80.303,18.886 C80.303,19.000 80.303,19.104 80.303,19.209 C80.303,20.663 80.308,22.117 80.302,23.571 C80.298,24.427 80.666,25.065 81.387,25.518 C81.463,25.566 81.547,25.675 81.547,25.756 C81.553,27.171 81.546,28.585 81.542,30.000 C81.484,30.000 81.425,30.000 81.366,30.000 ZM76.017,17.097 C76.017,16.540 76.017,15.997 76.017,15.453 C76.017,14.965 76.012,14.478 76.017,13.990 C76.030,12.831 76.911,11.892 78.032,11.838 C79.203,11.781 80.217,12.619 80.282,13.797 C80.341,14.885 80.294,15.978 80.294,17.097 C78.857,17.097 77.452,17.097 76.017,17.097 Z"></path>
                                    </svg>
                                </a>
                                <address class="font-size-2 mb-5">
                                    <span class="mb-2 font-weight-normal text-dark">
                                        1418 River Drive, Suite 35 Cottonhall, CA 9622 <br> United States
                                    </span>
                                </address>
                                <div class="mb-4">
                                    <a href="mailto:sale@bookworm.com" class="font-size-2 d-block link-black-100 mb-1">sale@bookworm.com</a>
                                    <a href="tel:+1246-345-0695" class="font-size-2 d-block link-black-100">+1 246-345-0695</a>
                                </div>
                                <ul class="list-unstyled mb-0 d-flex">
                                    <li class="btn pl-0">
                                        <a class="link-black-100" href="#">
                                            <span class="fab fa-instagram"></span>
                                        </a>
                                    </li>
                                    <li class="btn">
                                        <a class="link-black-100" href="#">
                                            <span class="fab fa-facebook-f"></span>
                                        </a>
                                    </li>
                                    <li class="btn">
                                        <a class="link-black-100" href="#">
                                            <span class="fab fa-youtube"></span>
                                        </a>
                                    </li>
                                    <li class="btn">
                                        <a class="link-black-100" href="#">
                                            <span class="fab fa-twitter"></span>
                                        </a>
                                    </li>
                                    <li class="btn">
                                        <a class="link-black-100" href="#">
                                            <span class="fab fa-pinterest"></span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-2 mb-6 mb-lg-0">
                            <h4 class="font-size-3 font-weight-medium mb-2 mb-xl-5 pb-xl-1">Explore</h4>
                            <ul class="list-unstyled mb-0">
                                <li class="pb-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">About as</a>
                                </li>
                                <li class="py-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Sitemap</a>
                                </li>
                                <li class="py-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Bookmarks</a>
                                </li>
                                <li class="pt-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Sign in/Join</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-lg-2 mb-6 mb-lg-0">
                            <h4 class="font-size-3 font-weight-medium mb-2 mb-xl-5 pb-xl-1">Customer Service</h4>
                            <ul class="list-unstyled mb-0">
                                <li class="pb-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Help Center</a>
                                </li>
                                <li class="py-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Returns</a>
                                </li>
                                <li class="py-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Product Recalls</a>
                                </li>
                                <li class="py-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Accessibility</a>
                                </li>
                                <li class="py-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Contact Us</a>
                                </li>
                                <li class="pt-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Store Pickup</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-lg-2 mb-6 mb-lg-0">
                            <h4 class="font-size-3 font-weight-medium mb-2 mb-xl-5 pb-xl-1">Policy</h4>
                            <ul class="list-unstyled mb-0">
                                <li class="pb-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Return Policy</a>
                                </li>
                                <li class="py-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Terms Of Use</a>
                                </li>
                                <li class="py-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Security</a>
                                </li>
                                <li class="pt-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Privacy</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-lg-2 mb-6 mb-lg-0">
                            <h4 class="font-size-3 font-weight-medium mb-2 mb-xl-5 pb-xl-1">Categories</h4>
                            <ul class="list-unstyled mb-0">
                                <li class="pb-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Action</a>
                                </li>
                                <li class="py-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Comedy</a>
                                </li>
                                <li class="py-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Drama</a>
                                </li>
                                <li class="py-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Horror</a>
                                </li>
                                <li class="py-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Kids</a>
                                </li>
                                <li class="pt-2">
                                    <a class="widgets-hover transition-3d-hover font-size-2 link-black-100" href="#">Romantic Comedy</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="space-1">
                <div class="container">
                    <div class="d-lg-flex text-center text-lg-left justify-content-between align-items-center">
                        <!-- Copyright -->
                        <p class="mb-3 mb-lg-0 font-size-2">Â©2020 Book Worm. All rights reserved</p>
                        <!-- End Copyright -->

                        <div class="ml-auto d-lg-flex align-items-center">
                            <div class="mb-4 mb-lg-0 mr-5">
                               <img class="img-fluid" src="/img/324x38/img1.png" alt="Image-Description">
                            </div>

                            <!-- Select -->
                            <select class="js-select selectpicker dropdown-select mb-3 mb-lg-0"
                                data-style="border px-4 py-2 rounded-0 height-5 outline-none shadow-none form-control font-size-2"
                                data-dropdown-align-right="true">
                                <option value="one" selected>English (United States)</option>
                                <option value="two">Deutsch</option>
                                <option value="three">FranÃ§ais</option>
                                <option value="four">EspaÃ±ol</option>
                            </select>
                            <!-- End Select -->

                            <!-- Select -->
                            <select class="js-select selectpicker dropdown-select ml-md-3"
                                data-style="border px-4 py-2 rounded-0 height-5 outline-none shadow-none form-control font-size-2"
                                data-dropdown-align-right="true"
                                data-width="fit">
                                <option value="one" selected>$ USD</option>
                                <option value="two">â¬ EUR</option>
                                <option value="three">âº TL</option>
                                <option value="four">â½ RUB</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ========== END FOOTER ========== -->

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="/vendor/jquery/dist/jquery.min.js"></script>
    <script src="/vendor/jquery-migrate/dist/jquery-migrate.min.js"></script>
    <script src="/vendor/popper.js/dist/umd/popper.min.js"></script>
    <script src="/vendor/bootstrap/bootstrap.min.js"></script>
    <script src="/vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
    <script src="/vendor/slick-carousel/slick/slick.min.js"></script>
    <script src="/vendor/multilevel-sliding-mobile-menu/dist/jquery.zeynep.js"></script>
    <script src="/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>


    <!-- JS HS Components -->
    <script src="/js/hs.core.js"></script>
    <script src="/js/components/hs.unfold.js"></script>
    <script src="/js/components/hs.malihu-scrollbar.js"></script>
    <script src="/js/components/hs.header.js"></script>
    <script src="/js/components/hs.slick-carousel.js"></script>
    <script src="/js/components/hs.selectpicker.js"></script>
    <script src="/js/components/hs.show-animation.js"></script>

    <!-- JS Bookworm -->
    <!-- <script src="/js/bookworm.js"></script> -->
    <script>
        $(document).on('ready', function () {
            // initialization of unfold component
            $.HSCore.components.HSUnfold.init($('[data-unfold-target]'));

            // initialization of slick carousel
            $.HSCore.components.HSSlickCarousel.init('.js-slick-carousel');

            // initialization of header
            $.HSCore.components.HSHeader.init($('#header'));

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
<div class="popup_layer" id="popup_layer" style="display: none;">
    	<div id="popup_box" class="popup_box">
    		<div style="height: 10px; width: 375px; float: top;">
    			<a href="javascript:closePop();"><img src="/img/ic_close.svg" class="m_header-banner-close" width="60px" height="60px"></a>
    		</div>
    		<!--팝업 컨텐츠 영역-->
    		<div class="popup_cont">
    			<div id="popup_primary" class="popup_content-area">
    				<main id="main" class="site-main ">
    					<div class="product">
    						<div class="container"> 
    							<div class="row">
    								<div class="col-lg-5 woocommerce-product-gallery woocommerce-product-gallery--with-images images">
    									<figure id="figure_slick" class="woocommerce-product-gallery__wrapper mb-0">
    										
    									</figure>
    								</div>
    								<div class="col-lg-7 pl-lg-0 summary entry-summary">
    									<div class="px-lg-4 px-xl-6">
    										<h1 id="book_title" class="product_title entry-title font-size-7 mb-3"></h1>
    										<div class="font-size-2 mb-4">
    										<span class="ml-3 font-weight-medium">지은이</span>
    											<span id="book_author" class="ml-2 text-gray-600"></span>
    											<br>
    											<span class="text-yellow-darker">
    												<span class="fas fa-star"></span>
    												<span class="fas fa-star"></span>
    												<span class="fas fa-star"></span>
    												<span class="fas fa-star"></span>
    												<span class="fas fa-star"></span>
    											</span>
    											<span class="ml-3">(3,714)</span>
    											&nbsp;
    											<span class="mr-6 mb-4 mb-md-0" id="popupFav" style="display:content;">			   											
												</span>     											
    										</div>    										
    										<div class="woocommerce-product-details__short-description font-size-2 mb-4">
    											<p id="book_desc" class=""></p>
    										</div>
    										
    										 <p class="price font-size-22 font-weight-medium mb-4">                                      
											     <span class="woocommerce-Price-amount amount">                                          
											         <span class="woocommerce-Price-currencySymbol"></span>카테고리                          
											     </span> <div></div>                                                                 
											     <span class="woocommerce-Price-amount amount">                                          
											         <span id="book_catgo" class="woocommerce-Price-currencySymbol"></span>
											     </span>       
											                                                                           
											   
											 
											 <div class="mb-4">                                                                 
    											<label class="form-label font-size-2 font-weight-medium mb-3">상태 &nbsp;</label>
    											<!-- 대출가능 도서 label -->
    											<label id="rental_book_count"></label>
    											<!--  도서위치 label -->
    											<label id="rental_book_fac"></label>
    										</div>
    										
    										<form action="/rental.ok" id="rental" name="rental" class="cart d-md-flex align-items-center" method="post">    										
    										</form>							                                                                                  
    									</div>    									
    								</div>
    							</div>
    						</div>
    					</div> 
    				</main>
    			</div>
    		</div>
    		<div class="popup_btn" style="float: bottom; margin-top: 20px;">
	          <a href="javascript:closePop();">닫기</a>   
	      </div>
    	</div>
    </div>
    <div id="btn_script"></div>
    
<!-- Popup -->
    <link rel="stylesheet" type="text/css" href="/css/popup.css">
    <script src="/js/popup.js" type="text/javascript"></script>
    <script>
    function addFav(isbn){    		
    	let memnum = "${member.mem_num}";
    	var favsuccess = false;
    	if($('#'+isbn+'').children('svg').attr('class') == "heart-empty"){//빈하트 클릭시    			
    		$.ajax({
    			url: "/ajax/fav/book.json", 
    			type: "GET", 
    			data: {isbn: isbn,
    				memnum: memnum
    				}, 
    			success: function(data){
    				if(!data){
    					alert("즐겨찾기할 수 없는 도서입니다.");
    					favsuccess = false;
    				}
    				if(data==true){ //db에 있는 도서 즐겨찾기(성공)    						  	
    					favsuccess = true;    						
    				}
    				else if(data==false){ //db에 없는 도서 즐겨찾기(실패)    						   
    					favsuccess = false;
    				}
    				if(favsuccess == true){
    	    			$('.'+isbn+'').empty();
    	        		$('.'+isbn+'-').empty();
    	    			$('.'+isbn+'').html('<svg class="heart-fill" role="img" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="-2 -2 26 26" fill="#f75454" stroke="#161619" stroke-width="1.5" stroke-linecap="square" stroke-linejoin="miter"><path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z"></path></svg>');
    	    			$('.'+isbn+'-').html('<svg class="heart-fill" role="img" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="-2 -2 26 26" fill="#f75454" stroke="#161619" stroke-width="1.5" stroke-linecap="square" stroke-linejoin="miter"><path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z"></path></svg>');    			    			    		    			
    	    		}
    			},
    			error: function(){
    				alert('서버에러');
    			}    				
    		});    	    				    		    
    	}else if($('#'+isbn+'').children('svg').attr('class') == "heart-fill"){
    		$.ajax({
    			url: "/ajax/favdel/book.json", 
    			type: "GET", 
    			data: {isbn: isbn,
    				memnum: memnum
    				}, 
    			success: function(data){
    				if(!data){
    					alert("존재하지않는 data");
    					return false;
    				}    					
    			},
    			error: function(){
    				alert('서버에러');
    			}
    		});    			
    		$('.'+isbn+'').empty();
    		$('.'+isbn+'-').empty();
    		$('.'+isbn+'').html('<svg class="heart-empty" role="img" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="-2 -2 26 26" fill="white" stroke="#161619" stroke-width="1.5" stroke-linecap="square" stroke-linejoin="miter"><path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z"></path></svg>');
    		$('.'+isbn+'-').html('<svg class="heart-empty" role="img" xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="-2 -2 26 26" fill="white" stroke="#161619" stroke-width="1.5" stroke-linecap="square" stroke-linejoin="miter"><path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z"></path></svg>');    			
    	}    		
    }
    function login(){
    	alert("로그인을 해주세요");
    }
    </script>
</html>
