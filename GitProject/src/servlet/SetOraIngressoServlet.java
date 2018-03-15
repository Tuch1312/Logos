package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestionePresenze;
import entity.Corso;
import entity.Docente;
import entity.Studente;

/**
 * Servlet implementation class SetOraIngressoServlet
 */
@WebServlet("/SetOraIngressoServlet")
public class SetOraIngressoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetOraIngressoServlet() {
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
		
		Docente d = om.readValue("docente", Docente.class);
		Studente s = om.readValue("studente", Studente.class);
		Corso c = om.readValue("corso", Corso.class);
		
		GestionePresenze gp = new GestionePresenze();
		Boolean andataBuonFine = gp.setOraIngresso(d, s, c);
		
		response.getWriter().append(andataBuonFine.toString());
	}

}
