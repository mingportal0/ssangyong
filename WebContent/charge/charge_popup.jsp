<%@page import="com.zim.member.MemberVO"%>
<%@page import="com.zim.product.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//     String ctx = request.getContextPath();    //콘텍스트명 얻어오기.
    MemberVO user = (MemberVO)session.getAttribute("user");
    request.setAttribute("user", user);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	body {
		font-family: Arial, Verdana, sans-serif;
		color: #111111;    }   
    table { 
    	width: 1000px;   }
    th, td {
        padding: 7px 10px 10px 10px;   }
    th {
		text-transform: uppercase;
		letter-spacing: 0.1em;
		font-size: 90%;
		border-bottom: 2px solid #111111;
		border-top: 1px solid #999;
		text-align: left;	}
	tr.even {
		background-color: #efefef;}
	tr:hover {
		background-color: #c3e6e5;}
   .money {
		text-align: right;}
</style>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<link rel="stylesheet" href="/ZIMZALABIM/js/jquery-ui.css" >
<!-- 부트스트랩 -->
<link rel="stylesheet" href="/ZIMZALABIM/css/bootstrap.min.css">
<link rel="shortcut icon" href="/ZIMZALABIM/image/favicon.ico">
<title>Insert title here</title>
<script src="/ZIMZALABIM/js/jquery-1.12.4.js"></script>
<script src="/ZIMZALABIM/js/jquery-ui.js"></script>
<!-- jQuery를 사용하기위해 jQuery라이브러리 추가 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
</head>
<body>

<div class="container">
	<div class="row">
        <div class="col-sm-12">
        	<br>
            <legend>포인트 충전</legend>
        </div>
        <form class="form-horizontal" id="chargeFrm" name="chargeFrm" action="/ZIMZALABIM/product/writing.do" method="post" >		
	        <input type="hidden" name="user_id" id="user_id" value="${user.userId}"/>	
	        <!-- panel preview -->
	        <div class="col-sm-12" >
	            <div class="panel panel-default">
	                <div class="panel-body form-horizontal payment-form">
	                	<br>
	                    <div class="form-group">
	                        <label for="concept" class="col-sm-3 control-label">충전 금액</label>
	                        <div class="col-sm-5">
	                            <input type="text" class="form-control" id="charge_point" name="charge_point" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')">
	                        </div>
	                    </div>
	                    <br>
	                    <div class="form-group">
	                        <label for="status" class="col-sm-3 control-label">충전 방법</label>
	                        <div class="col-sm-5">
	                            <select class="form-control" id="charge_way" name="charge_way">
	                            	<option value="">--충전 방법을 선택하세요--</option>
	                                <option value="10">신용카드</option>
	                                <option value="20">무통장입금</option>
	                                <option value="30">휴대폰결제</option>
	                            </select>
	                        </div>
	                    </div>            
	                    <br>        
	                    <div class="form-group">
	                        <div class="col-sm-12 text-center">
	                            <input type="button" value="결제하기" id="charge_btn" name="charge_btn" class="btn btn-default"/>
	                        </div>
	                    </div>
	                </div>
	            </div>            
	        </div>
		</form>
	</div>
</div>

	<script>
	$("#charge_btn").click(function(){
		var frm = document.chargeFrm;
		
		var charge_point = $("#charge_point").val();
		if(null == charge_point || charge_point.trim().length ==0){
			$("#charge_point").focus();
			alert('충전할 금액을 입력해주세요.');
			return;
		}
		
		var charge_way = $("#charge_way").val();
		if(null == charge_way || charge_way.trim().length ==0){
			$("#charge_way").focus();
			alert('충전방법을 선택해주세요.');
			return;
		}
		
		if( false == confirm('충전하시겠습니까?')) return;			
		
		var charge_point = $("#charge_point").val();
		var user_id = $("#user_id").val();
		//param
		console.log("charge_point : "+charge_point);
		console.log("user_id : "+user_id);
		
		//ajax
		$.ajax({
				type: "POST",
				url:"/ZIMZALABIM/charge/charge.json",
				dataType:"html",
				data:{
					"work_div":"do_point_charge",
					"charge_point":charge_point,
					"user_id":user_id
			},
			success: function(data){
				console.log(data);
				var jData = JSON.parse(data); //스트링을 json데이터로 바꿔주는 것
				console.log(jData.msgId+"|"+jData.msgContents);
				if(null != jData && jData.msgId == "1"){
					alert(charge_point+"포인트가 충전되었습니다.");	
// 					window.location.href="/ZIMZALABIM/listall/listall.do?work_div=do_totalCategory_select";
				}else{
					alert(jData.msgId+"|"+jData.msgContents);
				}
			},
			complete: function(data){
				
			},
			error:function(xhr,status,error){
				alert("error"+error);
			}
			
		});//--ajax

	});

	</script>
 
</body>
</html>