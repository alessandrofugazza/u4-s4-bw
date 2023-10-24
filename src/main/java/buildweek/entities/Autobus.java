package buildweek.entities;

import buildweek.enums.StatusMezzo;

import javax.persistence.Entity;

@Entity
public class Autobus extends Mezzi {
    public Autobus() {
    }

    public Autobus(int capienza, StatusMezzo statusMezzo, Tratta tratta) {
        super(capienza, statusMezzo, tratta);
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "mezzoId=" + mezzoId +
                ", capienza=" + capienza +
                ", statusMezzo=" + statusMezzo +
                '}';
    }
}
