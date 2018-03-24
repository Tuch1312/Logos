package servlet;

import java.io.IOException;
import java.util.Date;

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
 * Servlet implementation class NuovoCorsoServlet
 */
@WebServlet("/NuovoCorsoServlet")
public class NuovoCorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovoCorsoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boolean automaticFill = Boolean.parseBoolean(request.getParameter("automaticFill"));
		ObjectMapper om = new ObjectMapper();
		
		GestioneCorso gc = new GestioneCorso();
		
		Docente d = om.readValue(request.getParameter("json"), Docente.class);
		Corso c = om.readValue(request.getParameter("corso"), Corso.class);
		String titolo = c.getTitolo();
		String descrizione = c.getDescrizione();
		int numMaxStudenti = c.getNumMaxStudenti();
		String sede = c.getSede();
		String immagine = c.getImmagine();
		
		
		Boolean andataBuonFine;
		if (automaticFill == false) {
			andataBuonFine = gc.nuovoCorso(d, titolo, descrizione, numMaxStudenti, sede, immagine, automaticFill);
		} else {
			Date dataInizio = new Date (Date.parse(request.getParameter("dataInizio"))); 
			int numeroGiorni = Integer.parseInt(request.getParameter("numeroGiorni"));
			int durataLezione = Integer.parseInt(request.getParameter("durataLezione"));
			int numLezioniXgiorno = Integer.parseInt(request.getParameter("numLezioniXgiorno"));
			Date oraInizioLezioni = new Date (Date.parse(request.getParameter("oraInizioLezioni")));
			String patternLezioni = request.getParameter("patternLezioni");
			andataBuonFine = gc.nuovoCorso(d, titolo, descrizione, numeroGiorni, dataInizio, durataLezione, numLezioniXgiorno, numMaxStudenti, sede, immagine, oraInizioLezioni, patternLezioni, automaticFill);
		}
		
		response.getWriter().append(andataBuonFine.toString());
	}

}
