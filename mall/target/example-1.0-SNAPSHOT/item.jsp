<%@ page import="com.springmvc.vo.ItemVo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2">
    <tr>
        <th>序号</th>
        <th>商品名称</th>
        <th>商品类型</th>
        <th>价格</th>
        <th>库存量</th>
        <th>操作</th>
    </tr>

    <%-- 此方法读取不到信息--%>
    <%--<c:forEach var="itemVo" items="${itemVoList}">--%>
        <%--<tr>--%>
            <%--<td>${itemVo.id}</td>--%>
            <%--<td>${itemVo.itemName}</td>--%>
            <%--<td>${itemVo.typeName}</td>--%>
            <%--<td>${itemVo.price}</td>--%>
            <%--<td>${itemVo.itemNumber}</td>--%>
            <%--<td>--%>
                <%--<a href="${pageContext.request.contextPath}/item/update?id=${itemVo.id}">修改</a>--%>
                <%--<a href="${pageContext.request.contextPath}/item/delete?id=${itemVo.id}">删除</a>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>

    <%
        List<ItemVo> itemVoList = (List<ItemVo>) request.getAttribute("itemVoList");
        for(ItemVo itemVo: itemVoList){
            out.print("<tr>");
            out.print("<td>");
            out.print(itemVo.getId());
            out.print("</td>");
            out.print("<td>");
            out.print(itemVo.getItemName());
            out.print("</td>");
            out.print("<td>");
            out.print(itemVo.getTypeName());
            out.print("</td>");
            out.print("<td>");
            out.print(itemVo.getPrice());
            out.print("</td>");
            out.print("<td>");
            out.print(itemVo.getItemNumber());
            out.print("</td>");
    %>
    <td>
        <a href="${pageContext.request.contextPath}/item/update?id=<%=itemVo.getId()%>">修改</a>
        <a href="${pageContext.request.contextPath}/item/delete?id=<%=itemVo.getId()%>">删除</a>
    </td>
    <%
            out.print("</tr>");
        }
    %>
</table>
<a href="${pageContext.request.contextPath}/item/addItem">新增商品信息</a>
</body>
</html>
