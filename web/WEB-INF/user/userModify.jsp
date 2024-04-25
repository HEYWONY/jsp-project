<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%-- 카카오 주소 API--%>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="gsh_user/js/addrPopup.js"></script>
    <title>프로필 수정</title>
</head>
<body>
<%-- 로그인한 user 정보 가져오기 --%>
<%--<c:set var="userDto" value="${requestScope.dto}"/>--%>
<%-- 프로필 수정 폼 --%>
<form method="post" action="userModifyResult.do">
    <ul>
        <li>
            <label>사진 영역</label>
            <input type="button" value="수정">
            <input type="button" value="삭제">
        </li>
        <li>
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" value="${id}" readonly>
        </li>
        <li>
            <label for="name">이름</label>
            <input type="text" id="name" name="name" value="${name}" required>
        </li>
        <li>
            <label for="nickname">닉네임</label>
            <input type="text" id="nickname" name="nickname" value="${nickname}" required>
        </li>
        <li>
            <label>주소</label><br>
            <input type="text" name="addr1" id="postcode" placeholder="우편번호" value="${addr1}">
            <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
            <input type="text" name="addr2" id="address" placeholder="주소" value="${addr2}"><br>
            <input type="text" name="addr3" id="detailAddress" placeholder="상세주소" value="${addr3}">
            <input type="text" name="" id="extraAddress" value="">
        </li>
        <li>
            <label for="phone">휴대전화</label>
            <input type="text" id="phone" name="phone" value="${phone}">
        </li>
        <li>
            <label for="email">이메일</label>
            <input type="text" id="email" name="email" value="${email}">
            <input type="button" value="중복확인"><br>
        </li>
        <li>
            <input type="submit" value="수정" id="modify">
            <input type="reset" value="취소">
        </li>

    </ul>
</form>
<script>
    document.getElementById('modify').onclick = function () {
        alert("회원 정보 수정 완료되었습니다.");
        location.href = "myPage.do?id=${id}";
    }
</script>
</body>
</html>
    