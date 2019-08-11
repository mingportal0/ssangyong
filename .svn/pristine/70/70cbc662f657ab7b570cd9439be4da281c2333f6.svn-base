<%@page import="com.zim.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberVO user = (MemberVO)session.getAttribute("user");
	request.setAttribute("user", user);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->    
<link rel="stylesheet" href="/ZIMZALABIM/js/jquery-ui.css" >
<link rel="shortcut icon" href="/ZIMZALABIM/image/favicon.ico">
<!-- 부트스트랩 -->
<link href="/ZIMZALABIM/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/ZIMZALABIM/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<title>ZIMZALABIM</title>
<script src="/ZIMZALABIM/js/jquery-1.12.4.js"></script>
<script src="/ZIMZALABIM/js/jquery-ui.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="/ZIMZALABIM/js/bootstrap.min.js"></script>	
<!-- jquery valdation -->
<script src="/ZIMZALABIM/js/jquery.validate.js"></script>
<script src="/ZIMZALABIM/js/messages_ko.js"></script>
<script src="/ZIMZALABIM/js/additional-methods.js"></script>
<!-- //jquery valdation -->
<link rel="stylesheet" href="/ZIMZALABIM/css/login.css">
</head>
<body>
	<h2>회원탈퇴</h2>
	<p>비밀번호를 한번 더 입력해주세요.</p>
	<form id="quit_frm" name="quit_frm" method="post" >
		<input type="hidden"  name="work_div" id="work_div"  />
		<table>
			<tr>
				<td><label>비밀번호</label><br/><input type="password" id="passWd" name="passWd"></td>
			</tr>
		</table>
		<br/>
	</form>
		<button class="btn btn-warning" id="quit_btn" name="quit_btn" >탈퇴</button>
		<button class="btn btn-warning" id="cancel_btn">취소</button>			
	
	<script>
		$("#quit_btn").on("click",function(){
			console.log($("#passWd").val());
			var passWd = $("#passWd").val();
			if(null == passWd || passWd.trim().length == 0){
				$("#passWd").focus();
				alert('비밀번호를 입력하세요.');
				return;
			}
			if( false == confirm('정말 탈퇴하시겠습니까?'))return;
			
			//ajax
			$.ajax({
					type:"POST",
					url:"/ZIMZALABIM/quit/quit.json",
					dataType:"html",
					data:{
						"work_div":"do_delete",
						"passWd":$("#passWd").val()
				},
				success: function(data){
					//gsonString : {"msgId":"1","msgContents":"삭제되었습니다.","total":0,"num":0}
					console.log("1.data "+data);
					var jData = JSON.parse(data);
					console.log(jData.msgId+" | "+jData.msgContents);
					if(null != jData && jData.msgId=="1"){
						alert(jData.msgContents);
						window.location.href="/ZIMZALABIM/mainpage/mainpage_view.jsp";
					}else{
						alert(jData.msgContents);
					}
					//alert("성공 : "+data);
				},
				comlete: function(data){
					
				},
				error: function(xhr,status,error){
					alert("실패 : "+error);
				}
			});
		});
		
		$("#cancel_btn").on("click",function(){
			//alert('cancel_btn');
		});
	
		$(document).ready(function(){
			
		});
	</script>
</body>
</html>