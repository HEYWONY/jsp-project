<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
</head>
<body>
<
<c:set var="dto" value="${requestScope.dto}"/>
<%-- 회원 사진 --%>
<p>${dto.nickname}님</p>
<p>${teacher_ck}</p>
<ul>
    <li><a href="userModify.do">프로필 보기</a></li>
    <li><a href="">찜한 목록</a></li>
    <li><a href="userSaleList.do?u_id=${dto.u_id}">거래 내역</a></li>
    <li><a href="">FAQ</a></li>
    <li><a href="">로그아웃</a></li>
    <%-- 회원 탈퇴 만들기 --%>
</ul>
</div>
</body>
<script>
    // 사진 수정버튼 클릭시
    document.getElementById('btn').onclick = function () {
        // location =
    }
</script>
</html>
    