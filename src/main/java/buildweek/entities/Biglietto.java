package buildweek.entities;

import buildweek.enums.Vidimazione;

import javax.persistence.*;

@Entity
@Table(name = "biglietti")
public class Biglietto {

    @Id
    @GeneratedValue
    @Column(name = "codice_univoco")
    private long codiceUnivoco;

    private Vidimazione vidimazione;

    public Biglietto() {
    }

    public Biglietto(Vidimazione vidimazione) {
        this.vidimazione = vidimazione;
    }

    public long getCodiceUnivoco() {
        return codiceUnivoco;
    }


    public Vidimazione getVidimazione() {
        return vidimazione;
    }

    public void setVidimazione(Vidimazione vidimazione) {
        this.vidimazione = vidimazione;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "codiceUnivoco=" + codiceUnivoco +
                ", vidimazione=" + vidimazione +
                '}';
    }
}
