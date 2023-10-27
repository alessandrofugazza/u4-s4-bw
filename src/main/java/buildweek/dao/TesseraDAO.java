package buildweek.dao;

import buildweek.entities.Tessera;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Tessera> getTesseraByNumber(int number) {
        TypedQuery<Tessera> getTessera = em.createNamedQuery("getTesseraByNumber", Tessera.class);
        getTessera.setParameter("number", (long) number);
        return getTessera.getResultList();
    }

    public List<Tessera> getTesseraByIdUser(int userId) {
        TypedQuery<Tessera> getTessera = em.createNamedQuery("getTesseraByIdUser", Tessera.class);
        getTessera.setParameter("userId", (long) userId);
        return getTessera.getResultList();
    }

    public List<Tessera> getTessereScadute() {
        TypedQuery<Tessera> getTessere = em.createNamedQuery("getTessereScadute", Tessera.class);
        return getTessere.getResultList();
    }

    public List<Tessera> getTessereInCorso() {
        TypedQuery<Tessera> getTessere = em.createNamedQuery("getTessereInCorso", Tessera.class);
        return getTessere.getResultList();
    }

}
