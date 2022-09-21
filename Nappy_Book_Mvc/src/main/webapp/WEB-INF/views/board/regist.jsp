<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>책 등록하기</title>
</head>

<body>

<nav class="navbar navbar-dark bg-dark">
  <!-- Navbar content -->
    <h5 class="text-white h4">책을 읽읍시다!</h5>
</nav>

<div class="container mt-3">
    <h2>책 등록하기</h2>
    <hr>
    <form name="frm" action="regist" method="post">
        <div class="mb-3">
            <label for="title">책 제목:</label>
            <input type="text" class="form-control" id="title" placeholder="책 제목을 입력하세요" name="title" required>
        </div>

        <div class="mb-3 mt-3">
            <label for="price">가격:</label>
            <input type="text" class="form-control" id="price" placeholder="가격을 입력하세요" name="price" required>
        </div>
        <div class="mb-3 mt-3">
            <label for="summary">내용:</label>
            <textarea class="form-control" rows="5" id="summary" placeholder="내용을 입력하세요" name="summary"></textarea>
        </div>

        <input class="btn btn-primary" type="submit" value="Submit">
        <a class="btn btn-primary" href="list" role="button">목록</a>

    </form>

</div>

</body>

</html>
