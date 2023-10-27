package buildweek.entities;

import buildweek.enums.StatusDistributore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Distributore Automatico")
public class DistributoreAutomatico extends Rivenditore {

    @Enumerated(EnumType.STRING)
    private StatusDistributore statusDistributore;

    public DistributoreAutomatico() {
    }


    public DistributoreAutomatico(String luogoDiEmissione, StatusDistributore statusDistributore) {
        super(luogoDiEmissione);
        this.statusDistributore = statusDistributore;
    }

    public StatusDistributore getStatusDistributore() {
        return statusDistributore;
    }

    public void setStatusDistributore(StatusDistributore statusDistributore) {
        this.statusDistributore = statusDistributore;
    }

    @Override
    public String toString() {
        return "DistributoreAutomatico{" +
                "statusDistributore=" + statusDistributore +
                ", rivenditoreId=" + rivenditoreId +
                ", luogoDiEmissione='" + luogoDiEmissione + '\'' +
                '}';
    }
}
