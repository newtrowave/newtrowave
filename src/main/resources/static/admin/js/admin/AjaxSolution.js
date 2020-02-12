let xhr;

export function postRequestAjax(url, func, data) {
    xhr = new XMLHttpRequest();

    xhr.open("POST", url);

    xhr.onload = func;

    xhr.onerror = function(e) {
        console.log("에러코드 : " + xhr.errorCode);
        console.log(xhr.errorClass);
    }

    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    xhr.send(data);

}