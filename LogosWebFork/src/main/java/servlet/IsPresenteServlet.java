package servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestionePresenze;
import business.JPAUtility;
import entity.Corso;
import entity.Docente;
import entity.Studente;

/**
 * Servlet implementation class IsPresenteServlet
 */
@WebServlet("/IsPresenteServlet")
public class IsPresenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IsPresenteServlet() {
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
		EntityManager em = JPAUtility.emf.createEntityManager();
		Studente s = em.find(Studente.class, request.getParameter("codicePersona"));
		Corso c = em.find(Corso.class, Integer.parseInt(request.getParameter("idCorso")));
		GestionePresenze gp = new GestionePresenze();
		Boolean andataBuonFine = gp.isPresente(s, c);
		response.getWriter().append(andataBuonFine.toString());
	}

}
