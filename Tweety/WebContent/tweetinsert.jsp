<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="UTF-8">
<title>ツイートを保存</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript">
   //登録された内容を削除する際の確認メッセージ
    function checkSubmit() {
      result = confirm("削除してもいいですか？");
      if (result) {
        document.myform.action = "";
        } else {
        alert("キャンセルします。");
        return false;
      }
    }
  </script>
</head>
<body>
  <h1>ツイートを保存する</h1>
  <p>${contentSet}</p>
  <form action="TweetInsertServlet" method="post">
    <textarea name="content" cols="50" rows="10" placeholder="ツイート内容"></textarea>
    <br> <input type="date" name="date" placeholder="日付設定"><br>
    <input type="time" name="time" placeholder="時間設定"><br> <input
      type="submit">
  </form>

  <br>
  <a href="GetTimeLineServlet">ツイートする</a>
  <br>
  <a href="index.jsp">ホームへ</a><br>
  <a href="tweetbot.jsp">ボットアプリのホームへ</a>
  <br>
  <c:choose>
    <c:when test="${tweetCount!=0}">
      <p>${contentStatus}</p>
      <h1>保存されたツイート一覧 （全${tweetCount}件）</h1>
      <h2>時間指定あり</h2>
      <table border="1">
        <tr>
          <th>ID</th>
          <th>内容</th>
          <th>投稿回数</th>
          <th>時間設定</th>
          <th>公開設定</th>
        </tr>

        <c:forEach var="content" items="${tweetList}">
          <tr>
            <td>${content.contentId}</td>
            <td>${content.content}</td>
            <td>${content.count}</td>
            <td>${content.timeSetting}</td>
            <td>${content.visibility}</td>
            <td>
              <form action="VisibilityUpdateServlet" method="post">
                <label>公開<input type="radio" name="visibility"
                  value="公開"></label> <label>非公開<input type="radio"
                  name="visibility" value="非公開"></label> <input type="hidden"
                  name="contentId" value="${content.contentId}"> <input
                  type="submit" value="設定する">
              </form>
            </td>
            <td>
              <form action="InputUpdateServlet" method="post">
                <input type="hidden" name="contentId"
                  value="${content.contentId}"> <input type="hidden"
                  name="content" value="${content.content }"> <input
                  type="hidden" name="count" value="${content.count }"> <input
                  type="hidden" name="timeSetting"
                  value="${content.timeSetting }"> <input type="submit"
                  value="投稿を編集する">
              </form>
            </td>
            <td>
              <form action="TweetDeleteServlet" onSubmit="return checkSubmit()"
                method="post">
                <input type="hidden" name="contentId"
                  value="${content.contentId}"> <input type="submit"
                  value="削除">
              </form>
            </td>
          </tr>
        </c:forEach>
      </table>

      <h2>時間指定なし</h2>
      <table border="1">
        <tr>
          <th>ID</th>
          <th>内容</th>
          <th>表示回数</th>
          <th>時間設定</th>
          <th>公開設定</th>
        </tr>

        <c:forEach var="content2" items="${tweetListNoTime}">
          <tr>
            <td>${content2.contentId}</td>
            <td>${content2.content}</td>
            <td>${content2.count}</td>
            <td>${content2.timeSetting}</td>
            <td>${content2.visibility}</td>
            <td>
              <form action="VisibilityUpdateServlet" method="post">
                <label>公開<input type="radio" name="visibility"
                  value="公開"></label> <label>非公開<input type="radio"
                  name="visibility" value="非公開"></label> <input type="hidden"
                  name="contentId" value="${content2.contentId}"> <input
                  type="submit" value="設定する">
              </form>
            </td>
            <td>
              <form action="InputUpdateServlet" method="post">
                <input type="hidden" name="contentId"
                  value="${content2.contentId}"> <input type="hidden"
                  name="content" value="${content2.content }"> <input
                  type="hidden" name="count" value="${content2.count }">
                <input type="hidden" name="timeSetting"
                  value="${content2.timeSetting }"> <input type="submit"
                  value="投稿を編集する">
              </form>
            </td>
            <td>
              <form action="TweetDeleteServlet" onSubmit="return checkSubmit()"
                method="post">
                <input type="hidden" name="contentId"
                  value="${content2.contentId}"> <input type="submit"
                  value="削除">
              </form>
            </td>
          </tr>
        </c:forEach>
      </table>
    </c:when>

    <c:otherwise>
      <p>登録されているツイートがありません</p>
    </c:otherwise>
  </c:choose>

</body>
</html>