<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="indexCSS/top.css">
</head>
<body>
<%// String id = (String) session.getAttribute("id");%>
<c:set var="session_id" value="${sessionScope.id}"/>

<header>
    <span class="header_01">
        <a href="index.do"><img class="header_img" src="indexImg/pasam_logo.gif" alt="pasam_logo"></a>
    </span>
    <div class="header_02">
        <label>
            <input class="header_search" id="header_search" name="header_search" type="text" placeholder="어떤 상품을 찾으시나요?">
        </label>
        <img src="indexImg/search.png" alt="search">
    </div>
        <c:choose>
        <c:when test="${session_id==null ||  empty session_id || session_id == '' }">
            <span class="header_03">
                <a href="login.do">로그인</a>
            </span>
        </c:when>
        <c:when test="${session_id == 'admin'}">
            <span class="header_03_admin">
                <a href="admin.do">관리자페이지</a>
            </span>
        </c:when>
        <c:otherwise>
            <span class="header_03_1">
                <a class="header_03_1_1" href="product_write.do">상품등록</a>
                <a href="myPage.do">마이페이지</a>
            </span>
        </c:otherwise>
    </c:choose>
</header>

<nav>
    <ul>
        <li><a href="adis_list.do">교구</a></li>
        <li><a href="textbook.do">교재</a></li>
        <li><a href="handout_list.do">수업자료</a></li>
        <li><a href="etc.do">기타</a></li>
        <li><a href="list.do">전체매물</a></li>
        <li><a href="boardlist.do">공지사항</a></li>
    </ul>
</nav>

<ul id="result"></ul>

<script>
    let typingTimer;
    let doneTypingInterval = 100;
    
    window.onload = function() {
        let searchInput = document.getElementById('header_search');
        let result = document.getElementById('result');

        searchInput.onkeyup = function() {
            clearTimeout(typingTimer);
            typingTimer = setTimeout(function() {
                let search_data = searchInput.value.trim();
                if (search_data.length === 0) {
                    result.innerHTML = '';
                    return;
                }

                fetch("listjson?header_search=" + search_data, {
                    method: "get",
                    headers: {'Accept': 'text/json'}
                }).then(response => {
                    if (!response.ok) throw new Error('로드 실패');
                    return response.json();
                }).then(data => {
                    console.log(data, 'data');
                    result.innerHTML = '';

                    if (data.length === 0) {
                        let noResultItem = document.createElement('li');
                        noResultItem.textContent = "결과가 없습니다.";
                        result.appendChild(noResultItem);
                    } else {
                        data.forEach(item => {
                            let listItem = document.createElement('li');
                            let link = document.createElement('a');
                            link.href = 'product_detail.do?pid=' + item.p_id;
                            link.textContent = item.p_name;
                            listItem.appendChild(link);
                            result.appendChild(listItem);
                        });
                    }
                }).catch(error => {
                    console.log(error);
                    result.innerHTML = '';
                }).finally(() => console.log('finally'));
            }, doneTypingInterval);
        };
    };


</script>
</body>
</html>
