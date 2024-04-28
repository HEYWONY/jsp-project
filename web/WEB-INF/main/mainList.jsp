<%--
  Created by IntelliJ IDEA.
  User: FULL8-011
  Date: 2024-04-22
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="indexCSS/mainList.css">
    <script defer src="indexCSS/heart.js"></script>
</head>
<body>
<c:set var="list" value="${requestScope.list}"/>
<c:set var="list2" value="${requestScope.list2}"/>
<c:set var="uid" value="${requestScope.uid}"/>
<c:set var="like_data" value="${requestScope.like_data}"/>
<c:set var="session_id" value="${sessionScope.id}"/>

<%-- 메인에 있는 애--%>
<article>
    <%-- 캐러셀 들어갈 공간... 임시 이미지가 들어가있어요 --%>
    <img class="main_img_1"src="indexImg/main.png" alt="index"/>
</article>
<article>
    <%-- 메인 페이지에서 최신 물품 나오는 곳, 최대 5개 제한 시간 --%>
    <h1>최신 물품</h1>
    <div class="mainList1">
        <c:forEach var="i" begin="0" end="${fn:length(list)-1}" step="1" varStatus="loop">
            <ul>
                <li class="mainList_li_1"><img class="list_img" src="productUpload/${item.p_img}" alt="${item.p_img}"></li>
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
                            <img src="indexImg/nolike.png" class="like" alt="빈하트" onclick="check(${list2[i].p_id})"/>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${like_data[i]==0}"> <%--like_date가 0 -> 내가 좋아요 안 누름--%>
                                    <img src="indexImg/nolike.png" class="like" alt="빈하트" onclick="check(${list2[i].p_id})"/>
                                </c:when>
                                <c:otherwise>
                                    <img src="indexImg/yeslike.png" class="like" alt="찬하트" onclick="check(${list2[i].p_id})"/>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </c:forEach>
    </div>
</article>
<article>
    <%-- 메인 페이지에서 인기 상품 나오는 공간, 근 일주일 내에 가장 많은 조회수를 기록한 게시물 보여줌 무한 스크롤링 --%>
    <h1>인기 상품</h1>
    <div class="mainList2">
        <c:forEach var="i" begin="0" end="${fn:length(list2)-1}" step="1" varStatus="loop">
            <ul>
                <li class="mainList_li_1"><img class="list_img" src="productUpload/${item.p_img}" alt="${item.p_img}"></li>
                <c:choose>
                    <c:when test="${list2[i].p_cate == '교재'}">
                        <li class="mainList_li_textbook">${list2[i].p_cate}</li>
                    </c:when>
                    <c:when test="${list2[i].p_cate == '교구'}">
                        <li class="mainList_li_adis">${list2[i].p_cate}</li>
                    </c:when>
                    <c:when test="${list2[i].p_cate == '수업자료'}">
                        <li class="mainList_li_handout">${list2[i].p_cate}</li>
                    </c:when>
                    <c:when test="${list2[i].p_cate == '기타'}">
                        <li class="mainList_li_etc">${list2[i].p_cate}</li>
                    </c:when>
                    <c:otherwise>
                        <li class="mainList_li_ddk">미분류</li>
                    </c:otherwise>
                </c:choose>
                <li class="mainList_li_3"><a href="product_detail.do?pid=${list2[i].p_id}">${list2[i].p_name}</a></li>
                <li class="mainList_li_4">₩${list2[i].p_price}</li>
                <li class="mainList_li_5">${list2[i].p_state}</li>

                <li class="mainList_li_6" id="fav${list2[i].p_id}">
                    <c:choose>
                        <c:when test="${empty session_id}">
                            <img src="indexImg/nolike.png" class="like" alt="빈하트" onclick="check(${list2[i].p_id})"/>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${like_data[i]==0}"> <%--like_date가 0 -> 내가 좋아요 안 누름--%>
                                    <img src="indexImg/nolike.png" class="like" alt="빈하트" onclick="check(${list2[i].p_id})"/>
                                </c:when>
                                <c:otherwise>
                                    <img src="indexImg/yeslike.png" class="like" alt="찬하트" onclick="check(${list2[i].p_id})"/>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </c:forEach>
    </div>
</article>
</body>
</html>
