package buildweek.entities;

import buildweek.enums.StatusMezzo;

import javax.persistence.Entity;

@Entity
public class Tram extends Mezzi {
    public Tram() {
    }

    public Tram(int capienza, StatusMezzo statusMezzo, Tratta tratta) {
        super(capienza, statusMezzo, tratta);
    }

    @Override
    public String toString() {
        return "Tram{" +
                "mezzoId=" + mezzoId +
                ", capienza=" + capienza +
                ", statusMezzo=" + statusMezzo +
                '}';
    }
}
