<%--
  /**
  * @Class Name : useOutObject.jsp
  * @Description : Sample Register 화면
  * @Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2019.07.01            최초 생성
  *
  * author 실행환경 개발팀
  * since 2019.07.01
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->    
<link rel="stylesheet" href="/ZIMZALABIM/js/jquery-ui.css" >
<!-- 부트스트랩 -->
<link href="/ZIMZALABIM/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
<script src="/ZIMZALABIM/js/jquery-1.12.4.js"></script>
<script src="/ZIMZALABIM/js/jquery-ui.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="/ZIMZALABIM/js/bootstrap.min.js"></script>	
</head>
<body>
	<h2>비밀번호 찾기</h2>
	<p>비밀번호를 찾기 위해 필요한 정보를 입력해 주세요~</p>
	<form>
		<table>
			<tr>
				<td><label>아이디</label><br/><input type="text" id="user_Id" name="user_Id"></td>
			</tr>	
			<tr><td><br/></td></tr>
			<tr>
				<td><label>이메일</label><br/><input type="text" id="email" name="email"></td>
			</tr>
			<tr><td><br/></td></tr>
			<tr>
				<td><label>주민등록번호</label><br/><input type="text" id="resident_No" name="resident_No"></td>
			</tr>			
		</table>
		<br/>
	</form>
		<button class="btn btn-warning" onclick="javascript:do_SearchPw();">확인</button>
		<button id="cancel" id="cancel" class="btn btn-warning">취소</button>			
	
	<script>
		function do_SearchPw(){
			//alert("do_SearchPw");
			var user_Id = $("#user_Id").val();
			if(null == user_Id || user_Id.trim().length == 0){
				$("#user_Id").focus();
				alert('아이디를 입력하세요.');
				return;
			}
			var email = $("#email").val();
			if(null == email || email.trim().length == 0){
				$("#email").focus();
				alert('이메일을 입력하세요.');
				return;
			}
			var resident_No = $("#resident_No").val();
			if(null == resident_No || resident_No.trim().length == 0){
				$("#resident_No").focus();
				alert('주민등록번호를 입력하세요.');
				return;
			}
			//ajax
			$.ajax({
					type:"POST",
					url:"/ZIMZALABIM/searchpw/searchpw.json",
					dataType:"html",
					data:{
						"work_div":"do_SearchPw",
						"user_Id":$("#user_Id").val(),
						"email":$("#email").val(),
						"resident_No":$("#resident_No").val()
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
			
			
			
			
			
		}
		$(document).ready(function(){
			
		});
	</script>
</body>
</html>