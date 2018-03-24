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
import entity.Studente;

/**
 * Servlet implementation class IscrivitiServlet
 */
@WebServlet("/IscrivitiServlet")
public class IscrivitiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IscrivitiServlet() {
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
		String codiceCorso = request.getParameter("codiceCorso");
		String stud =request.getParameter("studente");
		System.out.println(stud);
		stud = stud.replaceAll(",\"presenza\":.*,", "").replaceAll("\"presenzaOggi\":\\d", "");
		System.out.println(stud);
		Studente s = om.readValue(stud, Studente.class);
		GestioneCorso gc = new GestioneCorso(); 
		Boolean andataBuonFine = gc.iscriviti(s, codiceCorso);
		response.getWriter().append(andataBuonFine.toString());
	}

}
