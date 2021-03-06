package servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.JPAUtility;
import business.Lister;
import entity.Corso;
import entity.Docente;
import entity.Iscrizione;
import entity.Lezione;

/**
 * Servlet implementation class GetIscrizioniPerCorsoServlet
 */
@WebServlet("/GetIscrizioniPerCorsoServlet")
public class GetIscrizioniPerCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetIscrizioniPerCorsoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JPAUtility.emf.createEntityManager();
		ObjectMapper om = new ObjectMapper();
		Corso c = em.find(Corso.class,Integer.parseInt(request.getParameter("idCorso")));
		Lister lister = new Lister();
		List<Iscrizione> l = lister.getIscrizioniperCorso(c);
		String json = om.writeValueAsString(l);
		response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
