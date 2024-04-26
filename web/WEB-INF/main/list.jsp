<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="indexCSS/list.css">
</head>
<body>

<%-- 로그인한 사람만 찜버튼 누를 수 있게 설계하기 위해서... --%>
<c:set var="list" value="${requestScope.list}"/>

<h1>전체매물</h1>
<form method="post" action="listResult.do">
    <select name="p_cate" id="p_cate">
        <option value="교재">교재</option>
        <option value="교구">교구</option>
        <option value="수업자료">수업자료</option>
        <option value="기타">기타</option>
    </select>
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
    <c:set var="session_id" value="${sessionScope.id}"/>
    <c:set var="number" value="0"/>
    <c:forEach var="item" items="${list}">
        <ul>
            <li class="mainList_li_1"><img class="list_img" src="productUpload/${item.p_img}" alt="${item.p_img}"></li>
            <c:choose>
                <c:when test="${item.p_cate == '교재'}">
                    <li class="mainList_li_textbook">${item.p_cate}</li>
                </c:when>
                <c:when test="${item.p_cate == '교구'}">
                    <li class="mainList_li_adis">${item.p_cate}</li>
                </c:when>
                <c:when test="${item.p_cate == '수업자료'}">
                    <li class="mainList_li_handout">${item.p_cate}</li>
                </c:when>
                <c:when test="${item.p_cate == '기타'}">
                    <li class="mainList_li_etc">${item.p_cate}</li>
                </c:when>
                <c:otherwise>
                    <li class="mainList_li_ddk">미분류</li>
                </c:otherwise>
            </c:choose>
            <li class="mainList_li_3"><a href="product_detail.do?pid=${item.p_id}">${item.p_name}</a></li>
            <li class="mainList_li_4">₩${item.p_price}</li>
            <li class="mainList_li_5">${item.p_state}</li>
            <li class="mainList_li_6" id="fav${number}">
                <%--<c:choose>
                    <c:when test="${item.p_fav == 0}">
                        <input type="image" src="indexImg/nolike.png" class="like" alt="빈하트" onclick="check(${item.p_id})"/>
                    </c:when>
                    <c:otherwise>
                        <input type="image" src="indexImg/yeslike.png" class="like" alt="찬하트" onclick="check(${item.p_id})"/>
                    </c:otherwise>
                </c:choose>--%>
                
                <c:choose>
                    <c:when test="${empty session_id}">
                        <input type="image" src="indexImg/nolike.png" class="like" alt="빈하트" onclick="check(${item.p_id})"/>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${item.p_fav == 0}">
                                <input type="image" src="indexImg/nolike.png" class="like" alt="빈하트" onclick="check(${item.p_id})"/>
                            </c:when>
                            <c:otherwise>
                                <input type="image" src="indexImg/yeslike.png" class="like" alt="찬하트" onclick="check(${item.p_id})"/>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </li>
            <c:set var="number" value="${number+1}"/>
        </ul>
    </c:forEach>
</div>

<script>

    let check = function(pid) {
        let id = '<%=(String)session.getAttribute("id")%>';
        if(id === "null"){
            alert('로그인이 필요한 기능입니다.');
        }
        fetch('like?p_id='+pid,
            {
                method: 'GET',
                headers: {
                    'Accept': 'text/html'
                }
            }).then(response => {
            if (!response.ok) throw new Error('로드 실패');
            return response.text();
        }).then(data => {
            console.log(data + "data");

            let likeButton = document.getElementById('fav' + pid);

            // 좋아요 버튼 이미지 변경
            if (data === 'added') {
                // 벌건색으로 이미지 변경
                likeButton.innerHTML = '';
                let fullInput = document.createElement('input');
                fullInput.type = 'image';
                fullInput.src = 'indexImg/yeslike.png';
                likeButton.appendChild(fullInput); // 새 버튼 추가
            } else if (data === 'removed') {
                // 흰색으로 이미지 변경하기
                likeButton.innerHTML = '';
                let nullInput = document.createElement('input');
                nullInput.type = 'image';
                nullInput.src = 'indexImg/nolike.png';
                likeButton.appendChild(nullInput); // 새 버튼 추가
            }
        }).catch(error => {
            console.log(error);
        }).finally(() => console.log('finally'));
    }
    
    
</script>

</body>
</html>

