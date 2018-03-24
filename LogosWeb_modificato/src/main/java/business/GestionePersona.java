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
		persona = em.find(Persona.class, JPAUtility.cod(mail));
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (persona!=null && checkPassword(psw, persona)) {
			 String $return = "{\"mail\":\"" + persona.getMail() + "\"," + "\"nome\":\"" + persona.getNome() + "\"," +  "\"cognome\":\"" + persona.getCognome() + "\"}";
			return persona;
				}
		else return null;
		}
	
	public boolean registrazione(String nome, String cognome, String mail, String password, String immagine, String indirizzo, boolean isDocente) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Persona persona = null;
		try {
		persona = em.find(Persona.class, JPAUtility.cod(mail));
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
				p.setRuolo("d");
			
			} else {
				p = new Studente();
				p.setRuolo("s");
			}
			p.setNome(nome);
			p.setCognome(cognome);
			p.setMail(mail);
			p.setPassword(password);
			p.setImmagine(immagine);
			p.setIndirizzo(indirizzo);
			p.setCodicePersona(JPAUtility.cod(mail));
			
			
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			return true;
		}
	}
	
	//Non ancora usato
	public String webLogin(String mail, String psw) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Persona persona = null;
		try {
		persona = em.find(Persona.class, JPAUtility.cod(mail));
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (persona!=null && checkPassword(psw, persona)) {
			return assegnaCodice(persona.getMail());
				}
		else return null;
		}
	
	public boolean cambiaPassword(String oldPassword,String newPassword, Persona p) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Persona s = em.find(Persona.class, JPAUtility.cod(p.getMail()));
		
		if(s.getPassword().equals(oldPassword)) {
			em.getTransaction().begin();
			s.setPassword(newPassword);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
//	//Dato che la mail � mappata come primary key non si puo cambiare all'interno del database e di conseguenza 
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
		
		//Non ancora usato
		public String assegnaCodice(String mail) {
			  try {
			        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			        byte[] array = md.digest(mail.getBytes());
			        StringBuffer sb = new StringBuffer();
			        for (int i = 0; i < array.length; ++i) {
			          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
			       }
			        return sb.toString();
			    } catch (java.security.NoSuchAlgorithmException e) {
			    }
			    return null;
			}
			
		

}
