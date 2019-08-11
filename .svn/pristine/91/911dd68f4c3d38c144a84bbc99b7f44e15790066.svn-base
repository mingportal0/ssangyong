<%@page import="com.zim.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div class="container">
        <div class="card card-container">
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <div class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="hidden" name="login_div"/>
                <input type="text" id="user_id" name="user_id" class="form-control" placeholder="User ID" required autofocus>
                <input type="password" id="passwd" name="passwd" class="form-control" placeholder="Password" required>
            </div>
            <button id="login_bt"class="btn btn-lg btn-primary btn-block btn-signin" onclick="javascript:doLogin();">로그인</button>
            <a href="javascript:goResister();" class="forgot-password">회원가입</a><br/>
            <a href="javascript:goSearchID();" class="forgot-password">아이디</a> / 
            <a href="javascript:goSearchPW();" class="forgot-password">비번 찾기</a>
        </div><!-- /card-container -->
    </div><!-- /container -->	
	<script>
		function goSearchID(){
			//alert("goMain");
			window.top.close();
			window.opener.location.href="/ZIMZALABIM/member/searchid/search_id_view.jsp";
		}
		function goSearchPW(){
			//alert("goMain");
			window.top.close();
			window.opener.location.href="/ZIMZALABIM/member/searchpw/search_pw_view.jsp";
		}
		function goResister(){
			//alert("goMain");
			window.top.close();
			window.opener.location.href="/ZIMZALABIM/member/resister/resister_view.jsp";
		}
		function goMain(){
			//alert("goMain");
			window.top.close();
			opener.location.href="/ZIMZALABIM/mainpage/mainpage_view.jsp";
		}
		function login_check(){
			//ajax
			$.ajax({
					type:"POST",
					url:"<c:url value='/member/member.json' />",
					dataType:"html",
					data:{
						"login_div":"do_login",
						"user_id":$("#user_id").val(),
						"passwd":$("#passwd").val()
				},
				success: function(data){
					//gsonString : {"msgId":"1","msgContents":"삭제되었습니다.","total":0,"num":0}
					console.log("1.data "+data);
					var jData = JSON.parse(data);
					console.log(jData.msgId+" | "+jData.msgContents);
					if(null != jData && jData.msgId=="1"){
						//alert(jData.msgContents);
						goMain();
					}else if("10"==jData.msgId){
						alert(jData.msgContents);
						$("#user_id").focus();
					}else if("20"==jData.msgId){
						alert(jData.msgContents);
						$("#passwd").focus();
					}else{
						alert(msgContents);
					}
				},
				comlete: function(data){
					
				},
				error: function(xhr,status,error){
					alert("실패 : "+error);
				}
			});			
		}		
		//엔터키로 버튼 동작
		//댓글등록
		$("#passwd").keydown(function(key) {
		    //키의 코드가 13번일 경우 (13번은 엔터키)
			if (key.keyCode == 13) {
			    //ID가 alpreah_btn을 찾아 클릭해준다.
			    //버튼 말고도 p태그나 다른 태그도 다 응용 가능 합니다.
			    //대신 이벤트 발생을 위해서는 29번쨰 줄 코드처럼 이벤트를 걸어줘야 합니다.
			    $("#login_bt").click();
			}
		});
		
		
		function doLogin(){
			var user_id = $("#user_id").val();
			if(null == user_id || user_id.trim().length ==0){
				$("#user_id").focus();
				alert('ID를 입력하세요.');
				return;
			}
			var passwd = $("#passwd").val();
			if(null == passwd || passwd.trim().length ==0){
				$("#passwd").focus();
				alert('비번을 입력하세요.');
				return;
			}
			login_check();
		};
	
		$(document).ready(function(){
			
		});
	</script>
</body>
</html>