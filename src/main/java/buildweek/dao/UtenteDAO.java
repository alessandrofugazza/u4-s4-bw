package buildweek.dao;

import buildweek.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Utente> getAllUser() {
        TypedQuery<Utente> getUser = em.createNamedQuery("getAllUsers", Utente.class);
        return getUser.getResultList();
    }

    public List<Utente> getUserBYName(String name) {
        TypedQuery<Utente> getUser = em.createNamedQuery("getUserBYName", Utente.class);
        getUser.setParameter("name", name);
        return getUser.getResultList();
    }

    public List<Utente> getUserBYLastName(String lastName) {
        TypedQuery<Utente> getUser = em.createNamedQuery("getUserBYLastName", Utente.class);
        getUser.setParameter("lastName", lastName);
        return getUser.getResultList();
    }


}
