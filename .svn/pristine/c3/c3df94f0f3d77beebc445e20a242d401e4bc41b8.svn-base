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
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="java.util.List"%>
<%@page import="com.zim.product.ProductVO"%>
<%@page import="com.zim.product.image.ImageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Logger LOG = Logger.getLogger(this.getClass());
	
	//이미지 저장 후 이미지 정보를 담아온다------------------------------------------------
	ImageVO imageVO = (ImageVO)request.getAttribute("imageInfo");//일반상품 표시
	String orgFileNm = "";
	String saveFileNm = "";
	String fileSize = "";
	String extNm = "";
	
	String insetUpdateFlag = "";
	
	if(imageVO != null){
		orgFileNm = imageVO.getOrgFileNm();
		saveFileNm = imageVO.getSaveFileNm();
		fileSize = imageVO.getFileSize();
		extNm = imageVO.getExtNm();
	}
	LOG.debug("return writing======================================");
	LOG.debug("=imageVO="+imageVO);
	LOG.debug("======================================");
	//이미지 저장 후 이미지 정보를 담아온다------------------------------------------------	
	

	
	//이미지 첨부시 내용 유지를 위함-----------------------------------------------------
	String productNo = "";
	String productNm = "";
	String category = "";
	String price = "";
	String contents = "";
	String targetCnt = "";
	String deadline = "";
	String regId = "";
	String deliveryPrice = "";
	
	ProductVO vo = new ProductVO(); 
	ProductVO selectVO = (ProductVO)request.getAttribute("selectVO");
	ProductVO saveInVO = (ProductVO)request.getAttribute("saveInVO");
	if(selectVO!=null){
		vo = selectVO;
		insetUpdateFlag="update";
	}else if(saveInVO!=null){
		vo = saveInVO;
		insetUpdateFlag="insert";
	}else{
		vo=null;
		insetUpdateFlag="insert";
	}
		
	if( vo != null){
		productNo = vo.getProductNo();
		productNm = vo.getProductNm();
		category = vo.getCategory();
		price = vo.getPrice();
		contents = vo.getContents();
		targetCnt = vo.getTargetCnt();
		deadline = vo.getDeadline();
		regId = vo.getRegId();
		deliveryPrice = vo.getDeliveryPrice();
	}
	//이미지 첨부시 내용 유지를 위함-----------------------------------------------------
	
%>
<!DOCTYPE html>
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
<script type="text/javascript" src="/ZIMZALABIM/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<title>Insert title here</title>
<script src="/ZIMZALABIM/js/jquery-1.12.4.js"></script>
<script src="/ZIMZALABIM/js/jquery-ui.js"></script>
</head>
<body>



	<!-- div container -->
	<div class="container">
		<div class="page-header">
				<h2>게시글작성</h2>
		</div>
		
		<div class="row">
			<div class="fol-sm-12">
				<!-- writingFrm -->
				<form class="form-horizontal" name="writingFrm" id="writingFrm" action="ZIMZALABIM/product/writing.do" method="post">
					<input type="hidden"  name="work_div" id="work_div"/>					
					<input type="hidden"  name="orgFileNm" id="orgFileNm" />					
					<input type="hidden"  name="saveFileNm" id="saveFileNm"  />					
					<input type="hidden"  name="fileSize" id="fileSize" />					
					<input type="hidden"  name="extNm" id="extNm"/>				
					<input type="hidden"  name="product_no" id="product_no" value="<%=productNo%>"/>				
<%-- 					<input type="hidden"  name="orgFileNm" id="orgFileNm" value="<%=orgFileNm%>" />					 --%>
<%-- 					<input type="hidden"  name="saveFileNm" id="saveFileNm" value="<%=saveFileNm%>" />					 --%>
<%-- 					<input type="hidden"  name="fileSize" id="fileSize" value="<%=fileSize%>" />					 --%>
<%-- 					<input type="hidden"  name="extNm" id="extNm" value="<%=extNm%>" />					 --%>
					<!-- 카테고리 -->
					<div class="form-group row">
						<label class="col-xs-1 control-label">카테고리</label>
						<div class="col-sm-4">
							<select name="category" id="category" class="form-control input-sm" >
								<option value="">전체</option>
								<option value="10" <%if(category.equals("10"))out.print("selected");%>>의류</option>
								<option value="20" <%if(category.equals("20"))out.print("selected");%>>식품</option>
								<option value="30" <%if(category.equals("30"))out.print("selected");%>>문화</option>
								<option value="40" <%if(category.equals("40"))out.print("selected");%>>전자기기</option>
								<option value="50" <%if(category.equals("50"))out.print("selected");%>>미용</option>
								<option value="60" <%if(category.equals("60"))out.print("selected");%>>장난감</option>
								<option value="70" <%if(category.equals("70"))out.print("selected");%>>잡화</option>
								<option value="80" <%if(category.equals("80"))out.print("selected");%>>기타</option>
							</select>								
						</div>
						
<!-- 						아이디  -->
						<label class="col-sm-1 control-label">아이디</label>
						<diV class="col-sm-3 ">
							<input type="text" name="reg_id" id="reg_id" value="<%=regId%>" class="form-control input-sm" autocomplete="off"/>
						</div>	
<!-- 						// 아이디 -->
					</div>		
					<!--// 카테고리 -->
					
					<!-- 게시글 작성 폼 -->
					
					<!-- 제목 -->
					<div class="form-group">
						<label class="col-sm-1 control-label">제목</label>
						<diV class="col-sm-9">
							<input type="text" name="product_nm" id="product_nm" value="<%=productNm%>" class="form-control input-sm" autocomplete="off"/>
						</div>			
					</div>
					<!--// 제목 -->

					<!-- 수량, 마감일자 -->
					<div class="form-group">
						<label class="col-sm-1 control-label">수량</label>
						<diV class="col-sm-4">
							<input type="text" name="target_cnt" id="target_cnt" value="<%=targetCnt%>" class="form-control input-sm" autocomplete="off"/>
						</div>	
						<label class="col-sm-1 control-label">마감일자</label>
						<diV class="col-sm-4">
							<input type="text" name="deadline" id="deadline" value="<%=deadline%>" class="form-control input-sm" autocomplete="off"/>
						</div>		
					</div>
					<!--// 수량, 마감일자 -->
					
					<!-- 가격, 배송비 -->
					<div class="form-group">
						<label class="col-sm-1 control-label">가격</label>
						<diV class="col-sm-4">
							<input type="text" name="price" id="price" value="<%=price%>" class="form-control input-sm" autocomplete="off"/>
						</div>	
						<label class="col-sm-1 control-label">배송비</label>
						<diV class="col-sm-4">
							<input type="text" name="delivery_price" value="<%=deliveryPrice%>" id="delivery_price" class="form-control input-sm" autocomplete="off"/>
						</div>		
					</div>
					<!--// 가격, 배송비 -->
					
					<!-- 이미지  첨부 -->
					<div class="form-group">
						<label class="col-sm-1 control-label">이미지</label>
						<diV class="col-sm-4">
							<input type="text" class="form-control input-sm" id="imagetitle" name="imagetitle" value="<%=orgFileNm%>" readonly="readonly"/>							
						</div>	
							<input type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" value="첨부"></input>	
					</div>
					<!--// 이미지  첨부 -->

					
					<!-- modal 구동 버튼 (trigger) --> 
					

					
					<!-- 내용 -->
					<div class="form-group">
						<label class="col-sm-1 control-label"></label>
						<diV class="col-sm-9">
							<textarea name="contents" id="contents" rows="10" cols="100"><%=contents%></textarea>							
						</div>			
					</div>
					<!--// 내용 -->
					<!--// 게시글 작성 폼 -->
					
					<!-- button area -->
					<div class="form-group">
						<label class="col-sm-1 control-label"></label>
						<diV class="col-sm-9">
							<input type="button"  class="btn btn-default btn-sm" value="등록" id="save_btn" />
			    			<input type="button"  class="btn btn-default btn-sm" value="수정" id="update_btn" />
			    			<input type="button"  class="btn btn-default btn-sm" value="취소" id="cancel_btn" />
						</div>			
					</div>
   					<!--// button area -->										
				</form>				
			</div>
		</div>
	</div>
	<!--// div container -->

	<!-- 이미지 첨부 Modal -->
	<!-- <form class="form-horizontal" name="imageFrm" id="imageFrm" action="http://211.238.142.137:8080/ZIMZALABIM/product/writing.do" method="post" enctype="multipart/form-data"> -->
	<form class="form-horizontal" name="imageFrm" id="imageFrm" action="ZIMZALABIM/product/writing.do" method="post" enctype="multipart/form-data">
		<input type="hidden"  name="work_div" id="work_div"/>		
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">이미지 첨부</h4>
		      </div>
		      <div class="modal-body">
		       <input type="file" name="org_file_nm" id="org_file_nm"/> 
		       <input type="hidden" name="m_product_nm" id="m_product_nm"/> 	
		       <input type="hidden" name="m_product_no" id="m_product_no"/> 	
		       <input type="hidden" name="m_price" id="m_price"/> 	
		       <input type="hidden" name="m_category" id="m_category"/> 	
		       <input type="hidden" name="m_contents" id="m_contents"/> 	
		       <input type="hidden" name="m_target_cnt" id="m_target_cnt"/> 	
		       <input type="hidden" name="m_deadline" id="m_deadline"/> 	
		       <input type="hidden" name="m_reg_id" id="m_reg_id"/> 	
		       <input type="hidden" name="m_delivery_price" id="m_delivery_price"/> 	
		      </div>
		      <div class="modal-footer">
		     	<input type="button" class="btn btn-default" data-dismiss="modal" id="modal_save" value="첨부하기"/>
		        <input type="button" class="btn btn-default" data-dismiss="modal" id="modal_cancel" value="닫기"/>
		      </div>
		    </div>
		  </div>
		</div>
	</form>
	<!--// 이미지 첨부 Modal -->


<!-- 
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
 oAppRef: oEditors,
 elPlaceHolder: "contents",
 sSkinURI: "/ZIMZALABIM/html/SmartEditor2Skin.html",
 fCreator: "createSEditor2"
});
</script>
 -->

	<script>
	$("#modal_save").on('click',function(){
 		var frm = document.imageFrm;
 		var writingFrm = document.writingFrm;
 		frm.work_div.value = "do_image_save";
 		frm.m_product_nm.value=$("#product_nm").val();
 		frm.m_product_no.value=$("#product_no").val();
 		frm.m_price.value=$("#price").val();
 		frm.m_category.value=$("#category").val();
 		frm.m_contents.value=$("#contents").val();
 		frm.m_target_cnt.value=$("#target_cnt").val();
 		frm.m_deadline.value=$("#deadline").val();
 		frm.m_reg_id.value=$("#reg_id").val();
 		frm.m_delivery_price.value=$("#delivery_price").val();
 		
//   	alert('frm.mproduct_nm.value='+frm.mproduct_nm.value);
//  	frm.action = "/ZIMZALABIM/product/writing.do";
 		frm.action = "http://211.238.142.137:8080/ZIMZALABIM/product/writing.do";
 		frm.submit();
	});
	
	 //게시글 수정
    $("#update_btn").on('click',function(){
//     	alert('save_btn');
    	
    	var product_nm = $("#product_nm").val();
		if(null == product_nm || product_nm.trim().length ==0){
			$("#product_nm").focus();
			alert('제목을 입력하세요.');
			return;
		}
		
		var reg_id = $("#reg_id").val();
		if(null == reg_id || reg_id.trim().length ==0){
			$("#reg_id").focus();
			alert('등록자를 입력하세요.');
			return;
		}
		
		var contents = $("#contents").val();
		if(null == contents || contents.trim().length ==0){
			$("#contents").focus();
			alert('내용을 입력하세요.');
			return;
		}
		
		
		var price = $("#price").val();
		if(null == price || price.trim().length ==0){
			$("#price").focus();
			alert('가격을 입력하세요.');
			return;
		}
		
		var category = $("#category").val();
		if(null == category || category.trim().length ==0){
			$("#category").focus();
			alert('카테고리를 선택하세요.');
			return;
		}
		
		var target_cnt = $("#target_cnt").val();
		if(null == target_cnt || target_cnt.trim().length ==0){
			$("#target_cnt").focus();
			alert('수량을 입력하세요.');
			return;
		}
		
		var deadline = $("#deadline").val();
		if(null == deadline || deadline.trim().length ==0){
			$("#deadline").focus();
			alert('마감기한을 입력하세요.');
			return;
		}
		
		var delivery_price = $("#delivery_price").val();
		if(null == delivery_price || delivery_price.trim().length ==0){
			$("#delivery_price").focus();
			alert('배송비를 입력하세요.');
			return;
		}
		
		var imagetitle = $("#imagetitle").val();
		if(null == imagetitle || imagetitle.trim().length ==0){
			$("#imagetitle").focus();
			alert('이미지를 첨부하세요.');
			return;
		}
			
		if( false == confirm(product_nm+'을(를)\n수정 하시겠습니까?'))return;
    	
		var frm = document.writingFrm;
		frm.work_div.value = "do_update";
		frm.orgFileNm.value = "<%=orgFileNm%>";
		frm.saveFileNm.value = "<%=saveFileNm%>";
		frm.fileSize.value = "<%=fileSize%>";
		frm.extNm.value = "<%=extNm%>";

		alert('frm.work_div.value='+frm.work_div.value);
		frm.action = "/ZIMZALABIM/product/writing.do";
		//frm.action = "http://211.238.142.137:8080/ZIMZALABIM/product/writing.do";
		frm.submit();
		
//  	window.location.href="/ZIMZALABIM/listall/listall.do?work_div=do_totalCategory_select";
    });
	
	
    //게시글 등록
	    $("#save_btn").on('click',function(){
	    	//alert('save_btn');
	    	
	    	var product_nm = $("#product_nm").val();
			if(null == product_nm || product_nm.trim().length ==0){
				$("#product_nm").focus();
				alert('제목을 입력하세요.');
				return;
			}
			
			var reg_id = $("#reg_id").val();
			if(null == reg_id || reg_id.trim().length ==0){
				$("#reg_id").focus();
				alert('등록자를 입력하세요.');
				return;
			}
			
			var contents = $("#contents").val();
			if(null == contents || contents.trim().length ==0){
				$("#contents").focus();
				alert('내용을 입력하세요.');
				return;
			}
			
			
			var price = $("#price").val();
			if(null == price || price.trim().length ==0){
				$("#price").focus();
				alert('가격을 입력하세요.');
				return;
			}
			
			var category = $("#category").val();
			if(null == category || category.trim().length ==0){
				$("#category").focus();
				alert('카테고리를 선택하세요.');
				return;
			}
			
			var target_cnt = $("#target_cnt").val();
			if(null == target_cnt || target_cnt.trim().length ==0){
				$("#target_cnt").focus();
				alert('수량을 입력하세요.');
				return;
			}
			
			var deadline = $("#deadline").val();
			if(null == deadline || deadline.trim().length ==0){
				$("#deadline").focus();
				alert('마감기한을 입력하세요.');
				return;
			}
			
			var delivery_price = $("#delivery_price").val();
			if(null == delivery_price || delivery_price.trim().length ==0){
				$("#delivery_price").focus();
				alert('배송비를 입력하세요.');
				return;
			}
			
			var imagetitle = $("#imagetitle").val();
			if(null == imagetitle || imagetitle.trim().length ==0){
				$("#imagetitle").focus();
				alert('이미지를 첨부하세요.');
				return;
			}

				
			if( false == confirm(product_nm+'을(를)\n등록 하시겠습니까?'))return;
	    	
			var frm = document.writingFrm;
			frm.work_div.value = "do_insert";
			frm.orgFileNm.value = "<%=orgFileNm%>";
			frm.saveFileNm.value = "<%=saveFileNm%>";
			frm.fileSize.value = "<%=fileSize%>";
			frm.extNm.value = "<%=extNm%>";

			alert('frm.work_div.value='+frm.work_div.value);
 			frm.action = "/ZIMZALABIM/product/writing.do";
//  		frm.action = "http://localhost:8080/ZIMZALABIM/product/writing.do";
			//frm.action = "http://211.238.142.137:8080/ZIMZALABIM/product/writing.do";
			frm.submit();
			
// 			window.location.href="http://localhost:8080/ZIMZALABIM/listall/listall.do?work_div=do_totalCategory_select";
	    });
		
		$("#cancel_btn").on('click',function(){
    		alert('cancel_btn');
		});
		
		$("#deadline").datepicker({
			dateFormat: 'yy.mm.dd' //Input Display Format 변경
			,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
			,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
			,changeYear: true //콤보박스에서 년 선택 가능
			,changeMonth: true //콤보박스에서 월 선택 가능                            
			,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
			,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
			,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
			,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
			,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
			,minDate: "M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
		});
		

		
	</script>
	
	


</body>
</html>