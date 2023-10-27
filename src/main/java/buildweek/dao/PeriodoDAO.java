package buildweek.dao;

import buildweek.entities.Periodo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class PeriodoDAO {
    private final EntityManager em;

    public PeriodoDAO(EntityManager em) {
        this.em = em;
    }

    public void findPeriodoByDataInizioAndUpdateDataInizio(LocalDate oldDate, LocalDate newDate) {
        // UPDATE animals SET name = 'nuovonome' WHERE name = 'Fido' AND tipo_animale = 'Cane'
        EntityTransaction transaction = em.getTransaction();
        // 1. Inizio la transazione
        transaction.begin();

        Query modifyNameQuery = em.createQuery("UPDATE Periodo p SET p.dataInizioServizio = :newDate WHERE p.dataInizioServizio = :oldDate"); // Query JPQL
        modifyNameQuery.setParameter("oldDate", oldDate);
        modifyNameQuery.setParameter("newDate", newDate);

        // 2. Eseguo la query
        int numeroModificati = modifyNameQuery.executeUpdate();

        // 3. Termino la transazione col salvataggio effettivo di una nuova riga nella tabella students
        transaction.commit();

        if (numeroModificati > 0) {
            System.out.println("Periodi modificati");
        } else {
            System.out.println("Non ho trovato nessun periodo con data: " + oldDate);
        }

    }

    public void findPeriodoByDataFineAndUpdateDataFine(LocalDate oldDate, LocalDate newDate) {
        // UPDATE animals SET name = 'nuovonome' WHERE name = 'Fido' AND tipo_animale = 'Cane'
        EntityTransaction transaction = em.getTransaction();
        // 1. Inizio la transazione
        transaction.begin();

        Query modifyNameQuery = em.createQuery("UPDATE Periodo p SET p.dataPresuntaFineServizio = :newDate WHERE p.dataPresuntaFineServizio = :oldDate"); // Query JPQL
        modifyNameQuery.setParameter("oldDate", oldDate);
        modifyNameQuery.setParameter("newDate", newDate);

        // 2. Eseguo la query
        int numeroModificati = modifyNameQuery.executeUpdate();

        // 3. Termino la transazione col salvataggio effettivo di una nuova riga nella tabella students
        transaction.commit();

        if (numeroModificati > 0) {
            System.out.println("Periodi modificati");
        } else {
            System.out.println("Non ho trovato nessun periodo con data: " + oldDate);
        }

    }

    public void save(Periodo periodo) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(periodo);
            transaction.commit();
            System.out.println("Periodo salvato con successo");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public Periodo findById(long id) {
        return em.find(Periodo.class, id);
    }

    public void findByIdAndDelete(long id) {
        Periodo foundPublication = em.find(Periodo.class, id);

        if (foundPublication != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(foundPublication);
            transaction.commit();
            System.out.println("Il periodo con id: " + id + " e' stato eliminato con successo");
        } else {
            System.out.println("Il periodo con id: " + id + " non e' stato trovato");
        }

    }

    public void refresh(Periodo periodo) {
        em.refresh(periodo);
        System.out.println("Il periodo e' stato refreshato");
    }

    public List<Periodo> getPeriodoByType(String status) {
        TypedQuery<Periodo> getPeriodo = em.createQuery("SELECT p FROM Periodo p WHERE LOWER(p.status) = LOWER(:status) ", Periodo.class);
        getPeriodo.setParameter("status", status);
        return getPeriodo.getResultList();
    }

    public List<Periodo> getPeriodoByMezzoId(long mezzo_id) {
        TypedQuery<Periodo> getPeriodo = em.createQuery("SELECT p FROM Periodo p WHERE p.mezzi.mezzoId = :mezzo_id", Periodo.class);
        getPeriodo.setParameter("mezzo_id", mezzo_id);
        return getPeriodo.getResultList();
    }

    public List<Periodo> getPeriodoByService(LocalDate inizio_servizio) {
        TypedQuery<Periodo> getPeriodo = em.createQuery("SELECT p FROM Periodo p WHERE p.dataInizioServizio= :inizio_servizio", Periodo.class);
        getPeriodo.setParameter("inizio_servizio", inizio_servizio);
        return getPeriodo.getResultList();
    }

    public List<Periodo> getPeriodoByManutenzione(LocalDate inizio_manutenzione) {
        TypedQuery<Periodo> getPeriodo = em.createQuery("SELECT p FROM Periodo p WHERE p.dataInizioManutenzione= :inizio_manutenzione", Periodo.class);
        getPeriodo.setParameter("inizio_manutenzione", inizio_manutenzione);
        return getPeriodo.getResultList();
    }

    public List<Periodo> getPeriodoById(long id_periodo) {
        TypedQuery<Periodo> getPeriodo = em.createQuery("SELECT p FROM Periodo p WHERE p.idPeriodo = :id_periodo", Periodo.class);
        getPeriodo.setParameter("id_periodo", id_periodo);
        return getPeriodo.getResultList();
    }


}
