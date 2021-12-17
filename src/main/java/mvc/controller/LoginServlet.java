package mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.model.UserContentBean;
import mvc.model.UserDatabase;

import javax.servlet.http.Cookie;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//System.out.println("POST runs");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDatabase uDB = new UserDatabase();
		
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("homePage.jsp");
		
		UserContentBean printBean = new UserContentBean();

		uDB.authenticate(username, password);
		
		if (uDB.authenticate(username, password)) {
			uDB.getUser(username);
			
			/* Session isn't used yet.
			 * session.setAttribute("Logged-in", "true");
			session.setAttribute("username", username);
			session.setMaxInactiveInterval(60);*/
			
			if (uDB.getUser(username).getType().equals("admin")) {
				printBean.setToPrint("<h1>Hello Admin!</h1>"); //HTMl borde egentligen vara i jsp, men detta funkar
				
			} else {
				printBean.setToPrint("<h1>Hello " + username +"!</h1>");
			}
		
		} else {
			//session.setAttribute("Logged-in", "false");
			printBean.setToPrint("hallo");
		}
		
		request.setAttribute("printBean", printBean);
		rd.forward(request,response);
	}

}
