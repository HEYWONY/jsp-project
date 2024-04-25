<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="chh/js/writeform.js"></script>
    <script src="chh/js/ripple.js"></script>
    <link rel="stylesheet" href="chh/css/ripple.css">
    <link rel="stylesheet" href="chh/css/writeform.css">
    <link rel="stylesheet" href="chh/css/file_custom.scss">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.ripples/0.5.3/jquery.ripples.min.js"></script>

</head>
<body>

<div id="wrap">
    <div class="full-landing-image">
    <form method="post" action="product_write_result.do" enctype="multipart/form-data">
        <ul>
            <li>
                <h1>상품 등록</h1>
            </li>
            <li>
                <label class="field" for="pimg"><b>상품 사진 업로드</b></label><br>
                <img id="preview"/><br>
                <input type="file" name="pimg" id="pimg" accept="image/*" onchange="readURL(this);">
            </li>
            <li>
                <label class="field" for="pname"><b>상품명</b></label><br>
                <input class="input_text" type="text" name="pname" id="pname" required>
            </li>
            <li>
                <label class="field" for="pprice"><b>가격</b></label><br>
                <input class="input_text" type="number" min="0" name="pprice" id="pprice" required>
            </li>
            <li>
                <label class="field" for="pcate"><b>카테고리</b></label><br>
                <select name="pcate" id="pcate">
                    <option value="교재" selected>교재</option>
                    <option value="교구">교구</option>
                    <option value="수업자료">수업자료</option>
                    <option value="기타">기타</option>
                </select>

            </li>
            <li>
                <label class="field" for="pcnt"><b>재고 수량</b></label><br>
                <input class="input_text" type="number" min="1" name="pcnt" id="pcnt" required>
            </li>
            <li>
                <label class="field" for="pdesc"><b>상품 상세 설명</b></label><br>
                <textarea name="pdesc" id="pdesc" cols="20" rows="3" required></textarea>
            </li>
            <li>
                <label class="field" for="popenchat"><b>오픈 카톡 링크</b></label><br>
                <input class="input_text" type="text" name="popenchat" id="popenchat" required>
            </li>

            <li>
                <label class="field" for="pstate"><b>제품 상태</b></label><br>
                <select name="pstate" id="pstate">
                    <option value="미개봉" selected>미개봉</option>
                    <option value="거의 새것">거의 새것</option>
                    <option value="사용감 있음">사용감 있음</option>
                </select>
            </li>

            <li>
                <label class="field" for="ptrade"><b>거래방식</b></label><br>
                <select name="ptrade" id="ptrade" onchange="changeFn()">
                    <option value="meet" selected>직거래</option>
                    <option value="deliver">택배</option>
                    <option value="both">택배,직거래</option>
                </select>
            </li>

            <li>
                <div id="address_choice_li">
                    <label class="field" ><b>직거래 희망 장소</b></label><br>
                    <input class="input_text" type="text" id="input_addr" name="pplace" placeholder="주소 선택" readonly>
                    <input type="button" class="form_btn" onclick="select_addr()" value="주소 검색"><br>
                </div>
            </li>
            <li>
                <button type="submit" class="form_btn" id="submit_btn">등록 하기</button>
            </li>
        </ul>
    </form>
    </div>
</div>

</body>
</html>