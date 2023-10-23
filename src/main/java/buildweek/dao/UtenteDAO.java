package buildweek.dao;

import buildweek.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(utente);
            transaction.commit();
            System.out.println("Utente salvato con successo");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public Utente findById(long id) {
        return em.find(Utente.class, id);
    }

    public void findByIdAndDelete(long id) {
        Utente foundPublication = em.find(Utente.class, id);

        if (foundPublication != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPublication);
            transaction.commit();
            System.out.println("L'utente con id: " + id + " e' stato eliminato con successo");
        } else {
            System.out.println("L'utente con id: " + id + " non e' stato trovato");
        }

    }

    public void refresh(Utente utente) {
        em.refresh(utente);
        System.out.println("L'utente e' stato refreshato");
    }

}
