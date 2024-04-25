<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="indexCSS/top.css">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
<header>
        <span class="header_01">
            <a href="index.do"><img class="header_img" src="indexImg/pasam_logo.png" alt="pasam_logo"></a>
        </span>
    
    <%-- ajax 처리할 곳
    onKeyDown은 키를 누르고 있을 때, onKeyUp은 키를 누르다가 땠을 때 => 누르고 있을 때보다는 떼고 나서가 낫ㄷ ㅏ... 라고 생각해서 keyup
    이렇게 되면 onKeyUp에 의해 serach() 함수가 실행됨! 검색 내용은 search.jsp로 넘기고 싶은데... 잘 될 지는 모르겠음. 일단 시도는 해 보기!
    당장은 1도 모르겠으니까 밑에 출력해 볼깡
    --%>
    <div class="header_02">
        <label>
            <input class="header_search" id="header_search" name="header_search" type="text" placeholder="어떤 상품을 찾으시나요?" onkeyup="search(this)">
        </label>
        <img src="indexImg/search.png" alt="search">
    </div>
    
    <span class="header_03">
            <a href="join.do">로그인</a>
        </span>
    <span class="header_03_1">
            <a href="#">상품등록</a>
           <a href="#">마이페이지</a>
        </span>
</header>
<nav>
    <ul>
        <li><a href="adisList.do">교구</a></li>
        <li><a href="#">교재</a></li>
        <li><a href="#">수업자료</a></li>
        <li><a href="#">기타</a></li>
        <li><a href="list.do">전체매물</a></li>
        <li><a href="boardlist.do">공지사항</a></li>
        <li><a href="product_write.do">상품등록</a></li>
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
