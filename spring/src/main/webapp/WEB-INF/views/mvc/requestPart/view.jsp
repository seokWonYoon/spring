<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
mvc/requestPart/view 입니다. <br>
	<form action="${pageContext.request.contextPath }/requestPart/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file"> <br>
		<input type="submit" value="전송"> <br>
	</form>
</body>
</html>