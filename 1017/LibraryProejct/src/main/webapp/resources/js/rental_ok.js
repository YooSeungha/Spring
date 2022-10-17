function rental_ok(ren_num){ //도서대출 수락
	var result = confirm("대출을 수락하시겠습니까?");
	if(result){
		$.ajax({
			url: "/admin/rental/ok",
			type: "GET",
			data: {ren_num: ren_num,
				state: 1},
			success: function(data){            						
			}            				
		});
		redraw();
	}	
	}