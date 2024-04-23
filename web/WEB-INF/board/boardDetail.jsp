<%--
  Created by IntelliJ IDEA.
  User: FULL8-007
  Date: 2024-04-22
  Time: 오후 4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <c:set var="detail" value="${requestScope.dto}"/>
<ul>
    <c:if test="${empty detail}">
        <li>자료가 없습니다.</li>
    </c:if>
    <c:if test="${!(empty detail)}">
        <li>${detail.b_no}</li>
        <li>${detail.title}</li>
        <li>${detail.content}</li>
        <li>${detail.writer}</li>
        <li>${detail.writedate}</li>
        <li>${detail.readno}</li>
    </c:if>
</ul>
 <a href="boardlist.do">목록보기</a>
 <a href="board_update.do?bno=${detail.b_no}">수정</a>
 <a href="board_delete.do?bno=${detail.b_no}">삭제</a>


</body>
</html>
