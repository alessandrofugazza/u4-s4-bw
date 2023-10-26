package buildweek.entities;

import buildweek.enums.StatusMezzo;

import javax.persistence.*;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "mezzi_di_trasporto")
@DiscriminatorColumn(name = "tipologia_mezzo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Mezzi {
    @Id
    @GeneratedValue
    @Column(name = "mezzo_id")
    protected long mezzoId;
    @Column(name = "capienza_mezzo")
    protected int capienza;
    @Enumerated(EnumType.STRING)
    protected StatusMezzo statusMezzo;
    @Column(insertable = false, updatable = false)
    private String tipologia_mezzo;
    @OneToMany(mappedBy = "mezzi")
    private List<Biglietto> bigliettoList;
    @OneToOne
    @JoinColumn(name = "id_tratta")
    private Tratta tratta;

    @Column(name = "numero_tratte_eseguite")
    private int numeroTratteEseguite;
    @OneToMany(mappedBy = "mezzi")
    private List<Manutenzione> manutenzioneList;
    @OneToMany(mappedBy = "mezzi")
    private List<Servizio> servizioList;


    protected Mezzi() {
    }

    public Mezzi(int capienza, StatusMezzo statusMezzo, Tratta tratta) {
        Random rndm = new Random();
        this.capienza = capienza;
        this.statusMezzo = statusMezzo;
        switch (statusMezzo) {
            case IN_SERVIZIO: {
                this.numeroTratteEseguite = rndm.nextInt(1, 5);
                break;
            }
            case MANUTENZIONE: {
                this.numeroTratteEseguite = 0;
                break;
            }
        }
        switch (statusMezzo) {
            case IN_SERVIZIO: {
                this.tratta = tratta;
                break;
            }
            case MANUTENZIONE: {
                this.tratta = null;
            }
        }
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public long getMezzoId() {
        return mezzoId;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public StatusMezzo getStatusMezzo() {
        return statusMezzo;
    }

    public void setStatusMezzo(StatusMezzo statusMezzo) {
        this.statusMezzo = statusMezzo;
    }

    @Override
    public String toString() {
        return "Mezzi{" +
                "mezzoId=" + mezzoId +
                ", capienza=" + capienza +
                ", statusMezzo=" + statusMezzo +
                '}';
    }
}

