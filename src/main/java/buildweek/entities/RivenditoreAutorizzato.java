package buildweek.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Rivenditore Autorizzato")
public class RivenditoreAutorizzato extends Rivenditore {
}
