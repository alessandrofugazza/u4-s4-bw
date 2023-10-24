package buildweek.dao;

import buildweek.entities.Mezzi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MezziDAO {
    private final EntityManager em;

    public MezziDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Mezzi mezzi) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(mezzi);
            transaction.commit();
            System.out.println("Mezzo salvato con successo");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public Mezzi findById(long id) {
        return em.find(Mezzi.class, id);
    }

    public void findByIdAndDelete(long id) {
        Mezzi foundPublication = em.find(Mezzi.class, id);

        if (foundPublication != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPublication);
            transaction.commit();
            System.out.println("Il mezzo con id: " + id + " e' stato eliminato con successo");
        } else {
            System.out.println("Il mezzo con id: " + id + " non e' stato trovato");
        }

    }

    public void refresh(Mezzi mezzi) {
        em.refresh(mezzi);
        System.out.println("Il mezzo e' stato refreshato");
    }
}
