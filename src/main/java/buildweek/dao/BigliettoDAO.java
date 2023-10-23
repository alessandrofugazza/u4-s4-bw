package buildweek.dao;

import javax.persistence.EntityManager;

public class BigliettoDAO {
    private final EntityManager em;
    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }
}
