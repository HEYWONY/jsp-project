IMP.init('imp43374577'); //아임포트 고객사 식별 코드

//html에서 각 요소(버튼, 텍스트 데이터)들을 가져옴
const button = document.querySelector("button");

const pid = document.getElementById('pid').value;
const pname = document.getElementById('pname').textContent;
const total_price = document.getElementById('total').textContent;
const order_name = document.getElementById('oname').textContent;
const order_phone = document.getElementById('ophone').textContent;
const order_addr = document.getElementById('oaddr').textContent;
const post_memo = document.getElementById('omemo').value;
const order_count = document.getElementById('ocnt').textContent;

const order_no_random = "order_test_"+(Math.random()*100) //주문번호가 동일하면 같은 결제 반복. 랜덤으로 생성(임시)

//결제 버튼을 눌렀을 때 실행할 함수
const onClickPay = async () => {
    //결제 정보를 넘김
    IMP.request_pay({
        //pg사 선택 가능
        pg:"kakaopay"
        //pg:"tosspayments"
        //pg:"html5_inicis"
        , pay_method: "card"
        , amount: total_price.toString()
        , name: pname.toString()
        , merchant_uid: order_no_random.toString()
        , buyer_name: order_name.toString()
        , buyer_tel: order_phone.toString()
        , buyer_addr: order_addr.toString()
    }, function (response) { //reponse 객체 내부에서 유저가 수행한 작업에 대한 정보를 가져올 것임
        // 결제가 성공적으로 완료된 경우, 유저가 결제창을 닫을 때 호출될 경우 호출

        if ( response.success ) { //결제 성공 시
            pay_info(response);

        } else {
            alert(response.error_msg);
            location.href=`product_detail.do?pid=${pid}`;
        }

    });
};

function pay_info(rsp){ //결제 정보를 다른 곳으로 넘기는 작업(JS->JSP/Servlet)

    // form에 input태그를 이용해서 넘김

    let form = document.createElement('form');
    let objs;

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'pid');
    objs.setAttribute('value', pid);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'ocnt');
    objs.setAttribute('value', order_count);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'ophone');
    objs.setAttribute('value', rsp.buyer_tel);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'oaddr');
    objs.setAttribute('value', rsp.buyer_addr);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'omemo');
    objs.setAttribute('value', post_memo); //rsp에서 받아올 수 없는 데이터도 이처럼 넘길 수 있음
    form.appendChild(objs);

    form.setAttribute('method', 'post');
    form.setAttribute('action', "order_pay.do"); // 결제 성공 시 주문 정보 데이터 베이스에 입력
    document.body.appendChild(form);
    form.submit();
}

button.addEventListener("click", onClickPay); // 버튼 클릭 시 onClickPay 메소드 호출