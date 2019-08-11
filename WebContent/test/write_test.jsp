<%@page import="com.zim.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">

</style>
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->    
<link rel="stylesheet" href="/ZIMZALABIM/js/jquery-ui.css" >
<link rel="shortcut icon" href="/ZIMZALABIM/image/favicon.ico">
<!-- 부트스트랩 -->
<link href="/ZIMZALABIM/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/ZIMZALABIM/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<title>ZIMZALABIM</title>
<script src="/ZIMZALABIM/js/jquery-1.12.4.js"></script>
<script src="/ZIMZALABIM/js/jquery-ui.js"></script>
<script src="/ZIMZALABIM/js/popper.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="/ZIMZALABIM/js/bootstrap.min.js"></script>	
<script src="/ZIMZALABIM/js/plugins.js"></script>
<script src="/ZIMZALABIM/js/active.js"></script>
<!-- jquery valdation -->
<script src="/ZIMZALABIM/js/jquery.validate.js"></script>
<script src="/ZIMZALABIM/js/messages_ko.js"></script>
<script src="/ZIMZALABIM/js/additional-methods.js"></script>
<!-- //jquery valdation -->
<!-- Core Style CSS -->
<link rel="stylesheet" href="/ZIMZALABIM/css/core-style.css">
<link rel="stylesheet" href="/ZIMZALABIM/css/style.css">
</head>
<body>
<h1>게시글 작성</h1>
<div>
	<textarea id="popContents" name="popContents" ></textarea>
</div>
</body>
<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "popContents", //textarea에서 지정한 id와 일치해야 합니다. 
		//SmartEditor2Skin.html 파일이 존재하는 경로
		sSkinURI: "/ZIMZALABIM/SE2/SmartEditor2Skin.html",  
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,             
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,     
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true,         
			fOnBeforeUnload : function(){
			}
		}, 
		fCreator: "createSEditor2"
	});
</script>
</html>