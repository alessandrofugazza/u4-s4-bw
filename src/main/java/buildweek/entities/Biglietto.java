package buildweek.entities;

import buildweek.enums.Vidimazione;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "biglietti")
@NamedQueries({
        @NamedQuery(name = "getBigliettiVidimati", query = "SELECT b FROM Biglietto b WHERE b.vidimazione = :vidimazione"),
        @NamedQuery(name = "getByMezzo", query = "SELECT b FROM Biglietto b WHERE b.mezzi.mezzoId = :mezzoid"),
        @NamedQuery(name = "getByRivenditore", query = "SELECT b FROM Biglietto b WHERE b.rivenditore.rivenditoreId = :rivenditoreid")
})
public class Biglietto {

    @Id
    @GeneratedValue
    @Column(name = "codice_univoco")
    private long codiceUnivoco;

    @Enumerated(EnumType.STRING)
    private Vidimazione vidimazione;
    @Column(name = "data_di_emissione")
    private LocalDate dataDiEmissione;
    @ManyToOne
    @JoinColumn(name = "rivenditore_id")
    private Rivenditore rivenditore;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzi mezzi;

    public Biglietto() {
    }

    public Biglietto(Vidimazione vidimazione, Rivenditore rivenditore, LocalDate dataDiEmissione, Mezzi mezzi) {
        this.vidimazione = vidimazione;
        this.rivenditore = rivenditore;
        this.dataDiEmissione = dataDiEmissione;
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
