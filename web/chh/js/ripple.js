window.onload=function () {
    $(".full-landing-image").ripples({
        resolution: 256, // 렌더링 값이 클수록 잔물결 효과가 느리게 전파
        perturbance: 0.04, // 잔물경 굴절 강도. 0은 굴절 없음
    });
}
