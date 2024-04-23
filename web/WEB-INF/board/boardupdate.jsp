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
    <title>Title</title>
</head>
<body>
<c:set var="dto" value="${requestScope.dto}"></c:set>
<ul>
    <form method="post" action="board_update_result.do">
        <li>
            <label for="b_no">번  호</label>
            <input type="text" name="b_no" id="b_no" value="${dto.b_no}" readonly><br>
        </li>
        <li>
            <label for="title">제목</label>
            <input type="text" name="title" id="title" value="${dto.title}">
        </li>
        <li>
            <label for="content">내용</label>
            <textarea name="content" id="content" cols="30" rows="7">${dto.content}</textarea>
        </li>
        <li>
            <button type="submit">등록</button>
            <button type="reset">취소</button>
        </li>
    </form>
</ul>

</body>
</html>
