<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import = "java.util.*"%>
<%@ page import = "PYS.bean.*"%> 
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
	<meta charset="UTF-8">
	<title>REPORT</title>
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script> 
	<link rel="stylesheet" href="css/style-chart.css">
	<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
	<div class="home_content">
		<div class="text">
			<h1>Sales Report</h1>
		</div>
		<!-- Add Chart -->
		<div class="graphBox">
			<div class="box">
				<h3>Total Sales Per Month</h3>
				<canvas id="spmChart"></canvas>
				
					 <script> 
        				var chartData = { 
            				labels: [ 
                				<c:forEach items="${spmChart}" var="chart" varStatus="loop"> //bean name
                   				 '<c:out value="${chart.spmLabel}" />'${not loop.last ? ',' : ''} //variable in bean
               					</c:forEach> 
            				], 
            				datasets: [{ 
                				label: 'Sales RM', 
                				data: [ 
                    				<c:forEach items="${spmChart}" var="chart" varStatus="loop"> //bean name
                    				'<c:out value="${chart.sales}" />'${not loop.last ? ',' : ''} //variable in bean
                    				</c:forEach> 
                				], 
                				backgroundColor: ['rgba(0, 123, 255, 0.5)',
                        			'rgba(255, 0, 0, 0.5)',
                        			'rgba(0, 255, 0, 0.5)',
                        			'rgba(255, 255, 0, 0.5)',
                        			'rgba(128, 0, 128, 0.5)',
                        			'rgba(255, 105, 180, 0.5)',
                        			'rgba(210, 105, 30, 0.5)',
                        			'rgba(128, 128, 128, 0.5)',] // Chart color
                
            				}] 
        				}; 
 
        				var ctx = document.getElementById('spmChart').getContext('2d'); //bean name
        				var myChart = new Chart(ctx, { 
            				type: 'pie', 
            				data: { 
                				labels: chartData.labels,datasets: chartData.datasets 
            				} 
        				}); 
    				</script> 
			</div>
			
			<div class="box">
				<h3>Total Customer Per Package</h3>
				<canvas id="custPerPackageChart"></canvas>
				
				<script> 
        				var chartData = { 
            				labels: [ 
                				<c:forEach items="${custPerPackageChart}" var="chart" varStatus="loop"> //bean name
                   				 '<c:out value="${chart.packagename}" />'${not loop.last ? ',' : ''} 	//variable in bean
               					</c:forEach> 
            				], 
            				datasets: [{ 
                				label: 'Total Customer', 
                				data: [ 
                    				<c:forEach items="${custPerPackageChart}" var="chart" varStatus="loop"> //bean name
                    				'<c:out value="${chart.totalCustPerPackage}" />'${not loop.last ? ',' : ''} //variable in bean
                    				</c:forEach> 
                				], 
                				backgroundColor: ['rgba(0, 123, 255, 0.5)',
                        			'rgba(255, 0, 0, 0.5)',
                        			'rgba(0, 255, 0, 0.5)',
                        			'rgba(255, 255, 0, 0.5)',
                        			'rgba(128, 0, 128, 0.5)',
                        			'rgba(255, 105, 180, 0.5)',
                        			'rgba(210, 105, 30, 0.5)',
                        			'rgba(128, 128, 128, 0.5)',] // Chart color
                
            				}] 
        				}; 
 
        				var ctx = document.getElementById('custPerPackageChart').getContext('2d'); //bean name
        				var myChart = new Chart(ctx, { 
            				type: 'pie', //type of chart
            				data: { 
                				labels: chartData.labels,datasets: chartData.datasets 
            				} 
        				}); 
    				</script> 
				
			</div>
			
			<div class="box">
				<h3>Total Customer Per Month</h3>
				<canvas id="cpmChart"></canvas>
				
				<script> 
        		var chartData = { 
            		labels: [ 
                		<c:forEach items="${cpmChart}" var="chart" varStatus="loop"> 
                    		'<c:out value="${chart.cpmLabel}" />'${not loop.last ? ',' : ''} 
                		</c:forEach> 
            		], 
            		datasets: [{ 
               		label: 'Total Customer', 
                		data: [ 
                    		<c:forEach items="${cpmChart}" var="chart" varStatus="loop"> 
                    		'<c:out value="${chart.totalCust}" />'${not loop.last ? ',' : ''} 
                    		</c:forEach> 
                		], 
                		backgroundColor: [ 
                			'rgba(0, 123, 255, 0.5)',
                			'rgba(255, 0, 0, 0.5)',
                			'rgba(0, 255, 0, 0.5)',
                			'rgba(255, 255, 0, 0.5)',
                			'rgba(128, 0, 128, 0.5)',
                			'rgba(255, 105, 180, 0.5)',
                			'rgba(210, 105, 30, 0.5)',
                			'rgba(128, 128, 128, 0.5)',
                    
                    		// Add more colors for each label if needed 
                		] 
            		}] 
        		}; 
 
        		var ctx = document.getElementById('cpmChart').getContext('2d'); 
        		var myChart = new Chart(ctx, { 
         		type: 'pie', 
            		data: { 
                		labels: chartData.labels, 
                		datasets: chartData.datasets 
            		}, 
            		options: { 
                		plugins: { 
                    		legend: { 
                        		position: 'bottom', 
                    		}, 
                		}, 
            		} 
        		}); 
    		</script> 
				
			</div>
			
			
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/chart.js@4.3.0/dist/chart.umd.min.js"></script>
	<script src="js/my_chart.js"></script>
</body>
	
</html>