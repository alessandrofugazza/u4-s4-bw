package buildweek.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "rivenditori")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({@NamedQuery(name = "getResellerByName", query = "SELECT r FROM Rivenditore r WHERE LOWER(r.nomeRivenditore) LIKE LOWER(CONCAT(:name,'%'))"),
        @NamedQuery(name = "getMachineReseller", query = "SELECT r FROM Rivenditore r WHERE r.dtype = 'Distributore Automatico'"),
        @NamedQuery(name = "getUmanReseller", query = "SELECT r FROM Rivenditore r WHERE r.dtype = 'Rivenditore Autorizzato'"),
        @NamedQuery(name = "getMachineResellerByStatusAttivo", query = "SELECT r FROM Rivenditore r WHERE r.statusDistributore = 'ATTIVO'"),
        @NamedQuery(name = "getMachineResellerByStatusFuoriServizio", query = "SELECT r FROM Rivenditore r WHERE r.statusDistributore = 'FUORI_SERVIZIO'")
})
public abstract class Rivenditore {
    @Id
    @GeneratedValue
    @Column(name = "rivenditore_id")
    protected long rivenditoreId;

    @Column(name = "luogo_di_emissione")
    protected String luogoDiEmissione;
    @OneToMany(mappedBy = "rivenditore")
    List<Biglietto> bigliettoList;
    @Column(insertable = false, updatable = false)
    private String dtype;


    protected Rivenditore() {
    }

    public Rivenditore(String luogoDiEmissione) {
        this.luogoDiEmissione = luogoDiEmissione;
    }

    public long getRivenditoreId() {
        return rivenditoreId;
    }

    public String getLuogoDiEmissione() {
        return luogoDiEmissione;
    }

    public void setLuogoDiEmissione(String luogoDiEmissione) {
        this.luogoDiEmissione = luogoDiEmissione;
    }


    @Override
    public String toString() {
        return "Rivenditore{" +
                "rivenditoreId=" + rivenditoreId +
                ", luogoDiEmissione='" + luogoDiEmissione + '\'' +
                '}';
    }
}
