<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="gsh_user/css/idcheck.css">
    <title>아이디 중복 확인</title>
</head>
<c:set var="id" value="${requestScope.id}"/>
<c:set var="check" value="${requestScope.check}"/>
<body>
<form>
    <ul>
        <li>
            <input type="text" name="id" value="${id}">
        </li>

            <c:choose>
                <c:when test="${check}">
                    <li>이미 존재하는 아이디 입니다.</li>
                </c:when>
                <c:otherwise>
                    <li>사용 가능한 아이디입니다.</li>
                </c:otherwise>
            </c:choose>
        <li>
            <a href="#" onclick="self.close()">닫기</a>
        </li>
    </ul>
</form>
</body>
</html>
    