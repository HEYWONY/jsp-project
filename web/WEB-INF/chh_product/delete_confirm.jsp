<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="pid" value="${requestScope.pid}"/>
<c:set var="pimg" value="${requestScope.pimg}"/>

<script>
    answer = confirm(" 해당 상품을 삭제 하시겠습니까? ");
    if (answer===true){
        location.href="product_delete_result.do?pid=${pid}&pimg=${pimg}"
    } else{
        location.href="product_detail.do?pid=${pid}"
    }
</script>

</body>
</html>
