<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="indexCSS/list.css">
    <link rel="stylesheet" href="gsh_user/css/fav.css">
    <script defer src="indexCSS/heart.js"></script>
    <title>찜한 목록</title>
</head>
<body>
<div class="wrap">
    <div class="fav">
        <h3>찜 목록</h3>
    </div>
    <c:set var="list" value="${requestScope.list}"/>
    <c:set var="u_id" value="${requestScope.u_id}"/>
    <c:set var="like_data" value="${requestScope.like_data}"/>
    <c:set var="session_id" value="${sessionScope.id}"/>

    <div class="list_ul1">
        <c:if test="${empty list}">
            <ul>
                <li class="txt">찜한 상품이 없습니다.</li>
                <li class="a"><a href="myPage.do?u_id=${id}">이전으로</a>
                <li class="a"><a href="index.do">홈으로</a></li>
            </ul>
        </c:if>
    </div>
    <div class="list_ul">
        <c:forEach var="i" begin="0" end="${fn:length(list) - 1}" step="1" varStatus="status">
            <ul>
                <li class="mainList_li_1"><img class="list_img" src="productUpload/${item.p_img}" alt="${item.p_img}">
                </li>
                <c:choose>
                    <c:when test="${list[i].p_cate == '교재'}">
                        <li class="mainList_li_textbook">${list[i].p_cate}</li>
                    </c:when>
                    <c:when test="${list[i].p_cate == '교구'}">
                        <li class="mainList_li_adis">${list[i].p_cate}</li>
                    </c:when>
                    <c:when test="${list[i].p_cate == '수업자료'}">
                        <li class="mainList_li_handout">${list[i].p_cate}</li>
                    </c:when>
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
                                    <img src="indexImg/nolike.png" class="like" alt="빈하트"
                                         onclick="check(${list[i].p_id})"/>
                                </c:when>
                                <c:otherwise>
                                    <img src="indexImg/yeslike.png" class="like" alt="찬하트"
                                         onclick="check(${list[i].p_id})"/>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </c:forEach>
    </div>
</div>
</body>
</html>
    