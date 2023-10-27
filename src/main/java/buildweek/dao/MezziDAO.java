package buildweek.dao;

import buildweek.entities.Mezzi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Mezzi> getMezziByTypeAutobus() {
        TypedQuery<Mezzi> getMezzi = em.createNamedQuery("getMezziByTypeAutobus", Mezzi.class);
        return getMezzi.getResultList();
    }

    public List<Mezzi> getMezziByTypeTram() {
        TypedQuery<Mezzi> getMezzi = em.createNamedQuery("getMezziByTypeTram", Mezzi.class);
        return getMezzi.getResultList();
    }

    public List<Mezzi> getMezziById(long id) {
        TypedQuery<Mezzi> getMezzi = em.createNamedQuery("getMezziById", Mezzi.class);
        getMezzi.setParameter("id", id);
        return getMezzi.getResultList();
    }

    public List<Mezzi> getMezziByCapienzaLessThen30() {
        TypedQuery<Mezzi> getMezzi = em.createNamedQuery("getMezziByCapienzaLessThen30", Mezzi.class);
        return getMezzi.getResultList();
    }

    public List<Mezzi> getMezziByCapienzaMoreThen20() {
        TypedQuery<Mezzi> getMezzi = em.createNamedQuery("getMezziByCapienzaMoreThen20", Mezzi.class);
        return getMezzi.getResultList();
    }

    public List<Mezzi> getMezziByTratta(long trattaId) {
        TypedQuery<Mezzi> getMezzi = em.createNamedQuery("getMezziByTratta", Mezzi.class);
        getMezzi.setParameter("trattaId", trattaId);
        return getMezzi.getResultList();
    }

    public List<Mezzi> getMezziByStatusManutenzione() {
        TypedQuery<Mezzi> getMezzi = em.createNamedQuery("getMezziByStatusManutenzione", Mezzi.class);
        return getMezzi.getResultList();
    }

    public List<Mezzi> getMezziByStatusInServizio() {
        TypedQuery<Mezzi> getMezzi = em.createNamedQuery("getMezziByStatusInServizio", Mezzi.class);
        return getMezzi.getResultList();
    }


}
