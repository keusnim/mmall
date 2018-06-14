<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/type/save">
    编号:<input type="text" name="id" value="${type.id}" readonly/><br/>
    类型:<input type="text" name="name" value="${type.name}"/><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
