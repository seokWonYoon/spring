<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("loading complete");
		var lineRangers = ["brown","cony","sally","james"];
		var memberVO = {"mem_id":"brown","mem_alias":"sally"};

		$("#before").html(JSON.stringify(lineRangers));
		
		//call 전송 클릭시 ajas 호출
		$("#call").click(function() {
			$.ajax({
				method : "post",
				url : "${pageContext.request.contextPath }/json/requestBody/sendData",
				data : JSON.stringify(lineRangers),
				dataType: "json", //서버 응답데이터타입
				contentType:"application/json; charset=UTF-8", // 서버로 전송하는 데이터 타입
				success: function(data) {
					$("#after").html(JSON.stringify(lineRangers));
					
				},
				error: function(xhr) {
					console.log(xhr);
				}
			})
		})
		
		$.ajax
		$.post(url, data, function(data, textStatus, req) {
			
		}, dataType)
		
	})
</script>
</head>
<body>
	mvc/json/view.jsp
	<span id="before"></span>
	<button id="call">전송</button>
	<span id="after"></span>
	<br>
</body>
</html>