

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import twitter.TweetInsert;
import twitter.TweetList;

/**
 * Servlet implementation class TweetInsertServlet
 */
@WebServlet("/TweetInsertServlet")
public class TweetInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		
		TweetList tl = new TweetList();
		tl.setContent(request.getParameter("content"));	
		
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		if(date!="" || time!="") {
			String timeSetting = date + " " + time + ":00";
			System.out.println(timeSetting);
			tl.setTimeSetting(timeSetting);	
		}
		
		TweetInsert ti = new TweetInsert();
		
		if(tl.getContent()!=null) {
			ti.tweetInsert(tl);
			request.setAttribute("contentSet","ツイート内容を保存しました");
		}
		
		ArrayList list = new ArrayList();
		list = (ArrayList) ti.tweetList();
		request.setAttribute("tweetList", list);
		
		ArrayList noTimeList = new ArrayList();
		noTimeList = (ArrayList) ti.tweetListNoTime();
		request.setAttribute("tweetListNoTime", noTimeList);
		
		int tweetCount = ti.tweetListCount();
		request.setAttribute("tweetCount", tweetCount);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("tweetinsert.jsp");
		rd.forward(request, response);

	}

}
