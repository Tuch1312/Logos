package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestionePersona;
import entity.Persona;

/**
 * Servlet implementation class LoginServlet
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("mail");
		String r = request.getParameter("password");
		GestionePersona gp = new GestionePersona();
		String t = null;
		try  {
			t = gp.login(s, r);
		} catch (Exception e) {
			
		}
		
		if(t!=null) {
			response.getWriter().append(t);
		} else {
			response.getWriter().append("123456789");
		}
		
	}

}
