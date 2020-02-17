document.querySelector('.block-section').addEventListener("dragover", dragOver);
document.querySelector('.block-section').addEventListener("drop", uploadFiles);

function dragOver(e) {
    e.stopPropagation();
    e.preventDefault();

    if (e.type == "dragover") {
        e.target.style.backgroundColor = "black";
        e.target.style.outlineOffset = "-20px";

    } else {
        e.target.style.backgroundColor = "gray";
        e.target.style.outlineOffset = "-10px";
    }
}

function uploadFiles(e) {
    e.stopPropagation();
    e.preventDefault();
    dragOver(e);
    let forms = new FormData(document.getElementById("fileImagesForm"));

    let dropFiles = e.dataTransfer.files;
    if (dropFiles.length > 0)
        for (f of dropFiles) {
            forms.append("files", f, f.name);
        }

    let response = fetch("/api/product/files", {
        method: "POST",
        body: forms
    }).then(res => {
        console.log("res(성공) : " + res);
        return res;
    }).catch(err => {
        console.log("err(실패) : " + err);
        return err;
    });

    var files = e.target.files || e.dataTransfer.files;

    if (files[0].type.match(/image.*/)) {
        e.target.style.outline = "dashed";
        e.target.append(imageBlockBuild(e.dataTransfer.files[0]));
    } else {
        alert("이미지가 아님");
        return;
    }
}

function imageBlockBuild(fileUrl) { // list를 받아 이미지를 생성

    let imageBlock = document.createElement("span");
    let image = document.createElement("img");

    console.log("#61 : " + window.URL.createObjectURL(fileUrl));            // todo 아직 완벽하게 이해하지 못한 window.URL.createObjectURL 개념

    image.src = window.URL.createObjectURL(fileUrl);

    image.style.width = "90px";                                             //  드롭존에 업로드되는 이미지 크기 수정
    image.style.height = "90px";
    image.style.borderRadius = "5px";

    imageBlock.append(image);
    imageBlock.className = "image-blocks";

    return imageBlock;
}