package businessTest;

class GestioneLezioneTest {

	/*@Test
	public void creaLezioneTest() {
		EntityManager em = JPAUtility.emf.createEntityManager();
		GestioneCorso gc = new GestioneCorso();
		Docente d = new Docente();
		d.setNome("DocenteProvaLezione");
		d.setCognome("ciao");
		d.setMail("docente@provalezione");
		d.setPassword("ciao");
		String s = "prova";
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		Date inizio= new Date();
		Date ora = new Date(1516176000000L);
		String pattern = "1,2,3"; 
		//Lunedi, mercoledi, venerdi | 2 lezioni al giorno | 2 ore a lezione | a partire da oggi
		gc.nuovoCorso(d, "corsoprovalezione", s, 10, inizio, 2, 2, 20, s, s, ora, pattern);
		Corso c = em.find(Corso.class, 1);
		GestioneLezioni gl = new GestioneLezioni();
		boolean esito = gl.creaLezioni(c);
		assertTrue("funziona", esito == true);
		
	}
	@Test
	public void eliminaLezioniTest() {
		EntityManager em = JPAUtility.emf.createEntityManager();
		GestioneLezioni gl = new GestioneLezioni();
		Corso c = new Corso();
		c.setIdCorso(1);
		Lezione l = new Lezione();
		l.setIdLezione(1);
		boolean esito = gl.eliminaLezione(c, l);
		assertTrue("funziona", esito == true);
	}
	
	@Test
	public void aggiungiLezioniTest() {
		EntityManager em = JPAUtility.emf.createEntityManager();
		GestioneLezioni gl = new GestioneLezioni();
		Corso c = new Corso();
		c.setIdCorso(1);
		Lezione l = new Lezione();
		l.setIdLezione(1);
		boolean esito = gl.aggiungiLezione(c, l);
		assertTrue("funziona", esito == true);
	}*/
	
//	@Test
//	public void modificaLezioniTest() {
//		EntityManager em = JPAUtility.emf.createEntityManager();
//		GestioneLezioni gl = new GestioneLezioni();
//		Corso c = new Corso();
//		c.setIdCorso(1);
//		Lezione l = new Lezione();
//		l.setIdLezione(22);
//		l.setDurata(25);
//		boolean esito = gl.modificaLezione(c, l);
//		assertTrue("funziona", esito == true);
//	}
	

	
}
