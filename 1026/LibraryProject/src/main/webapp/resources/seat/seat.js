  
let roomid = "";

//window.onload 는 document.onload($(function(){}) 와 비슷하다.
$(function() {
         $('#room1,#room2,#room3,#room4').click(function(){
        	 
        	 var myDiv = "";
        	 for(var i=1; i<5; i++){
        		myDiv = $("#room"+i)
        		myDiv.attr('disabled',false);
        		myDiv.parent().parent().css({ //이렇게도 쓸 수 있으며 제일 낫다
     				"border-color": "",
     				"border-width": "0px",
     	 			"box-shadow": "0px 0px 0px"
    			});
			 }
        	 $(this).attr('disabled',true);

        	 $(this).parent().parent().css({ //이렇게도 쓸 수 있으며 제일 낫다
	   			  "display": "flex",
	   			  "flexDirection": "column",
	   			  "borderRadius": "15px",  
	   			  "box-shadow": "inset 0px 0px 15px 5px #00BFFF"
 				
 			 });
        	 var room = $(this).attr('id');
        	 roomid = room.substr(4,5);
        	 
        	 
        	 var myDiv = document.getElementById("appearS");
        	 var parent = myDiv.parentElement; // 부모 객체 알아내기
        	 parent.removeChild(myDiv); // 부모로부터 myDiv 객체 떼어내기
        	 
        	 const temp = document.createElement("div");
        	 temp.innerHTML = '<div id="appearS"><h6>제 '+roomid+'열람실 선택됨</h6></div>';
        	 document.querySelector("#appear").append(temp);
        	 
        	 // 열람실 선택시 버튼 값변경
        	 $(".time .btn-hover").css({
        		 "background-image": "linear-gradient(to right, #25aae1, #4481eb, #04befe, #3f86ed)",
                 "color": "#fff",
        	 });
        	 $(".time .btn-hover").html("자리선택");
             $(".time .btn-hover").removeAttr('disabled');
        	 var myDiv = document.getElementById("goseat");
             if(myDiv != null) {
                 var parent = myDiv.parentElement; // 부모 객체 알아내기
        	     parent.removeChild(myDiv);} // 부모로부터 myDiv 객체 떼어내기
        	 $("#roomNum").html("제 "+roomid+" 열람실");
        	 
        	 var TimeR = document.getElementById("selectTime")
        	 var Time1 = document.getElementById("time1")
        	 if(TimeR != null) TimeR.remove();
        	 const temp2 = document.createElement("div");
        	 temp2.setAttribute("id", "selectTime");
        	 temp2.setAttribute("class", "row mx-3");
        	 temp2.innerHTML = '<div id = "TimeButton" class="col-12 px-1 py-1"><h5>자리를 선택해주세요.</h5></div>';
        	 Time1.appendChild(temp2);
        	 document.getElementById("seatappearchild").innerHTML = "자리 및 시간 선택";
        	 document.getElementById("timeappearchild").innerHTML = "";
         })      	 
     });

// 시간 생성 및 체크
var reserveTime = () =>{
	
	var selected = document.querySelector("#layout .selected");
	var jsonObject = {
	    	roomid:roomid,
	    	seatnum:selected.innerHTML,
	    };
    var url = '../selectTime';
    fetch(url,{
      method : 'POST',
      headers: {
        "Content-Type": "application/json",
      },
      body : JSON.stringify(jsonObject)
      })
      .then(res=>{ // javascript로 데이터를 받아 json 형태로 return 시키고
        return res.json();
      }) 
      .then(json=>{ // 다시 then으로 받아 json으로 출력하면 결과값이 나온다
      var AllTime = [];
      var TimeCom = [];
	  for(var i = 0;i<json.timelist.length;i++){
	    	let time = json.timelist[i].seat_time
	    	let time1 = time.split(' ')[1].substr(0,2)
	    	let seatuse = json.timelist[i].seat_time_use
	    	
	    	TimeCom.push(json.timelist[i].seat_time.split(' ')[0]);
	    	AllTime.push(time1+":00,"+seatuse);
	    	
	  }
	  let all = document.querySelectorAll("#TimeButton");
	  for(let i=0; i<=all.length-1 ;i++){
			all[i].remove();
	  }
	  let TimeButton = document.getElementById("TimeButton");
	  if(TimeButton != null) TimeButton.remove();
	  var seatTimeList = []
			if(json.reztime != "null"){
				
				
				for(let i=0; i<= AllTime.length-1;i++){
					const seat_time = new Date(json.timelist[i].seat_time);
					var res_end = "";
					var res_start = "";
					json.reztime.forEach(function(time){
						res_end = new Date(time.res_end);
						res_start = new Date(time.res_start);
						if(res_start<=seat_time && seat_time<res_end) 
							seatTimeList.push(AllTime[i].split(',')[0]);
					});
				}
			}
			else {
				seatTimeList = null
				
			}
	  if(seatTimeList != null){
		  for(let i=0; i<= AllTime.length-1;i++){
			  if(seatTimeList.includes(AllTime[i].split(',')[0])){
					const aa = document.createElement("div");
					aa.setAttribute("class", "col-4 px-1 py-1");
					aa.setAttribute("id", "TimeButton");
					aa.innerHTML = '<button type="button" class="btn btn-light"'+"disabled"+' style="width:100%;border-radius: 5px;"> '+AllTime[i].split(',')[0]+'</button>';
					aa.onclick = "";
			  		document.getElementById("selectTime").append(aa);
			  }else{
					const aa = document.createElement("div");
					aa.setAttribute("class", "col-4 px-1 py-1");
					aa.setAttribute("id", "TimeButton");
					aa.innerHTML = '<button type="button" class="btn btn-light"'+AllTime[i].split(',')[1]+' style="width:100%;border-radius: 5px;"> '+AllTime[i].split(',')[0]+'</button>';
					aa.onclick = () => {
			            var all2 = document.querySelector("#layout .selected");
			            if(all2 == null){
			                alert("좌석을 먼저 선택해주세요.");
			            }else{
			                let all = document.querySelectorAll("#TimeButton");
			                for(let i=0; i<=all.length-1 ;i++){
			                    if(all[i] != null)
			                    all[i].classList.remove("selected");
			                }
			                aa.classList.toggle(AllTime[i].split(',')[2]);
			                var timeR = document.getElementById("timeappearchild");
			                if(timeR != null) timeR.remove();
			                var selected2 = document.querySelector("#selectTime .selected");
			                var timeappear = document.getElementById("timeappear");
			                var bb = document.createElement("h6");
			                bb.setAttribute("id", "timeappearchild");
			                bb.innerHTML = ", "+selected2.innerHTML.slice(-15,-9);
			                timeappear.appendChild(bb);
			            }
						
					};
			  		document.getElementById("selectTime").append(aa);
			  }
		  }
	  }else{
		  console.log("널임");
		  for(let i=0; i<= AllTime.length-1;i++){
			  const aa = document.createElement("div");
				aa.setAttribute("class", "col-4 px-1 py-1");
				aa.setAttribute("id", "TimeButton");
				aa.innerHTML = '<button type="button" class="btn btn-light"'+AllTime[i].split(',')[1]+' style="width:100%;border-radius: 5px;"> '+AllTime[i].split(',')[0]+'</button>';
				aa.onclick = () => {
		            var all2 = document.querySelector("#layout .selected");
		            if(all2 == null){
		                alert("좌석을 먼저 선택해주세요.");
		            }else{
		                let all = document.querySelectorAll("#TimeButton");
		                for(let i=0; i<=all.length-1 ;i++){
		                    if(all[i] != null)
		                    all[i].classList.remove("selected");
		                }
		                aa.classList.toggle(AllTime[i].split(',')[2]);
		                var timeR = document.getElementById("timeappearchild");
		                if(timeR != null) timeR.remove();
		                var selected2 = document.querySelector("#selectTime .selected");
		                var timeappear = document.getElementById("timeappear");
		                var bb = document.createElement("h6");
		                bb.setAttribute("id", "timeappearchild");
		                bb.innerHTML = ", "+selected2.innerHTML.slice(-15,-9);
		                timeappear.appendChild(bb);
		            }
					
				};
		  		document.getElementById("selectTime").append(aa);
		  } //else 끝
	  }

      })
      .catch(err=>{
        console.log(err);
      })

}
//(c) 좌석 표시하기
var saveSeat = () => {
	var selected = document.querySelector("#layout .selected");
	if(selected != null){
		var seatR = document.getElementById("seatappearchild")
	    if(seatR != null) seatR.remove();
	    var seatappear = document.getElementById("seatappear");
	    var bb = document.createElement("h6");
	    bb.setAttribute("id", "seatappearchild");
	    bb.innerHTML = selected.innerHTML+'번 좌석';
	    seatappear.appendChild(bb);
	    
	    
	    document.getElementById("popup_layer").style.display = "none";
	    reserveTime();
	}else alert("좌석을 선택해주세요.")
    
    
}
var update = () => {
	let selected = document.querySelector("#layout .selected");
    let selected2 = document.querySelector("#selectTime .selected");

    /*alert(roomid + ", "+ selected.innerHTML + ", " +selected2.innerHTML.slice(-16,-9));*/
    if (roomid == ""){
        alert("열람실을 선택해주세요");
    }else{
        if(selected == null){
            alert("자리를 선택해주세요")
        }else{
            if(selected2 == null){
                alert("시간을 선택해주세요")
            }else{
            	
            	var jsonObject = {
            	    	roomid:roomid,
            	    	seatnum:selected.innerHTML,
            	    	seattime:selected2.innerHTML.slice(-15,-9),
            	    };
            	
            	    var url = '../updateRez.do';
            	    fetch(url,{
            	      method : 'POST',
            	      headers: {
            	        "Content-Type": "application/json",
            	      },
            	      body : JSON.stringify(jsonObject)
            	      })
            	      .then(res=>{ // javascript로 데이터를 받아 json 형태로 return 시키고
				        return res.json();
				        
				      }) 
				      .then(json=>{ // 다시 then으로 받아 json으로 출력하면 결과값이 나온다
				    	  console.log(json.update);
				    	  if(json.update == 1){
				    		  alert("예약시간이 꽉 차 있습니다.")
				    		  location.href="/rezUpdate";
				    	  }else if(json.update == 2){
				    		  alert("예약된 시간이 없습니다.");
				    		  location.href="/";
				    	  }else{
				    		  console.log(roomid + ", "+ selected.innerHTML + ", " +selected2.innerHTML.slice(-17,-9));
				    		  alert("수정 완료!")
				              location.href="/";
				    	  }
				      }) 
            	      .catch(err=>{
            	        console.log(err);
            	      })	
            }
        }
    }
}

// 모든것 저장하기
var save = () => {
    let selected = document.querySelector("#layout .selected");
    let selected2 = document.querySelector("#selectTime .selected");

    /*alert(roomid + ", "+ selected.innerHTML + ", " +selected2.innerHTML.slice(-16,-9));*/
    if (roomid == ""){
        alert("열람실을 선택해주세요");
    }else{
        if(selected == null){
            alert("자리를 선택해주세요")
        }else{
            if(selected2 == null){
                alert("시간을 선택해주세요")
            }else{
            	
            	var jsonObject = {
            	    	roomid:roomid,
            	    	seatnum:selected.innerHTML,
            	    	seattime:selected2.innerHTML.slice(-15,-9),
            	    };
            	
            	    var url = '../updateSeat';
            	    fetch(url,{
            	      method : 'POST',
            	      headers: {
            	        "Content-Type": "application/json",
            	      },
            	      body : JSON.stringify(jsonObject)
            	      })
            	      .then(res=>{ // javascript로 데이터를 받아 json 형태로 return 시키고
				        return res.json();
				        
				      }) 
				      .then(json=>{ // 다시 then으로 받아 json으로 출력하면 결과값이 나온다
				    	  console.log(json.size);
				    	  if(json.size > 0){
				    		  alert("예약시간이 꽉 차 있습니다.")
				    		  location.href="/rez";
				    	  }else if(json.rez != null){
				    		  alert("이미 예약을 하신 상태입니다.")
				    		  location.href="/";
				    	  }else{
				    		  console.log(roomid + ", "+ selected.innerHTML + ", " +selected2.innerHTML.slice(-17,-9));
				    		  alert("예약 완료!")
				              location.href="/";
				    	  }
				    	  
				      }) 
            	      .catch(err=>{
            	        console.log(err);
            	      })	
            }
        }
    }
}

// 자리 생성 및 체크
var reserve = {
  // (A) INIT
  init : () => {
	  
	    
    // (A1) GET LAYOUT WRAPPER
      
    // 열람실별로 다르게 하기
    let layoutR = document.getElementById("layout");
    if(layoutR != null) layoutR.remove();
    const aa = document.createElement("div");
    aa.setAttribute("id", "layout");
    document.getElementById("layoutP").append(aa);
    
    // (A2) GENERATE SEATS
    
    let k = 0;
    
    if(roomid==1) {k = 71;}
    else if(roomid==2) {k=80;}
    else if(roomid==3) {k=72;}
    else if(roomid==4) {k=74;}
    
    let AllSeat = [];
    let con = 0;  
    for (let i=65; i<=k; i++) { for (let j=1; j<=5; j++) {
        con++;
      let seat = document.createElement("div");
      seat.innerHTML = String.fromCharCode(i) + j;
      seat.className = "seat";
      seat.id = "seatSearch";
      seat.onclick = () => { reserve.toggle(seat); };
      aa.appendChild(seat);
      AllSeat.push(String.fromCharCode(i) + j);
      // 자리 줄 만들기
      if(con%2 != 0) continue;
        let seatC = document.createElement("div");
        seatC.setAttribute("class", "row-1");
        seatC.setAttribute("id", "seatRow");
        aa.appendChild(seatC);
        
      /*let seatRow = document.querySelector("#layout #seatRow");*/
        //console.log(seatRow);
      
    }}
    
    //asyncTest(AllSeat); // 데이터 넣기(좌석 개수 변경시 사용 ㄱ)
    
    // 이미 선택된 좌석 만들기
    let all2 = document.querySelectorAll("#layout .seat")
    var red1 = [];var red2 = [];var red3 = [];var red4 = [];
    var url = '../initSeat';
    fetch(url,{
      method : 'POST',
      headers: {
        "Content-Type": "application/json",
      },
      }).then(response=>{ // javascript로 데이터를 받아 json 형태로 return 시키고
        return response.json();
      }) 
      .then(json=>{ // 다시 then으로 받아 json으로 출력하면 결과값이 나온다
        
        for(var i = 0;i<json.length;i++){
        	let takenSeat = json[i].seat_num
        	let takenF = json[i].f_num
        	if(takenF == 6) red1.push(takenSeat);
        	else if(takenF == 7) red2.push(takenSeat);
        	else if(takenF == 8) red3.push(takenSeat);
        	else if(takenF == 9) red4.push(takenSeat);
        }
        var red = [];
        if(roomid==1) red = red1;
        else if(roomid==2) red = red2;
        else if(roomid==3) red = red3;
        else if(roomid==4) red = red4;
        for(let i=0; i<all2.length;i++){
            if(red.includes(all2[i].innerHTML)) {
                all2[i].classList.add("taken");
            }
        }
      })
      .catch(err=>{
        console.log(err);
      })
  },

  // (B) CHOOSE THIS SEAT
  toggle : (seat) => {
	let all = document.querySelectorAll("#layout .seat");
	for(let i=0; i<=all.length-1 ;i++){
		all[i].classList.remove("selected");
	}
    seat.classList.toggle("selected");
  },  
};

// Seat번호  DB에 넣기
function asyncTest(array){
    let jsonObj = new Object();
    let jsonArray = new Array();
    const seats = array;

    for(let i = 0; i < seats.length; i++){
      jsonObj.seat = seats[i];
      jsonArray.push(jsonObj);
      jsonObj = {};
      /* 주의사항으로...
        Object 초기화, 해당 사항을 해주지 않으면 객체에는 마지막 데이터만 남게된다.
        아래와 같이 말이다
        jsonArray[0].name = "길동", 
        jsonArray[1].name = "길동",
        jsonArray[2].name = "길동"
        이렇게 되는 이유는 무엇일까? jsonArray.push(jsonObj) 를 하게 될 경우
        단일 데이터가 저장되는 것이 아닌 jsonObj 객체를 선언한 주소값이 저장되기 때문에
        jsonArray의 각각의 배열에는 jsonObj의 동일한 주소값을 바라보고 있는 것이다.
      */
    }    

    // POST 비동기 	
    let url = '../insertSeat';
    fetch(url,{
      method : 'POST',
      headers: {
        "Content-Type": "application/json",
      },
      body : JSON.stringify(jsonArray)
      }).then(res=>{ // javascript로 데이터를 받아 json 형태로 return 시키고
        return res.json();
      }) 
      .then(json=>{ // 다시 then으로 받아 json으로 출력하면 결과값이 나온다
        console.log(json);
      })
      .catch(err=>{
        console.log(err);
      })
}
//=========================== 눈에 보이는 클릭 function 모음 ===============

//팝업창 여닫기
var popup = () => {
    document.getElementById("popup_layer").style.display = "block";
    reserve.init();
}
var closePop = () => {
    document.getElementById("popup_layer").style.display = "none";
    var all = document.querySelectorAll("#layout .seat");
    for(let i=0; i<=all.length-1 ;i++){
		all[i].classList.remove("selected");
	}
}


//멤버만 열람실 예약 들어갈수 있게
var memberis = () => {
	alert("호호");
}


