package buildweek.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Distributore Automatico")
public class DistributoreAutomatico extends Rivenditore {
}
