<%--
  Created by IntelliJ IDEA.
  User: FULL8-007
  Date: 2024-04-24
  Time: 오후 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="smr/css/findid.css">
    <title>아이디 찾기</title>
</head>
<body>
<div class="wrap">
<h1 class="findid_title">아이디 찾기</h1>
<form method="post" action="findId_result.do">
    <ul>
        <div class="findbox">
            <li>
                <label for="name" class="findtitle" id="nametxt">이름</label>
                <input type="text" name="name" id="name" class="findinput" placeholder="이름을 입력하세요">
            </li>
            <li>
                <label for="email" class="findtitle" >이메일</label>
                <input type="text" name="email" id="email" class="findinput" placeholder="이메일을 입력하세요">
            </li>
        </div>
        <li>
            <input type="submit" class="findbtn" value="찾기">
        </li>
    </ul>
</form>
</div>


</body>
</html>
