<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <title>목록</title>
</head>

<body>

<nav class="navbar navbar-dark bg-dark">
  <!-- Navbar content -->
    <h5 class="text-white h4">목록</h5>
</nav>


<div class="alert alert-light" role="alert">
<c:forEach var="dto" items="${list }">
<div class="card" style="width: 18rem;">
  <div class="card-body">
  	<h6>${dto.id }</h6>
    <h5 class="card-title"><a href="detail?id=${dto.id }">${dto.title }</a></h5>
    <h6 class="card-subtitle mb-2 text-muted">가격:${dto.price }</h6>
    <p class="card-text">조회수 : ${dto.viewCnt }</p>
    <a class="card-link">${dto.regDateTime}</a>
  </div>
</div>
</c:forEach>
        <a class="btn btn-primary" href="regist" role="button">책 소개하기</a>
    </div>

</body>
</html>
