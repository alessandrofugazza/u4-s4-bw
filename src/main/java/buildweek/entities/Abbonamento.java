package buildweek.entities;

import buildweek.enums.DurataAbbonamento;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "abbonamenti")
public class Abbonamento {

    @Id
    @GeneratedValue
    @Column(name = "codice_abbonamento")
    private long codiceAbbonamento;

    private DurataAbbonamento durataAbbonamento;

    @Column(name = "data_di_emissione_abbonamento")
    private LocalDate dataDiEmissioneAbbonamento;

    @Column(name = "data_di_scadenza_abbonamento")
    private LocalDate dataDiScandenzaAbbonamento;

    @Column(name = "data_odierna_abbonamento")
    private LocalDate dataOdiernaAbbonamento;

    public Abbonamento() {
    }

    public Abbonamento(DurataAbbonamento durataAbbonamento, LocalDate dataDiEmissioneAbbonamento, LocalDate dataDiScandenzaAbbonamento, LocalDate dataOdiernaAbbonamento) {
        this.durataAbbonamento = durataAbbonamento;
        this.dataDiEmissioneAbbonamento = dataDiEmissioneAbbonamento;
        this.dataDiScandenzaAbbonamento = dataDiScandenzaAbbonamento;
        this.dataOdiernaAbbonamento = dataOdiernaAbbonamento;
    }

    public long getCodiceAbbonamento() {
        return codiceAbbonamento;
    }

    public DurataAbbonamento getDurataAbbonamento() {
        return durataAbbonamento;
    }

    public void setDurataAbbonamento(DurataAbbonamento durataAbbonamento) {
        this.durataAbbonamento = durataAbbonamento;
    }

    public LocalDate getDataDiEmissioneAbbonamento() {
        return dataDiEmissioneAbbonamento;
    }

    public void setDataDiEmissioneAbbonamento(LocalDate dataDiEmissioneAbbonamento) {
        this.dataDiEmissioneAbbonamento = dataDiEmissioneAbbonamento;
    }

    public LocalDate getDataDiScandenzaAbbonamento() {
        return dataDiScandenzaAbbonamento;
    }

    public void setDataDiScandenzaAbbonamento(LocalDate dataDiScandenzaAbbonamento) {
        this.dataDiScandenzaAbbonamento = dataDiScandenzaAbbonamento;
    }

    public LocalDate getDataOdiernaAbbonamento() {
        return dataOdiernaAbbonamento;
    }

    public void setDataOdiernaAbbonamento(LocalDate dataOdiernaAbbonamento) {
        this.dataOdiernaAbbonamento = dataOdiernaAbbonamento;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "codiceAbbonamento=" + codiceAbbonamento +
                ", durataAbbonamento=" + durataAbbonamento +
                ", dataDiEmissioneAbbonamento=" + dataDiEmissioneAbbonamento +
                ", dataDiScandenzaAbbonamento=" + dataDiScandenzaAbbonamento +
                ", dataOdiernaAbbonamento=" + dataOdiernaAbbonamento +
                '}';
    }
}
