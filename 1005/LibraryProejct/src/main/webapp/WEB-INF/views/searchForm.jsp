<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>HostSpace</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="HostSpace template project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="hsp/styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="hsp/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="hsp/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="hsp/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="hsp/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="hsp/styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="hsp/styles/responsive.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

</head>
<body>

<script>
	jQuery(function($) {
		$("#search").keydown(function(e) {		// 메인 페이지 중간 검색어 입력박스 엔터-키 처리
			if (e.keyCode == 13) {
				$("#search_button").trigger( "click" );
			}
		});
		$("#search_button").click(function(e) {					// 메인 페이지 검색어 입력박스 옆 전송버튼 클릭시
			let terms = $("#search").val().trim();
			let type = $("#selected_type").text();
			if (terms == '') {
				alert("검색어를 입력하세요.");
				return false;
			}
			let searchtype = '';
			if (type == "통합검색") {				// 통합검색
				searchtpye = "1";
			}
			else if (type == "책제목") {		// 책제목
				searchtpye = "2";
			}
			else if (type == "저자") {		// 저자
				searchtpye = "3";
			}
			else if (type == "출판사") {		// 출판사
				searchtpye = "4";
			}
			$(location).attr('href', "/search/book?type="+searchtpye+"&keyword="+terms);
			return false;
		});
	});
</script>
<div class="row" style="background:black;">
	<div class="col-lg-10 offset-lg-1">
		<div class="domain_search_form_container">
			<form action="/search/book" id="domain_search_form" class="domain_search_form d-flex flex-md-row flex-column align-items-center justify-content-start" method="POST">
				<div class="d-flex flex-row align-items-center justify-content-start">
					<input id="search" type="text" class="domain_search_input" placeholder="검색어를 입력해 주세요" required="required">
					<div class="domain_search_dropdown d-flex flex-row align-items-center justify-content-start">
						<i class="fa fa-chevron-down" aria-hidden="true"></i>
						<div id="selected_type" class="domain_search_selected">통합검색</div>
						<ul>
							<li>통합검색</li>
							<li>책제목</li>
							<li>저자</li>
							<li>출판사</li>
						</ul>
					</div>
				</div>
				<button id="search_button" class="domain_search_button d-flex flex-row align-items-center justify-content-center"><img src="hsp/images/search.png" alt="">검색</button>
			</form>
		</div>
	</div>
</div>

<script src="hsp/js/jquery-3.2.1.min.js"></script>
<script src="hsp/styles/bootstrap-4.1.2/popper.js"></script>
<script src="hsp/styles/bootstrap-4.1.2/bootstrap.min.js"></script>
<script src="hsp/plugins/greensock/TweenMax.min.js"></script>
<script src="hsp/plugins/greensock/TimelineMax.min.js"></script>
<script src="hsp/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="hsp/plugins/greensock/animation.gsap.min.js"></script>
<script src="hsp/plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="hsp/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="hsp/plugins/easing/easing.js"></script>
<script src="hsp/plugins/progressbar/progressbar.min.js"></script>
<script src="hsp/plugins/parallax-js-master/parallax.min.js"></script>
<script src="hsp/js/custom.js"></script>
</body>
</html>