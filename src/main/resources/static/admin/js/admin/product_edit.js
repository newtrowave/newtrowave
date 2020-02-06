import {postRequestAjax} from './AjaxSolution.js';

let p = document.getElementById("productSaveBtn");

p.addEventListener("click", function() {
    postRequestAjax()
})
