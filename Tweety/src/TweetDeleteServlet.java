

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter.TweetDelete;
import twitter.TweetList;

/**
 * Servlet implementation class TweetDeleteServlet
 */
@WebServlet("/TweetDeleteServlet")
public class TweetDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetDeleteServlet() {
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
		
		TweetList tl = new TweetList();
		tl.setContentId(contentId);	
		
		TweetDelete td = new TweetDelete();
		td.tweetDelete(tl);
		request.setAttribute("contentStatus",contentId+"を削除しました");
		
		RequestDispatcher rd = request.getRequestDispatcher("TweetInsertServlet");
		rd.forward(request, response);
	}

}
