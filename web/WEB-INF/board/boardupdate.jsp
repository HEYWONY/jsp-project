<%--
  Created by IntelliJ IDEA.
  User: FULL8-007
  Date: 2024-04-22
  Time: 오후 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>공지사항</title>
    <link rel="stylesheet" href="smr/css/boardupdate.css">
</head>
<body>
<c:set var="dto" value="${requestScope.dto}"></c:set>

<div class="wrap">

    <div class="notice">
        <h3>공지사항 수정</h3>
    </div>

    <ul>
        <form method="post" action="board_update_result.do">
            <input type="hidden" name="b_no" value="${dto.b_no}">
            <li>
                <label for="title">제목</label>
                <input type="text" name="title" id="title" value="${dto.title}">
            </li>
            <li>
                <label for="content">내용</label>
                <textarea name="content" id="content" cols="30" rows="7">${dto.content}</textarea>
            </li>
            <li class="btn">
                <button type="submit">등록</button>
                <button type="reset">취소</button>
            </li>
        </form>
    </ul>

</div>
</body>
</html>
