<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<script src="/ZIMZALABIM/js/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
          //json data call
          var jsonArray = $.ajax({
          					url:"<c:url value='/chart/chart.json' />",
          					dataType: "html",
          					data:{
          						login_div: "do_pro_chart"
          					},
          					async:false  //동기
          }).responseText;
          console.log("jsonArray"+jsonArray);
         
          var jsonArrayObject = JSON.parse(jsonArray);
          
          console.log("jsonArrayObject:"+jsonArrayObject);
          var data =new google.visualization.DataTable();
         
          data.addColumn('string','label');
          data.addColumn('number','data');
          for(var i=0;i<jsonArrayObject.length;i++){
          	console.log("jsonArrayObject[i]:"+jsonArrayObject[i]);
          	data.addRow(jsonArrayObject[i]);
          }

          var options = {
            title: '19년도 인기 상품 순위'
          };

          var chart = new google.visualization.PieChart(document.getElementById('piechart'));
          chart.draw(data, options);
        }
      
      /* 	function moveTolist(){
      		
      		if(false==confirm('전 페이지로 이동 하시겠습니까?'))return;
      		var frm = document.frmMng;
      		frm.work_div.value = "do_move_to_list"
      		frm.action = "/chart/chart.do"
      	    frm.submit();
      		
      	}
      	
      	 $("#preTo_btn").on('click',function(){
      		alert('dddd');
         	moveTolist();
         }); */
      	 
    </script>
</head>
<body>
	<div id="piechart" style="width: 1000px; height: 900px;"></div>
	
</body>

</html>
