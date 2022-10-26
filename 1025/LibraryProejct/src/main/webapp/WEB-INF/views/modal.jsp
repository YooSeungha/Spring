<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <title>Modal</title>
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>   
</head>
<link rel="stylesheet" href="/css/modal.css">
<body>

<div id="root">   
    <button type="button" id="modal_opne_btn">모달 창 열기</button>       
</div>


<script>
	$("#modal_opne_btn").click(function(){
	    $("#modal").fadeIn();
	});
	
	 $("#modal_close_btn").click(function(){
	    $("#modal").fadeOut();
	}); 
</script>
</body>
</html>