<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="gsh_user/css/saleList.css">
    <title>거래내역</title>
</head>
<body>
<c:set var="list" value="${requestScope.list}"/>
<h3>거래내역</h3>
<div id="wrap">

    <div class="trade">
        <h4><a href="userSaleList.do?u_id=${u_id}">판매내역</a></h4>
        <c:if test="${u_id == uid}">
            <h4><a href="userShoppingList.do?u_id=${u_id}">구매내역</a></h4>
        </c:if>
    </div>
    <div class="tradeState">
        <h5><a href="userSaleList.do?u_id=${u_id}">판매중</a></h5>
        <h5><a href="userSoldList.do?u_id=${u_id}">거래완료</a></h5>
    </div>


    <ul class="title board">
        <li class="fl tc w70 t t_line">품목</li>
        <li class="fl tc w500 t t_line">상품명</li>
        <li class="fl tc w120 t t_line">가격</li>
        <li class="fl tc w100 t t_line">등록일자</li>
        <li class="fl tc w100 t t_line">조회수</li>
        <li  class="fl tc w100 t t_line">찜수</li>
    </ul>
    <c:if test="${empty list}">
        <p>판매중인 자료가 없습니다.</p>
    </c:if>

    <c:if test="${!(empty list)}">
        <c:forEach var="item" items="${list}">
            <ul class="cntxt board">
                <li class="fl tc w70 list t_line lt_line">${item.p_cate}</li>
                <li class="fl tc w500 list t_line lt_line"><a href="product_detail.do?pid=${item.p_id}">${item.p_name}</a></li>
                <li class="fl tc w120 list t_line lt_line">${item.p_price}</li>
                <li class="fl tc w100 list t_line lt_line">${item.p_date}</li>
                <li class="fl tc w100 list t_line lt_line">${item.readno}</li>
                <li class="fl tc w100 list t_line lt_line">${item.p_fav}</li>
            </ul>
        </c:forEach>
    </c:if>
    <br>
</div>
</body>
</html>
    