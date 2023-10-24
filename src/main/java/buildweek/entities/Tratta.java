package buildweek.entities;

import javax.persistence.*;

@Entity
@Table(name = "tratta")


public class Tratta {
    @Id
    @GeneratedValue
    @Column(name = "id_tratta")
    private long id;
    @Column(name = "zona_partenza")
    private String zonaPartenza;
    @Column(name = "capolinea")
    private String capolinea;
    @Column(name = "tempo_medio")
    private int tempoMedio;
    @Column(name = "tempo_effettivo")
    private int tempoEffettivo;

    @OneToOne(mappedBy = "tratta")
    private Mezzi mezzi;


    public Tratta(String zonaPartenza, String capolinea, int tempoMedio) {
        this.zonaPartenza = zonaPartenza;
        this.capolinea = capolinea;
        this.tempoMedio = tempoMedio;
        this.tempoEffettivo = tempoMedio - 10;
    }


    public Tratta() {
    }


    public String getZonaPartenza() {
        return zonaPartenza;
    }

    public void setZonaPartenza(String zonaPartenza) {
        this.zonaPartenza = zonaPartenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public int getTempoMedio() {
        return tempoMedio;
    }

    public void setTempoMedio(int tempoMedio) {
        this.tempoMedio = tempoMedio;
    }

    public int getTempoEffettivo() {
        return tempoEffettivo;
    }

    public void setTempoEffettivo(int tempoEffettivo) {
        this.tempoEffettivo = tempoEffettivo;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", zonaPartenza='" + zonaPartenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempoMedio=" + tempoMedio +
                ", tempoEffettivo=" + tempoEffettivo +
                ", mezzi=" + mezzi +
                '}';
    }
}
