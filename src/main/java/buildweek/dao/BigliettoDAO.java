package buildweek.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BigliettoDAO {
    private final EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(BigliettoDAO biglietto) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(biglietto);
            transaction.commit();
            System.out.println("biglietto salvato con successo");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public BigliettoDAO findById(long id) {
        return em.find(BigliettoDAO.class, id);
    }

    public void findByIdAndDelete(long id) {
        BigliettoDAO foundPublication = em.find(BigliettoDAO.class, id);

        if (foundPublication != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPublication);
            transaction.commit();
            System.out.println("Il biglietto con id: " + id + " e' stato eliminato con successo");
        } else {
            System.out.println("Il biglietto con id: " + id + " non e' stato trovato");
        }

    }

    public void refresh(BigliettoDAO biglietto) {
        em.refresh(biglietto);
        System.out.println("Il biglietto e' stato refreshato");
    }
}
