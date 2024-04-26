<%--
  Created by IntelliJ IDEA.
  User: FULL8-007
  Date: 2024-04-26
  Time: 오전 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .wrap {
            margin: 0 auto;
            display: flex;
            flex-direction: row;
            justify-content: space-evenly;
            list-style: none;
            max-width: 1200px;
        }
        h2{
            margin: 0 auto;
            padding-top: 50px;
            left: 50px;
            max-width: 1200px;
            /*border-bottom: 2px solid black;*/
        }
    </style>
    <link rel="stylesheet" href="smr/css/admin.css">
</head>
<body>
    <article>
        <h2>관리자 페이지</h2>

        <div class="wrap">
            <jsp:include page="adminCkpage.jsp"/>
            <jsp:include page="adminUlist.jsp"/>
        </div>
    </article>
</body>
</html>
