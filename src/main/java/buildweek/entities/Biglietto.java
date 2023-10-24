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

    @Enumerated(EnumType.STRING)
    private Vidimazione vidimazione;
    @ManyToOne
    @JoinColumn(name = "rivenditore_id")
    private Rivenditore rivenditore;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzi mezzi;

    public Biglietto() {
    }

    public Biglietto(Vidimazione vidimazione, Rivenditore rivenditore, Mezzi mezzi) {
        this.vidimazione = vidimazione;
        this.rivenditore = rivenditore;
        switch (vidimazione) {
            case TRUE: {
                this.mezzi = mezzi;
                break;
            }
            case FALSE: {
                this.mezzi = null;
                break;
            }
        }


    }


    public Rivenditore getRivenditore() {
        return rivenditore;
    }

    public void setRivenditore(Rivenditore rivenditore) {
        this.rivenditore = rivenditore;
    }

    public Mezzi getMezzi() {
        return mezzi;
    }

    public void setMezzi(Mezzi mezzi) {
        this.mezzi = mezzi;
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
