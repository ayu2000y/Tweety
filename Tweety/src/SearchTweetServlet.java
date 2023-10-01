

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter.SearchListBean;
import twitter.Tweet;

/**
 * Servlet implementation class SearchTweetServlet
 */
@WebServlet("/SearchTweetServlet")
public class SearchTweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTweetServlet() {
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
		
		String searchWord = request.getParameter("searchWord");
		request.setAttribute("word",searchWord);
		if(searchWord!=null) {
			Tweet tweet = new Tweet();
			
			ArrayList al = new ArrayList();
			al = (ArrayList) tweet.searchTweet(searchWord);
			
			request.setAttribute("search", al);

		}else {
			request.setAttribute("search", "検索結果がありません");
			
		}
		request.setAttribute("searchCheck", "OK");
		RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
		rd.forward(request, response);
	}

}
