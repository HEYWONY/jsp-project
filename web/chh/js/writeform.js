function select_addr() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById("input_addr").value = addr;
        }
    }).open();
}

function changeFn() {
    let result ={};
    const ptrade = document.getElementById('ptrade');

    const address_choice = document.getElementById('address_choice_li');
    let address = document.getElementById('input_addr');

    result.ptrade = ptrade.options[ptrade.selectedIndex].value;
    console.log(result.ptrade); //테스트 코드

    if (result.ptrade==="deliver"){ //value값 한글로 설정하면 인식 못함
        address_choice.style.display='none';
        address.value='';
    } else {
        address_choice.style.display='block';
    }
}

window.onload=function (){ //수정 폼에서 로드 시 선택 되어 있는 거래 방식에 따라 주소 입력창 가시성 설정
    changeFn();
}