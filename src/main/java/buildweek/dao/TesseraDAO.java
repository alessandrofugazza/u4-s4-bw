package buildweek.dao;

import buildweek.entities.Tessera;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TesseraDAO {
    private final EntityManager em;

    public TesseraDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tessera tessera) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(tessera);
            transaction.commit();
            System.out.println("Tessera salvata con successo");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public Tessera findById(long id) {
        return em.find(Tessera.class, id);
    }

    public void findByIdAndDelete(long id) {
        Tessera foundPublication = em.find(Tessera.class, id);

        if (foundPublication != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPublication);
            transaction.commit();
            System.out.println("La tessera con id: " + id + " e' stata eliminata con successo");
        } else {
            System.out.println("La tessera con id: " + id + " non e' stata trovata");
        }

    }

    public void refresh(Tessera tessera) {
        em.refresh(tessera);
        System.out.println("La tessera e' stata refreshata");
    }
}
