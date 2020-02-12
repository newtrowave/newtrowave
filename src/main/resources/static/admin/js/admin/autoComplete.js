const a = document.getElementById("keyword"); // input 태그 ID
const b = document.getElementById("autoCompleteForm-group"); // 자동완성 div 태그 ID

function setArray(result) {
  return result;
}

a.addEventListener("keydown", function(e) {
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

  setTimeout(function() {
    let av = a.value;

    if (av == "") {
      b.innerHTML = "";
    }

    if (check && av != "") {
      b.innerHTML = "";
      let len;
      let result;

      let s = fetch("/api/keyword/list/"+av, {
        method : 'GET'
      })
          .then(res => res.json())
          .then(res => {
            result = res.data;
            console.log(res.data);
            if(res.ok) {
              return result;
            }
          })

      console.log(typeof s);
      console.log(s);

      if (len > 0) {
        for (let i = 0; i < len; i++) {
          let t = document.createElement("button");
          t.innerHTML = result[i].keyword_name;
          t.className = "btnList";
          t.setAttribute("key_id", result[i].keyword_id);

          b.append(t);

        }
      } else {
        b.innerHTML = "";

        let t = document.createElement("button");
        t.innerHTML = av;
        t.className = "btnList";

        b.append(t);

        if (e.keyCode == 13) {
          alert(t.innerHTML);
        }
      }
    } else if (e.keyCode == 40) {
      b.firstChild.focus();
    }
  }, 0);
});

b.addEventListener("keydown", function(e) {
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
        console.log("true");
      } else {
        console.log(false);
        let b = document.createElement("input");
        b.readOnly = "readOnly";
        b.setAttribute(
          "keywordId",
          document.activeElement.getAttribute("key_id")
        );
        b.value = document.activeElement.innerHTML;

        document.getElementById("autoB").append(b);
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

function creatingTags() {}

