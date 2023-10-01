

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter.TweetList;

/**
 * Servlet implementation class InputUpdateServlet
 */
@WebServlet("/InputUpdateServlet")
public class InputUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputUpdateServlet() {
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
		int count = Integer.parseInt(request.getParameter("count"));
		String timeSetting = request.getParameter("timeSetting");
		
		System.out.println(timeSetting);
		
		String date = "";
		String time = "";
		
		if(timeSetting.equals("時刻設定なし")==false) {
			date = timeSetting.substring(0, 4) + "-" + timeSetting.substring(5,7) + "-" + timeSetting.substring(8,10);
			time = timeSetting.substring(11, 16);
			System.out.println("date:"+date+"\t time:"+time);
		}
		
		request.setAttribute("contentId", contentId);
		request.setAttribute("content", content);
		request.setAttribute("date", date);
		request.setAttribute("time", time);
		
		RequestDispatcher rd = request.getRequestDispatcher("tweetupdate.jsp");
		rd.forward(request, response);
	}

}
