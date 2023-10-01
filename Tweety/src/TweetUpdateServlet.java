

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter.TweetDelete;
import twitter.TweetList;
import twitter.TweetUpdate;

/**
 * Servlet implementation class TweetUpdateServlet
 */
@WebServlet("/TweetUpdateServlet")
public class TweetUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetUpdateServlet() {
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
		
		String contentId = request.getParameter("contentId");
		String content = request.getParameter("content");
		
		TweetList tl = new TweetList();
		tl.setContent(content);
		tl.setContentId(contentId);
		
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		if(date!="" || time!="") {
			String timeSetting = date + " " + time + ":00";
			System.out.println(timeSetting);
			tl.setTimeSetting(timeSetting);	
		}
			
		request.setAttribute("contentId", contentId);
		request.setAttribute("content", content);
		request.setAttribute("date", date);
		request.setAttribute("time", time);
		
		TweetUpdate tu = new TweetUpdate();
		tu.tweetUpdate(tl);
		request.setAttribute("contentStatus","更新しました");
		
		RequestDispatcher rd = request.getRequestDispatcher("tweetupdate.jsp");
		rd.forward(request, response);
	}

}
