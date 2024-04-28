<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>joinSuccess</title>
    <style>
        #wrap{
            /*border: #00aaff 1px solid;*/
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            width: 90vw;
            height: 30vh;
            margin-bottom: 10vw;
        }

        h2 {
            font-size: 1.2rem;
        }

        h3{
            font-size: 1rem;
            margin-bottom: 40px;
        }
        #wrap a {
            padding: 10px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 1rem;
        }

    </style>
</head>
<body>
<div id="wrap">
    <h2>가입해 주셔서 감사합니다.</h2>
    <h3>(교사 인증 완료 후에 파샘 이용 가능합니다.)</h3>
    <a href="login.do">로그인</a>
    <a href="index.do">메인으로</a>
</div>
</body>
</html>
    