package servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestioneLezioni;
import business.JPAUtility;
import entity.Corso;
import entity.Docente;
import entity.Lezione;

/**
 * Servlet implementation class ModificaLezioneServlet
 */
@WebServlet("/ModificaLezioneServlet")
public class ModificaLezioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaLezioneServlet() {
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
		System.out.println(request.getParameter("codicePersona"));
		
		EntityManager em =JPAUtility.emf.createEntityManager();
		Docente d = em.find(Docente.class, request.getParameter("codicePersona"));
		Corso c = em.find( Corso.class, Integer.parseInt(request.getParameter("idCorso")));
		Lezione l = om.readValue(request.getParameter("lezione"), Lezione.class);
		GestioneLezioni gl = new GestioneLezioni(); 
		Boolean andataBuonFine = gl.modificaLezione(d, c, l);
		response.getWriter().append(andataBuonFine.toString());
	}

}
