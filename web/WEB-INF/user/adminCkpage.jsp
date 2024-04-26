<%--
  Created by IntelliJ IDEA.
  User: FULL8-007
  Date: 2024-04-26
  Time: 오전 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
  <title>Title</title>
    <link rel="stylesheet" href="smr/css/adminCkpage.css">
</head>
<body>
<c:set var="cklist" value="${requestScope.cklist}"/>

<div class="wrap">

<ul class="te_ck">

  <h3>교사 인증 승인 여부</h3>

        <div class="wpahr">
            <li>
                <span>회원 아이디</span>
                <span>승인여부</span>
            </li>
        </div>

        <div class="sodyd">
          <c:choose>
              <c:when test="${empty cklist || fn:length(cklist)==0}">
                  <li>승인 대기회원이 없습니다.</li>
              </c:when>
              <c:otherwise>
                  <c:forEach var="item" items="${cklist}">
                      <li>
                          <span><c:out value="${item.id}"/></span>
                          <span><a href="adminCk_Ok.do?id=${item.id}"><input type="submit" value="승인"></a></span>
                      </li>
                  </c:forEach>
              </c:otherwise>
          </c:choose>
        </div>
</ul>
</div>
</body>
</html>
