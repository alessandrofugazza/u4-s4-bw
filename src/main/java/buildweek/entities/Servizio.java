package buildweek.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "servizi")
public class Servizio extends Periodo {

    private LocalDate dataInizioServizio;
    private LocalDate dataPresuntaFineServizio;

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzi mezzi;

    public Servizio() {
    }

    public Servizio(LocalDate dataInizioServizio, LocalDate dataPresuntaFineServizio, Mezzi mezzi) {
        this.dataInizioServizio = dataInizioServizio;
        this.dataPresuntaFineServizio = dataPresuntaFineServizio;
        switch (mezzi.getStatusMezzo()) {
            case IN_SERVIZIO: {
                this.mezzi = mezzi;
                break;
            }
            case MANUTENZIONE: {
                this.mezzi = null;
                break;
            }
        }
    }

    public LocalDate getDataInizioServizio() {
        return dataInizioServizio;
    }

    public void setDataInizioServizio(LocalDate dataInizioServizio) {
        this.dataInizioServizio = dataInizioServizio;
    }

    public LocalDate dataPresuntaFineServizio() {
        return dataPresuntaFineServizio;
    }

    public void dataPresuntaFineServizio(LocalDate dataFineServizio) {
        this.dataPresuntaFineServizio = dataPresuntaFineServizio;
    }

    @Override
    public String toString() {
        return "Servizio{" +
                "dataInizioServizio=" + dataInizioServizio +
                ", dataPresuntaFineServizio=" + dataPresuntaFineServizio +
                '}';
    }
}
