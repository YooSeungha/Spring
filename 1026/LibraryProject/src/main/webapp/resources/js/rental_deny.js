function rental_deny(ren_num){ //도서대출 거절
	var result = confirm("거절하시겠습니까?");
	if(result){
		$.ajax({
			url: "/admin/rental/del",
			type: "GET",
			data: {ren_num: ren_num},
			success: function(data){            						
			}            				
		});
		redraw();
	}	
}