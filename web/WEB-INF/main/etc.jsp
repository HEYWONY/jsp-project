<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="indexCSS/list.css">
    <script defer src="indexCSS/heart.js"></script>
</head>
<body>

<c:set var="list" value="${requestScope.list}"/>
<c:set var="uid" value="${requestScope.uid}"/>
<c:set var="like_data" value="${requestScope.like_data}"/>
<c:set var="session_id" value="${sessionScope.id}"/>

<h1>교구</h1>
<form method="post" action="listResult.do">
    <select name="p_state" id="p_state">
        <option value="미개봉">미개봉</option>
        <option value="거의 새것">거의 새것</option>
        <option value="사용감 있음">사용감 있음</option>
    </select>
    <select name="p_trade" id="p_trade">
        <option value="직거래">직거래</option>
        <option value="택배거래">택배거래</option>
        <option value="직거래, 택배거래">직거래, 택배거래</option>
    </select>
    <input type="submit" value="전송">
</form>
<div class="list_ul">
    <c:forEach var="i" begin="0" end="${fn:length(list)-1}" step="1" varStatus="loop">
        <ul>
            <li class="mainList_li_1"><img class="list_img" src="productUpload/${item.p_img}" alt="${item.p_img}"></li>
            <c:choose>
                <c:when test="${list[i].p_cate == '기타'}">
                    <li class="mainList_li_etc">${list[i].p_cate}</li>
                </c:when>
                <c:otherwise>
                    <li class="mainList_li_ddk">미분류</li>
                </c:otherwise>
            </c:choose>
            <li class="mainList_li_3"><a href="product_detail.do?pid=${list[i].p_id}">${list[i].p_name}</a></li>
            <li class="mainList_li_4">₩${list[i].p_price}</li>
            <li class="mainList_li_5">${list[i].p_state}</li>

            <li class="mainList_li_6" id="fav${list[i].p_id}">
                <c:choose>
                    <c:when test="${empty session_id}">
                        <img src="indexImg/nolike.png" class="like" alt="빈하트" onclick="check(${list[i].p_id})"/>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${like_data[i]==0}"> <%--like_date가 0 -> 내가 좋아요 안 누름--%>
                                <img src="indexImg/nolike.png" class="like" alt="빈하트" onclick="check(${list[i].p_id})"/>
                            </c:when>
                            <c:otherwise>
                                <img src="indexImg/yeslike.png" class="like" alt="찬하트" onclick="check(${list[i].p_id})"/>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </c:forEach>
</div>

</body>
</html>

