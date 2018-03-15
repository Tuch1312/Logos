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
import entity.Lezione;
import entity.Studente;

/**
 * Servlet implementation class GetStudentiPerCorsoServlet
 */
@WebServlet("/GetStudentiPerCorsoServlet")
public class GetStudentiPerCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudentiPerCorsoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		EntityManager em = JPAUtility.emf.createEntityManager();
		Corso c = em.find(Corso.class, Integer.parseInt(request.getParameter("idCorso")));
		Lister lister = new Lister();
		List<Studente> l = lister.getStudentiPerCorso(c);
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
