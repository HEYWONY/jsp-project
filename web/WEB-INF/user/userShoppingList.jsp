<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="gsh_user/css/saleList.css">
    <title>구매내역</title>
</head>
<body>
<c:set var="list" value="${requestScope.list}"/>

<h3>거래내역</h3>
<div id="wrap">

    <div class="trade">
        <h4><a href="userSaleList.do?u_id=${u_id}">판매내역</a></h4>
        <h4><a href="userShoppingList.do?u_id=${u_id}">구매내역</a></h4>
    </div>
    <ul>
        <li>품목</li>
        <li>상품명</li>
        <li>가격</li>
        <li>구매일자</li>
        <li></li>
    </ul>
    <c:if test="${empty list}">
        <p>구매한 내역이 없습니다.</p>
    </c:if>

    <c:if test="${!(empty list)}">
        <c:forEach var="item" items="${list}">
            <ul>
                <li>${item.p_cate}</li>
                <li><a href="product_detail.do?pid=${item.p_id}">${item.p_name}</a></li>
                <li>${item.p_price}</li>
                <li>${item.o_date}</li>
                <li><a href="review.do?pid=${item.p_id}&id=${id}&u_id=${u_id}">리뷰하기</a></li>
            </ul>
        </c:forEach>
    </c:if>
    <br>
</div>
</body>
</html>
