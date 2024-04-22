<%--
  Created by IntelliJ IDEA.
  User: FULL8-007
  Date: 2024-04-22
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>글번호</th>
                <th>제목</th>
            </tr>
        </thead>
        <tbody>
                <c:if test="${empty list}">
                    <tr><td>자료가 없습니다.</td></tr>
                </c:if>
                <c:if test="${!(empty list)}">
                    <c:forEach var="item" items="${list}">
                        <tr>
                            <td><c:out value="${item.b_no}"/></td>
                            <td><a href="board_detail.do?bno=${item.b_no}"> <c:out value="${item.title}"/></a></td>
                        </tr>
                    </c:forEach>
                </c:if>
        </tbody>
    </table>
</body>
</html>
