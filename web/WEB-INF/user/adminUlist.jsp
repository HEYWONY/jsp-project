<%--
  Created by IntelliJ IDEA.
  User: FULL8-007
  Date: 2024-04-26
  Time: 오전 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="smr/css/adminUlist.css">

</head>
<body>
<c:set var="userlist" value="${requestScope.userlist}"/>
<div class="wrap">

<ul class="userlist">
    <h3>회원 목록</h3>

    <div class="wpahr">
        <li>
            <span>아이디</span>
            <span>이름</span>
            <span>닉네임</span>
            <span>삭제여부</span>
        </li>
    </div>
    <div class="sodyd">
    <c:forEach var="item" items="${userlist}">
        <li>
            <span><c:out value="${item.id}"/></span>
            <span><c:out value="${item.name}"/></span>
            <span><c:out value="${item.nickname}"/></span>
            <span><a href="admin_user_delete.do?id=${item.id}"><input type="submit" value="삭제"></a></span>
        </li>

    </c:forEach>
    </div>
</ul>
</div>
</body>
</html>
