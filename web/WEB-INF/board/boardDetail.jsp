<%--
  Created by IntelliJ IDEA.
  User: FULL8-007
  Date: 2024-04-22
  Time: 오후 4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>공지사항</title>
    <link rel="stylesheet" href="smr/css/boardDetail.css">
</head>
<body>
 <c:set var="detail" value="${requestScope.dto}"/>
 <c:set var="uid" value="${requestScope.uid}"/>

 <div class="wrap">
     <div class="notice">
         <h3>공지사항</h3>
     </div>

    <ul>
        <c:if test="${empty detail}">
            <li>자료가 없습니다.</li>
        </c:if>
        <c:if test="${!(empty detail)}">
            <li>
                <span class="titletxt">${detail.title}</span>
                <span>조회수 : ${detail.readno}</span>
            </li>
            <li class="contentbox">${detail.content}</li>
            <li>작성자 : ${detail.writer}</li>
            <li>작성일 : ${detail.writedate}</li>

        </c:if>
    </ul>

     <div class="btn">
         <a href="boardlist.do"><button type="button">목록보기</button></a>
            <c:choose>
                <c:when test="${uid==100}">
                     <a href="board_update.do?bno=${detail.b_no}"><button type="button">수정</button></a>
                     <a href="board_delete.do?bno=${detail.b_no}"><button type="button">삭제</button></a>
                </c:when>
            </c:choose>
     </div>

 </div>
</body>
</html>
