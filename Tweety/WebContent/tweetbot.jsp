<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<%
    String time = "";
    String url = "TweetPostNoTime?time="+time;
    if(request.getParameter("time")!=null){
        time = (String)request.getParameter("time");
    }
 %>
<meta id="meta" http-equiv="refresh" content="<%=time%>; URL=">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
    $(function() {
        timer(<%=time%>);
        var meta = document.getElementById('meta');
        console.log(meta);
        //自動投稿するとき
        $('#post').on('click', function() {
            var time = prompt('時間を設定してください(秒)');
            console.log("自動投稿開始");
            $('#meta').after('<meta id="post" http-equiv="refresh" content="'+time+'; URL=TweetPostNoTime?time='+time+'">');
            $('#meta').remove();
            var post = document.getElementById('post');
            console.log(post);
            var meta = document.getElementById('meta');
            console.log(meta);
            timer(time);
        });

        //自動投稿を止めるとき
        $('#stop').on('click', function() {
            console.log("自動投稿終了");
            $('#meta').after('<meta id="stop" http-equiv="refresh" content="0; URL=index.jsp">');
            $('#meta').remove();
            var meta2 = document.getElementById('meta');
            console.log(meta2);
            var stop = document.getElementById('stop');
            console.log(stop);
        });
    });

    function timer(sec){
        if(sec!=null){
          // 開始日時を設定
          var dt = new Date();
          console.log("Start: ", dt);
          // 終了時刻を開始日時+カウントダウンする秒数に設定
          var endDt = new Date(dt.getTime() + sec * 1000);
          console.log("End : ", endDt);

          // 1秒おきにカウントダウン
          cnt = sec;
          var id = setInterval(function(){
            cnt--;
            console.log(cnt);
            document.getElementById("time").innerHTML="<p><strong>次にツイートされるまでの時間："+cnt+"</strong></p>";
            // 現在日時と終了日時を比較
            dt = new Date();
            if(dt.getTime() >= endDt.getTime()){
              clearInterval(id);
              console.log("Finish!");
            }
          }, 1000);
        }
    }
</script>
<title>ホーム</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
  <p>BotAppTest</p>
  <h1>ついったーAPIのてすと</h1>
  <div id="time"></div>
  ${content}

  <p style="color: red">${tweetToken}</p>

  <a href="GetTimeLineServlet">ツイートする</a>
  <br>
  <a href="TweetInsertServlet">ツイートの管理</a>
  <br>
  <br>
  <a href="TweetPostNoTime">時間指定のないものを投稿する</a>
  <br>

  <button id="post" onclick="">自動投稿する</button>
  <button id="stop" onclick="">自動投稿ストップ</button>

  <br>
  <br>

  <form action="SearchTweetServlet" method="post">
    <input type="text" name="searchWord" placeholder="検索" required>
    <input type="submit" value="検索">
  </form>
  <br>
  <a href="index.jsp">ホームへ</a>
</body>
</html>