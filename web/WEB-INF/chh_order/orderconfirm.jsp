<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="chh/css/ripple.css">
    <link rel="stylesheet" href="chh/css/orderconfirm.css">
    <script src="chh/js/ripple.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.ripples/0.5.3/jquery.ripples.min.js"></script>

</head>
<body>
<c:set var="pid" value="${requestScope.pid}"/>
<c:set var="pname" value="${requestScope.pname}"/>
<c:set var="pprice" value="${requestScope.pprice}"/>
<c:set var="ocnt" value="${requestScope.ocnt}"/>
<c:set var="total" value="${requestScope.total}"/>
<c:set var="oname" value="${requestScope.oname}"/>
<c:set var="ophone" value="${requestScope.ophone}"/>
<c:set var="oaddr" value="${requestScope.oaddr}"/>
<c:set var="omemo" value="${requestScope.omemo}"/>

<div id="wrap">
    <div class="full-landing-image">
        <section id="confirm_info">
            <div class="form_title">
                <h1>주문확인서</h1>
                <h6 class="info_txt">주문 정보를 다시 한 번 확인해 주세요.</h6>
            </div>
            <div class="line"></div>
            <div id="order_info">
                <ul>
                    <input type="hidden" id="pid" value=${pid}>
                    <li>
                        <span class="field">상품명: </span>
                        <span class="info" id="pname">${pname}</span>
                    </li>
                    <li>
                        <span class="field">가격: </span>
                        <span class="info" id="pprice">${pprice}</span>
                        <span>원</span>
                    </li>
                    <li>
                        <span class="field">수량: </span>
                        <span class="info" id="ocnt">${ocnt}</span>
                        <span>개</span>
                    </li>
                    <li class="strong_info">
                        <span class="field">총 결제금액: </span>
                        <span class="info" id="total">${total}</span>
                        <span>원</span>
                    </li>
                    <li>
                        <span class="field">주문자 이름: </span>
                        <span class="info" id="oname">${oname}</span>
                    </li>
                    <li>
                        <span class="field">전화 번호: </span>
                        <span class="info" id="ophone">${ophone}</span>
                    </li>
                    <li>
                        <span class="field">배송지 주소: </span>
                        <span class="info" id="oaddr">${oaddr}</span>
                    </li>
                    <li>
                        <span class="field">배송 방법: </span>
                        <span class="info"> 택배 </span>
                    </li>
                    <li>
                        <span class="field">배송 메모: </span>
                        <input class="info" id="omemo" readonly value="${omemo}">
                    </li>
                    <li>
                        <div class="end_btn"><button id="pay_btn">결제하기</button></div>
                    </li>
                </ul>
            </div>

        </section>
    </div>
</div>

<!--포트원(아임포트) 라이브러리 추가 코드-->
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<!--paytest.js 연결 (결제 시스템)-->
<script src="chh/js/orderpay.js" ></script>

</body>
</html>
