package buildweek.dao;

import buildweek.entities.Periodo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PeriodoDAO {
    private final EntityManager em;

    public PeriodoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Periodo periodo) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(periodo);
            transaction.commit();
            System.out.println("Periodo salvato con successo");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public Periodo findById(long id) {
        return em.find(Periodo.class, id);
    }

    public void findByIdAndDelete(long id) {
        Periodo foundPublication = em.find(Periodo.class, id);

        if (foundPublication != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPublication);
            transaction.commit();
            System.out.println("Il periodo con id: " + id + " e' stato eliminato con successo");
        } else {
            System.out.println("Il periodo con id: " + id + " non e' stato trovato");
        }

    }

    public void refresh(Periodo periodo) {
        em.refresh(periodo);
        System.out.println("Il periodo e' stato refreshato");
    }
}
