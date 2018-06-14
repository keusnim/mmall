<%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${message.error}</title>
</head>
<body>
${message.error},<a href="${pageContext.request.contextPath}${message.hint}">点击返回</a>
</body>
</html>
