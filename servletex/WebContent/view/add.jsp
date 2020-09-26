<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력하세용</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/add">
<input type="text" name="n1"> + <input type="text" name="n2">
<input type="submit" value="더하기">
</form>
</body>
</html>