<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action="post" action="<%=request.getContextPath()%>/signup">
	이름: <input type="text" name="name"> <br>
	아이디: <input type="text" name="id"> <br>
	비밀번호: <input type="password" name="pw1"> <br>
	비밀번호 확인: <input type="password" name="pw2"> <br>
	<input type="submit" value="회원가입">
</form>
</body>
</html>