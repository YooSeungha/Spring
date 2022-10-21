function rental_ok(ren_num){ //도서대출 수락
	$.ajax({
		url: "/ajax/rental/manage.json", 
		type: "GET", 
		data: {isbn: info}, 
		success: function(data){
			if(!data){
				alert("존재하지않는 data");
				return false;
			}
			console.log("data : " + data.rblr);
		}
	});		
}

function rental_deny(ren_num){ //도서대출 거절
	var result = confirm("거절하시겠습니까?");
	if(result){
		$(location).attr('href', "/admin/rental/del?ren_num="+ren_num);
	}else{
		
	}
}

function rental_return(ren_num){ //도서대출 반납
	var result = confirm("반납이 완료되었습니까?");
	if(result){
		$(location).attr('href', "/admin/rental/return?ren_num="+ren_num+"&state=2");
	}else{
		
	}
}

function rental_del(ren_num){ //도서대출 삭제
	var result = confirm("반납완료 도서를 삭제하시겠습니까?");
	if(result){
		$(location).attr('href', "/admin/rental/del?ren_num="+ren_num);
	}else{
		
	}
}

/*<c:forEach items="${listResult.rblr.items}" var="list">
                        <div class="d-md-flex align-items-center mb-5">
                            <span class="d-block mb-3 mb-md-0">
                                <img class="img-fluid" src="${list.book.book_img}" alt="Image-Description" width=150px; height=150px;>
                            </span>
                            <div class="ml-md-8">
                                <div class="mb-2">
                                	<c:choose>
						   			    <c:when test="${list.ren_stat==0}">
						   			    	<span class="font-size-2" >상태 : <span style="color:red;">예약중</span></span>						                	
						                </c:when>
						                <c:when test="${list.ren_stat==1}">
						   			    	<span class="font-size-2">상태 : <span style="color:orange;">대출중</span></span>						                	
						                </c:when>
						                <c:otherwise>
						                    <span class="font-size-2">상태 : <span style="color:green;">반납완료</span></span>
						                </c:otherwise>
									</c:choose>	
                                    
                                </div>
                                <h6 class="font-size-7 crop-text-2 font-weight-medium text-lh-1dot4" style="width:400px;">
                                    <span>${list.book.book_title}</span>
                                </h6>
                                <p class="font-size-2 text-secondary-gray-700">예약날짜 : ${list.ren_borrow}</p>
                                <p class="font-size-2 text-secondary-gray-700">반납날짜 : ${list.ren_return}</p>
                                <div class="font-size-2 text-secondary-gray-700">
                                    <span>예약한 회원 : ${list.member.mem_name }</span>
                                    <span class="ml-3">회원연락처 : ${list.member.mem_phone}</span>
                                    <span class="ml-3">예약번호 : ${list.ren_num}</span>                                                                          
                                </div>                                
                            </div>
                            <c:choose>
				   			    <c:when test="${list.ren_stat==0}">
				   			    	<a class="btn btn-primary btn-sm-wide transition-3d-hover" href="javascript:rental_ok(${list.ren_num});">수락</a>
                           			 &nbsp;                            
                           			<a class="btn btn-primary-red btn-sm-wide transition-3d-hover" href="javascript:rental_deny(${list.ren_num})">거절</a>						                	
				                </c:when>
				                <c:when test="${list.ren_stat==1}">
				   			    	<a class="btn btn-yellow-darker btn-sm-wide transition-3d-hover" href="javascript:rental_return(${list.ren_num})">반납완료</a>						                	
				                </c:when>
				                <c:otherwise>
				                    <a class="btn btn-primary-red btn-sm-wide transition-3d-hover" href="javascript:rental_del(${list.ren_num})">반납도서삭제</a>
				                </c:otherwise>
							</c:choose>
                            
                        </div>  
                        <hr>
                     </c:forEach>*/