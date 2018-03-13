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
		GestionePersona gp = new GestionePersona();
		Persona t = gp.login(request.getParameter("mail"), request.getParameter("password"));
		if(t!=null) {
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(t);
			response.getWriter().append(json);
		} else {
			response.getWriter().append("sei un prila");
		}
		
	}

}
