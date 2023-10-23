package buildweek.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(UtenteDAO utente) {
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

    public UtenteDAO findById(long id) {
        return em.find(UtenteDAO.class, id);
    }

    public void findByIdAndDelete(long id) {
        UtenteDAO foundPublication = em.find(UtenteDAO.class, id);

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

    public void refresh(UtenteDAO utente) {
        em.refresh(utente);
        System.out.println("L'utente e' stato refreshato");
    }

}
