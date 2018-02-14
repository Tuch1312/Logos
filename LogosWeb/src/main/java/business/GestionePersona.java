package business;

import javax.persistence.*;

import entity.Docente;
import entity.Persona;
import entity.Studente;

public class GestionePersona {
	
	public Persona login(String mail, String psw) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Persona persona = null;
		try {
		persona = em.find(Persona.class, mail);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (persona!=null && checkPassword(psw, persona)) {
			return persona;
				}
		else return null;
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
			Persona p = null;
			if (isDocente == true) {
				p = new Docente();
			
			} else {
				p = new Studente();
			}
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
		
		if(s.getPassword().equals(oldPassword)) {
			em.getTransaction().begin();
			s.setPassword(newPassword);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
//	//Dato che la mail è mappata come primary key non si puo cambiare all'interno del database e di conseguenza 
//	//sono costretto a cancellare e a ricreare l'oggetto persona
//	public boolean cambiaMail(String password,String newMail, Persona p) {
//		EntityManager em = JPAUtility.emf.createEntityManager();
//		Persona s = em.find(Persona.class, p.getMail());
//		Persona z = em.find(Persona.class, newMail);
//		if (z==null) {
//			if(s.getPassword().equals(password)) {
//				em.getTransaction().begin();
//				s.setMail(newMail);
//				em.getTransaction().commit();
//				return true;
//			} else {
//				return false;
//				}
//			}else return false;
//	}
		
		
		
		
		private boolean checkPassword(String password, Persona persona) {
			if (persona.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
	}

}
