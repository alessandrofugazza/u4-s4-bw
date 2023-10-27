package buildweek.entities;

import buildweek.enums.DurataAbbonamento;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "abbonamenti")
@NamedQueries({
        @NamedQuery(name = "getAbbonamentiByDurata", query = "SELECT a FROM Abbonamento a WHERE a.durataAbbonamento = :durataAbbonamento"),
        @NamedQuery(name = "getAbbonamentiScaduti", query = "SELECT a FROM Abbonamento a WHERE a.dataOdiernaAbbonamento > dataDiScandenzaAbbonamento"),
        @NamedQuery(name = "getAbbonamentiInCorso", query = "SELECT a FROM Abbonamento a WHERE a.dataOdiernaAbbonamento <= dataDiScandenzaAbbonamento"),
        @NamedQuery(name = "getAbbonamentoById", query = "SELECT a FROM Abbonamento a WHERE a.codiceAbbonamento = :codiceAbbonamento"),
        @NamedQuery(name = "getAllAbbonamenti", query = "SELECT a FROM Abbonamento a")
})
public class Abbonamento {

    @Id
    @GeneratedValue
    @Column(name = "codice_abbonamento")
    private long codiceAbbonamento;

    @Enumerated(EnumType.STRING)
    private DurataAbbonamento durataAbbonamento;

    @Column(name = "data_di_emissione_abbonamento")
    private LocalDate dataDiEmissioneAbbonamento;

    @Column(name = "data_di_scadenza_abbonamento")
    private LocalDate dataDiScandenzaAbbonamento;

    @Column(name = "data_odierna_abbonamento")
    private LocalDate dataOdiernaAbbonamento;
    @OneToOne
    @JoinColumn(name = "numero_tessera")
    private Tessera tessera;

    public Abbonamento() {
    }

    public Abbonamento(DurataAbbonamento durataAbbonamento, LocalDate dataDiEmissioneAbbonamento, LocalDate dataOdiernaAbbonamento, Tessera tessera) {
        this.durataAbbonamento = durataAbbonamento;
        this.dataDiEmissioneAbbonamento = dataDiEmissioneAbbonamento;
        switch (durataAbbonamento) {
            case SETTIMANALE: {
                this.dataDiScandenzaAbbonamento = dataDiEmissioneAbbonamento.plusDays(7);
                break;
            }
            case MENSILE: {
                this.dataDiScandenzaAbbonamento = dataDiEmissioneAbbonamento.plusMonths(1);
                break;
            }
        }
        this.dataOdiernaAbbonamento = dataOdiernaAbbonamento;
        this.tessera = tessera;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
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
                ", tessera=" + tessera +
                '}';
    }
}
