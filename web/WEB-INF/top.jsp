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
            <a href="index.do"><img class="header_img" src="indexImg/pasam_logo.png" alt="pasam_logo"></a>
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
        <li><a href="#">교구</a></li>
        <li><a href="#">교재</a></li>
        <li><a href="#">수업자료</a></li>
        <li><a href="#">기타</a></li>
        <li><a href="list.do">전체매물</a></li>
        <li><a href="boardlist.do">공지사항</a></li>
    </ul>
</nav>

<ul id="result">
</ul>

<script>
    window.onload=function() {
        document.getElementById('header_search').onkeyup = function(e) {
            if(e.keyCode === 13) {
                let search_data=this.value;
                let result = document.getElementById('result');

                result.innerHTML = '';
                fetch("listjson?header_search="+search_data,
                    { method : "get"
                        , headers : {'Accept' : 'text/json'}
                    }).then(response => {
                    if(!response.ok) throw new Error('로드 실패');
                    return response.json();
                }).then(data => {
                    console.log(data,'data');
                    if (data.length === 0) {
                        let noResultItem = document.createElement('li');
                        noResultItem.textContent = "결과가 없습니다.";
                        result.appendChild(noResultItem);
                    } else {
                        data.forEach(item=> {
                            let d1 = document.createElement('li');
                            let aTag = document.createElement('a');
                            let txt1 = document.createTextNode(item.p_name);
                            aTag.href = 'product_detail.do?pid=' + item.p_id;
                            aTag.textContent = txt1.textContent;

                            d1.appendChild(aTag);
                            result.appendChild(d1);
                        });
                    }
                }).catch(
                    error=>console.log(error)
                ).finally(
                    ()=>console.log('finally')
                )
            }
        }
    }
</script>
</body>
</html>
