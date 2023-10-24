package buildweek.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "manutenzioni")
public class Manutenzione extends Periodo {

    private LocalDate dataInizioManutenione;
    private LocalDate dataFineManutenione;
    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzi mezzi;

    public Manutenzione() {
    }

    public Manutenzione(LocalDate dataInizioManutenione, LocalDate dataFineManutenione, Mezzi mezzi) {
        this.dataInizioManutenione = dataInizioManutenione;
        this.dataFineManutenione = dataFineManutenione;
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

    public LocalDate getDataInizioManutenione() {
        return dataInizioManutenione;
    }

    public void setDataInizioManutenione(LocalDate dataInizioManutenione) {
        this.dataInizioManutenione = dataInizioManutenione;
    }

    public LocalDate getDataFineManutenione() {
        return dataFineManutenione;
    }

    public void setDataFineManutenione(LocalDate dataFineManutenione) {
        this.dataFineManutenione = dataFineManutenione;
    }

    @Override
    public String toString() {
        return "Manutenzione{" +
                "dataInizioManutenione=" + dataInizioManutenione +
                ", dataFineManutenione=" + dataFineManutenione +
                ", idPeriodo=" + idPeriodo +
                '}';
    }
}
