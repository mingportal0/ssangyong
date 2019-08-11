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

<%@page import="com.zim.wishlist.WishlistVO"%>
<%@page import="com.zim.code.CodeVO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    //절대 경로:System.out.println( application.getRealPath("board_mng.jsp"));
	//E:\Java_20190415\02_ORACLE\workspace_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0
	//E:\Java_20190415\02_ORACLE\workspace_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\WEB_EX01\org\apache\jsp\board\board_005fmng_jsp.java
	List<CodeVO> list = (List<CodeVO>)request.getAttribute("lvlList");
    WishlistVO   vo   = (WishlistVO)request.getAttribute("vo");


    //out.print(vo);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<link rel="stylesheet" href="/WEB_EX01/js/jquery-ui.css">
<!-- 부트스트랩 -->
<link href="/ZIMZALABIM/css/bootstrap.min.css" rel="stylesheet">
<title>위시리스트상품 자세히보기</title>
<script src="/ZIMZALABIM/js/jquery-1.12.4.js"></script>
<script src="/ZIMZALABIM/js/jquery-ui.js"></script>

<script src="/ZIMZALABIM/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- div container -->
	<div class="container">
		<!-- 제목 -->
		<div class="page-header">
			<center><h2>위시리스트 상품 자세히보기</h2></center>

		</div>
		<!--// 제목 -->

		<!--// button area -->
		<br />
		<!-- 회원관리 Form -->
	
		<form name="frmMng" id="frmMng"
			action="/ZIMZALABIM/wishlist/wishlist.do" method="post"
			class="form-horizontal">
			<input type="hidden" name="work_div" id="work_div" /> 
			<!-- input text-->
			<div class="form-group">
				<label class="col-sm-2 control-label">상품번호</label>
				<div class="col-sm-8">
					<input type="text" readonly="readonly" value="${vo.getProduct_no() }" name="Productno" id="Productno"
						size="30" maxlength="100" />
				</div>
			</div> 
			<!--// input text-->
			<!-- input text-->
			<div class="form-group">
				<label class="col-sm-2 control-label">상품명</label>
				<div class="col-sm-8">
					<input type="text" readonly="readonly" value="${vo.getProductNm() }" name="productNm"
						id="productNm" size="30" maxlength="20" />
				</div>
			</div>
			<!--// input text-->
			<!-- input text-->
			<div class="form-group">
				<label class="col-sm-2 control-label">등록일</label>
				<div class="col-sm-8">
					<input type="text" readonly="readonly" value="${vo.getReg_dt() }" name="regDt" id="regDt"
						size="30" />
				</div>
			</div>

			<!-- button area -->
			<div class="row">
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-8">

					<input type="button" class="btn btn-warning"  value="돌아가기"
						id="listTo_btn" /> <input type="button"
						class="btn btn-warning"  value="삭제" id="del_btn" />
				</div>
			</div>
			
		
		
		</form>
		
		<img src="/ZIMZALABIM/test/test.jpg" />
		<!--// 회원관리 Form -->
	</div>
	<!--// div container -->

	<script>
		//삭제 function
	    function doDel(){
	    	if( false == confirm('삭제 하시겠습니까?'))return;
	    	var frm = document.frmMng;
	    	frm.work_div.value = "do_delete";
	    	frm.action = "/ZIMZALABIM/wishlist/wishlist.do";
	    	frm.submit();
	    }
	
		//삭제
		$("#del_btn").on('click',function(){
			
			//validation
			var Productno = $("#Productno").val();
			
			
			if( false == confirm($("#Productno").val()+'을(를)\n삭제 하시겠습니까?'))return;
			
			//ajax
 			$.ajax({
 				type : "POST",
 				url : "/ZIMZALABIM/wishlist/wishlist.json",
 				dataType:"html",
 				data:{
 					"work_div" : "do_delete",
 					"product_no": Productno
 				},
 				success: function(data){
 					
 					var jData = JSON.parse(data);
					console.log(jData.msgId+"|"+jData.msgContents);
					if(null != jData && jData.msgId=="1"){
						alert(jData.msgContents);
						window.location.href="/ZIMZALABIM/wishlist/wishlist.do?work_div=do_retrieve";
					}else{
						alert(jData.msgproductNo);
					}
 				},
 				complete:function(data){
 					
 				},
 				error:function(xhr,status,error){
 					alert("error"+error);
 				}
 				
 			});
			//--ajax
		});
    
		
	
        
      
        
        
     
  
      
       
        // 화면이동
        function moveTolist(){
        	if(false==confirm('전 페이지로 이동 하시겠습니까?'))return;
        	
        	var frm = document.frmMng;
        	frm.work_div.value = "do_move_to_list";
        	frm.action = "/ZIMZALABIM/wishlist/wishlist.do"
        	frm.submit();
        	
        }
        
        
        //조회이동
        $("#listTo_btn").on('click',function(){
        	moveTolist();
        });
        
        //초기화
       
        
        
        
		$(document).ready(function(){

		});
		
		
		
		
		
		
		
		
		
		
		
	</script>
</body>
</html>