import {postRequestAjax} from './AjaxSolution.js';

let productSaveBtn = document.getElementById("productSaveBtn");

productSaveBtn.addEventListener("click", function () {
    import * as Obj from './Objects.js';
    var form = new FormData(document.getElementById("form_product_keywords"));

    Obj.header.data.category_id = ""

    let CategoryRequestDto = {
        "transaction_time": "",
        "result_code": "",
        "description": "",
        "data": {
            "category_id": "",
            "category_name": ""
        }
    };

    CategoryRequestDto.data.category_id = form.get("categoryId");
    CategoryRequestDto.data.category_name = form.get("categoryName");

    console.log(CategoryRequestDto);

    let jsonObj = JSON.stringify(CategoryRequestDto);

    postRequestAjax("/api/categos", function (e) {
        console.log(e);
    }, jsonObj);
});