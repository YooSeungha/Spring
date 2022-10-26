// html 태그에 추가 onkeyup="mobile_keyup(this)"
// 핸드폰 번호 010-0000-0000 - 자동 입력기

function mobile_keyup(obj){
    let mobile_len=obj.value.length;
    if(event.keyCode == 8){
        obj.value=obj.value.slice(0,mobile_len); 
        return 0; 
    }else if (mobile_len == 3 || mobile_len == 8){
        obj.value += '-';
    }
}


// 회원가입시 체크 사항 
var e_check = false;
function email_check(){
	var mem_email = $('#signinEmail1').val();
	var email_ok = document.getElementById("email_ok");
	$.ajax({
		url:"http://localhost:8080/emailcheck.do",
		type:"post",
		dataType:"json",
		data:{ mem_email:mem_email },
		success: function(ec){
			if(ec == 1){	// 중복일 때
				e_check = false;
				//alert(e_check);
				email_ok.innerHTML = "※ 존재하는 이메일 입니다.";
				email_ok.style.color = "#ef4949";
                //$('#signinEmail1').val("");

			}else if(ec == 0){
				e_check = true;
				//alert(e_check);
				//email_ok.innerHTML = "※ 사용 가능한 이메일 입니다.";
				email_ok.innerHTML = "&nbsp;";
				//email_ok.style.color = "#138deb";
			}
		},
		error:function(err){
			alert("이메일 중복관련 에러"+err);
		}
	});
};

var p_check = false;
function phone_check(){
	var phone = $('#signinphone').val();
	let phone_ok = document.getElementById("phone_ok");
	//let patternPhone = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	$.ajax({
		url:"http://localhost:8080/phonecheck.do",
		type:"post",
		dataType:"json",
		data:{ mem_phone:phone },
		success: function(pc){
			if(pc == 1){	// 중복일 때 
				//alert("1번일때 값: "+pc);
				p_check = false;
				phone_ok.innerHTML = "※ 중복된 핸드폰 입니다.";
				phone_ok.style.color = "#ef4949";
                //$('#signinphone').val("");

			}else if(pc == 0){
				//alert("2번일때 값: "+pc);
				p_check = true;
				//phone_ok.innerHTML = "※ 사용 가능한 핸드폰 번호 입니다.";
				phone_ok.innerHTML = "&nbsp;";
				//phone_ok.style.color = "#138deb";
			}
		},
		error:function(){
			alert("핸드폰 중복관련 에러");
		}
	});
};

var id_check = false;
function id_checks(){
	var id = $('#signinid').val();
	//alert("111");
	let id_ok = document.getElementById("id_ok");
	$.ajax({
		url:"idcheck.do",
		type:"post",
		dataType:"json",
		data:{ mem_id:id },
		success: function(ic){
			if(ic == 1){	// 중복일 때 
				//alert("1");
				//alert("1번일때 값: "+ic);
				id_check = false;
				id_ok.innerHTML = "※ 중복된 아이디 입니다.";
				id_ok.style.color = "#ef4949";
                //$('#signinid').val("");

			}else if(ic == 0){
				//alert("2");
				//alert("2번일때 값: "+ic);
				id_check = true;
				//id_ok.innerHTML = "※ 사용가능한 아이디 입니다.";
				id_ok.innerHTML = "&nbsp;";
				//id_ok.style.color = "#138deb";
			}
		},
		error:function(err){
			alert("아이디 중복관련 에러: "+err);
		}
	});
};
///회원가입시 체크사항 끝

var phone_auth_check = false;
//회원가입시 핸드폰 인증 체크
function memberPhoneChecks(){
	alert("인증하기");
	var tel = $('#signinphone').val();
	let patternPhone = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	let auth_result = document.getElementById("phone_auth");
	
	if(!tel){
		phone_ok.innerHTML = "※ 핸드폰 번호를 입력해주세요.";
		phone_ok.style.color = "#ef4949";
		phone_auth_check = false;
	}else if(!patternPhone.test(tel)){
		phone_ok.innerHTML = "※ - (하이픈)제외 정확히 적어 인증해 주세요.";
		phone_ok.style.color = "#ef4949";
		phone_auth_check = false;
	}else{
		$.ajax({
			url : "http://localhost:8080/naverphone.do",
			type : "post",
			data : "tel=" + tel,
			dataType : "json",
			success : function(data) {
				const checkNum = data;
				alert('인증번호:'+ checkNum);
				alert('인증번호 발송 완료\n휴대폰에서 인증번호를 확인해주세요');
				var check = 0;
				if(!data){
					check = 2;
					alert("인증번호 안옴");
				}
	            //인증하기 버튼 클릭 이벤트
				$('#certifyCheck').click(function(){
					const userNum = $('input[name="memberPhoneCertify"]').val();		
					if(checkNum == userNum){
						//alert('인증 성공하였습니다.');
						auth_result.innerHTML = "※ 인증 성공";
						auth_result.style.color = "#138deb";
						phone_auth_check = true;
						check = 1;
						//alert(check);
					}else {
						//alert('인증 실패하였습니다. 다시 입력해주세요.');
						auth_result.innerHTML = "※ 인증 실패";
						auth_result.style.color = "#ef4949";
						phone_auth_check = false;
						check = 2;
						//alert(check);
					}
				});
			},
			error : function() {
				//alert("핸드폰 인증 에러코드[101]")
			}
		});
	}
};


//회원가입 버튼
//계정생성 버튼 인증확인 되어야만 회원가입 가능 
function signup_check(){
	//alert("누름");
	if(!e_check){
		alert("이메일을 확인해 주세요");
	}else if(!p_check){
		alert("핸드폰 번호를 확인해 주세요.");
	}else if(!id_check){
		alert("아이디를 확인해 주세요.");
	}else if(!phone_auth_check){
		alert("인증번호를 확인해 주세요.");
	}else if(e_check && p_check && id_check && phone_auth_check){
		//alert("회원가입 성공");
		document.getElementById('singUpForm').submit();
	}
};



function loginNaver(){
	$.ajax({
		url:'http://localhost:8080/naverlogin.do',
		type:'get',	
	}).done(function(res){
		//alert(res);
		//location.href = res;
		$('#signinEmail').val("");
		$('#signinPassword').val("");
	});
};

function loginNaver1(){
	$.ajax({
		url:'http://localhost:8080/naverlogin.do',
		type:'get',	
	}).done(function(res){
		//alert(res);
		location.href = res;
	});
};

function loginKakao(){
	$.ajax({
		url:'http://localhost:8080/kakaologin',
		type:'get',	
	}).done(function(res){
		alert(res);
		//location.href = res;
	});
}

//계정 찾기 시 핸드폰 유무 체크
function find_phone_check(){
	var phone = $('#findphone').val();
	var phone_input = document.getElementById('findphone');
	var find_ok = document.getElementById('find_phone_ok');
	//alert(find_ok);
	$.ajax({
		url:"http://localhost:8080/findphonecheck.do",
		type:"post",
		dataType:"json",
		data:{ mem_phone:phone },
		success: function(fpc){
			if(fpc == 1){	// 중복일 때 
				//alert(find_ok);
                find_ok.innerHTML = "※ 계정이 존재하는 핸드폰 번호 입니다. 인증을 진행해주세요.";
                find_ok.style.color = "#138deb";
                phone_input.style.border = "1px double #138deb";
			}else if(!phone && fpc == 0){
				//alert("zzz");
				find_ok.innerHTML = "&nbsp;";
				phone_input.style.border = "1px double black";
				phone_input.focus();
			}else if(fpc == 0){	//중복이 아닐 때 
				find_ok.style.color = "#ef4949";
				find_ok.innerHTML = "※ 존재하지 않는 핸드폰 번호 입니다. 회원가입을 진행해주세요.";
                phone_input.style.border = "1px double #ef4949";
			}
		},
		error:function(){
			alert("핸드폰 중복관련 에러");
		}
	});
};

//계정찾기 시 핸드폰 인증 체크	//2022-09-29 통합 후 수정
var phoneCheck = 0;
function find_phone_btn(){
	//alert("눌림");
	var tel = $('#findphone').val();
	var find_ok_check = document.getElementById("find_phone_auth");
	var find_value = document.getElementById("findphone").value;
	let patternPhone = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;

	if(!find_value){
		alert("핸드폰 번호를 입력해주세요");
	}else if(!patternPhone.test(find_value)){
		alert("핸드폰 양식에 맞춰 작성해 주세요\n -(하이픈) 표시는 하지 않아도 됩니다.");
	}else{
		$.ajax({
			url : "http://localhost:8080/findphone.do",
			type : "POST",
			data : "tel=" + tel,
			dataType : "json",
			success : function(data) {
				const checkNum = data;
				//alert('인증번호:'+ checkNum);
				alert('인증번호 발송 완료\n휴대폰에서 인증번호를 확인해주세요');
	            //인증하기 버튼 클릭 이벤트
				$('#phoneoauthchecking').click(function(){
					const userNum = $('input[name="phoneoauthcheck"]').val();		
					if(checkNum == userNum){
						alert('인증 성공하였습니다.');
						//alert('인증 성공 후 phoneCheck값: '+phoneCheck);
						find_ok_check.innerHTML = "※ 인증성공";
						find_ok_check.style.color = "#138deb";
						phoneCheck = 1;
						//alert(check);
					}else {
						//alert('인증 실패하였습니다. 다시 입력해주세요.');
						//alert('인증 실패 후 phoneCheck값: '+phoneCheck);
						find_ok_check.innerHTML = "※ 인증실패";
						find_ok_check.style.color = "#ef4949";
						$('.find_phoneauth').val("");
						phoneCheck = 2;
						//alert(check);
					}
				});
			},
			error : function(err) {
				//alert("핸드폰 인증 에러코드[201]"+err);
			}
		});
	}
}

function findphoneauth(){
	//alert("s");
	let auth = document.getElementById("findphoneauth").value;
	if(!auth){
		alert("인증번호를 입력해주세요.");
	}
}
// 확인 버튼 누를 시 
function findaccount_check(){
	var mem_phone = $('#findphone').val();
	var look_email = document.getElementById('lookemail_ok');
	var pcheck = phoneCheck;
	
	$.ajax({
		url:'http://localhost:8080/findemails.do',
		type:'post',
		data:{'mem_phone':mem_phone},
		//dataType:'json',
		success: function(email){
			if(pcheck == 0){
				alert("※ 인증을 진행해 주세요 ※");
			}else if(pcheck == 1){
				alert("인증 성공");
				//alert("인증 성공 후 pcheck"+pcheck);
				$('#lookemail_ok').html(email);
				look_email.innerHTML = email;
				look_email.style.color = "#138deb";
			}else if(pcheck == 2){
				//alert("NULL"+email);
				look_email.innerHTML = "존재 하지 않는 이메일 입니다 회원가입을 진행해 주세요.";
				look_email.style.color = "#ef4949";
			}
		},
		error: function(err){
			alert("에러 "+err);
		}
	});
	
};//확인 버튼 누를 시
		

///////////// 패스워드 찾기 시 이메일 중복 여부 ///////////////////
function find_password_check(){
	var mem_email = $('#find_email').val();
	let email_input = document.getElementById("find_email");
	let p_value = document.getElementById("find_email_ok");

	$.ajax({
		url:"http://localhost:8080/findpasswordcheck.do",
		type:"post",
		data:{ mem_email:mem_email },
		dataType:"json",
		success: function(fec){
			if(fec == 1){	// 중복일 때 이러면 DB에 값이 있음 확인
				//alert("1번일때 중복 값: "+fec);
				p_value.innerHTML = "※ 존재하는 이메일 입니다. 인증을 진행해주세요";
				p_value.style.color = "#138deb";
				email_input.style.border = "1px double #138deb";
			}else if(!mem_email && fec == 0){
				//alert("2번일때 중복 아님 값: "+fec);
				p_value.innerHTML = "&nbsp;";
				email_input.style.border = "1px double black";
				email_input.focus();
			}else if(fec == 0){
				//alert("2번일때 중복 아님 값: "+fec);
				p_value.innerHTML = "※ 존재하지 않는 이메일 입니다. 회원가입을 진행해주세요";
				p_value.style.color = "#ef4949";
				email_input.style.border = "1px double #ef4949";
			}
		},
		error:function(err){
			alert("계정 찾기 시 이메일 중복관련 에러"+err);
		}
	});
};


///////////////이메일로 비밀번호 찾기/////////////////////
var emailCheck = 0;
function find_email_btn() {
	const eamil = $('#find_email').val(); // 이메일 주소값 얻어오기!
	//alert('완성된 이메일 : ' + eamil); // 이메일 오는지 확인
	const checkInput = $('.find_pass_input'); // 인증번호 입력하는곳 and 인증값과 비교 대상
	var email_p = document.getElementById("find_pass_auth");
	var email_value = document.getElementById("find_email").value;
	var e_check = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	if(!e_check.test(email_value)){
		alert("이메일 양식에 맞춰 진행해 주세요.");
	}else{
		//alert("s");
		alert('인증번호가 전송되었습니다.');
		$.ajax({
			type : 'get',
			url : 'http://localhost:8080/mailCheck', // GET방식이라 Url 뒤에 email을 뭍힐수있다.
			data: {'mem_email':eamil},
			dataType: 'json',
			success : function (data) {
				//alert("data : " +  data);
				checkInput.attr('disabled',false);
				code = data;
				//이메일 인증번호 비교
				$('#find_pass_input_check').click(function(){
					const inputCode = $('input[name="find_pass"]').val();
					//const $resultMsg = $('#find_pass_input_check');
					if(inputCode == code){
						//alert("인증번호가 일치합니다");
						//$resultMsg.html('인증번호가 일치합니다.');
						emailCheck = 1;
						email_p.innerHTML = "※ 인증성공";
						email_p.style.color = "#138deb";
					}else{
						emailCheck = 2;
						//alert("인증번호 불일치");
						email_p.innerHTML = "※ 인증실패";
						email_p.style.color = "#ef4949";
					}
				});
			}			
		});
	}
}

function find_pass_input_check(){
	let find_val = document.getElementById("finedpassauth").value;
	if(!find_val){
		alert("인증번호를 입력해 주세요.");
	}
}

/////// 이메일 인증하기 후 인증확인이 되어야지만 확인 버튼 눌림 ////
function find_pass_check(){
	var mem_email = $('#find_email').val();
	var mCheck = emailCheck;
	let lookpass = document.getElementById("lookpass");
	$.ajax({
		url:'http://localhost:8080/passCheck.do',
		type:'post',
		data:{'mem_email':mem_email},
		//dataType:'json',
		success: function(data){
			//alert(data);
			if(mCheck == 0){
				alert("※ 인증을 진행해 주세요 ※");
			}else if(mCheck == 1){
				//alert("인증 성공");
				//alert("성공 후 데이터 값"+data)
				lookpass.innerHTML = data;
				lookpass.style.color = "#138deb";

			}else if(mCheck == 2){
				//alert("NULL"+data);
				lookpass.innerHTML = "존재 하지 않는 이메일 입니다 회원가입을 진행해 주세요.";
				lookpass.style.color = "#ef4949";
			}
		},
		error: function(err){
			alert("에러 "+err);
		}
	});
};//function find_pass_check()끝

//////////////회원 탈퇴 //////////////
var passwordChecking = 0;
var coo = 0;
//회원탈퇴시 비밀번호 체크
function pass_check() {
	//alert("입력됨");
	var mem_email = $('#deleteEmail').val();
	var mem_pass = $('#deleteCheckPass').val();
	var mem_pass_input = $('#deleteCheckPass').val();
	
	///alert(mem_email+", "+mem_pass);
	$.ajax({
		url:'http://localhost:8080/deletepasswordcheck',
		type:'post',
		data:{'mem_email':mem_email, 'mem_pass':mem_pass},
		dataType:'json',
		success: function(data){
			//alert("비밀번호 체크 성공data: "+data);
			if(data == 1){
				passwordChecking = 1;
				coo = 1;
				//alert(passwordChecking);
				$('#pass_ok').css("display","block");
				$('#pass_ok').css("color","green");
				$('#pass_ok').css("font-size","15px");
				$('#pass_fail').css("display","none");
			}else if(!mem_pass_input){
				passwordChecking = 2;
				$('#pass_ok').css("display","none");
				$('#pass_fail').css("display","none");
			}else{
				passwordChecking = 3;
				coo = 3;
				$('#pass_ok').css("display","none");
				$('#pass_fail').css("display","block");
				$('#pass_fail').css("color","red");
				$('#pass_fail').css("font-size","15px");
			}
		},
		error: function(err){
			alert("비밀번호 체크 ERROR: "+err);
		}
	});
};

//비밀번호 확인이 되면 회원탈퇴 일반회원용
function deleteBtns(){
	alert("회원탈퇴"+passwordChecking);
	var check = passwordChecking;
	if(check == 1){
		//alert("회원탈퇴 완료"+check);
		alert("※ 회원탈퇴 완료 ※");
		document.getElementById('deleteForm1').submit();	
	}else{
		alert("※ 회원탈퇴 실패 ※");
	}
};

//////////////회원탈퇴 네이버회원용///////////////
function go(){
	let deleteBtn = document.getElementById('deleteForm2');
	//alert(deleteBtn);
	if(!confirm("탙퇴하시겠습니까?")){
		alert("취소하셨습니다.");
	}else{	//2아래가 YES 클릭시
		alert("탈퇴완료[네이버]");
		location.href= "http://localhost:8080/naverResign.do";
		deleteBtn.submit();
		
	}
};


// 회원 업데이트 비밀번호 확인 시 
function update_pass(){
	var pass_one = $('#updatePass1').val();
	var pass_two = $('#updatePass2').val();
	if(pass_one == pass_two){
		alert("패스워드 위아래 동일함");
		document.getElementById('updateForm').submit();
	}else{
		alert("패스워드 위아래 틀림");
		$('#passwarning').css("display", "block");
		$('#passwarning').css("color", "red");
	}
};



