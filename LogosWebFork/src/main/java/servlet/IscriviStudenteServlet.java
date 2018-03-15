package servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestioneCorso;
import business.JPAUtility;
import entity.Corso;
import entity.Docente;

/**
 * Servlet implementation class IscriviStudenteServlet
 */
@WebServlet("/IscriviStudenteServlet")
public class IscriviStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IscriviStudenteServlet() {
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
		ObjectMapper om = new ObjectMapper();
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente d = em.find(Docente.class, request.getParameter("codicePersona"));
		Corso c = em.find( Corso.class, Integer.parseInt(request.getParameter("idCorso")));
		String mail = request.getParameter("mail");
		GestioneCorso gc = new GestioneCorso(); 
		Boolean andataBuonFine = gc.iscriviStudente(d, c, mail);
		response.getWriter().append(andataBuonFine.toString());
	}

}
