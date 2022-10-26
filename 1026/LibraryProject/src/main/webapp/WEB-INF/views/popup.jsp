<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>HostSpace</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="HostSpace template project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/popup.css">
<script src="js/popup.js" type="text/javascript"></script>

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
    
    <!-- Popup -->
    <link rel="stylesheet" type="text/css" href="/css/popup.css">
    <script src="/js/popup.js" type="text/javascript"></script>
</head>
<body>


<a href="javascript:openPop()">
    <div>
        팝업오픈!
    </div>
</a>
<button type="button" id="btn_rental" name="btn_rental" class="btn btn-blue border-0 rounded-0 p-3 btn-block ml-md-4 single_add_to_cart_button button alt">대출예약</button>

<div class="popup_layer" id="popup_layer" style="display: none;">
  <div class="popup_box">
      <div style="height: 10px; width: 375px; float: top;">
        <a href="javascript:closePop();"><img src="img/ic_close.svg" class="m_header-banner-close" width="30px" height="30px"></a>
      </div>
      <!--팝업 컨텐츠 영역-->
      <div class="popup_cont">
          <div id="primary" class="content-area">
                    <main id="main" class="site-main ">
                        <div class="product">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-5 woocommerce-product-gallery woocommerce-product-gallery--with-images images">
                                        <figure class="woocommerce-product-gallery__wrapper mb-0">
                                            <div class="js-slick-carousel u-slick slick-initialized slick-slider slick-dotted" data-pagi-classes="text-center u-slick__pagination my-4">
                                                <div class="slick-list draggable"><div class="slick-track" style="opacity: 1; width: 322px; transform: translate3d(0px, 0px, 0px);"><div class="js-slide slick-slide slick-current slick-active" data-slick-index="0" aria-hidden="false" style="width: 322px; height: auto;" tabindex="0" role="tabpanel" id="slick-slide00" aria-describedby="slick-slide-control00">
                                                    <img src="https://image.aladin.co.kr/product/41/58/cover/8990098556_1.jpg" alt="Image Description" class="mx-auto img-fluid">
                                                </div></div></div>
                                            <ul class="js-pagination text-center u-slick__pagination my-4" role="tablist"><li class="slick-active slick-current" role="presentation"><span></span></li></ul></div>
                                        </figure>
                                    </div>
                                    <div class="col-lg-7 pl-lg-0 summary entry-summary">
                                        <div class="px-lg-4 px-xl-6">
                                            <h1 class="product_title entry-title font-size-7 mb-3">메모의 기술 - 머리보다 손이 먼저 움직이는 (양장본)</h1>
                                            <div class="font-size-2 mb-4">
                                                <span class="text-yellow-darker">
                                                    <span class="fas fa-star"></span>
                                                    <span class="fas fa-star"></span>
                                                    <span class="fas fa-star"></span>
                                                    <span class="fas fa-star"></span>
                                                    <span class="fas fa-star"></span>
                                                </span>
                                                <span class="ml-3">(3,714)</span>
                                                <span class="ml-3 font-weight-medium">지은이</span>
                                                <span class="ml-2 text-gray-600">사카토 켄지 (지은이), 고은진 (옮긴이)</span>
                                            </div>

                                            <div class="woocommerce-product-details__short-description font-size-2 mb-4">
                                                <p class="">주로 비즈니스 상에서 메모를 적극 활용하는 법을 알려주는데, 얇은 책자라 쉽게 손이 간다. 메모의 기술을 익히는데만 두꺼운 책 하나를 마스터해야 한다면 그 습관을 익히기도 전에 질려버리고 말 것이다.</p>
                                            </div>

                                            <p class="price font-size-22 font-weight-medium mb-4">
                                                <span class="woocommerce-Price-amount amount">
                                                    <span class="woocommerce-Price-currencySymbol"></span>카테고리
                                                </span> </p><div></div>
                                                <span class="woocommerce-Price-amount amount">
                                                    <span class="woocommerce-Price-currencySymbol"></span>국내도서&gt;자기계발&gt;시간관리/정보관리&gt;정보관리
                                                </span>
                                            <p></p>

                                            <div class="mb-4">
                                                <label class="form-label font-size-2 font-weight-medium mb-3">Book Format</label>
                                                <!-- Select -->
                                                <div class="dropdown bootstrap-select js-select dropdown-select w-100 position-relative"><select class="js-select selectpicker dropdown-select w-100 position-relative" data-style=" border px-4 py-2 rounded-0 height-5 outline-none shadow-none form-control font-size-2" data-show-subtext="true" data-dropdown-align-right="true" tabindex="-98">
                                                    <option value="one" data-subtext="$9.59" selected="">Hardcover</option>
                                                    <option value="two" data-subtext="$9.59">Softcover</option>
                                                    <option value="three" data-subtext="$10.00">Kindal</option>
                                                </select><button type="button" class="btn dropdown-toggle border px-4 py-2 rounded-0 height-5 outline-none shadow-none form-control font-size-2" data-toggle="dropdown" role="button" title="Hardcover $9.59"><div class="filter-option"><div class="filter-option-inner"><div class="filter-option-inner-inner">Hardcover <small class="text-muted">$9.59</small></div></div> </div></button><div class="dropdown-menu dropdown-menu-right" role="combobox"><div class="inner show" role="listbox" aria-expanded="false" tabindex="-1"><ul class="dropdown-menu inner show"></ul></div></div></div>
                                                <!-- End Select -->
                                            </div>

                                            <form class="cart d-md-flex align-items-center" method="post" enctype="multipart/form-data">
                                                <div class="quantity mb-4 mb-md-0 d-flex align-items-center">
                                                    <!-- Quantity -->
                                                    <div class="border px-3 width-120">
                                                        <div class="js-quantity">
                                                            <div class="d-flex align-items-center">
                                                                <label class="screen-reader-text sr-only">Quantity</label>
                                                                <a class="js-minus text-dark" href="javascript:;">
                                                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="10px" height="1px">
                                                                        <path fill-rule="evenodd" fill="rgb(22, 22, 25)" d="M-0.000,-0.000 L10.000,-0.000 L10.000,1.000 L-0.000,1.000 L-0.000,-0.000 Z"></path>
                                                                    </svg>
                                                                </a>
                                                                <input type="number" class="input-text qty text js-result form-control text-center border-0" step="1" min="1" max="100" name="quantity" value="1" title="Qty">
                                                                <a class="js-plus text-dark" href="javascript:;">
                                                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="10px" height="10px">
                                                                        <path fill-rule="evenodd" fill="rgb(22, 22, 25)" d="M10.000,5.000 L6.000,5.000 L6.000,10.000 L5.000,10.000 L5.000,5.000 L-0.000,5.000 L-0.000,4.000 L5.000,4.000 L5.000,-0.000 L6.000,-0.000 L6.000,4.000 L10.000,4.000 L10.000,5.000 Z"></path>
                                                                    </svg>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- End Quantity -->
                                                </div>

                                                <button type="submit" name="add-to-cart" value="7145" class="btn btn-dark border-0 rounded-0 p-3 btn-block ml-md-4 single_add_to_cart_button button alt">Add to cart</button>

                                            </form>
                                        </div>
                                        <div class="px-lg-4 px-xl-7 py-5 d-flex align-items-center">
                                            <ul class="list-unstyled nav">
                                                <li class="mr-6 mb-4 mb-md-0">
                                                    <a href="#" class="h-primary"><i class="flaticon-heart mr-2"></i> Add to Wishlist</a>
                                                </li>
                                                <li class="mr-6">
                                                    <a href="#" class="h-primary"><i class="flaticon-share mr-2"></i> Share</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </main>
                </div>

      </div>
      <!--팝업 버튼 영역-->
      <div class="popup_btn" style="float: bottom; margin-top: 200px;">
          <a href="javascript:closePop();">닫기</a>          
      </div>
      
  </div>
</div>
</body>
<script type="text/javascript">	                                                                   
    $(document).ready(function (e){
		$('#btn_rental').on("click", function(){
			console.log("1111");
		});
	});                                          	
	</script>
</html>