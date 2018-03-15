package servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.JPAUtility;
import entity.Persona;

@WebServlet("/GetPersonaServlet")
public class GetPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public GetPersonaServlet() {
        super();
           }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager em = JPAUtility.emf.createEntityManager();
		ObjectMapper om = new ObjectMapper();
		Persona p = em.find(Persona.class, req.getParameter("codicePersona"));
		String json = om.writeValueAsString(p);
		resp.getWriter().append(json);
		
	}



}
