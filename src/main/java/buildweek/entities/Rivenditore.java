package buildweek.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rivenditori")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Rivenditore {
    @Id
    @GeneratedValue
    @Column(name = "rivenditore_id")
    protected long rivenditoreId;

    @Column(name = "luogo_di_emissione")
    protected String luogoDiEmissione;
    @OneToMany(mappedBy = "rivenditore")
    List<Biglietto> bigliettoList;


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
