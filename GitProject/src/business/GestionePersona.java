package business;

import javax.persistence.*;

import entity.Persona;

public class GestionePersona {
	
	public Boolean login(String mail, String psw) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Persona persona = null;
		try {
		persona = em.find(Persona.class, mail);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (persona!=null) {
			return checkPassword(psw, persona);
			}
		else return false;
		}
	
	public boolean registrazione(String nome, String cognome, String mail, String password, String immagine, String indirizzo, boolean isDocente) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Persona persona = null;
		try {
		persona = em.find(Persona.class, mail);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(persona!=null) {
			return false;
		}
		else {
			Persona p = new Persona();
			p.setNome(nome);
			p.setCognome(cognome);
			p.setMail(mail);
			p.setPassword(password);
			p.setImmagine(immagine);
			p.setIndirizzo(indirizzo);
			
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			return true;
		}
	}
	
	
	public boolean cambiaPassword(String oldPassword,String newPassword, Persona p) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Persona s = em.find(Persona.class, p.getMail());
		
		if(s.getPassword()==oldPassword) {
			em.getTransaction().begin();
			s.setPassword(newPassword);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean cambiaMail(String password,String newMail, Persona p) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Persona s = em.find(Persona.class, p.getMail());
		Persona z = em.find(Persona.class, newMail);
		if (z!=null) {
			if(s.getPassword() == password) {
				em.getTransaction().begin();
				s.setMail(newMail);
				em.getTransaction().commit();
				return true;
			} else {
				return false;
				}
			}else return false;
	}
		
		
		
		
		private boolean checkPassword(String password, Persona persona) {
			if (persona.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
	}

}
