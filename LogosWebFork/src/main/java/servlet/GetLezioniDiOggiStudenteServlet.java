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
import entity.Docente;
import entity.Lezione;
import entity.Persona;
import entity.Studente;

/**
 * Servlet implementation class GetLezioniDiOggiStudenteServlet
 */
@WebServlet("/GetLezioniDiOggiStudenteServlet")
public class GetLezioniDiOggiStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLezioniDiOggiStudenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Persona p = em.find(Persona.class, request.getParameter("codicePersona"));
		Studente s = (Studente) p;
		System.out.println(request.getParameter("codicePersona"));
		Lister lister = new Lister();
		System.out.println("Mail:" + s.getMail());
		List<Lezione> l = lister.getLezioniDiOggi(s);
		ObjectMapper om = new ObjectMapper();
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
