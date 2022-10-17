$(document).on('ready', function () {
	var para = document.location.href.split("?");			
	var subPageStart = para[1].indexOf('=', para[1].indexOf('isbn'))+1;
	var subPageEnd = para[1].indexOf('&', para[1].indexOf('isbn'));	
	if(subPageEnd==-1){
		var isbnVal = para[1].substring(subPageStart);
	}else{
		var isbnVal = para[1].substring(subPageStart, subPageEnd);
	}								    
	$.ajax({
		url: '/infoChart.json',
		dataType: "json",
		type: 'post',
		data: {isbn: isbnVal}, 
		async: false,
		success: function(list) {
			var items = [];
			var number = [];
			if(list.length != 0) {
				$.each(list, function(i, item){		
					items.push(item.item);
					number.push(item.number);
				});
			}
				 var context = document
	                .getElementById('infoChart')
	                .getContext('2d');
				 
				 var myChart = new Chart(context, {
		                type: 'bar', // 차트의 형태
		                data: { // 차트에 들어갈 데이터
		                    labels: items,
		                    datasets: [
		                        { //데이터
		                            label: '대출수', //차트 제목
		                            fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
		                            data: number, //x축 label에 대응되는 데이터 값,
		                            backgroundColor: 'rgb(5, 189, 250)',
		                            borderColor: 'rgb(5, 189, 250)',
		                            borderWidth: 1, //경계선 굵기
		                            borderRadius: 5,
		                            borderSkipped: false,
		                        }
		                    ]
		                },
		                options: {
		                	responsive: true,
		                	plugins: {
		                	      title: {
		                	        display: true,
		                	        text: '지난주 일일 대출 도서'
		                	      }
		                	    },		                	
		                    scales: {		                    	
		                    	y: {		                            
		                            min: 0,
		                            ticks: {
		                                stepSize: 1
		                            }
		                        }                      
		                    }
		                }
		            });						
			}
		});
	});
