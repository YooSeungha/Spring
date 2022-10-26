
  var INDEX = 0; 
  $("#chat-submit").click(function(e) {
    e.preventDefault();
    var msg = $("#chat-input").val(); 
    if(msg.trim() == ''){
      return false;
    }
    generate_message(msg, 'self');
    var buttons = [
        {
          name: 'Existing User',
          value: 'existing'
        },
        {
          name: 'New User',
          value: 'new'
        }
      ];
    setTimeout(function() {      
      generate_message(msg, 'user');  
    }, 1000)
    
  })
  
  function generate_message(msg, type) {
    INDEX++;
    var str="";
    str += "<div id='cm-msg-"+INDEX+"' class=\"chat-msg "+type+"\">";
    str += "          <span class=\"msg-avatar\">";
    str += "            <img src='/img/ch.png'>";
    str += "          <\/span>";
    str += "          <div class=\"cm-msg-text\">";
    str += msg;
    str += "          <\/div>";
    str += "        <\/div>";
    $(".chat-logs").append(str);
    $("#cm-msg-"+INDEX).hide().fadeIn(300);
    if(type == 'self'){
     $("#chat-input").val(''); 
    }    
    $(".chat-logs").stop().animate({ scrollTop: $(".chat-logs")[0].scrollHeight}, 1000);    
  }  
  
  function generate_button_message(msg, buttons){    

    INDEX++;
    var btn_obj = buttons.map(function(button) {
       return  "              <li class=\"button\"><a href=\"javascript:;\" class=\"btn btn-primary chat-btn\" chat-value=\""+button.value+"\">"+button.name+"<\/a><\/li>";
    }).join('');
    var str="";
    str += "<div id='cm-msg-"+INDEX+"' class=\"chat-msg user\">";
    str += "          <span class=\"msg-avatar\">";
    str += "            <img src='/img/ch.png'>";
    str += "          <\/span>";
    str += "          <div class=\"cm-msg-text\">";
    str += msg;
    str += "          <\/div>";
    str += "          <div class=\"cm-msg-button\">";
    str += "            <ul>";   
    str += btn_obj;
    str += "            <\/ul>";
    str += "          <\/div>";
    str += "        <\/div>";
    $(".chat-logs").append(str);
    $("#cm-msg-"+INDEX).hide().fadeIn(300);   
    $(".chat-logs").stop().animate({ scrollTop: $(".chat-logs")[0].scrollHeight}, 1000);
    $("#chat-input").attr("disabled", true);
  }
  
  $(document).delegate(".chat-btn", "click", function() {
    var value = $(this).attr("chat-value");
    var name = $(this).html();
    $("#chat-input").attr("disabled", false);
    generate_message(name, 'self');
  })
  
  $("#chat-circle").click(function() {    
    $("#chat-circle").toggle('scale');
    $(".chat-box").toggle('scale');
  })
  
  $(".chat-box-toggle").click(function() {
    $("#chat-circle").toggle('scale');
    $(".chat-box").toggle('scale');
  })
 
  
  function code_click(){
	  var log = document.getElementsByClassName("chat-logs");
	  let one = document.getElementById("codes1").value;
	  //alert("코드원의 value값: "+one);
	
	  html = "";
	  
	  html += "<div class='chat-msg user'>";
	  html += "<span class='msg-avatar'>";
	  html += "<img src='/img/ch.png'>";
	  html += "</span>";
	  html += "<div class='cm-msg-text'>";
	  html += "저희 파스텔 도서관은 도서관 관리 시스템으로 회원들이 빌리고 싶은 책을 검색을 하고 정보를 보는 것이 가능합니다.</br>";
	  html += "또한 도서관에 있는 책들은 대출이 가능하고 없는 책들은 도서를 신청해서 도서관에서 책을 받아서 회원들에게 대출을 할 수 있도록 서비스를 하고 있습니다.</br>";
	  html += "그리고 도서관에 있는 모든 책들은 관리자가 직접 관리를 할 수 있고 회원은 한달에 어떤 책이 가장 많이 빌려갔는지,</br>";
	  html += "도서관에 있는 책들의 종류가 어떤 것 인지 그래프로 보는 것이 가능합니다.</br>";
	  html += "<br/>";
	  html += "<input type='button' onclick='back()' class='log-menu' value='메뉴보기'/>";
	  html += "</div>";
	  html += "</div>";

	  //log.innerHTML = html;
	  $(".chat-logs").append(html);
	  $(".chat-logs").stop().animate({ scrollTop: $(".chat-logs")[0].scrollHeight}, 1000);
		 
  }
  function two_click(){
	  html = "";
	  html += "<div class='chat-msg user'>";
	  html += "<span class='msg-avatar'>";
	  html += "<img src='/img/ch.png'>";
	  html += "</span>";
	  html += "<div class='cm-msg-text'>";
	  html += "대여방법은 개발 중 입니다.";
	  html += "<br/>";
	  html += "<input type='button' onclick='back()' class='log-menu' value='메뉴보기'/>";
	  html += "</div>";
	  html += "</div>";

	  $(".chat-logs").append(html);
	  $(".chat-logs").stop().animate({ scrollTop: $(".chat-logs")[0].scrollHeight}, 1000);
  }
  function three_click(){
	  html = "";
	  html += "<div class='chat-msg user'>";
	  html += "<span class='msg-avatar'>";
	  html += "<img src='/img/ch.png'>";
	  html += "</span>";
	  html += "<div class='cm-msg-text'>";
	  html += "열람실 이용방법은 개발 중 입니다.";
	  html += "<br/>";
	  html += "<input type='button' onclick='back()' class='log-menu' value='메뉴보기'/>";
	  html += "</div>";
	  html += "</div>";

	  $(".chat-logs").append(html);
	  $(".chat-logs").stop().animate({ scrollTop: $(".chat-logs")[0].scrollHeight}, 1000);
  }
  
  
  function four_click(){
	  let four = document.getElementById("codes4").value;
	  //alert("코드포의 value값: "+four);
	   
	  html = "";
	  
	  html += "<div class='chat-msg user'>";
	  html += "<span class='msg-avatar'>";
	  html += "<img src='/img/ch.png'>";
	  html += "</span>";
	  html += "<div class='cm-msg-text'>";
	  html += "상담 문의는 개발 중 입니다.";
	  html += "<br/>";
	  html += "자세한 상담문의는 <a href='tel:010-6555-7022'>&nbsp;<strong style='color:#2b138b;font-weight:bold'>010-6555-7022</strong>&nbsp;</a>로 문의 주세요";
	  html += "<br/>";
	  html += "<input type='button' onclick='back()' class='log-menu' value='메뉴보기'/>";
	  html += "</div>";
	  html += "</div>";

	  $(".chat-logs").append(html);
	  $(".chat-logs").stop().animate({ scrollTop: $(".chat-logs")[0].scrollHeight}, 1000);

  }
  
  
  function back(){
	  html = "";
	  html += "<div class='chat-msg user'>";
	  html += "<span class='msg-avatar'>";
	  html += "<img src='/img/ch.png'>";
	  html += "</span>";
	  html += "<div class='cm-msg-text'>";
	  html += "<center>안녕하세요 파스텔 도서관 입니다.</center></br>";
	  html += "<input type='button' onclick='code_click()' class='log-menu' value='1. 도서관 소개'/>";
	  html += "<input type='hidden' id='codes1' name='c_num' value='one'/>";
	  html += "<input type='button' class='log-menu' value='2. 대여 방법'/>";
	  html += "<input type='button' class='log-menu' value='3. 열람실 이용 방법'/>";
	  html += "<input type='button' onclick='four_click()' class='log-menu' value='4. 상담문의'/>";
	  html += "<input type='hidden' id='codes4' name='c_num' value='four'/>";
	  html += "</div>";
	  html += "</div>";
	  
	  $(".chat-logs").append(html);
	  $(".chat-logs").stop().animate({ scrollTop: $(".chat-logs")[0].scrollHeight}, 1000);
	  
  }
