<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加商品类型</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/type/add" >
    类型名称:<input type="text" name="name"/><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
