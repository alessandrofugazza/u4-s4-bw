package buildweek.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "manutenzioni")
public class Manutenzione extends Periodo {
    @Column(name = "data_inizio_manutenzione")
    private LocalDate dataInizioManutenzione;
    @Column(name = "data_fine_manutenzione")
    private LocalDate dataFineManutenzione;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzi mezzi;

    public Manutenzione() {
    }

    public Manutenzione(LocalDate dataInizioManutenzione, LocalDate dataFineManutenzione, Mezzi mezzi) {
        this.dataInizioManutenzione = dataInizioManutenzione;
        this.dataFineManutenzione = dataFineManutenzione;
        switch (mezzi.getStatusMezzo()) {
            case MANUTENZIONE: {
                this.mezzi = mezzi;
                break;
            }
            case IN_SERVIZIO: {
                this.mezzi = null;
                break;
            }
        }

    }

    public LocalDate getDataInizioManutenzione() {
        return dataInizioManutenzione;
    }

    public void setDataInizioManutenzione(LocalDate dataInizioManutenzione) {
        this.dataInizioManutenzione = dataInizioManutenzione;
    }

    public LocalDate getDataFineManutenzione() {
        return dataFineManutenzione;
    }

    public void setDataFineManutenzione(LocalDate dataFineManutenzione) {
        this.dataFineManutenzione = dataFineManutenzione;
    }

    public Mezzi getMezzi() {
        return mezzi;
    }

    public void setMezzi(Mezzi mezzi) {
        this.mezzi = mezzi;
    }

    @Override
    public String toString() {
        return "Manutenzione{" +
                "dataInizioManutenzione=" + dataInizioManutenzione +
                ", dataFineManutenzione=" + dataFineManutenzione +
                ", mezzi=" + mezzi +
                ", idPeriodo=" + idPeriodo +
                '}';
    }
}
