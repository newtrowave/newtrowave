/* keywordsListForm-group 블럭된 태그들이 들어가야 할 div 태그 id */
/* autoCompleteForm-group 자동완성이 보여져야할 div 태그 id */
/* productsFilesForm 파일 드래그 앤 드롭 후 파일 추가하는 곳 */

let productSubmitBtn = document.getElementById("productSaveBtn");

let data = {
    "transaction_time": "",
    "result_code": "",
    "description": "",
    "data": {}
};

let k = productSubmitBtn.addEventListener("click", function () {
    let products = new FormData(document.getElementById("productsForm"));

    let i = [];
    products.forEach(function (value, key, opt) {

        if (key == "keywords") {
            let keywords = {
                "keyword_name" : value
            }
            i.push(keywords);
        } else {
            data.data[key] = value;
        }
    });

    data.data.keywords = i;

    fetch("/api/product", {
        method: 'post',
        headers: {
            'Content-Type': "application/json"
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            console.log(response);
        }).catch(err => {
        console.log(err);
    })
});
