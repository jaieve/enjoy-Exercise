<%@page import="com.enjoyexercise.www.vo.GreetingVO"%>
<%@page import="com.enjoyexercise.www.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<link href="${path }/css/MyType.css" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function(){
	var form = {};
	var items = [];
	var GreetingList = function() {
		$('.showContent').empty();
		$.ajax({
			url:"getGreetingList.do",
			type:"POST",
			data: form,
			async: false,
			success: function(greetingMap){
				const greetingList = greetingMap.greetingList;
				const paging = greetingMap.paging;
				for(i = 0; i < 5;i++){
					items[i] = greetingList[i];
				}
			}
		});
		var html = '';
		for(i=0 ; i<items.length ; i++){
			var obj = items[i];
			var user_nickname = obj.user_nickname;
			var content = obj.content;
			var longtime = obj.created_at;
			var time = longtime.split(" ");
			console.log(time);
			html += '<div style="display:block;width:735px;height:14px;line-height: 14px;"><div style="display: block;float:left">';
			html += '<div style="display:inline-block;font-weight: bold;">'+user_nickname+'</div>';
			html += '<div style="display:inline-block;">'+content+'</div></div>';
			html += '<div style="display:block;float:right;"><div style="display:inline-block;color: grey;">'+time[0];
			html += '</div></div></div></div><br>';
		}
		var showContent = document.querySelector('.showContent');
		showContent.innerHTML += html;
	}
	GreetingList();
	
	/*????????????*/
	//console.log('async ????????? ???');
	var NoticeList = function() {
		$('.showContent').empty();
		var notice = {};
		var items=[];
		var noticeHTML = '';
		$.ajax({
			url:"getNoticeListMain.do",
			type:"POST",
			data: notice,
			async: false,
			success: function(NoticeList, status) {
				console.log(items);
				for(i=0;i<NoticeList.length;i++){
					items[i] = NoticeList[i];
				}
			},
			error : function(error,status){
				alert(error, status);
			}
		});
		for(i=0 ; i<items.length ; i++){
			var obj = items[i];
			var writer = obj.writer;
			var title = obj.title;
			var longtime = obj.regdate;
			var time = longtime.split(' ');
			noticeHTML += '<div style="display:block;width:735px;height:14px;line-height: 14px;"><div style="display: block;float:left">';
			noticeHTML += '<div style="display:inline-block;font-weight: bold;">'+title+'</div></div>';
			noticeHTML += '<div style="display:block;float:right;"><div style="display:inline-block;color: grey;">'+time[0];
			noticeHTML += '</div></div></div></div><br>';
		}
		console.log(noticeHTML)
		$('.showContent').html(noticeHTML);
	}
	
	/*Greeting ?????? ????????? ???*/
	$('#greetingtab').click(function() {
		GreetingList();
	});
	/*Notice ??????(???) ????????? ???*/
	$('#noticetab').click(function() {
		NoticeList();
	});
	/* bmi  ??????*/
	$('#calculateBtn').click(function() {
		var height = $('#heigth').val();
		var weight = $('#weigth').val();
		var bmiresult = (weight / ( (height/100) * (height/100))).toFixed(2);
		var result = (bmiresult>=25) ? "??????????????????.": "?????????????????????." ;
		//console.log(bmiresult);
		//console.log(result);
		var bmioutput = document.querySelector('#bmioutput');
		//console.log(bmioutput);
		var html ='<h3>????????? BMI??? '+bmiresult+'?????????.<br>';
		html += '?????? ????????? ?????? BMI????????? ???????????? ???, '+result+'</h3>';
		bmioutput.innerHTML = html;
		var login =document.getElementById('loginuser');
		/*????????? ???????????? ??????????????? ????????????*/
		if(login != null) {
			var id = document.getElementById("loginID");
			console.log(id);
			id = id.value;
			var form = {weight:weight, height : height, bmi : bmiresult, id : id};
			$.ajax({
				url:"updateBmi.do",
				type:"POST",
				data:form,
				dataType:"html",
				contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
				success: function(){
					console.log("????????? ?????? ??????!");
				},
				error: function(error, request,status){
					alert('code:'+request.status + '\n'+'message:'+request.responseText+'\n'+'error:'+error);
				}
			});
		} else {
			console.log("????????? ?????? ??????");
		}
	});
});


</script>
<title>Enjoy Exercise!</title>
</head>
<% UserVO user = (UserVO)session.getAttribute("user");%>
<body>
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="main.jsp">Enjoy Exercise</a>
	<ul class="nav">
	  <li class="nav-item">
	    <a class="nav-link active" aria-current="page" href="#">Active</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="#">Link</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="#">Link</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
	  </li>
	</ul>
  </div>
</nav>
<!-- <header>
	<div class="wrapper">
		<h1>Enjoy Exercise</h1>
		<nav>
			<ul class="menu">
				<%  if(user == null) {%>
				<li><a href="join.jsp">Join us!</a></li>
				<li><a href="login.jsp">Login</a></li> <%} else { %>
				<li><a href="logout.do">Logout</a></li>
				<li><a href="mypage/myPage.jsp">My Page</a></li><%} %>
				<li><a href="getGreetingList.do">Greeting</a></li>
				<li><a href="Greeting.jsp">Greeting(ajax????????????)</a></li>
				<li><a href="info/getInfoList.jsp">Information(????????????)</a></li>
				<li><a href="getNoticeList.do">Notice(????????????)</a></li>
			</ul>
		</nav>
	</div>
</header> -->
<div class="container-lg">100% wide until large breakpoint</div>
<div class="container-xl">100% wide until extra large breakpoint</div>
<div id="mainImgSlide" style="display:absolute;top:100px;width:1050px;height:410px;margin:0 auto;background-position:center;"></div>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
	var images = ["main1.jpg","main2.jpg","main4.jfif"];
	$(function(){
		var i = 0;
		$("#mainImgSlide").css("background-image","url('./images/resource/" + images[i] + "')");
		setInterval(function () {
            i++;
            if (i == images.length) {
                i = 0;
            }
            $("#mainImgSlide").fadeOut("slow", function () {
                $(this).css("background-image", "url('./images/resource/" + images[i] + "')");
                $(this).fadeIn("slow");
            });
        }, 10000);
	});
</script>
<div class="blankline" style="width:100vw;height:15px;"></div>
<div class="content">
	<div class="boards">
		<div class="tab" style="display:block;height: 40px;">
	        <div id=tab1" style="display: inline-block;background-color: rgb(197, 112, 197);width:245px;height:40px;text-align:center;vertical-align:middle;">
	            <input type="button" id="greetingtab" value="Greeting"/>
	        </div>
	        <div id="tab2" style="display: inline-block;background-color: plum;width:245px;height:40px;text-align:center;vertical-align:middle;">
	            <input type="button" id="noticetab" value="Notice"/>
	        </div>
	        <div id="tab2" style="display: inline-block;background-color: plum;width:245px;height:40px;text-align:center;vertical-align:middle;">
	            <input type="button" id="infotab" value="Information"/>
	        </div>
  	  	</div>
		&nbsp;<div class="showContent"></div>
		<hr>
		<div class="cal">
			<div>
				<div class="bmiinput" style="display:inline-block;float:left;line-height:20px">
					???(cm)<br><input type="text" id="heigth" style/><br>
					?????????(kg)<br><input type="text" id="weigth" /><br>
					<input type="button" id="calculateBtn" value="????????????"/>
				</div>
				<div id="bmioutput" style="display:inline-block;float:right">
				</div>
			</div>
			
		</div>
	</div>
	<div class="sidebar">
		
		<% if(user != null){
		%><div id="loginuser">
		<input type="hidden" id="loginID" value="${sessionScope.user.id }">
		 <h3>????????? ??????</h3>
		<img src="images/profileImg/${user.filename }"><br>
		${sessionScope.user.nicname}??? ???????????????!<br>
		(ID : ${sessionScope.user.id })</div><%} %>
		
		<img id="logoImg"alt="logo" src="images/resource/logo.png" >
	</div>
</div>







</body>
</html>