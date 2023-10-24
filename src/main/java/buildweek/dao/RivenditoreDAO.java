package buildweek.dao;

import buildweek.entities.Rivenditore;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RivenditoreDAO {
    private final EntityManager em;

    public RivenditoreDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Rivenditore rivenditore) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(rivenditore);
            transaction.commit();
            System.out.println("Rivenditore salvato con successo");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public Rivenditore findById(long id) {
        return em.find(Rivenditore.class, id);
    }

    public void findByIdAndDelete(long id) {
        Rivenditore foundPublication = em.find(Rivenditore.class, id);

        if (foundPublication != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPublication);
            transaction.commit();
            System.out.println("Il rivenditore con id: " + id + " e' stato eliminato con successo");
        } else {
            System.out.println("Il rivenditore con id: " + id + " non e' stato trovato");
        }

    }

    public void refresh(Rivenditore rivenditore) {
        em.refresh(rivenditore);
        System.out.println("Il rivenditore e' stato refreshato");
    }
}
