<%--
  Created by IntelliJ IDEA.
  User: FULL8-007
  Date: 2024-04-22
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/board.css">
</head>
<body>
<c:set var="list" value="${requestScope.list}"></c:set>
<c:set var="currpage" value="${requestScope.currpage}"></c:set>
<c:set var="total_page" value="${requestScope.total_page}"></c:set>
<c:set var="startpage" value="${requestScope.startpage}"></c:set>
<c:set var="endpage" value="${requestScope.endpage}"></c:set>
<c:set var="search_txt" value="${requestScope.search_txt}"></c:set>

<a href="board_write.do">글쓰기</a>
<form method="get" action="boardlist.do">
    <input type="text" name="search_txt">
    <input type="submit" value="검색">

</form>
        <ul>
                <c:choose>
                    <c:when test="${empty list || fn:length(list)==0}">
                        <li>해당 자료가 없습니다.</li>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="item" items="${list}">
                            <li>
                                <a href="board_detail.do?bno=${item.b_no}"> <c:out value="${item.title}"></c:out></a>
                            </li>

                        </c:forEach>
                    </c:otherwise>
                </c:choose>
        </ul>
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
</body>
</html>
