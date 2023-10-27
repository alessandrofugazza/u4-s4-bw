package buildweek.entities;


import javax.persistence.*;

@Entity
@Table(name = "periodi")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "status")
public abstract class Periodo {
    @Id
    @GeneratedValue
    @Column(name = "id_periodo")
    protected long idPeriodo;

    public Periodo() {
    }

    public long getIdPeriodo() {
        return idPeriodo;
    }

    @Override
    public String toString() {
        return "Periodo{" +
                "idPeriodo=" + idPeriodo +
                '}';
    }
}
