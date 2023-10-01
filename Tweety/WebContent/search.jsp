<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
  <h1>${word} の結果</h1>
  <c:forEach var="tweet" items="${search}">
      <textarea name="tweet" cols="50" rows="10" readonly>ユーザー名：${tweet.userName}

${tweet.tweet}
      </textarea>

  </c:forEach>
    <br><br>
    <a href="index.jsp">ホームへ</a><br>
    <a href="tweetbot.jsp">ボットアプリのホームへ</a>
</body>
</html>