package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;


import entity.Corso;
import entity.Docente;
import entity.Lezione;
import entity.Studente;

public class Lister {

	public Lister() {
	}

	// Tested
	/*
	 * Ritorna tutte le lezioni di un corso
	 */
	public List<Lezione> getLezioniPerCorso(Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Lezione> lezioni = em.createQuery("select l from Lezione l where l.corso = :corso", Lezione.class)
				.setParameter("corso", c).getResultList();
		return lezioni;
	}

	// Tested
	/*
	 * Ritorna tutti i corsi inseganti da un detreminato docente, passato come
	 * argomento
	 */
	public List<Corso> getCorsiPerDocente(Docente d) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Corso> corsi = em.createQuery("select c from Corso c where c.docente = :docente", Corso.class)
				.setParameter("docente", d).getResultList();
		return corsi;

	}

	// Tested
	// TODO query da trasformare in jpql da sql
	/*
	 * Ritorna tutti i corsi a cui uno studente è isccritto
	 */
	public List<Corso> getCorsiPerStudente(Studente s) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Corso> corsi = em
				.createQuery("select c from Iscrizione i join i.corso c where i.studenteIscritto = :studente",
						Corso.class)
				.setParameter("studente", s).getResultList();
		return corsi;

	}

	// Tested
	/*
	 * Ritorna tutti gli studenti iscritti ad un detrminato corso
	 */
	public List<Studente> getStudentiPerCorso(Corso c) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Studente> studenti = em
				.createQuery("select s from Iscrizione i join i.studenteIscritto s where i.corso = :corso",
						Studente.class)
				.setParameter("corso", c).getResultList();
		return studenti;

	}

	// Tested
	/*
	 * Ritorna tutte le lezioni di oggi per un determinato docente
	 */

	public List<Lezione> getLezioniDiOggi(Docente d) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		List<Lezione> lezioni = em.createQuery(
				"select l from Lezione l where l.data = :data and l.corso = (select c from Corso c where c.docente = :docente)",
				Lezione.class).setParameter("data", new Date()).setParameter("docente", d).getResultList();
		return lezioni;
	}

	// Tested
	/*
	 * Ritorna tutte le lezioni di domani per un determinato docente
	 */
	public List<Lezione> getLezioniDiDomani(Docente d) {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		List<Lezione> lezioni = em.createQuery(
				"select l from Lezione l where l.data = :data and l.corso = (select c from Corso c where c.docente = :docente)",
				Lezione.class).setParameter("data", cal.getTime()).setParameter("docente", d).getResultList();
		return lezioni;
	}

	public List<Lezione> getLezioniDiOggi(Studente s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String data = sdf.format(new Date());
		List<Lezione> elenco = new ArrayList<Lezione>();
		try {
			Connection con = getConnection();
			Statement query = con.createStatement();
			String sql1 = "select `IDCORSO` from `ISCRIZIONE` where `MAILSTUDENTE` = \"" + s.getMail() + "\"";
			ResultSet ids = query.executeQuery(sql1);
			List<Integer> listaId = new ArrayList<Integer>();
			while (ids.next()) {
				int i = ids.getInt("IDCORSO");
				listaId.add(i);
			}
			for (int id : listaId) {
				String sql2 = "select * from `LEZIONE` where `DATA` = \"" + data +"\" and `CORSO_IDCORSO` = " + id;
				ResultSet lezioni = query.executeQuery(sql2);
				while (lezioni.next()) {
					Lezione l = assegnavalori(lezioni);
					if (l != null) {
						elenco.add(l);
					}
				}
			}
			query.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("si è verificato un errore");
		}
		return elenco;
	}
	
	public List<Lezione> getLezioniDiDomani(Studente s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String data = sdf.format(new Date(new Date().getTime() + 86400000L));
		List<Lezione> elenco = new ArrayList<Lezione>();
		try {
			Connection con = getConnection();
			Statement query = con.createStatement();
			String sql1 = "select `IDCORSO` from `ISCRIZIONE` where `MAILSTUDENTE` = \"" + s.getMail() + "\"";
			ResultSet ids = query.executeQuery(sql1);
			List<Integer> listaId = new ArrayList<Integer>();
			while (ids.next()) {
				int i = ids.getInt("IDCORSO");
				listaId.add(i);
			}
			for (int id : listaId) {
				String sql2 = "select * from `LEZIONE` where `DATA` = \"" + data +"\" and `CORSO_IDCORSO` = " + id;
				ResultSet lezioni = query.executeQuery(sql2);
				while (lezioni.next()) {
					Lezione l = assegnavalori(lezioni);
					if (l != null) {
						elenco.add(l);
					}
				}
			}
			query.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("si è verificato un errore");
		}
		return elenco;
	}

	private Lezione assegnavalori(ResultSet rs) throws SQLException {
		EntityManager em = JPAUtility.emf.createEntityManager();
		Lezione l = new Lezione();
		l.setIdLezione(rs.getInt("IDLEZIONE"));
		l.setArgomenti(rs.getString("ARGOMENTI"));
		l.setAssenti(rs.getString("ASSENTI"));
		l.setAula(rs.getString("AULA"));
		l.setCorso(em.find(Corso.class, rs.getInt("CORSO_IDCORSO")));
		l.setData(rs.getDate("DATA"));
		l.setNumAssenti(rs.getInt("NUMASSENTI"));
		l.setNumeroLezione(rs.getInt("NUMEROLEZIONE"));
		l.setDurata(rs.getInt("DURATA"));
		l.setOraInizio(rs.getTime("ORAINIZIO"));
		l.setPercentAssenti(rs.getFloat("PERCENTASSENTI"));
		
		return l;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mariadb://18.196.84.13:3306/main_table", "dbmaster",
				"ifts2k17");
		return con;
	}

}
