/* 아이디 비밀번호 유효성 검사 */
// 아이디 정보
let elInputId = document.querySelector('#id');  // id
let elSuccessMessage = document.querySelector('.success-message'); // 성공 메세지
let elFailureMessage = document.querySelector('.failure-message'); // 실패 메세지 (글자수 제한)
let elFailureMessage2 = document.querySelector('.failure-message2');    // 실패 메세지 (영어, 숫자)

// 비밀번호 정보
let elInputPw = document.querySelector('#pw');  // Password
let elInputPwCk = document.querySelector('#pwdCk'); // 비밀번호 확인 입력창
let elMismatch = document.querySelector('.mismatch-message');   // 비밀번호 불일치 메세지
let elStrongPw = document.querySelector('.strongPw-message');   // 비밀번호 실패 정보

/* 유효성 검증 */
/* 아이디 : 글자수 제한(4~10자) */
function  idLength(value) {
    return value.length >= 4 && value.length <= 10
}

/* 아이디 : 영어 or 숫자만 가능 */
function onlyEngNum(str) {
    return /^[A-Za-z0-9][A-Za-z0-9]*$/.test(str);
}  // 영어 또는 숫자 들어가면 true, 아니면 false 리턴

/* 비밀번호 : 8자 이상 + 영문, 숫자, 특수문자 사용*/
function strongPassword (str) {
    return /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/.test(str);
}   // 8글자 이상 & 알파벳/숫자/특수문자 포함 일때 true, 아니면 false

/* 비밀번호 확인*/
function isMatch(password1, password2) {
    return password1 === password2;
}

/* 아이디 이벤트 */
elInputId.onkeyup = function () {
    // 값을 입력한 경우
    if (elInputId.value.length !== 0) {
        // 영어 또는 숫자 외의 값을 입력했을 경우
        if(onlyEngNum(elInputId.value) === false) {
            elSuccessMessage.classList.add('hide');
            elFailureMessage.classList.add('hide');
            elFailureMessage2.classList.remove('hide'); // 영어 또는 숫자만 가능합니다
        }
        // 글자 수가 4~10글자가 아닐 경우
        else if(idLength(elInputId.value) === false) {
            elSuccessMessage.classList.add('hide'); // 성공 메시지가 가려져야 함
            elFailureMessage.classList.remove('hide'); // 아이디는 4~10글자이어야 합니다
            elFailureMessage2.classList.add('hide'); // 실패 메시지2가 가려져야 함
        }
        // 조건을 모두 만족할 경우
        else if(idLength(elInputId.value) || onlyEngNum(elInputId.value)) {
            elSuccessMessage.classList.remove('hide'); // 사용할 수 있는 아이디입니다
            elFailureMessage.classList.add('hide'); // 실패 메시지가 가려져야 함
            elFailureMessage2.classList.add('hide'); // 실패 메시지2가 가려져야 함
        }
    }
    // 값을 입력하지 않은 경우 (지웠을 때) 모든 메시지를 가린다.
    else {
        elSuccessMessage.classList.add('hide');
        elFailureMessage.classList.add('hide');
        elFailureMessage2.classList.add('hide');
    }
}

/* 비밀번호 이벤트 */
elInputPw.onkeyup = function () {

    // console.log(elInputPassword.value);
    // 값을 입력한 경우
    if (elInputPw.value.length !== 0) {
        if (strongPassword(elInputPw.value)) {
            elStrongPw.classList.add('hide'); // 실패 메시지가 가려져야 함
        }
        // 에러 메세지 확인
        else {
            elStrongPw.classList.remove('hide'); // 실패 메시지가 보여야 함
        }
    }
            // 값을 입력하지 않은 경우 (지웠을 때)
        // 모든 메시지를 가린다.
        else {
            elStrongPw.classList.add('hide');
        }
    // }
};

/* 비밀번호 확인 */
elInputPwCk.onkeyup = function () {

    // console.log(elInputPasswordRetype.value);
    if (elInputPwCk.value.length !== 0) {
        if(isMatch(elInputPw.value, elInputPwCk.value)) {
            elMismatch.classList.add('hide'); // 실패 메시지가 가려져야 함
        }
        else {
            elMismatch.classList.remove('hide'); // 실패 메시지가 보여야 함
        }
    }
    else {
        elMismatch.classList.add('hide'); // 실패 메시지가 가려져야 함
    }
};
