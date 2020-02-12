window.onload = function () {
    searcher = document.getElementById("daen_test");

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function (x) {
        if (xhr.status == 200) {
            if (xhr.readyState == 4) {
                console.log(x.target.response); //todo - daen - 제이슨으로 넘겨주나 gson 을 사용하면 더 간단해지긴 한다.
            }
        }
    }

    searcher.addEventListener("keydown", function (e) {
        setTimeout(function () {

            let k = searcher.value;
            console.log("this is value : " + k);
            xhr.open("GET", "/search/" + k);
            xhr.send();

        }, 0);

    })
};