package business;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {

		public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GitProject");

}
