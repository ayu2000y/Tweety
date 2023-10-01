<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ツイート</title>
 <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
  <h1>ツイートする</h1>
  <p>${tweetToken}</p>
  <form action="TweetServlet" method="post">
      <textarea name="tweet" cols="50" rows="10">${content}</textarea>
    <br>
    <input type="submit">
  </form>

  <br>

  <h1>タイムライン</h1>
  <p>アカウント名：@${myName}</p>
  <p>プロフィール：${myProf}</p>

  <c:forEach var="tl" items="${tlList}">
    <textarea cols="50" rows="15" readonly>${tl}</textarea><br>
  </c:forEach>
<br>
  <a href="index.jsp">ホームへ</a><br>
  <a href="tweetbot.jsp">ボットアプリのホームへ</a>
</body>
</html>