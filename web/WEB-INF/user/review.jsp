<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>리뷰하기</title>
    <style>
        .wrap{
            /*border: #00aaff 1px solid;*/
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            width: 90vw;
            height: 30vh;
            margin-bottom: 10vw;
        }

        form ul li {
            font-size: 1.3rem;
            margin-bottom: 20px;
        }

        form ul li input {
            padding: 10px;
        }

        .btn {
            margin-top: 20px;
        }

        .submit{
            background: white;
            color: black;
            padding: 10px 43px;
            border-radius: 10px;
            font-size: 1rem;
            margin-top: 10px;
        }

        .submit:hover{
            background: #93d6fc;
        }

        .reset {
            background: #bbbbbb;
            color: white;
            padding: 10px 43px;
            border-radius: 10px;
            font-size: 1rem;
            margin-top: 10px;
        }

    </style>
</head>
<body>
<div class="wrap">
<form method="post" action="reviewResult.do">
    <input type="hidden" name="id" value="${id}">
    <input type="hidden" name="u_id" value="${u_id}">
    <input type="hidden" name="pid" value="${pid}">
    <ul>
        <li>구매한 상품의 평점을 남겨주세요!</li>
        <li>
            <input type="radio" name="rank" value="5" checked>5점
            <input type="radio" name="rank" value="4" >4점
            <input type="radio" name="rank" value="3" >3점
            <input type="radio" name="rank" value="2" >2점
            <input type="radio" name="rank" value="1" >1점
        </li>
        <li class="btn">
            <input type="submit" id="submit" value="입력하기" class="submit">
            <input type="reset" value="다시선택" class="reset">
        </li>
    </ul>
</form>
</div>
<script>
    document.getElementById('submit').onclick = function () {
        alert("리뷰가 완료되었습니다.");
        location.href = "myPage.do?id=${id}";
    }
</script>
</body>
</html>
