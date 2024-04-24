<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="chh/js/writeform.js"></script>
</head>
<body>

<div id="wrap">
    <form method="post" action="product_write_result.do" enctype="multipart/form-data"> <!--나중에 post로 바꿀 것-->
        <h1>상품 등록</h1>
        <input type="hidden" name="u_id" id="u_id" value="3"> <!--임시 테스트 - 세션 u_id로 바꿀 것-->
        <ul>
            <li>
                <label for="pimg">상품 사진 업로드</label><br>
                <input type="file" name="pimg" id="pimg">
            </li>
            <li>
                <label for="pname">상품명</label><br>
                <input type="text" name="pname" id="pname" required>
            </li>
            <li>
                <label for="pprice">가격</label><br>
                <input type="number" min="0" name="pprice" id="pprice" required>
            </li>
            <li>
                <label for="pcate">카테고리</label><br>
                <select name="pcate" id="pcate">
                    <option value="교재" selected>교재</option>
                    <option value="교구">교구</option>
                    <option value="수업자료">수업자료</option>
                    <option value="기타">기타</option>
                </select>

            </li>
            <li>
                <label for="pcnt">재고 수량</label><br>
                <input type="number" min="1" name="pcnt" id="pcnt" required>
            </li>
            <li>
                <label for="pdesc"> 상품 상세 설명</label><br>
                <textarea name="pdesc" id="pdesc" required></textarea>
            </li>
            <li>
                <label for="popenchat">오픈 카톡 링크</label><br>
                <input type="text" name="popenchat" id="popenchat" required>
            </li>

            <li>
                <label for="pstate">제품 상태</label><br>
                <select name="pstate" id="pstate">
                    <option value="미개봉" selected>미개봉</option>
                    <option value="거의 새것">거의 새것</option>
                    <option value="사용감 있음">사용감 있음</option>
                </select>
            </li>

            <li>
                <label for="ptrade">거래방식</label><br>
                <select name="ptrade" id="ptrade" onchange="changeFn()">
                    <option value="meet" selected>직거래</option>
                    <option value="deliver">택배</option>
                    <option value="both">택배,직거래</option>
                </select>
            </li>

            <li>
                <div id="address_choice_li">
                    <label>직거래 희망 장소 </label><br>
                    <input type="text" id="input_addr" name="pplace" placeholder="주소 선택" readonly>
                    <input type="button" onclick="select_addr()" value="주소 검색"><br>
                </div>
            </li>
            <li>
                <button type="submit" id="submit_btn">상품등록</button>
            </li>
        </ul>


    </form>
</div>

</body>
</html>
