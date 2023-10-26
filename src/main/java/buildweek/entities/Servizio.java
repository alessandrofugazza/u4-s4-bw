package buildweek.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "servizi")
public class Servizio extends Periodo {
    @Column(name = "data_inizio_servizio")
    private LocalDate dataInizioServizio;
    @Column(name = "data_presunta_fine_servizio")
    private LocalDate dataPresuntaFineServizio;

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzi mezzi;


    public Servizio() {
    }

    public Servizio(LocalDate dataInizioServizio, LocalDate dataPresuntaFineServizio, Mezzi mezzi) {
        this.dataInizioServizio = dataInizioServizio;
        this.dataPresuntaFineServizio = dataInizioServizio.plusMonths(2);
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

    public LocalDate getDataPresuntaFineServizio() {
        return dataPresuntaFineServizio;
    }

    public void setDataPresuntaFineServizio(LocalDate dataPresuntaFineServizio) {
        this.dataPresuntaFineServizio = dataPresuntaFineServizio;
    }

    public Mezzi getMezzi() {
        return mezzi;
    }

    public void setMezzi(Mezzi mezzi) {
        this.mezzi = mezzi;
    }

    @Override
    public String toString() {
        return "Servizio{" +
                "dataInizioServizio=" + dataInizioServizio +
                ", dataPresuntaFineServizio=" + dataPresuntaFineServizio +
                ", mezzi=" + mezzi +
                ", idPeriodo=" + idPeriodo +
                '}';
    }
}
