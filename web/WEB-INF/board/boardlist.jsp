<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>공지사항</title>
    <link rel="stylesheet" href="smr/css/board.css">
</head>
<body>
<c:set var="list" value="${requestScope.list}"></c:set>
<c:set var="currpage" value="${requestScope.currpage}"></c:set>
<c:set var="total_page" value="${requestScope.total_page}"></c:set>
<c:set var="startpage" value="${requestScope.startpage}"></c:set>
<c:set var="endpage" value="${requestScope.endpage}"></c:set>
<c:set var="search_txt" value="${requestScope.search_txt}"></c:set>
<c:set var="uid" value="${requestScope.uid}"/>

<div class="wrap">
    <ul class="notice_list">
        <a href="boardlist.do"> <h1>고객센터</h1></a>
        <a href="boardlist.do"> <li class="notice">공지사항</li></a>
        <a href="faqlist.do"> <li class="faq">자주 묻는 질문</li></a>
    </ul>

    <div class="wrap_right">
    <div class="notice_write">
        <h3>공지사항</h3>
        <c:choose>
            <c:when test="${uid==100}">
                <a href="board_write.do" class="write_btn">글쓰기</a>
            </c:when>
        </c:choose>
    </div>

    <form method="get" action="boardlist.do" class="search">
        <input type="text" name="search_txt" class="search_bar" placeholder="검색어를 입력하세요">
        <input type="submit" value="검색" class="search_btn">
    </form>

    <ul class="list">
        <c:choose>
            <c:when test="${empty list || fn:length(list)==0}">
                <li>해당 자료가 없습니다.</li>
            </c:when>
            <c:otherwise>
                <c:forEach var="item" items="${list}">
                    <li>
                        <span><a href="board_detail.do?bno=${item.b_no}"><c:out value="${item.title}"/></a></span>
                        <span><c:out value="${item.writedate}"/></span>
                    </li>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </ul>
        <div class="pagenum">
    <c:if test="${startpage>1}">
        <a href="boardlist.do?bno=${startpage-1}&search_txt=${search_txt}">이전</a>
    </c:if>
    <c:forEach var="i" begin="${startpage}" end="${endpage}" step="1">
        <c:if test="${currpage==i}">
            <c:out value="${i}"/>
        </c:if>
        <c:if test="${currpage!=i}">
            <a href="boardlist.do?curr=${i}&search_txt=${search_txt}">${i}</a>
        </c:if>
    </c:forEach>
    <c:if test="${endpage < total_page}">
        <a href="boardlist.do?curr=${endpage+1}&search_txt=${search_txt}">다음</a>
    </c:if>
        </div>
    </div>
</div>
</body>
</html>
