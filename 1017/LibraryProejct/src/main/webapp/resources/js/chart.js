$(document).on('ready', function () {
	$.ajax({
		url: '/AreaChart.json',
		dataType: "json",
		type: 'post',
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
	                .getElementById('lineChart')
	                .getContext('2d');
				 
				 var myChart = new Chart(context, {
		                type: 'line', // 차트의 형태
		                data: { // 차트에 들어갈 데이터
		                    labels: items,
		                    datasets: [
		                        { //데이터
		                            label: '대출수', //차트 제목
		                            fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
		                            data: number, //x축 label에 대응되는 데이터 값,
		                            backgroundColor: 'rgb(255, 99, 132)',
		                            borderColor: 'rgb(255, 99, 132)',
		                            borderWidth: 1 //경계선 굵기
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
	
	$.ajax({
		url: '/pieChart.json',
		dataType: "json",
		type: 'post',
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
	                .getElementById('PieChart')
	                .getContext('2d');
				 
				 var myChart = new Chart(context, {
		                type: 'pie', // 차트의 형태
		                data: { // 차트에 들어갈 데이터
		                    labels: items,
		                    datasets: [
		                        { //데이터		                            		                           
		                            data: number, //x축 label에 대응되는 데이터 값,
		                            backgroundColor: [
		                                'rgba(255, 99, 132, 1)',
		                                'rgba(54, 162, 235, 1)',
		                                'rgba(255, 206, 86, 1)',
		                                'rgba(75, 192, 192, 1)',
		                                'rgba(153, 102, 255, 1)',
		                                'rgba(255, 159, 64, 1)',
		                                'rgba(50, 168, 82, 1)',
		                                'rgba(59, 248, 255, 1)',
		                                'rgba(59, 255, 183, 1)',
		                                'rgba(59, 95, 255, 1)',
		                            ],
		                            borderWidth: 1 //경계선 굵기
		                        }
		                    ]
		                },
		                options: {
		                	responsive: true,
		                	maintainAspectRatio :false,
		                    plugins: {
		                      legend: {
		                        position: 'right',
		                      },
		                      title: {
		                        display: true,
		                        text: '장르별 도서보유량'
		                      }
		                    }
		                }
		            });						
			}
		});
	
	
	$.ajax({
		url: '/barChart.json',
		dataType: "json",
		type: 'post',
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
			arrayOfObj = items.map(function(d, i){
				return{
					label: d,
					data: number[i] || 0
				};				
			});
			sortedArrayOfObj = arrayOfObj.sort(function(a, b){				
				return b.data - a.data;
			});		
			sortedItems = [];
			sortedNumber = [];
			sortedArrayOfObj.forEach(function(d){
				sortedItems.push(d.label);
				sortedNumber.push(d.data);
			});			
				 var context = document
	                .getElementById('BarChart')
	                .getContext('2d');
				 
				 var myChart = new Chart(context, {
		                type: 'bar', // 차트의 형태
		                data: { // 차트에 들어갈 데이터
		                    labels: sortedItems,
		                    datasets: [
		                        { //데이터		         
		                            label: '대출도서',
		                            data: sortedNumber, //x축 label에 대응되는 데이터 값,
		                            backgroundColor: [
		                                'rgba(255, 99, 132, 1)',
		                                'rgba(54, 162, 235, 1)',
		                                'rgba(255, 206, 86, 1)',
		                                'rgba(75, 192, 192, 1)',
		                                'rgba(153, 102, 255, 1)',
		                                'rgba(255, 159, 64, 1)',
		                                'rgba(50, 168, 82, 1)',
		                                'rgba(59, 248, 255, 1)',
		                                'rgba(59, 255, 183, 1)',
		                                'rgba(59, 95, 255, 1)',
		                            ],
		                            borderWidth: 1 //경계선 굵기
		                        }
		                    ]
		                },
		                options: {		                	
		                	maintainAspectRatio :false,
		                	indexAxis: 'y',
		                	elements: {
		                		bar: {
		                			borderWidth: 2,
		                		}
		                	},
		                	responsive: true,
		                    plugins: {
		                      legend: {
		                    	display:false,
		                        position: 'right',
		                      },
		                      title: {
		                        display: true,
		                        text: '지난 한달간 장르별 대출수'
		                      }
		                    }
		                }
		            });						
			}
		});
		
	
	$.ajax({
		url: '/verticalBarChart.json',
		dataType: "json",
		type: 'post',
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
			arrayOfObj = items.map(function(d, i){
				return{
					label: d,
					data: number[i] || 0
				};				
			});
			sortedArrayOfObj = arrayOfObj.sort(function(a, b){				
				return b.data - a.data;
			});		
			sortedItems = [];
			sortedNumber = [];
			sortedArrayOfObj.forEach(function(d){
				sortedItems.push(d.label);
				sortedNumber.push(d.data);
			});			
				 var context = document
	                .getElementById('VerticalBarChart')
	                .getContext('2d');
				 
				 var myChart = new Chart(context, {
		                type: 'bar', // 차트의 형태
		                data: { // 차트에 들어갈 데이터
		                    labels: sortedItems,		                   
		                    datasets: [
		                        { //데이터		         
		                            label: '대출도서',
		                            data: sortedNumber, //x축 label에 대응되는 데이터 값,
		                            backgroundColor: [
		                                'rgba(255, 99, 132, 1)',
		                                'rgba(54, 162, 235, 1)',
		                                'rgba(255, 206, 86, 1)',
		                                'rgba(75, 192, 192, 1)',
		                                'rgba(153, 102, 255, 1)',
		                                'rgba(255, 159, 64, 1)',
		                                'rgba(50, 168, 82, 1)',
		                                'rgba(59, 248, 255, 1)',
		                                'rgba(59, 255, 183, 1)',
		                                'rgba(59, 95, 255, 1)',
		                            ],
		                            borderWidth: 1 //경계선 굵기
		                        }
		                    ]
		                },
		                options: {		                	
		                	maintainAspectRatio :false,		                		                
		                	elements: {
		                		bar: {
		                			borderWidth: 2,
		                		}
		                	},
		                	responsive: true,
		                    plugins: {
		                      legend: {		                    	
		                    	display: false,
		                        position: 'right',
		                      },
		                      title: {
		                        display: true,
		                        text: '지난 한달간 대출도서'
		                      }
		                    }
		                }
		            });						
			}
		});
	
	
	});
