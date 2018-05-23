<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
<table>
	<thead>
		<tr>
		<td>이름</td>
		<td>id</td>
		<td>별명</td>
		<td>생일</td>
		<td>주소(주소1+주소2)</td>
	</thead>
	<tbody>
		<c:forEach items="${memberList }" var="memberVO">
			<tr>
				<td>${memberVO.mem_name }</td>
				<td>${memberVO.mem_id }</td>
				<td>${memberVO.mem_alias }</td>
				<td><fmt:formatDate value="${memberVO.mem_bir }" pattern="yyyy-MM-dd"/></td>
				<td>${memberVO.mem_add1 } ${memberVO.mem_add2 } </td>
			</tr>
		</c:forEach>
	</tbody>
	<tr>
</table>
<%-- 	${memberList } --%>
</body>
</html>