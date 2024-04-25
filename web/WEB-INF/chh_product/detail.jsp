<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="chh/css/product_detail.css">
</head>
<body>
<c:set var="dto" value="${requestScope.pdto}"/>
<c:set var="uid" value="${requestScope.uid}"/>
<c:set var="fav_cnt" value="${requestScope.fav_cnt}"/>

<div id="wrap">
    <div>
        <div id="product_detail_1">
            <img id="pimg" src="productUpload/${dto.p_img}" onerror="this.src='chh/img/noimg2.png'" alt="${dto.p_img}">

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
                        ${dto.p_date} | ${dto.p_stock}개 남음 | 조회 ${dto.readno} | 찜 ${fav_cnt}
                    </li>
                    <hr>

                    <div id="product_info_box">
                        <c:if test="${!(empty dto.p_place) || fn:length(dto.p_place)!=0}">
                            <li>
                                <label>거래 희망 장소</label>
                                <p class="label_text">${dto.p_place}</p>
                            </li>
                        </c:if>

                        <li>
                            <label>거래 방식</label>
                            <c:choose>
                                <c:when test="${dto.p_trade=='deliver'}">
                                    <p class="label_text">택배</p>
                                </c:when>
                                <c:when test="${dto.p_trade=='meet'}">
                                    <p class="label_text">직거래</p>
                                </c:when>
                                <c:when test="${dto.p_trade=='both'}">
                                    <p class="label_text">택배, 직거래</p>
                                </c:when>
                            </c:choose>

                        </li>
                        <li>
                            <label>제품 상태</label>
                            <p class="label_text">${dto.p_state}</p>
                        </li>
                    </div>

                    <li>
                        <div>
                            <!--로그인 한 사용자에 따라 버튼 다르게 보이도록 구현-->
                            <c:choose>
                                <c:when test="${dto.u_id==uid || uid==1}">
                                    <a href="product_update.do?pid=${dto.p_id}">수정하기</a>
                                    <a href="product_delete.do?pid=${dto.p_id}&pimg=${dto.p_img}">삭제하기</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="#">찜하기</a>
                                    <a href="product_order.do?pid=${dto.p_id}">바로구매</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </ul>
            </section>

        </div>


        <section>
            <h2>상품 설명</h2>
            <p>${dto.p_desc}</p>
            <a href="#">판매자 홈 ></a> <!--dto.u_id로 마이페이지 링크 걸기-->
            <a href="${dto.p_openchat}">상품 문의</a>
        </section>
    </div>
</div>


</body>
</html>
