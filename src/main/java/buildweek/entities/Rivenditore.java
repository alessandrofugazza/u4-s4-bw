package buildweek.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "rivenditori")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Rivenditore {
}
