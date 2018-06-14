<%@ page import="com.springmvc.pojo.User" %><%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 引入jstl库 -->
<html>
<head>
    <title>商品展示</title>
</head>
<body>
欢迎您，<%String username = (String)session.getAttribute("username");
if (username != null) {%>  <%=username%>
<%
    } else {
        out.print("<script>alert('请先登录....');window.location.href='login.jsp';</script>");
    }
%>
<a href="${pageContext.request.contextPath}/user/logout">注销</a>
<h1 align="center">商城后台管理系统</h1>
<table width="100%" height="700" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td width="15%" height="100%" valign="top">
            <a href="/type/list" target="mainFrame">商品类型管理页面</a><br><br><br>
            <a href="/type/addType" target="mainFrame">商品类型添加页面</a><br><br><br>
            <a href="/item/list" target="mainFrame">商品信息管理页面</a><br><br><br>
            <a href="/item/addItem" target="mainFrame">商品信息添加页面</a><br><br><br>
            <a href="${pageContext.request.contextPath}/user/logout">退出系统</a>
        </td>
        <td width="80%" valign="top">
            <iframe src="${pageContext.request.contextPath}/type/list" name="mainFrame" frameborder="2" height="800" width="1000" ></iframe>
        </td>
    </tr>
</table>

</body>
</html>
