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
<%-- 로그인한 사용자 회원정보--%>
<c:set var="dto" value="${requestScope.dto}"/>
<%-- 판매자의 회원정보--%>
<c:set var="uid" value="${requestScope.uid}"/>
<c:set var="pdto" value="${requestScope.pdto}"/>
<%-- 교사 인증 체크 --%>
<c:set var="teachek_ck" value="${requestScope.teachek_ck}"/>
<%-- 회원 사진 --%>
<div>
<ul>
    <c:choose>
        <c:when test="${dto.u_id == uid || uid == 0 }">
            <li>${dto.nickname}님</li>
            <li>${teacher_ck}</li>
            <li><a href="userModify.do?u_id=${dto.u_id}">프로필 보기</a></li>
            <li><a href="userFav.do?u_id=${dto.u_id}&id=${dto.id}">찜한 목록</a></li>
            <li><a href="userSaleList.do?u_id=${dto.u_id}">거래 내역</a></li>
            <li><a href="#">FAQ</a></li>
            <li><a href="logout.do">로그아웃</a></li>
            <%-- 회원 탈퇴 구현해야함!! --%>
            <li><a href="userDelete.do?u_id=${dto.u_id}">회원탈퇴</a></li>
        </c:when>
        <c:otherwise>
            <li>${pdto.nickname}님</li>
            <li><a href="userSaleList.do?u_id=${pdto.u_id}">거래 내역</a></li>
        </c:otherwise>
    </c:choose>
</ul>
</div>
</body>

</html>
    