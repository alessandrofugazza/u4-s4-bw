package buildweek.dao;

import javax.persistence.EntityManager;

public class RivenditoreDAO {
    private final EntityManager em;

    public RivenditoreDAO(EntityManager em) {
        this.em = em;
    }
}
