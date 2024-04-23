<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="pid" value="${requestScope.pid}"/>
<script>
    alert("상품 정보가 수정되었습니다.");
    location.href="product_detail.do?pid=${pid}";
</script>
</body>
</html>
