<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	http://localhost:8070/spring/validator/view mvc/validator
	<h2>origin</h2>
	<form action="${pageContext.request.contextPath }/validator/origin" method="post">
		<input type="text" name="mem_id"><br>
		<input type="password" name="mem_pass"><br>
		<input type="submit" name="전송"><br>
	</form>

	<h2>validator interface</h2>
	<spring:hasBindErrors name="memberVO"/>
	<form action="${pageContext.request.contextPath }/validator/validator" method="post">
		<input type="text" name="mem_id"> <form:errors path="memberVO.mem_id"/><br>
		<input type="password" name="mem_pass"> <form:errors path="memberVO.mem_pass"/><br>
		<input type="submit" name="전송"><br>
	</form>
	
	<h2>JSR303 validator interface</h2>
	<spring:hasBindErrors name="jsr303MemberVO"/>
	<form action="${pageContext.request.contextPath }/validator/jsr303validator" method="post">
		<input type="text" name="mem_id" value="${jsr303memberVO.mem_id }"> <form:errors path="jsr303MemberVO.mem_id"/><br>
		<input type="password" name="mem_pass"> <form:errors path="jsr303MemberVO.mem_pass"/><br>
		<input type="submit" name="전송"><br>
	</form>
</body>
</html>