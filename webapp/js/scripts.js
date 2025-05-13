//자바 스크립트
$(".answerWrite input[type=submit]").click(addAnswer);

function addAnswer(e) {
    console.log("addAnswer 호출됨");
    e.preventDefault();
    var queryString = $(".submit-write").serialize();

    $.ajax({
        type: 'post',
        url: '/api/qna/addAnswer',
        data: queryString,
        dataType: 'json',
        error: onError,
        success: onSuccess,
    });
}

//요청이 성공했을 때 아래 함수를 실행 시킴. 즉, 동적으로 화면 생성
function onSuccess(json, status) {
    console.log(json.answer.writer)
    var answerTemplate = $("#answerTemplate").html();
    var template = answerTemplate.format(json.answer.writer, new Date(json.answer.createdDate), json.answer.contents, json.answer.answerId);
    $(".qna-comment-kuit-articles").prepend(template);
    var countOfAnswer = document.getElementsByTagName("strong").item(0);
    let number = parseInt(countOfAnswer.innerText, 10);
    number += 1;
    countOfAnswer.textContent = number.toString();
}

function onError(xhr, status) {
    alert("error");
}

String.prototype.format = function () {
    var args = arguments;
    return this.replace(/{(\d+)}/g, function (match, number) {
        return typeof args[number] != 'undefined'
            ? args[number]
            : match
            ;
    });
};