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

    @Column(name = "data_di_emissione")
    private LocalDate dataDiEmissione;

    @Column(name = "data_di_scadenza")
    private LocalDate dataDiScandenza;

    @Column(name = "data_odierna")
    private LocalDate dataOdierna
}
