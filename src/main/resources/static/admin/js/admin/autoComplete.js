const a = document.getElementById("keyword"); // input 태그 ID
const b = document.getElementById("autoCompleteForm-group"); // 자동완성 div 태그 ID

a.addEventListener("keydown", function (e) {
    let check = false;

    check =
        e.keyCode !== 37 && e.keyCode != 38 && e.keyCode != 39 && e.keyCode != 40;

    /*

      todo - 문자 키를 눌렀을 시에만 이벤트 활성화

     ← 37
     ↑ 38
     → 39
     ↓ 40
     ENTER 13
     ESC 27

    */

    setTimeout(function () {
        let av = a.value;

        if (av == "") {
            b.innerHTML = "";
        }

        if (check && av != "") {
            b.innerHTML = "";
            let len;
            let result;

            let s = fetch("/api/keyword/list/" + av, {
                method: 'GET'
            })
                .then(res => {
                    return res.json();
                })
                .then(res => {
                    result = res.data;
                    console.log(res);
                    console.log(res.data);

                    setArray(res.data.keywords.length, res.data.keywords);
                })

            console.log(typeof s);
            console.log(s);

            function setArray(len, result) {
                console.log(len);
                if (len > 0) {
                    for (let i = 0; i < len; i++) {
                        let t = document.createElement("button");
                        t.innerHTML = result[i].keyword_name;
                        t.className = "autoCompleteBlocks";
                        t.setAttribute("key_id", result[i].keyword_id);

                        b.append(t);

                    }
                } else {
                    b.innerHTML = "";

                    let t = document.createElement("button");
                    t.innerHTML = av;
                    t.className = "autoCompleteBlocks";

                    b.append(t);

                    if (e.keyCode == 13) {
                        alert(t.innerHTML);
                    }
                }
            }
        } else if (e.keyCode == 40) {
            b.firstChild.focus();
        }
    }, 0);
});

b.addEventListener("keydown", function (e) {
    selectKeytegoryEvent(e, a, b);
});

/* 카테고리 & 키워드 생성 */

function makingAutoTag(keytegory, catOrKey) {
    switch (catOrKey) {
        // Category 일 때
        case 1:
            requestAutoTag(keytegory, catOrKey);

            break;

        // Keyword 일 때
        case 2:
            // 카테고리 모달창 UP
            categoryModalShow();

            // 그곳에서 카테고리를 선택 한 후
            categories =
                // 함께 데이터 세이브 요청 처리
                requestAutoTag(keyTegory, catOrKey, categories);

            break;
    }
}

function selectKeytegoryEvent(e, target, modal, selector) {
    let key = e.keyCode;

    switch (key) {
        case 40:
            document.activeElement.nextSibling.focus();

            break;

        case 38:
            if (
                document.activeElement.previousSibling != modal.firstChild &&
                document.activeElement.previousSibling == null
            ) {
                a.focus();
            } else {
                document.activeElement.previousSibling.focus();
            }
            break;

        case 13:
            if (selector) {
            } else {
              let z = document.createElement("div");
                let b = document.createElement("input");
                b.readOnly = true;
                b.type = "hidden";
                b.setAttribute(
                    "keyword_id",
                    document.activeElement.getAttribute("key_id")
                );
                b.name = "keywords";
                z.setAttribute("class", "keywordListBlock");
                z.innerHTML = document.activeElement.innerHTML;
                b.value = document.activeElement.innerHTML;

                z.append(b);

                document.getElementById("keywordsListForm-group").append(z);
            }
            break;

        default:
            target.focus();
            break;
    }
}

function categoryModalShow() {
    document.getElementById("modal").style.display = "block";
}

function creatingTags() {
}

