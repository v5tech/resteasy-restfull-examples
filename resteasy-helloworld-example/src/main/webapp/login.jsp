<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>基于FORM表单的验证</title>
</head>
<body>
<FORM name="logonForm"  method="post" action="j_security_check">
   <input name="j_username" type="text" /><br/>
   <input name="j_password" type="password" /><br/>
   <input type="submit" value="登录"/>
</FORM>
</body>
</html>