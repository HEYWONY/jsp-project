<%--
  Created by IntelliJ IDEA.
  User: FULL8-007
  Date: 2024-04-24
  Time: 오후 7:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
   <c:set var="id"  value="${requestScope.id}" ></c:set>
</head>
<body>
<script>
    alert('회원님의 아이디는 ${id} 입니다');
    location.href = "login.do";
</script>
</body>
</html>
