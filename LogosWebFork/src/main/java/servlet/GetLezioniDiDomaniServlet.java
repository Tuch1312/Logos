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
import entity.Docente;
import entity.Lezione;

/**
 * Servlet implementation class GetLezioniDiDomaniServlet
 */
@WebServlet("/GetLezioniDiDomaniServlet")
public class GetLezioniDiDomaniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLezioniDiDomaniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		EntityManager em = JPAUtility.emf.createEntityManager();
		Docente d = em.find(Docente.class, request.getParameter("codicePersona"));
		Lister lister = new Lister();
		List<Lezione> l = lister.getLezioniDiDomani(d);
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
