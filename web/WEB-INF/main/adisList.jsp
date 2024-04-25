<%--
  Created by IntelliJ IDEA.
  User: FULL8-011
  Date: 2024-04-24
  Time: 오전 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set var="list" value="${requestScope.list}"/>
    
    <h1>전체매물</h1>
    <form method="post" action="listResult.do">
        <select name="p_state" id="p_state">
            <option value="미개봉">미개봉</option>
            <option value="거의 새것">거의 새것</option>
            <option value="사용감 있음">사용감 있음</option>
        </select>
        <select name="p_trade" id="p_trade">
            <option value="직거래">직거래</option>
            <option value="택배거래">택배거래</option>
            <option value="직거래, 택배거래">직거래, 택배거래</option>
        </select>
        <input type="submit" value="전송">
    </form>
    <div class="list_ul">
        <c:forEach var="item" items="${list}">
            <ul>
                <li class="mainList_li_1"><img class="list_img" src="productUpload/${item.p_img}" alt="${item.p_img}"></li>
                <li class="mainList_li_2">${item.p_cate}</li>
                <li class="mainList_li_3"><a href="product_detail.do?pid=${item.p_id}">${item.p_name}</a></li>
                <li class="mainList_li_4">₩${item.p_price}</li>
                <li class="mainList_li_5">${item.p_state}</li>
                <li class="mainList_li_6">${item.p_fav}</li>
            </ul>
        </c:forEach>
    </div>
</body>
</html>
