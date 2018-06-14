<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增商品信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/item/add" >
    类型ID:<input type="text" name="itemType"/><br/>
    名称:<input type="text" name="itemName"/><br/>
    价格:<input type="text" name="price"/><br/>
    库存量:<input type="text" name="itemNumber"/><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
