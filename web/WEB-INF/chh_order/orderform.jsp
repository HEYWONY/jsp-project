<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="chh/css/product_detail.css">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="chh/js/orderform.js"></script>
</head>
<body>
<c:set var="dto" value="${requestScope.pdto}"/>
<div id="wrap">
    <form>
        <div>
            <div id="product_detail_1">
                <img id="pimg" src="productUpload/${dto.p_img}" alt="${dto.p_img}">

                <section>
                    <ul>
                        <li>
                            <h2>${dto.p_name}</h2>
                        </li>
                        <li>
                            <h3 id="price">${dto.p_price}</h3>
                        </li>

                        <hr>

                        <div>
                            <li>
                                <input type="hidden" id="p_stock" value="${dto.p_stock}">
                                <label for="ocnt">수량</label><br>
                                <label id="minus_btn">-</label>
                                <input type="text" min="1" name="ocnt" id="ocnt" value=1 readonly>
                                <label id="plus_btn">+</label>
                            </li>
                            <li>
                                <p id="total_pay"></p>
                            </li>
                        </div>
                    </ul>
                </section>

            </div>


            <section>
                <ul>
                    <li>
                        <label for="oname">주문자 이름</label><br>
                        <input type="text" name="oname" id="oname" placeholder="주문자 이름을 입력하세요." required>
                    </li>
                    <li>
                        <label for="ophone">전화 번호</label><br>
                        <input type="tel" name="ophone" id="ophone" placeholder="전화번호를 입력하세요." required>
                    </li>
                    <li>
                        <label>배송지 입력</label><br>
                        <input type="text" id="postcode" name="addr1" placeholder="우편번호">
                        <input type="button" onclick="find_postcode()" value="우편번호 찾기"><br>
                        <input type="text" id="address" name="addr2" placeholder="주소"><br>
                        <input type="text" id="detailAddress" name="addr3" placeholder="상세주소">
                        <input type="text" id="extraAddress" name="addr4" placeholder="참고항목">
                    </li>
                    <li>
                        <label for="omemo">배송 메모</label><br>
                        <textarea name="omemo" id="omemo"></textarea>
                    </li>
                    <li>
                        <a href="#">뒤로가기</a>
                        <button type="submit" id="order_btn">결제하기</button>
                    </li>
                </ul>
            </section>
        </div>
    </form>
</div>

</body>
</html>
