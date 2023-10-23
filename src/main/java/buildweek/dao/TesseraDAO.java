package buildweek.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TesseraDAO {
    private final EntityManager em;

    public TesseraDAO(EntityManager em) {
        this.em = em;
    }

    public void save(TesseraDAO tessera) {
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

    public TesseraDAO findById(long id) {
        return em.find(TesseraDAO.class, id);
    }

    public void findByIdAndDelete(long id) {
        TesseraDAO foundPublication = em.find(TesseraDAO.class, id);

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

    public void refresh(TesseraDAO tessera) {
        em.refresh(tessera);
        System.out.println("La tessera e' stata refreshata");
    }
}
