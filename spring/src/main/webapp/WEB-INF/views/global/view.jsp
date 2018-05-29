<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	global/view.jsp : ${language } <br>
	GREETING : <spring:message code="GREETING" /> <br>
	<form action="${pageContext.request.contextPath }/global/view">
		<select name="language">
			<c:forEach items="${languageMap}" var="lang">
				<c:set var="selected" />
				<c:if test="${lang.key ==language }">
					<c:set var="selected" value="selected"/>
				</c:if>
				<option value="${lang.key }" ${selected }>${lang.value } / ${lang.key ==language } </option>
			</c:forEach>
		</select>
		<input type="submit" value="제출하기">
	</form>

</body>
</html>