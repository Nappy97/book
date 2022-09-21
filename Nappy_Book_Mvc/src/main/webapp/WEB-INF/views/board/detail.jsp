<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   
<c:choose>
	<c:when test="${empty list || fn:length(list) == 0}">
		<script>
			alert("해당 정보가 삭제되거나 없습니다");
			history.back();
		</script>
	</c:when>
	<c:otherwise>
    	<c:set var="dto" value="${list[0]}"/>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <title>조회 - ${dto.title}</title>
</head>

<script>
function chkDelete(){
	let answer = confirm("삭제 go?");
	if(answer){
		document.forms['frmDelete'].submit();
	}
}
</script>

<body>
<nav class="navbar navbar-dark bg-dark">
  <!-- Navbar content -->
    <h5 class="text-white h4">책을 읽읍시다</h5>
</nav>
    <div class="container mt-3">
        <h2>조회 - ${dto.title }</h2>
        <hr>
        <div class="mb-3 mt-3 clearfix">
            <span class="float-start me-2">책 번호: ${dto.id}</span>
            <span class="float-end ms-4">작성일: ${dto.regDateTime }</span>
            <span class="float-end">조회수: ${dto.viewCnt }</span>
        </div>

        <section>
        	<form name="frmDelete" action="delete" method="POST">
        		<input type="hidden" name="id" value="${dto.id }">
        	</form>
            <div class="mb-3">
                <label for="title">제목:</label>
                <span class="form-control" >${dto.title }</span>
            </div>    
            <div class="mb-3 mt-3">
                <label for="price">가격:</label>
                <span class="form-control" >${dto.price }</span>
            </div>    
            <div class="mb-3 mt-3">
                <label for="content">내용:</label>
                <span class="form-control" >${dto.summary }</span>
            </div>    

            <!-- 하단 링크 -->
            <a class="btn btn-outline-dark" href="update?id=${dto.id }">수정</a>
            <a class="btn btn-outline-dark" href="list">목록</a>
            <button type="button" class="btn btn-outline-dark" onclick="chkDelete()">삭제</button>
            <a class="btn btn-outline-dark" href="write">작성</a>
            <!-- 하단 링크 -->        

        </section>
    </div>
</body>

</html>

	</c:otherwise>
</c:choose>   
    
    