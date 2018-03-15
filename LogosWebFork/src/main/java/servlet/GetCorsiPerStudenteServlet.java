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

import business.GestionePersona;
import business.JPAUtility;
import business.Lister;
import entity.Corso;
import entity.Docente;
import entity.Lezione;
import entity.Studente;

/**
 * Servlet implementation class GetCorsiPerStudenteServlet
 */
@WebServlet("/GetCorsiPerStudenteServlet")
public class GetCorsiPerStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCorsiPerStudenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Studente s = em.find(Studente.class, request.getParameter("codicePersona"));
		Lister lister = new Lister();
		List<Corso> l = lister.getCorsiPerStudente(s);
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(l);
		response.getWriter().append(json);
	}

}
