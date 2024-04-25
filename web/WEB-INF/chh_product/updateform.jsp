<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script src="chh/js/updateform.js"></script>
  <script src="chh/js/ripple.js"></script>
  <link rel="stylesheet" href="chh/css/ripple.css">
  <link rel="stylesheet" href="chh/css/updateform.css">
  <link rel="stylesheet" href="chh/css/file_custom.scss">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.ripples/0.5.3/jquery.ripples.min.js"></script>

</head>
<body>
<c:set var="dto" value="${requestScope.dto}"/>


<div id="wrap">
  <div class="full-landing-image">
    <form method="post" action="product_update_result.do?pid=${dto.p_id}" enctype="multipart/form-data"> <!--나중에 post로 바꿀 것-->

        <h1>상품 정보 수정</h1>
        <input type="hidden" name="p_id" id="p_id" value="${dto.p_id}">
        <ul>
          <li>
            <label class="test_title"><b>기존 상품 이미지</b></label>
            <div>
              <img id="pimg" src="productUpload/${dto.p_img}" alt="${dto.p_img}">
              <input type="hidden" name="old_pimg" id="old_pimg" value="${dto.p_img}">
            </div>
          </li>
          <li>
            <div id="new_image_box" style="display: none">
              <label for="new_pimg"><b>새 상품 이미지</b></label><br>
              <img id="preview"/><br>
            </div>
            <input type="file" name="new_pimg" id="new_pimg" accept="image/*" onchange="readURL(this);">
          </li>
          <li>
            <label for="pname"><b>상품명</b></label><br>
            <input class="input_text" type="text" name="pname" id="pname" value="${dto.p_name}" required>
          </li>
          <li>
            <label for="pprice"><b>가격</b></label><br>
            <input class="input_text" type="number" min="0" name="pprice" id="pprice" value="${dto.p_price}" required>
          </li>
          <li>
            <label for="pcate"><b>카테고리</b></label><br>
            <select name="pcate" id="pcate">
              <c:choose>
                <c:when test="${dto.p_cate=='교재'}">
                  <option value="교재" selected>교재</option>
                  <option value="교구">교구</option>
                  <option value="수업자료">수업자료</option>
                  <option value="기타">기타</option>
                </c:when>
                <c:when test="${dto.p_cate=='교구'}">
                  <option value="교재">교재</option>
                  <option value="교구" selected>교구</option>
                  <option value="수업자료">수업자료</option>
                  <option value="기타">기타</option>
                </c:when>
                <c:when test="${dto.p_cate=='수업자료'}">
                  <option value="교재">교재</option>
                  <option value="교구">교구</option>
                  <option value="수업자료" selected>수업자료</option>
                  <option value="기타">기타</option>
                </c:when>
                <c:when test="${dto.p_cate=='기타'}">
                  <option value="교재">교재</option>
                  <option value="교구">교구</option>
                  <option value="수업자료">수업자료</option>
                  <option value="기타" selected>기타</option>
                </c:when>
              </c:choose>

            </select>

          </li>
          <li>
            <label for="pcnt"><b>재고 수량</b></label><br>
            <input class="input_text" type="number" min="1" name="pcnt" id="pcnt" value="${dto.p_stock}" required>
          </li>
          <li>
            <label for="pdesc"><b>상품 상세 설명</b></label><br>
            <textarea name="pdesc" id="pdesc" required>${dto.p_desc}</textarea>
          </li>
          <li>
            <label for="popenchat"><b>오픈 카톡 링크</b></label><br>
            <input class="input_text" type="text" name="popenchat" id="popenchat" value="${dto.p_openchat}" required>
          </li>

          <li>
            <label for="pstate"><b>제품 상태</b></label><br>
            <select name="pstate" id="pstate">
              <c:choose>
                <c:when test="${dto.p_state=='미개봉'}">
                  <option value="미개봉" selected>미개봉</option>
                  <option value="거의 새것">거의 새것</option>
                  <option value="사용감 있음">사용감 있음</option>
                </c:when>
                <c:when test="${dto.p_state=='거의 새것'}">
                  <option value="미개봉">미개봉</option>
                  <option value="거의 새것" selected>거의 새것</option>
                  <option value="사용감 있음">사용감 있음</option>
                </c:when>
                <c:when test="${dto.p_state=='사용감 있음'}">
                  <option value="미개봉">미개봉</option>
                  <option value="거의 새것">거의 새것</option>
                  <option value="사용감 있음" selected>사용감 있음</option>
                </c:when>
              </c:choose>

            </select>
          </li>

          <li>
            <label for="ptrade"><b>거래방식</b></label><br>
            <select name="ptrade" id="ptrade" onchange="changeFn()">
              <c:choose>
                <c:when test="${dto.p_trade=='meet'}">
                  <option value="meet" selected>직거래</option>
                  <option value="deliver">택배</option>
                  <option value="both">택배,직거래</option>
                </c:when>
                <c:when test="${dto.p_trade=='deliver'}">
                  <option value="meet">직거래</option>
                  <option value="deliver" selected>택배</option>
                  <option value="both">택배,직거래</option>
                </c:when>
                <c:when test="${dto.p_trade=='both'}">
                  <option value="meet">직거래</option>
                  <option value="deliver">택배</option>
                  <option value="both" selected>택배,직거래</option>
                </c:when>
              </c:choose>

            </select>
          </li>


          <li>
            <div id="address_choice_li">
              <label><b>직거래 희망 장소</b></label><br>
              <input class="input_text" type="text" id="input_addr" name="pplace" placeholder="주소 선택" value="${dto.p_place}" required readonly>
              <input class="form_btn" type="button" onclick="select_addr()" value="주소 검색"><br>
            </div>
          </li>
          <li>
            <button class="form_btn" type="submit" id="submit_btn">수정완료</button>
          </li>
        </ul>
    </form>
  </div>
</div>



</body>
</html>
