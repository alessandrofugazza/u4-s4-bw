package buildweek.dao;

import javax.persistence.EntityManager;

public class AbbonamentoDAO {
    private final EntityManager em;
    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }
}
