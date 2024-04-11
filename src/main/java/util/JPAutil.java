package util;

import javax.persistence.*;

public class JPAutil {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	public static EntityManager getEntityManager(String persistUnit)
	{

	if (entityManager==null)
	{
	factory = Persistence.createEntityManagerFactory(persistUnit);
	entityManager = factory.createEntityManager();
	}
	return entityManager;
	}

}
