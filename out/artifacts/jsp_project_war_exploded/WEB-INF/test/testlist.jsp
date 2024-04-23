<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="list" value="${requestScope.list}"/>

<table>
    <thead>
        <tr>
            <th>주문번호</th>
            <th>배송지주소</th>
            <th>상품번호</th>
            <th>유저번호</th>
            <th>주문일자</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${empty list || fn:length(list)==0}">
                <tr>
                    <td colspan="5">해당 자료가 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.o_id}</td>
                        <td>${item.o_addr}</td>
                        <td>${item.p_id}</td>
                        <td>${item.u_id}</td>
                        <td>${item.o_date}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </tbody>
</table>
</body>
</html>
