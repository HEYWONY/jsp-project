<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="gsh_user/css/myPage.css">
    <title>마이페이지</title>
</head>
<body>
<%-- 로그인한 사용자 회원정보--%>
<c:set var="dto" value="${requestScope.dto}"/>
<%-- 판매자의 회원정보--%>
<c:set var="uid" value="${requestScope.uid}"/>
<c:set var="pdto" value="${requestScope.pdto}"/>
<%-- 교사 인증 여부--%>
<c:set var="teacher_ck" value="${requestScope.teacher_ck}"/>
<div class="wrap">
    <ul class="userInfo">
        <c:choose>
        <c:when test="${dto.u_id == uid || uid == 0 }">
        <li class="nickname">${dto.nickname}님</li>
        <li class="auth">${teacher_ck}</li>
        <li class="avg">
            <c:choose>
                <c:when test="${avg != 0.0}">
                    <img src="gsh_user/img/star.png" alt="star" id="img"> ${avg}
                </c:when>
                <c:otherwise>
                    아직 리뷰가 등록되지 않았어요!
                </c:otherwise>
            </c:choose>
        </li>
    </ul>
    <ul class="list">
        <li><a href="userModify.do?u_id=${dto.u_id}">프로필 보기</a></li>
        <li><a href="userFav.do?u_id=${dto.u_id}&id=${dto.id}">찜한 목록</a></li>
        <li><a href="userSaleList.do?u_id=${dto.u_id}">거래 내역</a></li>
        <li><a href="faqlist.do">FAQ</a></li>
        <li><a href="logout.do">로그아웃</a></li>
    </ul>
        <%-- 회원 탈퇴 구현해야함!! --%>
        <%-- <li><a href="userDelete.do?u_id=${dto.u_id}">회원탈퇴</a></li>--%>
    </c:when>
    <c:otherwise>
        <ul class="userInfo">
            <li class="nickname">${pdto.nickname}님</li>
            <li class="auth">${teacher_ck}</li>
            <li class="avg">
                <c:choose>
                <c:when test="${avg != 0.0}">
                <img src="gsh_user/img/star.png" alt="star" id="img"> ${avg}
                </c:when>
                <c:otherwise>
                아직 리뷰가 등록되지 않았어요!
                </c:otherwise>
                </c:choose>
        </ul>
        <ul class="list">
            <li><a href="userSaleList.do?u_id=${pdto.u_id}">거래 내역</a></li>
        </ul>
    </c:otherwise>
    </c:choose>

</div>
</body>

</html>
    