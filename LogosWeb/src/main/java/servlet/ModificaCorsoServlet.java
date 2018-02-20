package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestioneCorso;
import entity.Corso;
import entity.Docente;

/**
 * Servlet implementation class ModificaCorso
 */
@WebServlet("/ModificaCorsoServlet")
public class ModificaCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaCorsoServlet() {
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
		Docente d = om.readValue(request.getParameter("docente"), Docente.class);
		Corso c = om.readValue(request.getParameter("corso"), Corso.class);
		GestioneCorso gc = new GestioneCorso(); 
		Boolean andataBuonFine = gc.modificaCorso(c, d);
		response.getWriter().append(andataBuonFine.toString());
	}

}
