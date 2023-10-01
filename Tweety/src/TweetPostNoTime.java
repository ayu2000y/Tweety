

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter.Tweet;
import twitter.TweetList;
import twitter.TweetPost;
import twitter.TweetUpdate;

/**
 * Servlet implementation class TweetPostNoTime
 */
@WebServlet("/TweetPostNoTime")
public class TweetPostNoTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetPostNoTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");		
	
		TweetPost tp = new TweetPost();
		TweetList tl = tp.tweetPostNoTime();
			
		String content = tl.getContent();
				
		System.out.println("ツイート内容："+content);
				
		Tweet tw = new Tweet();
		String tweetToken = tw.tweet(content);
				
		if(tweetToken.equals("投稿したよ")==false) {
			
			request.setAttribute("tweetToken", tweetToken);
		}else {
			TweetUpdate tu = new TweetUpdate();
			tu.tweetCountUp(tl);
			request.setAttribute("tweetToken", tweetToken);
		}
		if(content==null) {
			content = "すべて非公開";
			request.setAttribute("content", content);
		}else {
			request.setAttribute("content", "<textarea cols='50' rows='15' readonly>"+content+"</textarea>");
		}
		request.setAttribute("flag", "on");
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}

}
