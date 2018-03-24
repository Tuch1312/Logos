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
 * Servlet implementation class SetOraUscitaServlet
 */
@WebServlet("/SetOraUscitaServlet")
public class SetOraUscitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetOraUscitaServlet() {
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
		Studente s = om.readValue(request.getParameter("studente"), Studente.class);
		Corso c = om.readValue(request.getParameter("corso"), Corso.class);
		GestionePresenze gp = new GestionePresenze();
		Boolean andataBuonFine = gp.setOraUscita(d, s, c);
		response.getWriter().append(andataBuonFine.toString());
	}

}
