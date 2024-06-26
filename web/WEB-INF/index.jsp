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
    <meta charset="utf-8">
    <style>

        body {
            width: 90%;
            margin: 0 auto;
        }
        @font-face {
            font-family: 'SeoulNamsanM';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/SeoulNamsanM.woff') format('woff');
            font-size: 1.2rem;
            font-weight: normal;
            font-style: normal;
        }
        @font-face {
            font-family: 'Noto Sans KR';
            font-style: normal;
            font-weight: 100 900;
            font-display: swap;
            src: url(https://fonts.gstatic.com/s/notosanskr/v36/PbykFmXiEBPT4ITbgNA5Cgm20xz64px_1hVWr0wuPNGmlQNMEfD4.2.woff2) format('woff2');
        }
        * {
            font-family: 'SeoulNamsanM';
        }

    </style>
</head>
<body>
<%--<%
    System.out.println("한글아 나와줄래.... (star...)");
%>--%>
    <jsp:include page="top.jsp"/>

    <section>
        <c:set var="contentpage" value="${param.page}"/>
        <c:choose>
            <c:when test="${empty contentpage || contentpage==''}">
                <jsp:include page="main/mainList.jsp"/>
            </c:when>
            <c:when test="admin.do">
                <jsp:include page="user/admin.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="${contentpage}"/>
            </c:otherwise>
        </c:choose>
    </section>

    <jsp:include page="footer.jsp" flush="true"/>
</body>
</html>
