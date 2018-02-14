package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.GestioneCorso;
import business.GestioneLezioni;
import entity.Corso;
import entity.Docente;
import entity.Lezione;

/**
 * Servlet implementation class AggiungiLezioneServlet
 */
@WebServlet("/AggiungiLezioneServlet")
public class AggiungiLezioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiLezioneServlet() {
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
		Corso c = om.readValue(request.getParameter("corso"), Corso.class);
		Lezione l = om.readValue(request.getParameter("lezione"), Lezione.class);
		GestioneLezioni gl = new GestioneLezioni(); 
		Boolean andataBuonFine = gl.aggiungiLezione(c, l);
		response.getWriter().append(andataBuonFine.toString());
	}

}
