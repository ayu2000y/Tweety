<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集</title>
 <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
  <h1>編集</h1>
  <form action="TweetUpdateServlet" method="post">
    <input type="hidden" name="contentId" value="${contentId}">
    <textarea name="content" cols="50" rows="10"  >${content}</textarea><br>
    <input type="date" name="date" value="${date}" placeholder="日付設定"><br>
    <input type="time" name="time" value="${time}" placeholder="時間設定"><br>
    <input type="submit" value="編集する">
  </form>
  <a href="TweetInsertServlet">戻る</a><br>
  <a href="GetTimeLineServlet">ツイートする</a><br>

  <br>
  <a href="index.jsp">ホームへ</a><br>
  <a href="tweetbot.jsp">ボットアプリのホームへ</a>
</body>
</html>