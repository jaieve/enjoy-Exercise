<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">

		
		<link id="contextPath" data-path="<c:url value='/'/>" />
		<link href="<c:url value='/libs/bootstrap-4.4.1-dist/css/bootstrap.min.css'/>" rel="stylesheet" >
		
		
		
		
		<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
		
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

		<script type="text/javascript" src="<c:url value='/libs/smarteditor/js/service/HuskyEZCreator.js'/>" charset="utf-8"></script>
		
		<title>Insert title here</title>
	</head>
	<body>
		<textarea name="ir1" id="ir1" rows="10" cols="100">에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면 됩니다.</textarea>
		<button type="button" class="btn">작성내용 콘솔에 찍기!!</button>
	</body>
	
	<script>
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: oEditors,
			elPlaceHolder: "ir1",
			sSkinURI: $('#contextPath').data('path') + "/libs/smarteditor/SmartEditor2Skin.html",
			fCreator: "createSEditor2"
		});
		
		$(".btn").on("click", function() {
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
			var value = document.getElementById("ir1").value;
			console.log(value);
		});
	</script>
</html>