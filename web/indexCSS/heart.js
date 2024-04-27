
let check = async function(pid) {
    let id = '${session_id}';
    let likeButton = document.querySelector('#fav' + pid);
    let nullInput = document.createElement('img');
    let fullInput = document.createElement('img');
    console.log(likeButton)

    if (id !== "null") {
        fetch('like?p_id=' + pid, {
            method: 'get',
            headers: {
                'Content-Type': 'application/json',
            },
        }).then(response => {
            if (!response.ok) throw new Error('로드 실패');
            return response.text();
        }).then(data => {
            console.log("data 정보" + data);

            if (data >= 1) { // 데이터가 1보다 크다 => 찬하트라는 뜻
                fullInput.src = 'indexImg/yeslike.png';
                fullInput.classList.add('like');
                fullInput.alt = '찬하트';
                fullInput.onclick = function() {
                    check(pid); // onclick 이벤트에 check 함수 연결
                };
                likeButton.innerHTML = '';
                likeButton.appendChild(fullInput);
            } else { // 아니다 => 빈하트라는 뜻 그러니까 찬하트로 변경
                nullInput.src = 'indexImg/nolike.png';
                nullInput.classList.add('like');
                nullInput.alt = '빈하트';
                nullInput.onclick = function() {
                    check(pid); // onclick 이벤트에 check 함수 연결
                };
                likeButton.innerHTML = '';
                likeButton.appendChild(nullInput);

            }

            /*if (data >= 1) { // 데이터가 1보다 크다 => 찬하트라는 뜻
                nullInput.src = 'indexImg/nolike.png';
                nullInput.classList.add('like');
                nullInput.alt = '빈하트';
                fullInput.onclick = function() {
                    check(pid); // onclick 이벤트에 check 함수 연결
                };
                console.log("nullInput");
                console.log(nullInput);
                console.log(likeButton)
                //likeButton.innerHTML = '';
                likeButton.appendChild(real)
                real.appendChild(nullInput)

            } else { // 아니다 => 빈하트라는 뜻 그러니까 찬하트로 변경

                fullInput.src = 'indexImg/yeslike.png';
                fullInput.classList.add('like');
                fullInput.alt = '찬하트';
                fullInput.onclick = function() {
                    check(pid); // onclick 이벤트에 check 함수 연결
                };
                console.log("fullInput");
                console.log(fullInput);
                console.log(likeButton)
                //likeButton.innerHTML = '';
                likeButton.appendChild(real)
                real.appendChild(fullInput)
            }*/
        }).catch(error => {
            console.log(error);
            result.innerHTML = '';
        }).finally(() => console.log('finally'));
    }
}
