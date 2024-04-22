<%--
  Created by IntelliJ IDEA.
  User: FULL8-011
  Date: 2024-04-22
  Time: 오전 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            width: 90%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <jsp:include page="top.jsp" flush="true"/>
    <section>
        <c:set var="contentpage" value="${param.page}"/>
        <c:choose>
            <c:when test="${empty contentpage || contentpage==''}">
                <jsp:include page="mainList.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="${contentpage}"/>
            </c:otherwise>
        </c:choose>
        
    </section>
    <jsp:include page="footer.jsp" flush="true"/>
</body>
</html>
