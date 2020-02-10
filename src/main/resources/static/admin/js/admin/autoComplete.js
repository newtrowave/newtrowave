const a = document.getElementById("autoC"); // input 태그 ID
const b = document.getElementById("autoD"); // 자동완성 div 태그 ID

const list = [
  {
    keyword_id: 1,
    keyword_name: "커널형",
    keyword_description: null,
    keyword_image: null
  },
  {
    keyword_id: 2,
    keyword_name: "오픈형",
    keyword_description: null,
    keyword_image: null
  },
  {
    keyword_id: 3,
    keyword_name: "유선",
    keyword_description: null,
    keyword_image: null
  },
  {
    keyword_id: 4,
    keyword_name: "무선",
    keyword_description: null,
    keyword_image: null
  },
  {
    keyword_id: 5,
    keyword_name: "유무선겸용",
    keyword_description: null,
    keyword_image: null
  },
  {
    keyword_id: 6,
    keyword_name: "코드리스",
    keyword_description: null,
    keyword_image: null
  },
  {
    keyword_id: 7,
    keyword_name: "넥밴드형",
    keyword_description: null,
    keyword_image: null
  },
  {
    keyword_id: 8,
    keyword_name: "백헤드형",
    keyword_description: null,
    keyword_image: null
  },
  {
    keyword_id: 9,
    keyword_name: "귀걸이형",
    keyword_description: null,
    keyword_image: null
  },
  {
    keyword_id: 10,
    keyword_name: "액티브노이즈캔슬링",
    keyword_description: null,
    keyword_image: null
  }
];
a.addEventListener("keydown", function(e) {
  let check = false;

  check =
    e.keyCode != 37 && e.keyCode != 38 && e.keyCode != 39 && e.keyCode != 40
      ? true
      : false;

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
      const result = list.filter(word => word.keyword_name.includes(av));
      let len = result.length;
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

