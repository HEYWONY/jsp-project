let check = async function(pid) {
    fetch('like?p_id=' + pid, {
        method: 'get',
        headers: {
            'Content-Type': 'application/json',
        },
    }).then(response => {
        if (!response.ok) throw new Error('로드 실패');
        return response.text();
    }).then(data => {
        if(data >= 1) {
            document.getElementById("star_fav").src="chh/img/fill_star.png"
        } else {
            document.getElementById("star_fav").src="chh/img/empty_star.png"
        }

    }).catch(error => {
        console.log(error);
        result.innerHTML = '';
    }).finally(() => console.log('finally'));
}