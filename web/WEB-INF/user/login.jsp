<%--
  Created by IntelliJ IDEA.
  User: FULL8-007
  Date: 2024-04-24
  Time: 오전 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script defer src="smr/js/login.js"></script>
  <link rel="stylesheet" href="smr/css/login.css">
    <title>로그인</title>
</head>
<body>

<div class="wrap">

  <h1 class="lo_title">로그인</h1>
<form method="post" action="login_result.do">
  <ul>
    <div class="loginbox">
    <li>
      <label for="id" class="logintitle">아이디</label>
      <input type="text" name="id" id="id" class="logininput" placeholder="ID">
    </li>
    <li>
      <label for="pw" class="logintitle" id="pwtxt">비밀번호</label>
      <input type="password" name="pw" id="pw" class="logininput" placeholder="PASSWORD">
    </li>
    </div>
    <li>
      <input type="submit" class="loginbtn" value="로그인">
    </li>
      <a href="join.do" class="join">회원가입</a>
      <a href="#" class="idsearch">아이디 찾기</a>
      <a href="#" class="pwsearch">비밀번호 찾기</a>

  </ul>
</form>

</div>

</body>
</html>
