package buildweek.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AbbonamentoDAO {
    private final EntityManager em;

    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(AbbonamentoDAO abbonamento) {
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

    public AbbonamentoDAO findById(long id) {
        return em.find(AbbonamentoDAO.class, id);
    }

    public void findByIdAndDelete(long id) {
        AbbonamentoDAO foundPublication = em.find(AbbonamentoDAO.class, id);

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

    public void refresh(AbbonamentoDAO abbonamento) {
        em.refresh(abbonamento);
        System.out.println("L'abbonamento e' stato refreshato");
    }
}
