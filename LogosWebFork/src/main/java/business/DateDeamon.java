package business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import entity.Corso;
import entity.Lezione;
import it.sauronsoftware.cron4j.Scheduler;

public class DateDeamon {
	/* Questa classe serve a far avanzare il tempo nel sistema, è responsabile dall'aggiornamento dell'attributo 
	 * "lezione corrente di un corso, su cui si basa tutta la gestione delle lezioni in corso, presenza etc...*/

	private Scheduler s;
	private EntityManager em;
	
	//Esegue l'aggiornamento ogni ora
	private static final String pattern = "1 * * * *";
	
	public void start() {

		System.out.println("Sono quasi aprtito");
	s = new Scheduler();
	em = JPAUtility.emf.createEntityManager();
	s.schedule(pattern, new Runnable() {
		public void run() {
			System.out.println("Sono partito");
			Date now = new Date();
			em = JPAUtility.emf.createEntityManager();
			List<Corso> corsi = em.createQuery("select c from Corso c", Corso.class).getResultList();
		
			for (Corso c : corsi) {
				int lezioneCorrente = c.getLezioneCorrente();
				if(lezioneCorrente == 0) lezioneCorrente++;
				Lezione l = null;
				for (Lezione ll : c.getLeziones()) {
					if (ll.getNumeroLezione() == lezioneCorrente) {
						l = ll;
					}
				}
				SimpleDateFormat sdf1 = new SimpleDateFormat("d M yyyy");
				SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
				SimpleDateFormat sdf3 = new SimpleDateFormat("d M yyyy HH:mm:ss");
				String data = sdf1.format(l.getData());
				String ora = sdf2.format(l.getOraInizio());
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
				System.out.println(fine);
				if (fine.before(now)) {
					c.setLezioneCorrente(c.getLezioneCorrente() + 1);
					em.getTransaction().begin();
					em.merge(c);
					em.getTransaction().commit();
				}

				
				
			}
		
		}
	});
	
	//Parto il demone
	s.start();

	}
	

}
