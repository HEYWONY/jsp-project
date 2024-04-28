<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 중복 확인</title>

</head>
<style>
    ul li{
        list-style: none;
        padding: 5px 0;
    }
    form {
        display: flex;
        flex-direction: column;
        justify-content: center;
        height: 300px;
        text-align: center;
    }
    .box {
        display: inline-block;
        font-size: 0.9rem;
        font-weight: bold;
        border: none;
        border: 1.5px solid #333;
        text-align: center;
        padding: 5px;
        width: 60%;
        min-width: 30px;
        border-radius: 6px;
    }
    .txt {
        text-align: center;
        font-size: 1rem;
        margin-top: 4px;
        padding-bottom: 10px;
    }
    a:link {
        background :white;
        color: black;
        padding: 13px 25px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
    }
</style>
<c:set var="id" value="${requestScope.id}"/>
<c:set var="check" value="${requestScope.check}"/>
<body>
<form>
    <ul>
        <li>
            <input class="box" type="text" name="id" value="${id}">
        </li>
            <c:choose>
                <c:when test="${check}">
                    <li class="txt">이미 존재하는 아이디 입니다.</li>
                </c:when>
                <c:otherwise>
                    <li class="txt">사용 가능한 아이디입니다.</li>
                </c:otherwise>
            </c:choose>
        <li>
            <a href="#" onclick="self.close()">닫기</a>
        </li>
    </ul>
</form>
</body>


</html>
    