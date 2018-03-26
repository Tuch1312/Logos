package servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.GestionePresenze;
import business.JPAUtility;
import entity.Corso;
import entity.Studente;

/**
 * Servlet implementation class GetAssenzeServlet
 */
@WebServlet("/GetAssenzeServlet")
public class GetAssenzeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAssenzeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Studente s = em.find(Studente.class, request.getParameter("codicePersona"));
		Corso c = em.find(Corso.class, Integer.parseInt(request.getParameter("idCorso")));
		GestionePresenze gp = new GestionePresenze();
		List<Integer> assenze = gp.getAssenze(s, c);
		response.getWriter().append("{" + 
				"  \"oreAssenza\": " + assenze.get(0) +
				",  \"percentuale\": " + assenze.get(1) + 
				"}");
		
		
	}

}
