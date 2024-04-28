<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="chh/css/detail.css">
    <script src="chh/js/detail.js"></script>
</head>
<body>
<c:set var="dto" value="${requestScope.pdto}"/>
<c:set var="uid" value="${requestScope.uid}"/>
<c:set var="fav_cnt" value="${requestScope.fav_cnt}"/>
<c:set var="fav_yn" value="${requestScope.fav_yn}"/>

<div id="wrap">
    <div>
        <div id="product_detail_1">
            <img id="pimg" src="productUpload/${dto.p_img}" onerror="this.src='chh/img/noimg2.png'" alt="${dto.p_img}">

            <section>
                <ul>
                    <li class="cate_box">
                        <c:choose>
                            <c:when test="${dto.p_cate=='교구'}">
                                <span class="cate" id="cate1">${dto.p_cate}</span>
                            </c:when>
                            <c:when test="${dto.p_cate=='교재'}">
                                <span class="cate" id="cate2">${dto.p_cate}</span>
                            </c:when>
                            <c:when test="${dto.p_cate=='수업자료'}">
                                <span class="cate" id="cate3">${dto.p_cate}</span>
                            </c:when>
                            <c:otherwise>
                                <span class="cate" id="cate4">${dto.p_cate}</span>
                            </c:otherwise>
                        </c:choose>
                    </li>

                    <li>
                        <h2>${dto.p_name}</h2>
                    </li>
                    <li>
                        <h3>${dto.p_price}원</h3>
                    </li>
                    <li class="font_gray">
                        ${dto.p_date} | ${dto.p_stock}개 남음 | 조회 ${dto.readno} | 찜 ${fav_cnt}
                    </li>

                    <c:choose>
                        <c:when test="${dto.p_cate=='교구'}">
                            <div class="line, line1"></div>
                        </c:when>
                        <c:when test="${dto.p_cate=='교재'}">
                            <div class="line, line2"></div>
                        </c:when>
                        <c:when test="${dto.p_cate=='수업자료'}">
                            <div class="line, line3"></div>
                        </c:when>
                        <c:otherwise>
                            <div class="line, line4"></div>
                        </c:otherwise>
                    </c:choose>


                    <div id="product_info_box">
                        <c:if test="${!(empty dto.p_place) || fn:length(dto.p_place)!=0}">
                            <li>
                                <label class="label_field">거래 희망 장소</label>
                                <p class="label_text">${dto.p_place}</p>
                            </li>
                        </c:if>

                        <li>
                            <label class="label_field">거래 방식</label>
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
                            <label class="label_field">제품 상태</label>
                            <p class="label_text">${dto.p_state}</p>
                        </li>
                    </div>

                    <li>
                        <div class="division_btn">
                            <!--로그인 한 사용자에 따라 버튼 다르게 보이도록 구현-->
                            <c:choose>
                                <c:when test="${dto.u_id==uid || uid==1}">
                                    <a class="left_btn" href="product_update.do?pid=${dto.p_id}">수정하기</a>
                                    <a class="right_btn" href="product_delete.do?pid=${dto.p_id}&pimg=${dto.p_img}">삭제하기</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="left_btn" onclick="check(${dto.p_id})">
                                        <c:choose>
                                            <c:when test="${fav_yn==0}">
                                                <img id="star_fav" class="btn_icon" src="chh/img/empty_star.png" alt="빈별">
                                            </c:when>
                                            <c:when test="${fav_yn==1}">
                                                <img id="star_fav" class="btn_icon" src="chh/img/fill_star.png" alt="찬별">
                                            </c:when>
                                        </c:choose>
                                        찜하기
                                    </a>
                                    <a class="right_btn" href="product_order.do?pid=${dto.p_id}">바로구매</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </ul>
            </section>
        </div>


        <section>
            <h2>상품 설명</h2>
            <p class="desc_txt">${dto.p_desc}</p>
            <div class="desc_btn">
                <a class="btn_style" href="myPage.do?uid=${dto.u_id}">
                    <span>
                        <span class="wave"></span>
                        <img class="btn_icon" src="chh/img/home_icon.png" alt="홈 아이콘"/>
                        <c:choose>
                            <c:when test="${dto.u_id==uid}">
                                마이 홈
                            </c:when>
                            <c:otherwise>
                                판매자 홈
                            </c:otherwise>
                        </c:choose>
                    </span>

                </a> <!--dto.u_id로 마이페이지 링크 걸기-->
                <a class="btn_style" href="${dto.p_openchat}">
                    <span>
                        <span class="wave"></span>
                        <img class="btn_icon" src="chh/img/chat_icon.png" alt="채팅 아이콘"/>
                    <c:choose>
                        <c:when test="${dto.u_id==uid}">
                            오픈 채팅
                        </c:when>
                        <c:otherwise>
                            상품 문의
                        </c:otherwise>
                    </c:choose>
                    </span>
                </a>
            </div>
        </section>
    </div>
</div>

</body>
</html>
