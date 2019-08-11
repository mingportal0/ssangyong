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
<%@page import="com.zim.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberVO vo = (MemberVO)session.getAttribute("user");
	out.print(vo);
	request.setAttribute("vo", vo);
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
</head>
<body>
	<h3>회원 정보 수정</h3>
	<hr/>
	<form id="form_edit" name="form_resister">
		<input type="hidden"  name="work_div" id="work_div"/>
		<input type="hidden"  name="lvl" value="${vo.getLvl()}"/>
		<div class="container">
			<div class="form-group">
				<label>*아이디</label>
				<input type="text" id="user_id" name="user_id" class="form-control" value="${vo.getUserId()}" placeholder="영문 및 숫자만 입력해주세요." maxlength="20" >
			</div>
			<div class="form-group">
				<label>*비밀번호 변경</label>
				<input type="password" id="passwd" name="passwd" class="form-control" value="${vo.getPasswd()}" placeholder="영문 및 숫자만 입력해주세요." maxlength="20" >
			</div>
			<div class="form-group">
				<label>*비밀번호 확인</label>
				<input type="password" id="repasswd" name="repasswd" class="form-control" value="${vo.getPasswd()}" maxlength="20" >
			</div>
			<div class="form-group">
				<label>*이름</label>
				<input type="text" id="name" name="name" class="form-control" value="${vo.getName()}" maxlength="30" >
			</div>
			<div class="form-group">
				<label>*이메일</label>
				<input type="text" id="email" name="email" class="form-control" value="${vo.getEmail()}" maxlength="320" >
			</div>
			<div class="form-group">
				<label>주민등록번호</label><br/>공구게시판 글 작성을 위해 필요합니다.
				<input type="text" id="resident_no" name="resident_no" class="form-control" value="${vo.getResidentNo()}" placeholder="000000-0000000" maxlength="13" >
			</div>
			<div class="form-group">
				<label>핸드폰 번호</label><br/>공구게시판 글 작성을 위해 필요합니다.
				<input type="tel" id="cell_phone" name="cell_phone" class="form-control" value="${vo.getCellPhone()}" placeholder="000-0000-0000" maxlength="13" >
			</div>
		</div>
		<br/>
		<input type="submit" class="btn btn-warning" value="회원 정보 수정" >
		<button class="btn btn-warning">취소</button>
	</form>
	
	<script>	
		function do_update(){
			alert("do_update");
			
			$("#work_div").val("do_update");//do_update Set
			var param = $("#form_edit").serialize();
			//ajax
            $.ajax({
               type:"POST",
               url:"<c:url value='/edit/edit.do' />",
               dataType:"html",
               data:param, 
            success: function(data){
              var jData = JSON.parse(data);
              if(null != jData && jData.msgId=="1"){
                alert(jData.msgContents);
                window.location.href="<c:url value='/mainpage/mainpage_view.jsp' />";
              }else{
                alert(jData.msgId+"|"+jData.msgContents);
              }
            },
            complete:function(data){
             
            },
            error:function(xhr,status,error){
                alert("error:"+error);
            }
           }); 
           //--ajax
           
		}
		$(document).ready(function(){
			$('#form_edit').validate({
				//validation 종료 후 submit 직전에 할 작업 ex)메세지 표시
				submitHandler:function(){
					var f = confirm('회원 정보를 수정하시겠습니까?');
					if(f){
						return do_update();
					}else{
						return false;
					}
				},
				//규칙
				rules:{
					user_id:{
						required:true
					},
					passwd:{
						required:true
					},
					repasswd:{
						required:true,
						equalTo:passwd
					},
					name:{
						required:true						
					},
					email:{
						required:true,						
						email:true
					},
					resident_no:{
						minlength: 13
					},
					cell_phone:{
						minlength: 13
					}
				},
				//출력 메세지
				messages:{
					user_id:{
						required:"필수 입력값입니다."
					},
					passwd:{
						required:"필수 입력값입니다."
					},
					repasswd:{
						required:"필수 입력값입니다.",
						equalTo:"비밀번호가 일치하지 않습니다."
					},
					name:{
						required:"필수 입력값입니다."
						
					},
					email:{
						required:"필수 입력값입니다.",
						email:"유효하지 않은 이메일주소입니다."
					},
					resident_no:{
						minlength: "유효하지 않은 주민등록번호입니다."
					},
					cell_phone:{
						minlength:"유효하지 않은 핸드폰번호입니다."
					}
				}
			});
		});
	</script>
</body>
</html>