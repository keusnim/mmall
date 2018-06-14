<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div align="center">
    <form id="form" action="${pageContext.request.contextPath}/user/doRegister" method="post">
    姓名:<input type="text" name="username"></br>
    密码:<input type="text" name="password"></br>
    <input type="submit" value="注册">
    </form>
</div>


</body>
</html>
