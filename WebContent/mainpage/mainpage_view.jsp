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
<%@page import="com.zim.cmn.StringUtil"%>
<%@page import="com.zim.product.listall.ListAllSearchVO"%>
<%@page import="com.zim.product.mainpage.MainPageService"%>
<%@page import="com.zim.product.ProductVO"%>
<%@page import="java.util.List"%>
<%@page import="com.zim.product.image.ImageDao"%>
<%@page import="com.zim.product.ProductDao"%>
<%@page import="org.apache.log4j.Logger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Logger LOG = Logger.getLogger(this.getClass());
	MainPageService mainPageService = new MainPageService();
	List<ProductVO> imList = (List<ProductVO>)mainPageService.do_imminent_select();//마감임박상품
	request.setAttribute("imList", imList);
	ListAllSearchVO inVO = new ListAllSearchVO();
	inVO.setPageSize(8);//한번에 표시할 갯수
	List<ProductVO> bestList = (List<ProductVO>)mainPageService.do_best_select(inVO);//베스트상품
	request.setAttribute("bestList", bestList);
	List<ProductVO> latestList = (List<ProductVO>)mainPageService.do_latest_select();//최근등록상품
	request.setAttribute("latestList", latestList);
%>   
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<form name="mainFrm" id="mainFrm" action="/ZIMZALABIM/mainpage/mainpage.do" method="post">
		<input type="hidden"  name="work_div"   />
		<input type="hidden"  name="page_num"   />
    	<input type="button" style="display: none;" class="btn btn-primary btn-sm" value="조회" onclick="javascript:do_retrieve();" />
		<br/>
		<!-- 마감임박 -->
		<div class="container" >
		<h4><label>마감임박</label></h4>
			<c:choose>
				<c:when test="${!empty imList && imList.size()>0 }">
					<c:forEach var="vo" items="${imList}">
						<div class="col-lg-3">
				  			<div class="thumbnail">
				  				<p><br><a href="#" class="" role="button"><img src="/ZIMZALABIM/img/product-img/product2.jpg" alt="..." style="height: 180px; width:200px;"></a></p>
				  				<div class="caption">
					  				<p>상품명 : "${StringUtil.cut(vo.getProductNm())}"</p>
					  				<p>판매액 : "${vo.getPrice()}(원)"</p> 
					  				<p>마감일 : "${vo.getDeadline()}"</p>
					  				<p style="display: none;">"${vo.getProductNo()}"</p>
				  				</div>
				  			</div>
				  		</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="table-responsive">
					<table id="noDataTable" class="table table-striped table-bordered table-hover">
						<tr>
							<td class="text-center" colspan="99">마감임박 상품이 없습니다.</td>
						</tr>
					</table>
				</div>
				</c:otherwise>
			</c:choose>
		</div>
		<br/>
		<!-- 베스트상품 -->
		<div class="container" >
		<h4><label>베스트상품</label></h4>
			<c:choose>
				<c:when test="${!empty bestList && bestList.size()>0 }">
					<c:forEach var="vo" items="${bestList}">
						<div class="col-lg-3">
				  			<div class="thumbnail">
				  				<p><br><a href="#" class="" role="button"><img src="/ZIMZALABIM/img/product-img/product2.jpg" alt="..." style="height: 180px; width:200px;"></a></p>
				  				<div class="caption">
					  				<p>상품명 : "${StringUtil.cut(vo.getProductNm())}"</p>
					  				<p>판매액 : "${vo.getPrice()}(원)"</p> 
					  				<p>마감일 : "${vo.getDeadline()}"</p>
					  				<p style="display: none;">"${vo.getProductNo()}"</p>
				  				</div>
				  			</div>
				  		</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="table-responsive">
					<table id="noDataTable" class="table table-striped table-bordered table-hover">
						<tr>
							<td class="text-center" colspan="99">마감임박 상품이 없습니다.</td>
						</tr>
					</table>
				</div>
				</c:otherwise>
			</c:choose>
		</div>
		<br/>
		<!-- 최근등록 -->
		<div class="container" >
		<h4><label>최근등록상품</label></h4>
		  <c:choose>
				<c:when test="${!empty latestList && latestList.size()>0 }">
					<c:forEach var="vo" items="${latestList}">
						<div class="col-lg-3">
				  			<div class="thumbnail">
				  				<p><br><a href="#" class="" role="button"><img src="/ZIMZALABIM/img/product-img/product2.jpg" alt="..." style="height: 180px; width:200px;"></a></p>
				  				<div class="caption">
					  				<p>상품명 : "${StringUtil.cut(vo.getProductNm())}"</p>
					  				<p>판매액 : "${vo.getPrice()}(원)"</p> 
					  				<p>마감일 : "${vo.getDeadline()}"</p>
					  				<p style="display: none;">"${vo.getProductNo()}"</p>
				  				</div>
				  			</div>
				  		</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="table-responsive">
					<table id="noDataTable" class="table table-striped table-bordered table-hover">
						<tr>
							<td class="text-center" colspan="99">마감임박 상품이 없습니다.</td>
						</tr>
					</table>
				</div>
				</c:otherwise>
			</c:choose>	
		</div>
		<br/>
	</form>
	
	<script>	
		//상품 상세보기 이동
		$('.col-lg-3').click(function(event) {
	 		var productNo = $(this).find('p').eq(4).text();
// 	 		alert("productNo:"+ productNo);  	    
	 		
	 		var frm = document.mainFrm;
			frm.work_div.value ="do_detail_select";
			frm.action = '/ZIMZALABIM/detail/detail.do?productNo='+productNo;
			frm.submit();
		});

		$(document).ready(function(){
			
		});
	</script>
</body>
</html>