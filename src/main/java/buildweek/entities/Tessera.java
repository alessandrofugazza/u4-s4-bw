package buildweek.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tessere")
public class Tessera {

    @Id
    @GeneratedValue
    @Column(name = "numero_tessera")
    private long numeroTessera;

    @Column(name = "data_di_emissione_tessera")
    private LocalDate dataDiEmissioneTessera;

    @Column(name = "data_di_scadenza_tessera")
    private LocalDate dataDiScandenzaTessera;

    @Column(name = "data_odierna_tessera")
    private LocalDate dataOdiernaTessera;
    @OneToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @OneToOne(mappedBy = "tessera")
    private Abbonamento abbonamento;


    public Tessera() {
    }

    public Tessera(LocalDate dataDiEmissioneTessera, LocalDate dataOdiernaTessera, Utente utente) {
        this.dataDiEmissioneTessera = dataDiEmissioneTessera;
        this.dataDiScandenzaTessera = dataDiEmissioneTessera.plusYears(1);
        this.dataOdiernaTessera = dataOdiernaTessera;
        this.utente = utente;
    }


    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public long getNumeroTessera() {
        return numeroTessera;
    }

    public LocalDate getDataDiEmissione() {
        return dataDiEmissioneTessera;
    }

    public void setDataDiEmissione(LocalDate dataDiEmissione) {
        this.dataDiEmissioneTessera = dataDiEmissione;
    }

    public LocalDate getDataDiScandenza() {
        return dataDiScandenzaTessera;
    }

    public void setDataDiScandenza(LocalDate dataDiScandenza) {
        this.dataDiScandenzaTessera = dataDiScandenza;
    }

    public LocalDate getDataOdierna() {
        return dataOdiernaTessera;
    }

    public void setDataOdierna(LocalDate dataOdierna) {
        this.dataOdiernaTessera = dataOdierna;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "numeroTessera=" + numeroTessera +
                ", dataDiEmissione=" + dataDiEmissioneTessera +
                ", dataDiScandenza=" + dataDiScandenzaTessera +
                ", dataOdierna=" + dataOdiernaTessera +
                '}';
    }
}
