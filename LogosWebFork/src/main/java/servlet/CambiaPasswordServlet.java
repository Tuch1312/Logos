package servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestionePersona;
import business.JPAUtility;
import entity.Persona;

/**
 * Servlet implementation class CambiaPasswordServlet
 */
@WebServlet("/CambiaPasswordServlet")
public class CambiaPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiaPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codicePersona = request.getParameter("codicePersona");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		GestionePersona gp = new GestionePersona();
		EntityManager em = JPAUtility.emf.createEntityManager();
		Persona p = em.find(Persona.class, codicePersona);
		Boolean andataBuonFine = gp.cambiaPassword(oldPassword, newPassword, p);
		response.getWriter().append(andataBuonFine.toString());
	}

}
