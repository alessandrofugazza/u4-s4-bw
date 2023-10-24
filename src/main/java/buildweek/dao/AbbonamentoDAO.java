package buildweek.dao;

import buildweek.entities.Abbonamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AbbonamentoDAO {
    private final EntityManager em;

    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Abbonamento abbonamento) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(abbonamento);
            transaction.commit();
            System.out.println("Abbonamento salvato con successo");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public Abbonamento findById(long id) {
        return em.find(Abbonamento.class, id);
    }

    public void findByIdAndDelete(long id) {
        Abbonamento foundPublication = em.find(Abbonamento.class, id);

        if (foundPublication != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPublication);
            transaction.commit();
            System.out.println("L'abbonamento con id: " + id + " e' stato eliminato con successo");
        } else {
            System.out.println("L'abbonamento con id: " + id + " non e' stato trovato");
        }

    }

    public void refresh(Abbonamento abbonamento) {
        em.refresh(abbonamento);
        System.out.println("L'abbonamento e' stato refreshato");
    }
}
