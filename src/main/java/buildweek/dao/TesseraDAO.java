package buildweek.dao;

import javax.persistence.EntityManager;

public class TesseraDAO {
    private final EntityManager em;
    public TesseraDAO(EntityManager em) {
        this.em = em;
    }
}
