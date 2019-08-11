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
<%@page import="com.zim.product.ProductVO"%>
<%@page import="com.zim.product.comment.CommentVO"%>
<%@page import="com.zim.cmn.StringUtil"%>
<%@page import="org.apache.log4j.Logger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("UTF-8");
	Logger LOG = Logger.getLogger(this.getClass());
	String product_no = StringUtil.nvl(request.getParameter("product_no"), "");
	String hcomment_no = StringUtil.nvl(request.getParameter("hcomment_no"), "");
	String reg_id = StringUtil.nvl(request.getParameter("reg_id"), "");
	LOG.debug("product_no:"+product_no);
	LOG.debug("hcomment_no:"+hcomment_no);
	LOG.debug("reg_id:"+reg_id);
%>
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
<title>게시관리</title>
<script src="/ZIMZALABIM/js/jquery-1.12.4.js"></script>
<script src="/ZIMZALABIM/js/jquery-ui.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="/ZIMZALABIM/js/bootstrap.min.js"></script>	
</head>
<body>
	
		<div class="container">
			<div class="container">
			<h2>댓글수정</h2>
			<hr/>
			<form name="commentfrm" id="commentfrm" action="/ZIMZALABIM/mainpage/commentcontroller.do" method="post" class="form-horizontal" >
				 <input type="hidden"  name="co_work_div" id="co_work_div"/> 
				 <input type="hidden" name="product_no" id="product_no" value=<%= product_no %> />
				 <input type="hidden" name="hcomment_no" id="hcomment_no" value=<%= hcomment_no %> />
			 	 <input type="hidden" name="reg_id" id="reg_id" value=<%= reg_id %> />
				 <div class="container">
					<p><%= reg_id %></p>
					<input type="text" name="contents" id="contents" placeholder="댓글을 입력하세요." class="form-control" style="width:100%; height:100px;" />
				 </div>
			</form>
				<br/>
				<center>
					<div class="container">
						<input type="button" class="btn btn-default  btn-sm  btn-warning btn-hover" name="recomment_btn" id="recomment_btn" value="등록" onClick="javascript:recomment_btn();" />
						<input type="button" class="btn btn-default  btn-sm  btn-warning btn-hover" value="취소" onClick="javascript:closewin();"/>
					</div>
				</center>
		</div>


	<script>
  		
	
	
		//대댓등록 버튼
		$("#contents").keydown(function(key) {
	        //키의 코드가 13번일 경우 (13번은 엔터키)
	        if (key.keyCode == 13) {
	            //ID가 alpreah_btn을 찾아 클릭해준다.
	            //버튼 말고도 p태그나 다른 태그도 다 응용 가능 합니다.
	            //대신 이벤트 발생을 위해서는 29번쨰 줄 코드처럼 이벤트를 걸어줘야 합니다.
	            $("#recomment_btn").click();
	        }
	    });
	
		
		
		//대댓글 등록 버튼
		function recomment_btn(){
			
			var contents = $("#contents").val();
			if(null == contents || contents.trim().length == 0){
				$("#contents").focus();
				alert('내용을 입력하세요.');
				return ;
			}
			
			var product_no = $("#product_no").val();
			var hcomment_no = $("#hcomment_no").val();
			//alert(product_no);
			//alert(hcomment_no);
			
 			var frm = document.commentfrm;
 			frm.co_work_div.value = "do_insert"; //controller에 있는 메소드 이름이랑 같이 줘야함. 그걸 동작하게 하는 것.
 			frm.action = '/ZIMZALABIM/mainpage/commentcontroller.do';
 			frm.submit();
 			opener.document.location.href = "/ZIMZALABIM/detail/detail.do?work_div=do_detail_select&productNo="+product_no;
 			window.self.close();
		}
		
		
		//대댓글 취소 버튼
		function closewin(){
			window.self.close();
		}
		
		
		
	 	$(document).ready(function(){
	  	
		});
  
  
 </script>
</body>
</html>