<%--
  Created by IntelliJ IDEA.
  User: FULL8-011
  Date: 2024-04-22
  Time: 오후 5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>전체매물</h1>
    <form method="post" action="listResult.do">
        <select>
            <option name="textbook">교재</option>
            <option name="adis">교구</option>
            <option name="handout">수업자료</option>
            <option name="etc">기타</option>
        </select>
        <select>
            <option name="good">미개봉</option>
            <option name="soso">거의 새것</option>
            <option name="bad">사용감 있음</option>
        </select>
        <select>
            <option name="delivery">직거래</option>
            <option name="meet">택배거래</option>
        </select>
        <input type="submit" value="전송">
    </form>
</body>
</html>
