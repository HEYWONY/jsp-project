<%--
  Created by IntelliJ IDEA.
  User: FULL8-007
  Date: 2024-04-22
  Time: 오후 4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>공지사항</title>
    <link rel="stylesheet" href="smr/css/boardwrite.css">
</head>
<body>
<div class="wrap">

    <div class="notice">
        <h3>공지사항 작성</h3>
    </div>

  <ul>
    <form method="post" action="board_result.do">
        <li>
            <label for="title">제목</label>
            <input type="text" name="title" id="title">
        </li>
        <li>
            <label for="content">내용</label>
            <textarea name="content" id="content" cols="30" rows="7"></textarea>
        </li>
        <li>
            <label for="writer">작성자</label>
            <input type="text" name="writer" id="writer">
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
