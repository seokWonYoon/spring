<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>${path }
	<br>${name }
	<br>${originalFileName }
	<br>${filePath }
<!-- 	spring/upload/brown.png -->
<%-- 	<img src="${pageContext.request.contextPath }${filepath }"> --%>
	<img src="${pageContext.request.contextPath }${uploadUrl}/${originalFileName}">
</body>
</html>