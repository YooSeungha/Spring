function rental_return(ren_num){ //도서대출 반납
	var result = confirm("반납이 완료되었습니까?");
	if(result){		
		$.ajax({
			url: "/admin/rental/return",
			type: "GET",
			data: {ren_num: ren_num,
				state: 2},
			success: function(data){            						
			}            				
		});
		redraw();
	}
}