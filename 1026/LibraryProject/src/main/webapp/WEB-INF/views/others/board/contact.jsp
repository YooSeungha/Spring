<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Title -->
    <title>Contact Us | Bookworm</title>

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
    <!-- 게시판 css -->
    <style type="text/css">
    body{
        line-height:2em;        
        font-family:"맑은 고딕";
}
    ul, li{ 
        list-style:none;
        text-align:center;
        padding:0;
        margin:0;
}

    #mainWrapper{
        width: 55%;
        margin: 0 auto; /*가운데 정렬*/
    }

    #mainWrapper > ul > li:first-child {
        text-align: center;
        font-size:14pt;
        height:40px;
        vertical-align:middle;
        line-height:30px;
}

    #ulTable {margin-top:10px;}
    

    #ulTable > li:first-child > ul > li {
        background-color:#88bf74;
        font-weight:bold;
        text-align:center;
}

    #ulTable > li > ul {
        clear:both;
        padding:0px auto;
        position:relative;
        min-width:40px;
}
    #ulTable > li > ul > li { 
        float:left;
        font-size:10pt;
        border-bottom:1px solid silver;
        vertical-align:baseline;
}    

    #ulTable > li > ul > li:first-child               {width:10%;} /*No 열 크기*/
    #ulTable > li > ul > li:first-child +li           {width:45%;} /*제목 열 크기*/
    #ulTable > li > ul > li:first-child +li+li        {width:20%;} /*작성일 열 크기*/
    #ulTable > li > ul > li:first-child +li+li+li     {width:15%;} /*작성자 열 크기*/
    #ulTable > li > ul > li:first-child +li+li+li+li{width:10%;} /*조회수 열 크기*/

    #divPaging {
          clear:both; 
        margin:0 auto; 
        width:220px; 
        height:50px;
}

    #divPaging > div {
        float:left;
        width: 30px;
        margin:0 auto;
        text-align:center;
}

    #liSearchOption {clear:both;}
    #liSearchOption > div {
        margin:0 auto; 
        margin-top: 30px; 
        width:auto; 
        height:100px;

}

.left {
        text-align : left;
}
@font-face {
    font-family: 'RIDIBatang';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/RIDIBatang.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
h6{
  font-family: 'RIDIBatang';
}

</style>
</head>
<body>
    <!--===== HEADER CONTENT =====-->
    <%@ include file="/WEB-INF/views/subheader.jsp" %>

    <!--===== END HEADER CONTENT =====-->

    <!-- ====== MAIN CONTENT ===== -->
    <main id="content">
		<div class="py-1 py-lg-7" style="position: relative;">
             <h6 class="font-weight-medium font-size-7 text-center my-1">
             <img  src="/img/도서관2.jpg" width="80%"  height="320"/>
             <br><br><br>
          <div style="color:white; left: 40%; width: 20%; bottom: 220px; font-size: 1.8em; font-weight: bold;   position: absolute"> 자유 게시판</div></h6>
        </div>
        
        
        
        <div id="mainWrapper">
        	<div class="board-total"style="float:left;">
        	<c:choose>
		         
				<c:when test="${ps == 5}">
				 <span class="total">총 <b style="color:#f75454 ;">${count}건</b></span>
				  <span class="txt">의 게시물이 등록되어 있습니다.</span>
				  <span class="page">(<b>${cp}</b> / ${size} Page)</span>
				</c:when>
				<c:when test="${ps == 10}">
				 <span class="total">총 <b style="color:#f75454 ;">${count}건</b></span>
				  <span class="txt">의 게시물이 등록되어 있습니다.</span>
				  <span class="page">(<b>${cp}</b> / ${size} Page)</span>
				</c:when>
				<c:when test="${ps == 15}">
				 <span class="total">총 <b style="color:#f75454 ;">${count}건</b></span>
				  <span class="txt">의 게시물이 등록되어 있습니다.</span>
				  <span class="page">(<b>${cp}</b> / ${size} Page)</span>
				</c:when>
			</c:choose>
			<%-- 
         	 <span class="total">총 <b style="color:#f75454 ;">${count}건</b></span>
                  <span class="txt">의 게시물이 등록되어 있습니다.</span>
                  <span class="page">(<b>${cp}</b> / ${size} Page)</span>
            </div>
             --%>
			<c:set var="loginId" value="${sessionScope.member.mem_name}"/>
            <c:if test="${loginId!= null}">  
               <div style="float:right;margin-right: 10px;">
                  <span  style="color:#f75454 ;">${loginId}</span>
                  <span class="txt">님이 로그인 중입니다.</span>
               </div>
            </c:if>
            
            </div>
<!-- 게시물 개수 선택--------------------------------------------------------------------------------------------------------------------------------------------------- -->

<form action="read.do">
	 <li id='ps' style="margin-right: 15%;">
	     보여질 게시물 수<div  style="float:right;margin-right: 5%;">
	         <select name="ps" id='selSearchOption' style="width:100%; height: 10%;" onchange="submit();">   
	         
		         <c:choose>
		         
	    			<c:when test="${ps == 5}">     
		             <option value='5' selected>5</option>
		             <option value='10'>10</option>
		             <option value='15'>15</option>
		             
		             </c:when>
		             <c:when test="${ps == 10}">     
		             <option value='5' >5</option>
		             <option value='10'selected>10</option>
		             <option value='15'>15</option>
		             </c:when>
		             
		             <c:when test="${ps == 15}">     
		             <option value='5' >5</option>
		             <option value='10'>10</option>
		             <option value='15'selected>15</option>
		             </c:when>
		             
		         </c:choose>
	         </select>
	     </div>
	  </li>
</form>
<script>
function submit(){
	$('#ps').submit();
}
</script>
<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------- -->
            <br>
            <!-- 게시판 목록  -->
         <li>
             <ul id ="ulTable">
                 <li style="color:white;">
                     <ul>
                         <li>No</li>
                         <li>제목</li>
                         <li>작성일</li>
                         <li>작성자</li>
                         <li>조회수</li>
                     </ul>
                 </li>
                
          <!-- 게시물이 출력될 영역 -->
          	<c:forEach items="${map.user}" var="Board" varStatus="status">
               <li>
               
                    <ul>        	
                        <li>${Board.b_num}</li>
                        <li >
                        <a class="link-black-100 mb-1"href="/others/view.do?b_num=${Board.b_num} ">
                        <c:choose>
                        	<c:when test="${map.reviewCount[status.index]>0}">
                        		<b>${Board.b_title}&nbsp;[${map.reviewCount[status.index]}]</b>
                        	</c:when>
                        	<c:otherwise>
	                        	<b>${Board.b_title}</b>
                        	</c:otherwise>
                        </c:choose>
                        
                        </a>
                        </li>
                        <li>${Board.b_rdate}</li>
                        <li>${map.mem_names[status.index]}</li>
                        <li>${Board.b_view}</li>
                    </ul>
                </li>
			</c:forEach>  	
					
			 <span style="float:right; padding-top: 10px;">
			 	<button type="submit" id="btnWrite" class="btn btn-primary btn-sm-wide transition-3d-hover" onclick="writeok('${member}')">글쓰기</button>
			 </span>
			
           <!-- 게시판 페이징 영역 -->
              <br><br>
                <div id="divPaging">
                   <nav  aria-label="Page navigation example" style="width:400px">
                    <ul class="pagination pagination__custom justify-content-start flex-nowrap flex-md-wrap overflow-auto overflow-md-visble mb-0">          
                <c:choose>
	           		<c:when test="${keyword != null}">
	           			<c:choose>
			           		<c:when test="${start != 1}">
			                	<div class="flex-shrink-0 flex-md-shrink-1 page-item"><a class="page-link" href="read.do?catgo=${catgo}&keyword=${keyword}&cp=${start-1}&ps=${ps}">Previous</a></div>
			                </c:when>
		                </c:choose>	
	                </c:when>  
	                <c:when test="${keyword == null}">
	           			<c:choose>
			           		<c:when test="${start != 1}">
			                	<div class="flex-shrink-0 flex-md-shrink-1 page-item"><a class="page-link" href="read.do?cp=${start-1}">Previous</a></div>
			                </c:when>
		                </c:choose>	
	                </c:when>  
	            </c:choose>    	            
	               

				<c:forEach begin="${start}" end="${end}" var="i">
                    <c:choose>
                          <c:when test="${keyword != null}">
                       		<div>
                      		 <c:choose>
                             	 <c:when test="${cp == i }">
                             		 <li class="flex-shrink-0 flex-md-shrink-1 page-item active" ><a class="page-link" href="read.do?catgo=${catgo}&keyword=${keyword}&cp=${i}&ps=${ps}">${i}</a></li>
                          		 </c:when>
                         		 <c:otherwise>
                            		 <li class="flex-shrink-0 flex-md-shrink-1 page-item " ><a class="page-link" href="read.do?catgo=${catgo}&keyword=${keyword}&cp=${i}}&ps=${ps}">${i}</a></li>
                         		 </c:otherwise>
                      		 </c:choose>
                 			</div>
                         </c:when>
	              		 <c:otherwise>
			              	 <c:choose>
				              	  <c:when test="${cp == i}">
				               	 	<div> <li class="flex-shrink-0 flex-md-shrink-1 page-item active"><a class="page-link" href="read.do?cp=${i}&ps=${ps}" onclick="/other/read.do">${i}</a></li></div>
				               	  </c:when>
				               	  <c:otherwise>
				               	  	<div> <li class="flex-shrink-0 flex-md-shrink-1 page-item"><a class="page-link" href="read.do?cp=${i}&ps=${ps}" onclick="/other/read.do">${i}</a></li> </div>
				               	  </c:otherwise>
			               	 </c:choose>       	  
	               		 </c:otherwise>
	               	</c:choose>
				</c:forEach>  
	
                <c:choose>
	           		<c:when test="${keyword != null}">
	           			<c:choose>
			           		<c:when test="${end != size}">
			                	<div class="flex-shrink-0 flex-md-shrink-1 page-item"><a class="page-link" href="read.do?catgo=${catgo}&keyword=${keyword}&cp=${end+1}&ps=${ps}">Next</a></div>
			                </c:when>
		                </c:choose>	
	                </c:when>  
	                <c:when test="${keyword == null}">
	           			<c:choose>
			           		<c:when test="${end != size}">
			                	 <div class="flex-shrink-0 flex-md-shrink-1 page-item"><a class="page-link" href="read.do?cp=${end+1}&ps=${ps}">Next</a></div>
			                </c:when>
		                </c:choose>	
	                </c:when>  
	            </c:choose>  

	            </ul>
	 
                </nav>
                </div>
            
			<br>
			<!--  글쓰기 영역   -->

			<br>
			<script>
            function writeok(member){
            	
            	console.log("${member}");
            	
           	 if("${member}".length>0){
           		 location.href='/write.do';	
     		 }else{
    			alert("로그인을 하셔야 이용하실 수 있습니다");
    			location.href='/';
    		  }
            }
            </script>
            <!-- 검색 폼 영역 -->
            <form action="read.do">
	            <li id='catgo'>
	                <div>
	                    <select name="catgo" id='selSearchOption' style="width:80px; height: 50px;">        
	                        <option value='b_title' >제목</option>
	                        <option value='b_content'>내용</option>
	                        <option value='mem_name'>작성자</option>
	                    </select>
	                    <input id='txtKeyWord' name="keyword" style="width:200px; height: 50px;"/>
	                    <button type="submit" class="btn btn-primary btn-sm-wide transition-3d-hover">검색</button>
	                    
	                </div>
	             </li>
            </form>
            <br>
      </ul>
      </li>
     

     
    </div>
   
    <!-- ====== END MAIN CONTENT ===== -->

    <!-- ========== FOOTER ========== -->
    <footer>
        <div class="border-top space-top-2"><!-- style="background: darkgray;" -->
<!--         푸터(footer)는 보통 <footer> 요소가 포함되어 있는 문서나 섹션에 대한 아래와 같은 정보를 포함합니다.

		- 저자(author) 정보
		- 저작권 정보
		- 연락처
		- 사이트맵(sitemap)
		- 페이지 맨 위로 되돌아갈 수 있는 Top 버튼
		- 연관 페이지 등 -->
          <!--   <div class="border-bottom pb-2"> -->
                <div class="container">

                    <div class="row">
                        <div class="col-lg-3 mb-4 mb-lg-0">
                            <div class="pb-1"id="map" style="width:200%;height:250%;">
                                <a href="../" class="d-inline-block mb-5">
									<img src='https://ifh.cc/g/syLZZr.png' border='100%;'width="300;"></a>
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-5 mb-6 mb-lg-0">
                           	    <address class="font-size-2">
                                    <span class="mb-2 font-weight-normal text-dark">
                                        (153-759) 서울시 금천구 가산동 426-5 월드메르디앙 2차 415호 
                                        <br>
                                        15강의실
                                        <br>
                                         TEL : 02-2025-8523 
                                         <br>
                                         FAX : 02-2025-4113
                                    </span>
                                </address> 
                        </div>
                        <div class="col-lg-3 mb-4 mb-lg-0"style="float: right; ">
                            <!-- * 카카오맵 - 지도퍼가기 -->
							<!-- 1. 지도 노드 -->
							<div id="daumRoughmapContainer1666601305997" class="root_daum_roughmap root_daum_roughmap_landing" style="border: 1px solid gold;  "></div>							
							<!--
								2. 설치 스크립트
								* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
							-->
							<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
							
							<!-- 3. 실행 스크립트 -->
							<script charset="UTF-8">
								new daum.roughmap.Lander({
									"timestamp" : "1666601305997",
									"key" : "2c6se",
									"mapWidth" : "350",
									"mapHeight" : "170"
								}).render();
							</script>
                        </div>
                    </div>
                </div>
           <!--  </div> -->
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
</html>
