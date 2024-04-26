<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="indexCSS/list.css">
    <title>찜한 목록</title>
</head>
<body>
<h3>찜 목록</h3>
<c:set var="list" value="${requestScope.list}"/>
<div class="list_ul">
    <c:if test="${empty list}">
        <ul>
        <li>찜한 상품이 없습니다.</li>
        <li><a href="myPage.do?u_id=${id}">이전으로</a></li>
        <li><a href="index.do">홈으로</a></li>
        </ul>
    </c:if>
    <c:forEach var="item" items="${list}">
        <ul>
            <li class="mainList_li_1"><img class="list_img" src="productUpload/${item.p_img}" alt="${item.p_img}"></li>
            <c:choose>
                <c:when test="${item.p_cate == '교재'}">
                    <li class="mainList_li_textbook">${item.p_cate}</li>
                </c:when>
                <c:when test="${item.p_cate == '교구'}">
                    <li class="mainList_li_adis">${item.p_cate}</li>
                </c:when>
                <c:when test="${item.p_cate == '수업자료'}">
                    <li class="mainList_li_handout">${item.p_cate}</li>
                </c:when>
                <c:when test="${item.p_cate == '기타'}">
                    <li class="mainList_li_etc">${item.p_cate}</li>
                </c:when>
                <c:otherwise>
                    <li class="mainList_li_ddk">미분류</li>
                </c:otherwise>
            </c:choose>
            <li class="mainList_li_3"><a href="product_detail.do?pid=${item.p_id}">${item.p_name}</a></li>
            <li class="mainList_li_4">₩${item.p_price}</li>
            <li class="mainList_li_5">${item.p_state}</li>
            <li class="mainList_li_6">${item.p_fav}</li>
        </ul>
    </c:forEach>
</div>
</body>
</html>
    