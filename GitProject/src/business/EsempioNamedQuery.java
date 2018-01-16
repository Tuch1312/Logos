package business;

import javax.persistence.EntityManager;

public class EsempioNamedQuery {
	
	public void esempio() {
		EntityManager em = JPAUtility.emf.createEntityManager();
		
		em.createNamedQuery("Corso.findAll").getResultList();
	}

}
