package buildweek.dao;

import buildweek.entities.Rivenditore;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class RivenditoreDAO {
    private final EntityManager em;

    public RivenditoreDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Rivenditore rivenditore) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(rivenditore);
            transaction.commit();
            System.out.println("Rivenditore salvato con successo");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public Rivenditore findById(long id) {
        return em.find(Rivenditore.class, id);
    }

    public void findByIdAndDelete(long id) {
        Rivenditore foundPublication = em.find(Rivenditore.class, id);

        if (foundPublication != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPublication);
            transaction.commit();
            System.out.println("Il rivenditore con id: " + id + " e' stato eliminato con successo");
        } else {
            System.out.println("Il rivenditore con id: " + id + " non e' stato trovato");
        }

    }

    public void refresh(Rivenditore rivenditore) {
        em.refresh(rivenditore);
        System.out.println("Il rivenditore e' stato refreshato");
    }

    public List<Rivenditore> getResellerByName(String name) {
        TypedQuery<Rivenditore> getReseller = em.createNamedQuery("getResellerByName", Rivenditore.class);
        getReseller.setParameter("name", name);
        return getReseller.getResultList();
    }

    public List<Rivenditore> getMachineReseller() {
        TypedQuery<Rivenditore> getReseller = em.createNamedQuery("getMachineReseller", Rivenditore.class);
        return getReseller.getResultList();

    }

    public List<Rivenditore> getUmanReseller() {
        TypedQuery<Rivenditore> getReseller = em.createNamedQuery("getUmanReseller", Rivenditore.class);
        return getReseller.getResultList();

    }

    public List<Rivenditore> getMachineResellerByStatusAttivo() {
        TypedQuery<Rivenditore> getReseller = em.createNamedQuery("getMachineResellerByStatusAttivo", Rivenditore.class);
        return getReseller.getResultList();

    }

    public List<Rivenditore> getMachineResellerByStatusFuoriServizio() {
        TypedQuery<Rivenditore> getReseller = em.createNamedQuery("getMachineResellerByStatusFuoriServizio", Rivenditore.class);
        return getReseller.getResultList();
    }


}
