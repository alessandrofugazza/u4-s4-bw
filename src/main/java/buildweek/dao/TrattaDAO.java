package buildweek.dao;

import buildweek.entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Tratta> getTrattaByZonaPartenzaeCapolinea(String zona_partenza, String capolinea) {
        TypedQuery<Tratta> getTratta = em.createQuery("SELECT t FROM Tratta t WHERE t.zonaPartenza =:zona_partenza AND t.capolinea=:capolinea", Tratta.class);
        getTratta.setParameter("zona_partenza", zona_partenza);
        getTratta.setParameter("capolinea", capolinea);
        return getTratta.getResultList();
    }

    public Tratta getTrattaById(long id_tratta) {
        TypedQuery<Tratta> getTratta = em.createQuery("SELECT t FROM Tratta t WHERE t.id = :id_tratta", Tratta.class);
        getTratta.setParameter("id_tratta", id_tratta);
        return getTratta.getSingleResult();
    }


    public int getTempoMedioById(long id_tratta) {
        TypedQuery<Integer> getTempoMedio = em.createQuery("SELECT t.tempoMedio FROM Tratta t WHERE t.id = :id_tratta", Integer.class);
        getTempoMedio.setParameter("id_tratta", id_tratta);
        Integer tempo = getTempoMedio.getSingleResult();

        if (tempo != null) {
            return tempo;
        } else {
            return 0;
        }
    }

    public Tratta getTratta() {
        TypedQuery<Tratta> getTratta = em.createQuery("SELECT * FROM Tratta ", Tratta.class);
        List<Tratta> tratte = getTratta.getResultList();
        return getTratta.getSingleResult();
    }

}
