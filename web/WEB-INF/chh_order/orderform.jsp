<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="chh/js/orderform.js"></script>

    <link rel="stylesheet" href="chh/css/ripple.css">
    <link rel="stylesheet" href="chh/css/orderform.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.ripples/0.5.3/jquery.ripples.min.js"></script>
</head>
<body>
<c:set var="dto" value="${requestScope.pdto}"/>
<div id="wrap">
    <div class="full-landing-image">
    <form method="post" action="order_confirm.do">
        <h2 class="form_title">주문서 작성</h2>
        <div>
            <div id="product_detail_1">
                <img id="pimg" src="productUpload/${dto.p_img}" alt="${dto.p_img}">

                <section>
                    <ul>
                        <li>
                            <h2>${dto.p_name}</h2>
                            <input type="hidden" name="pname" id="pname" value="${dto.p_name}">
                            <input type="hidden" name="pid" id="pid" value="${dto.p_id}">
                        </li>
                        <li class="font_big">
                            <span>₩ </span><span id="price">${dto.p_price}</span>
                            <input type="hidden" name="pprice" id="pprice" value="${dto.p_price}">
                        </li>

                        <div class="line"></div>

                        <div>
                            <li class="font_big">
                                <input type="hidden" name="pstock" id="pstock" value="${dto.p_stock}">
                                <label for="ocnt">수량</label><br>
                                <label id="minus_btn">-</label>
                                <input class="input_text" type="text" min="1" name="ocnt" id="ocnt" value=1 readonly>
                                <label id="plus_btn">+</label>
                            </li>
                            <li class="font_big">
                                <span id="total_pay"></span>
                            </li>
                        </div>
                    </ul>
                </section>

            </div>


            <section>
                <ul>
                    <li>
                        <label class="field" for="oname">주문자 이름</label><br>
                        <input class="input_text" type="text" name="oname" id="oname" placeholder="주문자 이름을 입력하세요." required>
                    </li>
                    <li>
                        <label class="field" for="ophone">전화 번호</label><br>
                        <input class="input_text" type="tel" name="ophone" id="ophone" placeholder="전화번호를 입력하세요." required>
                    </li>
                    <li>
                        <label class="field">배송지 입력</label><br>
                        <input class="input_text" type="text" id="postcode" name="addr1" placeholder="우편번호" readonly>
                        <input class="form_btn" type="button" onclick="find_postcode()" value="우편번호 찾기"><br>
                        <input class="input_text" type="text" id="address" name="addr2" placeholder="주소" readonly><br>
                        <input class="input_text" type="text" id="detailAddress" name="addr3" placeholder="상세주소">
                        <input class="input_text" type="text" id="extraAddress" name="addr4" placeholder="참고항목">
                    </li>
                    <li>
                        <label class="field" for="omemo">배송 메모</label><br>
                        <textarea name="omemo" id="omemo" cols="30" rows="3"></textarea>
                    </li>
                    <li>
                        <div class="button_sort">
                            <button class="form_btn" type="submit" id="order_btn">주문하기</button>
                        </div>
                    </li>
                </ul>
            </section>
        </div>
    </form>
    </div>
</div>
<script>
    $(".full-landing-image").ripples({
        resolution: 256, // 렌더링 값이 클수록 잔물결 효과가 느리게 전파
        perturbance: 0.04, // 잔물경 굴절 강도. 0은 굴절 없음
    });
</script>
</body>
</html>
