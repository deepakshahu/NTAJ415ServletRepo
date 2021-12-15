<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EL Test</title>
</head>
<body>
	<b>Add: ${4+5}</b>
	<br>
	<b>4 less than 5 ? ${4<5}</b>
	<br>
	<b>4 less than 5 ? ${4 lt 5}</b>
	<br>
	<b>4 greater than 5 ? ${4>5}</b>
	<br>
	<b>4 greater than 5 ? ${4 gt 5}</b>
	<br>
	<b>4 equals to 5 ? ${4 == 5}</b>
	<br>
	<b>4 equals to 5 ? ${4 eq 5}</b>
	<br> Cookie name :: ${cookie.JSESSIONID.name}
	<br> Cookie Value(session id) :: ${cookie.JSESSIONID.value}
	<br>
	<hr>
	context param db user value :: ${initParam.dbuser}
	<br> context param db pwd value :: ${initParam.dbpwd}
	<br>
	<b>uname req param value :: ${param.uname}</b>
	<br>
	<b>addrs req param value ::
		${paramValues.addrs[0]},${paramValues.addrs[1]}</b>
	<br>
	<b>user-agent request header value :: ${header['user-agent']}</b>
	<br>
	<br>
	<b>user-agent request header value :: ${headerValues['accept'][0]},${headerValues['accept'][1]}</b>
	<br>
</body>
</html>