<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html><head><title>게시판</title>
</head>
<body>
<h3>게시글 상세보기</h3>
제목 ${board.title} <br>
내용 ${board.content}
<hr>
<h3>댓글</h3>

<div id="reply"> </div>
<form name="replyFrm">
<input name="content">
<button type="button" id="btnAdd">댓글 등록</button>
</form>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
//댓글 목록 조회
$.ajax({
	url: "getReplyList",
	data: { board_seq:${board.seq} }, // --> "board_seq=${board.seq}"
	dataType: "json",
	success: function(response){
		for(i=0; i<response.length; i++) {
			$("#reply").append(response[i].content + "<br>");
		}
	}
});

//댓글등록
$(btnAdd).on("click", function(){
	//등록 ajax 처리하고 등록된 댓글을 div에 append
	$.ajax({
		url: "insertReply",
		data: { board_seq:${board.seq} , content:$("[name=content]").val() }, // --> ?board_seq=1&content=dddd
		dataType: "json",
		success : function(response){
			$("#reply").append(response.content + "<br>");
		}	
	})
});
</script>
</body>
</html>