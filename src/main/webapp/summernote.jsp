<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">

		
		<link id="contextPath" data-path="<c:url value='/'/>" />
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" charset="utf-8">
		<link  rel="stylesheet" href="<c:url value='/libs/summernote/summernote.min.css'/>" charset="utf-8"/>

		<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
		
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

		<script type="text/javascript" src="<c:url value='/libs/summernote/summernote.min.js'/>" charset="utf-8"></script>
		<script src="<c:url value='/js/summernote.js'/>" charset="utf-8"></script>
		
		<title>Insert title here</title>
	</head>
<body>
	<div id="summernote">Hello Summernote</div>
</body>
</html>