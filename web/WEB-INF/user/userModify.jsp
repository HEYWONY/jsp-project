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
    <link rel="stylesheet" href="gsh_user/css/modify.css">
    <title>프로필 수정</title>
</head>
<body>
<%-- 프로필 수정 폼 --%>
<div class="wrap">
    <h3 class="title">프로필 보기</h3>
    <form method="post" action="userModifyResult.do">
        <ul class="modify">
            <li>
                <label for="id">아이디 <span>*</span></label>
                <input type="text" id="id" name="id" value="${id}" class="input" readonly>
            </li>
            <li>
                <label for="name">이름 <span>*</span></label>
                <input type="text" id="name" name="name" value="${name}" class="input" required>
            </li>
            <li>
                <label for="nickname">닉네임 <span>*</span></label>
                <input type="text" id="nickname" name="nickname" value="${nickname}" class="input" required>
            </li>
            <li>
                <label>주소</label><br>
                <input type="text" name="addr1" id="postcode" placeholder="우편번호" class="addr1" value="${addr1}">
                <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="find"><br>
                <input type="text" name="addr2" id="address" placeholder="주소" value="${addr2}" class="input"><br>
                <input type="text" name="addr3" id="detailAddress" placeholder="상세주소" value="${addr3}" class="addr3">
                <input type="text" name="" id="extraAddress" value="" class="addr3">
            </li>
            <li>
                <label for="phone">휴대전화</label>
                <input type="text" id="phone" name="phone" value="${phone}" class="input">
            </li>
            <li>
                <label for="email">이메일 <span>*</span></label>
                <input type="text" id="email" name="email" value="${email}" class="input">
<%--                <input type="button" id="emailCk" value="중복확인" class="find"><br>--%>
            </li>
            <li>
                <input type="reset" value="취소" class="reset">
                <input type="submit" value="수정" id="modify" class="submit">
            </li>

        </ul>
    </form>
</div>
<script>
    document.getElementById('modify').onclick = function () {
        alert("회원 정보 수정 완료되었습니다.");
        location.href = "myPage.do?id=${id}";
    }
    /*
    document.getElementById('emailck').onclick = function () {

    }
    */
</script>
</body>
</html>
    