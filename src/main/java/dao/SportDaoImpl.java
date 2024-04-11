package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import metier.entities.Sport;
import util.JPAutil;

public class SportDaoImpl implements ISportDao {

    private EntityManager entityManager = JPAutil.getEntityManager("TP5_JEESport");

    @Override
    public Sport save(Sport sport) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(sport);
        tx.commit();
        return sport;
    }

  
    @Override
    public List<Sport> sportParMC(String mc) {
        List<Sport> prods = entityManager.createQuery("select p from Sport p where p.nomSport like :mc").setParameter("mc", "%" + mc + "%").getResultList();
        return prods;
    }

    @Override
    public Sport getSport(Long id) {
        return entityManager.find(Sport.class, id);
    }

    @Override
    public Sport updateSport(Sport sport) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(sport);
        tx.commit();
        return sport;
    }

    @Override
    public void deleteSport(Long id) {
        Sport sport = entityManager.find(Sport.class, id);
        if (sport != null) {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(sport);
            tx.commit();
        }
    }
}
