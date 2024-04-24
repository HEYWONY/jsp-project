<%--
  Created by IntelliJ IDEA.
  User: FULL8-011
  Date: 2024-04-22
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="indexCSS/mainList.css">
</head>
<body>
<c:set var="list" value="${requestScope.list}"/>
<c:set var="list2" value="${requestScope.list2}"/>
<%-- 메인에 있는 애--%>
<article>
    <%-- 캐러셀 들어갈 공간... 임시 이미지가 들어가있어요 --%>
    <img class="main_img_1"src="indexImg/main.png" alt="index"/>
</article>
<article>
    <%-- 메인 페이지에서 최신 물품 나오는 곳, 최대 5개 제한 시간 --%>
    <h1>최신 물품</h1>
    <div class="mainList1">
        <c:forEach var="item" items="${list}">
            <ul>
                <li class="mainList_li_1"><img class="list_img" src="productUpload/${item.p_img}" alt="${item.p_img}"></li>
                <li class="mainList_li_2">${item.p_cate}</li>
                <li class="mainList_li_3"><a href="product_detail.do?pid=${item.p_id}">${item.p_name}</a></li>
                <li class="mainList_li_4">₩${item.p_price}</li>
                <li class="mainList_li_5">${item.p_state}</li>
                <li class="mainList_li_6">${item.p_fav}</li>
            </ul>
        </c:forEach>
    </div>
</article>
<article>
    <%-- 메인 페이지에서 인기 상품 나오는 공간, 근 일주일 내에 가장 많은 조회수를 기록한 게시물 보여줌 무한 스크롤링 --%>
    <h1>인기 상품</h1>
    <div class="mainList2">
        <c:forEach var="item" items="${list2}">
            <ul>
                <li class="mainList_li_1"><img class="list_img" src="productUpload/${item.p_img}" alt="${item.p_img}"></li>
                <li class="mainList_li_2">${item.p_cate}</li>
                <li class="mainList_li_3"><a href="product_detail.do?pid=${item.p_id}">${item.p_name}</a></li>
                <li class="mainList_li_4">₩${item.p_price}</li>
                <li class="mainList_li_5">${item.p_state}</li>
                <li class="mainList_li_6">${item.p_fav}</li>
            </ul>
        </c:forEach>
    </div>
</article>
</body>
</html>
