package buildweek.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Rivenditore Autorizzato")
public class RivenditoreAutorizzato extends Rivenditore {

    @Column(name = "nome_rivenditore")
    private String nomeRivenditore;

    public RivenditoreAutorizzato() {
    }

    public RivenditoreAutorizzato(String luogoDiEmissione, String nomeRivenditore) {
        super(luogoDiEmissione);
        this.nomeRivenditore = nomeRivenditore;
    }

    public String getNomeRivenditore() {
        return nomeRivenditore;
    }

    public void setNomeRivenditore(String nomeRivenditore) {
        this.nomeRivenditore = nomeRivenditore;
    }

    @Override
    public String toString() {
        return "RivenditoreAutorizzato{" +
                "nomeRivenditore='" + nomeRivenditore + '\'' +
                ", rivenditoreId=" + rivenditoreId +
                ", luogoDiEmissione='" + luogoDiEmissione + '\'' +
                '}';
    }
}
