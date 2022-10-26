function redraw(){
	var search = getKeyword("searchModeStr");	
	var cp = getKeyword("cp");
	var ps = getKeyword("ps");
	console.log("cp : " + cp);
	console.log("ps : " + ps);
	setTimeout(function() {
		if(search!=""){ //검색했을 때
			var catgo = getKeyword("catgo");
			var keyword = getKeyword("keyword");								
			$.ajax({
				url: "/ajax/rental/manage.json", 
				type: "GET", 
				data: {catgo: catgo,
					keyword: keyword,
					searchModeStr: search,
					cp: cp,
					ps: ps}, 
				success: function(data){
					if(!data){
						alert("존재하지않는 data");
						return false;
					}
					console.log("data : " + data.rblr.items);
					var item = data.rblr.items;
					//$('#ren_content').empty();
					for(var i=0; i<item.length; i++){
						console.log("data : " + item[i].book.book_title);	                					
						//$('#ren_content').append(item[i].book.book_title);
					}
					html = "";
					$('#ren_content').empty();
					for(var i=0; i<item.length; i++){	                					
						html += '<div class="d-md-flex align-items-center mb-5">';
						html += '<span class="d-block mb-3 mb-md-0">';
						html += '<img class="img-fluid" src="'+item[i].book.book_img+'" alt="Image-Description" width=150px; height=150px;>';
						html += '</span>';
						html += '<div class="ml-md-8">';
						html += '<div class="mb-2">';
						if(item[i].ren_stat==0){
							html += '<span class="font-size-2" >상태 : <span style="color:red;">예약중</span></span>';
						}else if(item[i].ren_stat==1){
							html += '<span class="font-size-2">상태 : <span style="color:orange;">대출중</span></span>';
						}else{
							html += '<span class="font-size-2">상태 : <span style="color:green;">반납완료</span></span>';
						}
						html += '</div>';
						html += '<h6 class="font-size-7 crop-text-2 font-weight-medium text-lh-1dot4" style="width:400px;"><span>'+item[i].book.book_title+'</span></h6>';
						html += '<p class="font-size-2 text-secondary-gray-700">예약날짜 : '+item[i].ren_borrow+'</p>';
						html += '<p class="font-size-2 text-secondary-gray-700">반납날짜 : '+item[i].ren_return+'</p>';
						html += '<div class="font-size-2 text-secondary-gray-700">';
						html += '<span>예약한 회원 : '+item[i].member.mem_name+'</span>';
						html += '<span class="ml-3">회원연락처 : '+item[i].member.mem_phone+'</span>';
						html += '<span class="ml-3">예약번호 : '+item[i].ren_num+'</span>';
						html += '</div></div>'
						if(item[i].ren_stat==0){
							html += '<a class="btn btn-primary btn-sm-wide transition-3d-hover" href="javascript:rental_ok('+item[i].ren_num+');">수락</a>';
							html += '&nbsp;';
							html += '<a class="btn btn-primary-red btn-sm-wide transition-3d-hover" href="javascript:rental_deny('+item[i].ren_num+')">거절</a>';
						}else if(item[i].ren_stat==1){
							html += '<a class="btn btn-yellow-darker btn-sm-wide transition-3d-hover" href="javascript:rental_return('+item[i].ren_num+')">반납완료</a>';
						}else{
							html += '<a class="btn btn-primary-red btn-sm-wide transition-3d-hover" href="javascript:rental_del('+item[i].ren_num+')">반납도서삭제</a>';
						}
						html += '</div><hr>';
					}
					$('#ren_content').append(html);
				}
			});	
		}else{ //검색 안했을 때														
			$.ajax({
				url: "/ajax/rental/manage.json", 
				type: "GET", 
				data: {catgo: catgo,
					keyword: keyword,
					searchModeStr: search,
					cp: cp,
					ps: ps}, 
				success: function(data){
					if(!data){
						alert("존재하지않는 data");
						return false;
					}    	                				    	                				
					$('#ren_content').empty();    	                				
					var item = data.rblr.items;    	                				
					for(var i=0; i<item.length; i++){
						console.log("data : " + item[i].book.book_title);	                					
						//$('#ren_content').append(item[i].book.book_title);
					}
					html = "";
					$('#ren_content').empty();
					for(var i=0; i<item.length; i++){	                					
						html += '<div class="d-md-flex align-items-center mb-5">';
						html += '<span class="d-block mb-3 mb-md-0">';
						html += '<img class="img-fluid" src="'+item[i].book.book_img+'" alt="Image-Description" width=150px; height=150px;>';
						html += '</span>';
						html += '<div class="ml-md-8">';
						html += '<div class="mb-2">';
						if(item[i].ren_stat==0){
							html += '<span class="font-size-2" >상태 : <span style="color:red;">예약중</span></span>';
						}else if(item[i].ren_stat==1){
							html += '<span class="font-size-2">상태 : <span style="color:orange;">대출중</span></span>';
						}else{
							html += '<span class="font-size-2">상태 : <span style="color:green;">반납완료</span></span>';
						}
						html += '</div>';
						html += '<h6 class="font-size-7 crop-text-2 font-weight-medium text-lh-1dot4" style="width:400px;"><span>'+item[i].book.book_title+'</span></h6>';
						html += '<p class="font-size-2 text-secondary-gray-700">예약날짜 : '+item[i].ren_borrow+'</p>';
						html += '<p class="font-size-2 text-secondary-gray-700">반납날짜 : '+item[i].ren_return+'</p>';
						html += '<div class="font-size-2 text-secondary-gray-700">';
						html += '<span>예약한 회원 : '+item[i].member.mem_name+'</span>';
						html += '<span class="ml-3">회원연락처 : '+item[i].member.mem_phone+'</span>';
						html += '<span class="ml-3">예약번호 : '+item[i].ren_num+'</span>';
						html += '</div></div>'
						if(item[i].ren_stat==0){
							html += '<a class="btn btn-primary btn-sm-wide transition-3d-hover" href="javascript:rental_ok('+item[i].ren_num+');">수락</a>';
							html += '&nbsp;';
							html += '<a class="btn btn-primary-red btn-sm-wide transition-3d-hover" href="javascript:rental_deny('+item[i].ren_num+')">거절</a>';
						}else if(item[i].ren_stat==1){
							html += '<a class="btn btn-yellow-darker btn-sm-wide transition-3d-hover" href="javascript:rental_return('+item[i].ren_num+')">반납완료</a>';
						}else{
							html += '<a class="btn btn-primary-red btn-sm-wide transition-3d-hover" href="javascript:rental_del('+item[i].ren_num+')">반납도서삭제</a>';
						}
						html += '</div><hr>';
					}
					$('#ren_content').append(html);
	    			}
	    		});	
			}
		}, 200);
}