<%@page import="java.util.List"%>
<%@page import="com.enjoyexercise.www.vo.GreetingVO"%>
<%@page import="com.enjoyexercise.www.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<link href="${path }/css/MyType.css" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<% UserVO loginUser = (UserVO)session.getAttribute("user");%>
<script type="text/javascript">
$(document).ready(function() {
	var form= {	};
	var items = [];
	var html = '';
	var paging = '';
	
	function getList(form) {
		$('.output').empty()
		$.ajax({
			url:"getGreetingList.do",
			type:"POST",
			data: form,
			async: false,
			success: function(greetingMap){
				const greetingList = greetingMap.greetingList;
				paging = greetingMap.paging;
				//console.log("그리팅 총 갯수"+greetingList.length); //= 37
				for(i = 0; i < greetingList.length;i++){
					items[i] = greetingList[i];
				}
			}
		});
		for(i=0 ; i<items.length ; i++){
			var obj = items[i];
			var address = i;
			var greeting_id = obj.greeting_id;
			var user_nickname = obj.user_nickname;
			var content = obj.content;
			var longtime = obj.created_at;
			var time = longtime.split(' ');
			html = '<div class="greetingBundle" id="greetingBundle_'+i+'">';
			html += '<input type="hidden" id="greeting_id_'+i+'" name="greeting_id"';
			html += ' value="'+greeting_id+'"/>';
			html += '<div id="user">'+user_nickname+'</div>';
			html += '<div id="content_'+i+'">'+content+'</div>';
			html += '<div id="updateDiv_'+i+'" style="display:none"><form class="updateForm" id="updateForm_'+i+'">';
			html += '<input type="hidden" id="greeting_id_'+i+'" name="greeting_id" value="'+greeting_id+'"/>';
			html += '<input type="text" id="updateContent_'+i+'"name="content" value="'+content+'"/>';
			html += '<input type="submit" class="updateBtn" id="updateGreeting_'+i+'" value="수정하기"/></form></div>';
			html += '<div id="time_'+i+'">'+time+'</div>';
			html += '<div id="tool_'+i+'">';
			html += '<input type="button" class="updateVisual" id="updateCommentOpen_'+i+'" value="수정" >&nbsp;';
			html += '<input type="button" class="deleteBtn" id="deleteGreeting_'+i+'" value="삭제" >&nbsp;';
			html += '</div></div>';
			var output = document.querySelector('.output');
			$('.output').append(html);
		}
	}
	//Gretting.jsp 에 페이지수에 알맞게 페이지버튼 뜨게 만드는 중
	function setPaging() {
		const pagination = document.querySelector(".pagination");
		const pagesCnt = paging.pageCnt;
		var prev = pagination.querySelector(".prev");
    	var next = document.createElement("li");
	    	next.classList.add("page-item");
	    	next.classList.add("next");
	    	var nextA = document.createElement("a");
	    	nextA.classList.add("page-link");
	    	nextA.href="#";
	    	nextA.setAttribute("aria-label","Next");
	    	var span = document.createElement("span");
	    	span.setAttribute("aria-hidden","true");
	    	span.innerHTML = "&raquo;";
	    	nextA.appendChild(span);
	    	next.appendChild(nextA);
		//페이지 수가 5가 안넘어갈때는 페이지 수에 맞춰서,
		if(paging.pageCnt <= 5) {
			for(var i = 0; i < pagesCnt; i++) {
				var num = i + 1;
				var newPage = document.createElement("li");
				newPage.classList.add("page-item");
				newPage.classList.add("num");
				var newA = document.createElement("a");
				newA.classList.add("page-link");
				newA.href="getGreetingList.do?curPage="+num;
				newA.innerHTML = num;
				newPage.appendChild(newA);
				console.log(newPage);
				pagination.appendChild(newPage);
				//pagination.children.splice(number,0,page);
				//pagination.appendChild(page);
			}
			//pagination.splice(1,0,page);
			pagination.appendChild(next);
		} else {}	
		//페이지수가 6이상이면 next 눌렸을 때 다음 구간(6~10)으로 갈 수 있게.
		//console.dir(paging);
	}
	//페이지 2눌렸을 때 getList()가 아닌 2에 해당하는 리스트의 값 받기.

	getList();
	setPaging();
	
	/*작성*/
	$('#insertForm').submit(function(event){
		event.preventDefault();
		var insert = new Array();
		insert[0] = $('#insertdep').val();
		insert[1] = $('#insertuser_id').val();
		insert[2] = $('#insertuser_nickname').val();
		insert[3] = $('#insertcontent').val();
		//console.log(insert);
		var params = $(this).serialize();
		$.ajax({
			url:"insertGreeting.do",
			type: "POST",
			data : params,
			dataType: "html",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			success: function(result) {	},
			error: function(error){
				alert('error');;
				console.log(error);
			}
		});
		getList();
	});	
	/*삭제*/
	$('.deleteBtn').click(function(event){	
		var address = event.target.id.split('_')[1];
		var id = document.getElementById('greeting_id_'+address).value;
		var form = {greeting_id: id};
		$.ajax({
			url:'deleteGreeting.do',
			type:'GET',
			data : form,
			success : function(data) {
				alert("삭제되었습니다");
			},
			error : function(request, status, error){
				alert(error);
			}
		});
		getList();
		refreshList() 
	});
	
	function refreshList() {
		location.reload();
	}
	/*"수정" 버튼 눌렸을 때 수정 폼 열리기*/
	$('.updateVisual').click(function(event){
		const target = event.target
		var state = event.target.id.split('_')[0];
		var address = event.target.id.split('_')[1];
		tagToShow = null;
		tagToHIde = null;
		if(state.indexOf("Open")!= -1){
			//해당 수정폼 display Show()
			tagToShow = document.getElementById('updateDiv_'+address);
			$(tagToShow).show();
			//내용 보여주는 div 숨기기
			tagToHIde = document.getElementById('content_'+address);
			$(tagToHIde).hide();
			$(target).attr('id','updateCommentClose_'+address);
			console.log('버튼 id 바뀜 : ' + target.id);
			//updateCommentOpen_
			//$(target).attr('id','recommentHide'+bundleAddress.substring(14,15));
			//id 바꾸기
		} else if(state.indexOf("Close")!= -1){
			//해당 내용 보여주는 divShow()
			tagToShow = document.getElementById('content_'+address);
			$(tagToShow).show();
			//해당 수정폼 display 숨기기
			tagToHIde = document.getElementById('updateDiv_'+address);
			$(tagToHIde).hide();
			$(target).attr('id','updateCommentOpen_'+address);
			console.log('버튼 id 바뀜 : ' + target.id);
		}
	});
	//form class="updateForm" id="updateForm_'+i+'"
	$('.updateForm').submit(function(event){
		event.preventDefault();
		var address = event.target.id.split('_')[1]; 
		var form = document.getElementById('updateForm_' + address);
		var greeting_id = document.getElementById('greeting_id_'+address);
		var updateContent = document.getElementById('updateContent_'+address);
		greeting_id = greeting_id.value;
		updateContent = updateContent.value;
		var form = {greeting_id: greeting_id, content:updateContent};
		//console.log(form);
		$.ajax({
			url:"updateGreeting.do",
			type: "POST",
			data : form,
			dataType: "html",
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			success: function(result) {	
				console.log("데이터 입력 성공!");
			},
			error: function(error, request,status){
				alert('code:'+request.status + '\n'+'message:'+request.responseText+'\n'+'error:'+error);
			}
		});
		getList();
		refreshList() 
	});
	
});

</script>
<title>Enjoy Exercise!</title>
</head>
<% UserVO loginuser = (UserVO)session.getAttribute("user");
	//List<GreetingVO> greetingList = (List<GreetingVO>)request.getAttribute("greetingList");%>
<body>
<header>
	<div class="wrapper">
		<h1>Enjoy Exercise</h1>
		<nav>
			<ul class="menu">
				<%  if(loginuser == null) {%>
				<li><a href="join.jsp">Join us!</a></li>
				<li><a href="login.jsp">Login</a></li> <%} else { %>
				<li><a href="logout.do">Logout</a></li>
				<li><a href="mypage/myPage.jsp">My Page</a></li><%} %>
				<li><a href="info/getInfoList.jsp">Information(오픈예정)</a></li>
				<li><a href="${path }/getNoticeList.do">Notice</a></li>
				<li><a href="main.jsp">Main</a></li>
			</ul>
		</nav>
	</div>
</header>
<div class="blankline" style="width:100vw;height:75px;border:1px solid black"></div>
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
<script type="text/javascript">
$(document).ready(function(){
	
});
</script>
<div class="blankline" style="width:98vw;height:15px;"></div>
<div class="greetingcontent">
	<div class="title"><h1>한줄인사 게시판</h1></div>
	<div class="input">
		<%if(loginuser!=null) { %>
			<div class="insert">
				<form id="insertForm" name="insertForm" method="post">
					<input type="hidden" id="insertdep" name="dep" value="0">
					<input type="hidden" id="insertuser_id" name="user_id" value="${sessionScope.user.id}">
					<input type="hidden" id="insertuser_nickname" name="user_nickname" value="${sessionScope.user.nicname}">
					<table border="1" style="width:98%px">
						<tr style="text-align:center"><td style="width:30px">작성자</td><td>한줄인사</td></tr>
						<tr style="line-height:50px">
							<td>${sessionScope.user.nicname}</td>
							<td><input type="textarea" id="insertcontent" name="content" style="resize:none;width:850px;height:45px;display:inline;margin:3px" placeholder="한줄인사를 남겨주세요"/>
							<input id="inputSubmit" type="submit" value="등록" />
							
							</td>
						</tr>
					</table>
				</form>
				
			</div>
		<%} else {%>
			<div class="insert">
				<h3><a href="login.jsp">로그인</a>하고 한줄인사를 남겨보세요</h3>
			</div>
		<%} %>
		<div class="search">검색 박스<br><input id="testBtn" type="button" value="ajax테스트"/></div>
	</div>
	<div class="output">
	</div>
<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item prev">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>

  </ul>
</nav>
</div>


</body>
</html>