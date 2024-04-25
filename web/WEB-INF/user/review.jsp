<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>리뷰하기</title>
</head>
<body>
<form method="post" action="reviewResult.do">
    <input type="hidden" name="id" value="${id}">
    <input type="hidden" name="u_id" value="${u_id}">
    <input type="hidden" name="pid" value="${pid}">
    <ul>
        <li>~구매한 상품의 평점을 남겨주세요~</li>
        <li>
            <input type="radio" name="rank" value="5" checked>5점
            <input type="radio" name="rank" value="4" >4점
            <input type="radio" name="rank" value="3" >3점
            <input type="radio" name="rank" value="2" >2점
            <input type="radio" name="rank" value="1" >1점
        </li>
        <li>
            <input type="submit" id="submit" value="전송">
            <input type="reset" value="취소">
        </li>
    </ul>
</form>
<script>
    document.getElementById('submit').onclick = function () {
        alert("리뷰가 완료되었습니다.");
        location.href = "myPage.do?id=${id}";
    }
</script>
</body>
</html>
