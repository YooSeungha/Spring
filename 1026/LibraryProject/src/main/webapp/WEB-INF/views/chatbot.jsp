<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>chatbot</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="HostSpace template project">
<meta name="viewport" content="width=device-width, initial-scale=1">
	

    <!-- CSS Bookworm Template -->
    <link rel="stylesheet" type="text/css" href="css/chatbot.css">
    
    <script src="https://kit.fontawesome.com/d894d6e4a2.js" crossorigin="anonymous"></script>
    
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>

</head>
	<body>
		<div id="body"> 
			<div id="chat-circle" class="btn btn-raised">
			        <div id="chat-overlay"></div>
			        <i class="fa-solid fa-comment" style="font-size: 25px;position:relative; top:-5px;right:5px;"></i>
			</div>
			  
			  <div class="chat-box">
			    <div class="chat-box-header">
			      <i class="fa-solid fa-robot" style="font-size: 35px;padding-left: 25px;"></i>
			      <span class="chat-box-toggle"><i class="material-icons">close</i></span>
			    </div>
			    <div class="chat-box-body">
			      <div class="chat-box-overlay">   
			      </div>
			      <div class="chat-logs">
			      	
			      	<div class="chat-msg user">
			       	<span class="msg-avatar">
			       		<img src="/img/ch.png">
			       	</span>
			       	<div class="cm-msg-text">
			       		<center>안녕하세요 파스텔 도서관 입니다.</center></br>
			       		<input type="button" onclick="code_click()" class="log-menu" value="1. 도서관 소개"/>
			       		<input type="hidden" id="codes1" name="c_num" value="one"/>
			       		<input type="button" onclick="two_click()" class="log-menu" value="2. 대여 방법"/>
			       		<input type="button" onclick="three_click()" class="log-menu" value="3. 열람실 이용 방법"/>
			       		<input type="button" onclick="four_click()" class="log-menu" value="4. 상담문의"/>
			       		<input type="hidden" id="codes4" name="c_num" value="four"/>
			       		
			       	</div>
			       	</div>
			      
			      </div><!--글 써지는 곳 -->
			    </div>
			    <div class="chat-input">      
			      <form>
			        <input type="text" id="chat-input" placeholder="상담서비스 준비중입니다." disabled/>
			      	<button type="submit" class="chat-submit" id="chat-submit" disabled><i class="material-icons">send</i></button>
			      </form>
			  </div>
		</div>

		<script src="/js/chatbot.js" type="text/javascript"></script>
	</body>
</html>