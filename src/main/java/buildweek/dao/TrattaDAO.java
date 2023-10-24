package buildweek.dao;

import buildweek.entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TrattaDAO {
    private final EntityManager em;

    public TrattaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(tratta);
            transaction.commit();
            System.out.println("Tratta salvata con successo");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public Tratta findById(long id) {
        return em.find(Tratta.class, id);
    }

    public void findByIdAndDelete(long id) {
        Tratta foundPublication = em.find(Tratta.class, id);

        if (foundPublication != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPublication);
            transaction.commit();
            System.out.println("La tratta con id: " + id + " e' stata eliminata con successo");
        } else {
            System.out.println("La tratta con id: " + id + " non e' stata trovata");
        }

    }

    public void refresh(Tratta tratta) {
        em.refresh(tratta);
        System.out.println("La tratta e' stata refreshata");
    }
}
