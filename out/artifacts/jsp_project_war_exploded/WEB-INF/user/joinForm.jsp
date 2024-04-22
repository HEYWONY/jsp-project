<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="gsh_user/css/join.css">
    <title>회원가입</title>
</head>
<body>
<h2>회원가입</h2>
<form method="post" action="join_result.do" >
    <%-- 교사 증빙서류 등록--%>
    <ul>
        <li>교사인증</li>
        <li>
            <label for="uploadfile">증빙서류 등록</label><br>
            <input type="file" name="uploadfile" id="uploadfile">
        </li>
    </ul>

    <%-- 회원 가입 폼--%>
    <ul>
        <li>
            <label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름을 입력하세요." required>
        </li>
        <li>
            <label for="nickname">닉네임</label>
            <input type="text" id="nickname" name="nickname" placeholder="닉네임을 입력하세요." required>
        </li>
        <li>
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" required>
            <div></div>
        </li>
        <li>
            <label for="pw">비밀번호</label>
            <input type="password" id="pw" name="pw" required>
        </li>
        <li>
            <label for="pwdCk">비밀번호 확인</label>
            <input type="password" id="pwdCk" name="pwdCk" required>
        </li>
        <li>
            <label for="email">이메일</label>
            <input type="text" id="email" name="email" required>
            <input type="button" value="인증하기"><br>
            <input type="text" id="emailck" name="emailck" >
            <input type="button" value="인증번호 확인">
        </li>
        <li>
            <label>주소</label><br>
            <input type="text" name="addr1" id="sample6_postcode" placeholder="우편번호">
            <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
            <input type="text"  name="addr2" id="sample6_address" placeholder="주소"><br>
            <input type="text" name="addr3" id="sample6_detailAddress" placeholder="상세주소">
            <input type="text" id="sample6_extraAddress" placeholder="참고항목">
        </li>
        <li>
            <label for="phone">연락처</label>
            <input type="text" id="phone" name="phone" required>
        </li>
        <li>
            <input type="checkbox" name="agree" id="agree1">
            [필수] 만 14세이며 모두 동의합니다.
        </li>
        <li>
            <input type="checkbox" name="agree" id="agree2">
            [선택] 광고성 정보 수신에 모두 동의합니다.
        </li>
        <li>
            <input type="submit" value="가입하기">
        </li>
    </ul>
</form>

<%-- 카카오 주소 API--%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="gsh_user/js/addrPopup.js"></script>
</body>
</html>
    