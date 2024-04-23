<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%-- 카카오 주소 API--%>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="gsh_user/js/addrPopup.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="gsh_user/css/join.css">
    <%-- 회원가입 js --%>
    <script defer src="gsh_user/js/join.js"></script>
    <title>회원가입</title>
</head>
<body>
<%-- 마이페이지(TEST) --%>
<a href="myPage.do"><h5>마이페이지 TEST</h5></a>

<h2>회원가입</h2>
<form method="post" action="joinResult.do" >
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
            <input type="text" id="id" name="id"placeholder="영어 또는 숫자만 입력해주세요." required>
            <input type="button" id="btn" value="중복 확인"><br>
        </li>
        <div class="success-message hide">사용할 수 있는 아이디입니다.</div>
        <div class="failure-message hide">4 ~ 10글자 이내로 입력해주세요.</div>
        <div class="failure-message2 hide">영어 또는 숫자만 입력해주세요.</div>
        <li>
            <label for="pw">비밀번호</label>
            <input type="password" id="pw" name="pw"  placeholder="영문, 숫자, 특수문자 8자 이상 입력해주세요." required>
        </li>


        <li>
            <label for="pwdCk">비밀번호 확인</label>
            <input type="password" id="pwdCk" name="pwdCk" required>
        </li>
        <div class="mismatch-message hide">비밀번호가 일치하지 않습니다.</div>
        <li>
            <label for="email">이메일</label>
            <input type="text" id="email" name="email" required>
            <input type="button" value="인증하기"><br>
            <input type="text" id="emailck" name="emailck" >
            <input type="button" value="인증번호 확인">
        </li>
        <li>
            <label>주소</label><br>
            <input type="text" name="addr1" id="postcode" placeholder="우편번호">
            <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
            <input type="text"  name="addr2" id="address" placeholder="주소"><br>
            <input type="text" name="addr3" id="detailAddress" placeholder="상세주소">
            <input type="text" name="addr4" id="extraAddress" placeholder="참고항목">
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



</body>
</html>
    