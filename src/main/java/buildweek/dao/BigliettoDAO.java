package buildweek.dao;

import buildweek.entities.Biglietto;
import buildweek.enums.Vidimazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class BigliettoDAO {
    private final EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Biglietto biglietto) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(biglietto);
            transaction.commit();
            System.out.println("biglietto salvato con successo");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public Biglietto findById(long id) {
        return em.find(Biglietto.class, id);
    }

    public void findByIdAndDelete(long id) {
        Biglietto foundPublication = em.find(Biglietto.class, id);

        if (foundPublication != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPublication);
            transaction.commit();
            System.out.println("Il biglietto con id: " + id + " e' stato eliminato con successo");
        } else {
            System.out.println("Il biglietto con id: " + id + " non e' stato trovato");
        }

    }

    public void refresh(Biglietto biglietto) {
        em.refresh(biglietto);
        System.out.println("Il biglietto e' stato refreshato");
    }

    public List<Biglietto> getBigliettiVidimati(Vidimazione vidimazione) {
        TypedQuery<Biglietto> getBiglietti = em.createNamedQuery("getBigliettiVidimati", Biglietto.class);
        getBiglietti.setParameter("vidimazione", vidimazione);
        return getBiglietti.getResultList();
    }

    public List<Biglietto> getByMezzo(long id) {
        TypedQuery<Biglietto> getBiglietti = em.createNamedQuery("getByMezzo", Biglietto.class);
        getBiglietti.setParameter("mezzoid", id);
        return getBiglietti.getResultList();
    }

    public List<Biglietto> getByRivenditore(long id) {
        TypedQuery<Biglietto> getBiglietti = em.createNamedQuery("getByRivenditore", Biglietto.class);
        getBiglietti.setParameter("rivenditoreid", id);
        return getBiglietti.getResultList();
    }
}
