function modalPopup(info) {
	$.ajax({
		url: "/modal/read.json", 
		type: "GET", 
		data: {isbn: info}, 
		success: function(data){
			if(!data){
				alert("존재하지않는 data");
				return false;
			}		
		var title = data.book.title;
		var writer = data.book.writer;
		var publisher = data.book.publisher;
		var isbn = data.book.isbn;
		var img = data.book.img;
		var classList = data.classList;
		var facList = data.facList;
		var modalPop = "";
		modalPop += '<form name="add" method="post" class="checkout woocommerce-checkout row mt-8" action="/request/book/add.do" novalidate="novalidate" style="text-align:center;">'; 
		modalPop += '<div class="col2-set col-md-6 col-lg-7 col-xl-8 mb-6 mb-md-0" id="customer_details" style="margin-right:auto; margin-left:auto;">'; 
		modalPop += '<div class="px-4 pt-5 bg-white border"> <div class="woocommerce-billing-fields"> <h3 class="mb-4 font-size-3"></h3>'; 
		modalPop += '<div class="woocommerce-billing-fields__field-wrapper row">'; 
		modalPop += '<p class="col-lg-6 mb-4d75 form-row form-row-first validate-required woocommerce-invalid woocommerce-invalid-required-field" id="billing_first_name_field" data-priority="10">'; 
		modalPop += '<label for="billing_first_name" class="form-label">도서 제목<abbr class="required" title="required"></abbr></label>'; 
		modalPop += '<input type="text" class="input-text form-control" name="book_title" id="book_title" placeholder="도서 제목을 입력해주세요" value="'+title+'" autocomplete="given-name" autofocus="autofocus" readonly> </p>';
	    modalPop += '';
		modalPop += '<p class="col-lg-6 mb-4d75 form-row form-row-last validate-required" id="billing_last_name_field" data-priority="20">';
		modalPop += '<label for="billing_last_name" class="form-label">저자<abbr class="required" title="required"></abbr></label>';
		modalPop += '<input type="text" class="input-text form-control" name="book_writer" id="book_writer" placeholder="저자를 입력해주세요" value="'+writer+'" autocomplete="family-name" readonly>';
		modalPop += '</p>';
	    modalPop += '';
		modalPop += '<p class="col-12 mb-4d75 form-row form-row-wide" id="billing_company_field" data-priority="30">';
		modalPop += '<label for="billing_company" class="form-label">출판사</label>';
		modalPop += '<input type="text" class="input-text form-control" name="book_publisher" id="book_publisher" placeholder="출판사를 입력해주세요" value="'+publisher+'" autocomplete="organization" readonly>';
		modalPop += '</p>';
		modalPop += '';                
		modalPop += '<p class="col-12 mb-4d75 form-row form-row-wide address-field update_totals_on_change validate-required woocommerce-validated" id="billing_country_field" data-priority="40">';
		modalPop += '<label for="billing_country" class="form-label">도서 장르<abbr class="required" title="required"></abbr></label>';
		modalPop += '<select name="book_code" id="book_class" class="form-control country_to_state country_select  select2-hidden-accessible" autocomplete="country" tabindex="-1" aria-hidden="true">';
		modalPop += '<option value="">도서 장르 선택</option>';
		for(var i=1; i<=classList.length; i++){			
			modalPop += '<option value="'+i+'">'+classList[i-1]+'</option>';
		}                                                          
		modalPop += '</select>';
		modalPop += '</p>';
		modalPop += '<p class="col-12 mb-4d75 form-row form-row-wide address-field update_totals_on_change validate-required woocommerce-validated" id="billing_country_field" data-priority="40">';
		modalPop += '<label for="billing_country" class="form-label">도서 위치<abbr class="required" title="required"></abbr></label>';
		modalPop += '<select name="f_num" id="book_loc" class="form-control country_to_state country_select  select2-hidden-accessible" autocomplete="country" tabindex="-1" aria-hidden="true">';
		modalPop += '<option value="">도서 위치 선택</option>';
		for(var i=1; i<=facList.length; i++){
			modalPop += '<option value="'+i+'">'+facList[i-1]+'</option>';
		}		                          
		modalPop += '</select>';
		modalPop += '</p>';
		modalPop += '                ';
		modalPop += '<p class="col-12 mb-4d75 form-row form-row-wide address-field update_totals_on_change validate-required woocommerce-validated" id="billing_country_field" data-priority="40">';
		modalPop += '<label for="billing_country" class="form-label">도서 추천<abbr class="required" title="required"></abbr></label>';
		modalPop += '<select name="book_recomend" id="book_recomend" class="form-control country_to_state country_select  select2-hidden-accessible" autocomplete="country" tabindex="-1" aria-hidden="true">';
		modalPop += '<option value="">도서 추천 선택</option>';                                                            
		modalPop += '<option value="1">추천</option>';
		modalPop += '<option value="0">비추천</option>';                                                                                                                
		modalPop += '</select>';
		modalPop += '</p>';
	    modalPop += '';
		modalPop += '<p class="col-12 mb-3 form-row form-row-wide address-field validate-required" id="billing_address_1_field" data-priority="50">';
		modalPop += '<label for="billing_address_1" class="form-label">ISBN<abbr class="required" title="required"></abbr></label>';
		modalPop += '<input type="text" class="input-text form-control" name="book_isbn" id="book_isbn" placeholder="도서 ISBN번호를 입력해주세요" value="'+isbn+'" autocomplete="address-line1" readonly>';
		modalPop += '</p>';
	    modalPop += '';
		modalPop += '<p class="col-12 mb-4d75 form-row form-row-wide address-field validate-required" id="billing_city_field" data-priority="70" data-o_class="form-row form-row-wide address-field validate-required">';
		modalPop += '<label for="billing_city" class="form-label">도서 수량<abbr class="required" title="required"></abbr></label>';
		modalPop += '<input type="number" class="input-text form-control" name="book_count" id="book_count" placeholder="" value="" autocomplete="address-level2" min="0" maxlength="2" oninput="maxLengthCheck(this)">';
		modalPop += '</p>';   
		modalPop += '';                
		modalPop += '<p class="col-12 mb-4d75 form-row form-row-wide address-field validate-required" id="billing_city_field" data-priority="70" data-o_class="form-row form-row-wide address-field validate-required">';
		modalPop += '<label for="billing_city" class="form-label">도서 이미지 링크<abbr class="required" title="required"></abbr></label>';
		modalPop += '<input type="text" class="input-text form-control" name="book_img" id="book_img" placeholder="" value="'+img+'" autocomplete="address-level2" readonly>';
		modalPop += '</p>    ';                                              
		modalPop += '</div>';
		modalPop += '</div>';
		modalPop += '</div>';
		modalPop += '    ';
		modalPop += '<div class="form-row place-order">';
		modalPop += '<input type="button" class="button alt btn btn-blue btn-block rounded-0 py-4" name="woocommerce_checkout_place_order" id="add_btn" value="도서추가" data-value="add" onclick="addbook()">';                                                                                      
		modalPop += '</div>';
		modalPop += '</div>   ';                                
		modalPop += '</form>';
		
		//script 부분
		modalPop += '<script>';
		modalPop += 'var number = document.getElementById("book_count");';
		modalPop += 'number.onkeydown = function(e) {';
		modalPop += 'if(!((e.keyCode > 95 && e.keyCode < 106)';
		modalPop += '|| (e.keyCode > 47 && e.keyCode < 58)';
		modalPop += '|| e.keyCode == 8)) {';
		modalPop += 'return false;';
		modalPop += '} }';
		modalPop += '</script>';
		$('#modal_body').empty();
	    $('#modal_body').append(modalPop);	 
	    setTimeout(function() {
	    	$("#modal_body").scrollTop(0);	    	  
	    	}, 150);
		}
	}); 
}
	    
function maxLengthCheck(object){
    if (object.value.length > object.maxLength){
      object.value = object.value.slice(0, object.maxLength);
    }    
  }	

function addbook()
 {
     for(var i=0; i<document.add.elements.length; i++)
	   {				             	    	   
	      if(document.add.elements[i].value == "")
		  {
		     alert("모든 값을 입력 하셔야 합니다. ");
			 return false;
		  }
	   }
	   document.add.submit();
 }