<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="chh/css/product_detail.css">
</head>
<body>
<c:set var="dto" value="${requestScope.pdto}"/>
<div id="wrap">
    <div>
        <div id="product_detail_1">
            <img id="pimg" src="productUpload/${dto.p_img}" alt="${dto.p_img}">

            <section>
                <ul>
                    <li>
                        카테고리 > ${dto.p_cate}
                    </li>
                    <li>
                        <h2>${dto.p_name}</h2>
                    </li>
                    <li>
                        <h3>${dto.p_price}</h3>
                    </li>
                    <li>
                        ${dto.p_date} | ${dto.p_cnt}개 남음 | 조회 ${dto.readno} | 찜 ${dto.p_fav}
                    </li>
                    <hr>
                    <li>
                        <label>거래 희망 장소</label>
                        <p class="label_text">${dto.p_place}</p>
                    </li>
                    <li>
                        <label>거래 방식</label>
                        <p class="label_text">${dto.p_trade}</p>
                    </li>
                    <li>
                        <label>제품 상태</label>
                        <p class="label_text">${dto.p_state}</p>
                    </li>
                    <li>
                        <!--로그인에 따라 (판매자/사용자) 다르게 보일 버튼-->
                        <div>
                            <a href="#">찜하기</a>
                            <a href="#">바로구매</a>
                        </div>
                        <div>
                            <a href="#">수정하기</a>
                            <a href="#">삭제하기</a>
                        </div>
                    </li>
                </ul>
            </section>

        </div>


        <section>
            <h2>상품 설명</h2>
            <p>${dto.p_desc}</p>
            <a href="#">판매자 홈 ></a>
            <a href="${dto.p_openchat}">상품 문의</a>
        </section>
    </div>
</div>

</body>
</html>
