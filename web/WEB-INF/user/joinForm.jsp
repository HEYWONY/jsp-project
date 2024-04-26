<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="gsh_user/css/join.css">
    <%-- 카카오 주소 API--%>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="gsh_user/js/addrPopup.js"></script>
    <%-- 회원가입 js --%>
    <script defer src="gsh_user/js/join.js"></script>
    <title>회원가입</title>
</head>
<body>
<div class="wrap">
    <h1>회원가입</h1>
    <form method="post" action="joinResult.do" name="userInfo">
        <%-- 교사 증빙서류 등록--%>

        <ul>
            <div class="joinForm">
            <li>
                <label  for="uploadfile" class="title">증빙서류 등록</label><br>
                <input type="file" name="uploadfile" id="uploadfile">
            </li>

            <%-- 회원 가입 폼--%>
            <li>
                <label for="name" class="title">이름 <span>*</span></label>
                <input type="text" id="name" name="name" class="joinInput" placeholder="이름을 입력하세요." required>
            </li>
            <li>
                <label for="nickname" class="title">닉네임 <span>*</span></label>
                <input type="text" id="nickname" name="nickname" class="joinInput" placeholder="닉네임을 입력하세요." required>
            </li>
            <li>
                <label for="id" class="title">아이디 <span>*</span></label>
                <input type="text" id="id" name="id" placeholder="영어 또는 숫자만 입력해주세요." class="joinInput2"
                       onkeydown="inputIdChk()" required>
                <input type="button" value="중복 확인" onclick="IdCheck(userInfo.id.value)" >
                <input type="hidden" name="idDuplication" value="idUncheck">
            </li>
            <div class="success-message hide"></div>
            <div class="failure-message hide">4 ~ 10글자 이내로 입력해주세요.</div>
            <div class="failure-message2 hide">영어 또는 숫자만 입력해주세요.</div>
            <li>
                <label for="pw" class="title">비밀번호 <span>*</span></label>
                <input type="password" id="pw" name="pw" class="joinInput" placeholder="영문, 숫자, 특수문자 8자 이상 입력해주세요."
                       required>
            </li>
            <li>
                <label for="pwdCk" class="title">비밀번호 확인 <span>*</span></label>
                <input type="password" id="pwdCk" name="pwdCk" class="joinInput" placeholder="비밀번호를 확인해주세요." required>
            </li>
            <div class="mismatch-message hide">비밀번호가 일치하지 않습니다.</div>
            <li>
                <label for="email" class="title" >이메일 <span>*</span></label>
                <input type="text" id="email" name="email" class="joinInput" required placeholder="pasam@gmail.com">
                <%--                <input type="button" value="인증하기"><br>--%>
                <%--                <input type="text" id="emailck" name="emailck" class="joinInput">--%>
                <%--                <input type="button" value="인증번호 확인">--%>
            </li>
           <%-- <li>
                <label class="title">주소</label>
                <input type="text" name="addr1" class="joinInput2" id="postcode" placeholder="우편번호">
                <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
                <input type="text" name="addr2" class="joinInput" id="address" placeholder="주소"><br>
                <input type="text" name="addr3" class="joinInput" id="detailAddress" placeholder="상세주소">
                <input type="text" id="extraAddress" class="joinInput" placeholder="참고항목">
            </li>--%>
            <li>
                <label for="phone" class="title">연락처</label>
                <input type="text" id="phone" name="phone" class="joinInput" placeholder="010-1919-1919" required>
            </li>
            </div>
            <li>
                <input type="checkbox" name="agree" id="agree1" required>
                [필수] 만 14세이며 모두 동의합니다.
            </li>
            <li>
                <input type="checkbox" name="agree" id="agree2">
                [선택] 광고성 정보 수신에 모두 동의합니다.
            </li>
            <li>
                <input type="submit" value="가입하기" class="join">
                <input type="reset" value="취소" class="reset">
            </li>
        </ul>
    </form>
</div>
</body>
<script>
    function IdCheck(id) {
        var url;
        if (id === "") {
            alert("아이디를 입력하세요");
            document.userInfo.id.focus();
        } else {
            url = "idCheck.do?id="+id;
            window.open(url, "post", "width=300 height=200");
        }
    }
</script>


</html>
    