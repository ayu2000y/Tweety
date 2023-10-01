

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter.Tweet;

/**
 * Servlet implementation class GetTimeLineServlet
 */
@WebServlet("/GetTimeLineServlet")
public class GetTimeLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTimeLineServlet() {
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
		
		String tweet = request.getParameter("tweet");
		
		Tweet tw = new Tweet();
		String myName = tw.getMyName();
		String myProf = tw.getMyProf();
		
		ArrayList al = new ArrayList();
		al = (ArrayList) tw.getTimeLine();
		
		request.setAttribute("myName", myName);
		request.setAttribute("myProf", myProf);
		request.setAttribute("tlList", al);
		RequestDispatcher rd = request.getRequestDispatcher("tweet.jsp");
		rd.forward(request, response);
		
	}

}
