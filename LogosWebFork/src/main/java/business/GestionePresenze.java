package business;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.*;

public class GestionePresenze {
	
	public boolean setOraIngresso(Docente d, Studente s, Corso c) {
		Presenza p = new Presenza();
		EntityManager em = JPAUtility.emf.createEntityManager();
		
		if (d!=null&&s!=null&&c!=null) {
				p.setOraArrivo(new Date().getTime());
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("d M yyyy");
				SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
				SimpleDateFormat sdf3 = new SimpleDateFormat("d M yyyy HH:mm:ss");
				String data = sdf1.format(c.getLeziones().get(c.getLezioneCorrente()).getData());
				String ora = sdf2.format(c.getLeziones().get(c.getLezioneCorrente()).getOraInizio());
				String d3 = data.trim() + " " + ora.trim() ;
				
				Date date = null;
				try {
					date = sdf3.parse(d3);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				System.out.println(d3);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.HOUR, c.getDurataLezione());
				Date fine = cal.getTime();
				
				p.setOraUscita(fine.getTime());
				p.setStudente(s);
				p.setLezione(c.getLeziones().get(c.getLezioneCorrente()));
				p.setLezioneId(c.getLeziones().get(c.getLezioneCorrente()).getIdLezione());
				p.setCodiceStudente(s.getCodicePersona());
				em.getTransaction().begin();
				em.persist(p);
				em.getTransaction().commit();
				if (s.getPresenze() == null) s.initPresenze();
				s.addPresenzaOggi(p,c);
				em.getTransaction().begin();
				em.merge(s);
				em.getTransaction().commit();
				
				return true;
		}
				
		else return false;
	}
	
	public boolean setOraUscita(Docente d, Studente s, Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Presenza p = em.find(Presenza.class, s.getPresenzaOggi(c));
		if (d!=null&&c!=null&&s!=null) {
	
				p.setOraUscita(new Date().getTime());
				em.getTransaction().begin();
				em.persist(p);
				em.getTransaction().commit();
				return true;
			} 
		else return false;
	}
	
	//Controlla se lo studente è presente o assente per la data di oggi
	public boolean isPresente(Studente s, Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Presenza p = null;
		try {
		p = em.find(Presenza.class, s.getPresenzaOggi(c));
		} catch(Exception e) {
			e.printStackTrace();
	}
		if (p!=null) {
	
			if (p.getOraUscita() == null || p.getOraUscita() == 0) {
				return true;
			}
		} 
		return false;
		
	}
	
	public List<Integer> getAssenze(Studente s, Corso c) {
		int oreAssenza = 0;
		int percentAssenza = 0;
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Presenza> presenze = em.createQuery("select p from Presenza p where p.studente = ?1 and p.lezioneId <= ?2", Presenza.class)
				.setParameter(1, s)
				.setParameter(2, c.getLezioneCorrente())
				.getResultList();
		int diff = c.getLezioneCorrente() - presenze.size();
		if (diff != 0) {
			oreAssenza = diff*c.getDurataLezione();
		}
		for (Presenza p : presenze) {
			Lezione l = em.find(Lezione.class, p.getLezioneId());
			if (p.getOraUscita() < (l.getOraInizio().getTime() + (((c.getDurataLezione() * 60) * 60 )* 1000))) {
				long ass = p.getOraUscita() - (l.getOraInizio().getTime() + (((c.getDurataLezione() * 60) * 60 )* 1000));
				int assInt = (int) (ass / 3600000);
				oreAssenza += assInt;
			}		
		}
		percentAssenza = (oreAssenza * (c.getNumeroLezioni() * c.getDurataLezione())) / 100;
		List<Integer> result = new ArrayList<Integer>();
		result.add(oreAssenza);
		result.add(percentAssenza);
		return result;
	}
 
}
