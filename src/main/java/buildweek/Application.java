package buildweek;

import buildweek.dao.*;
import buildweek.entities.DistributoreAutomatico;
import buildweek.entities.RivenditoreAutorizzato;
import buildweek.entities.Tratta;
import buildweek.entities.Utente;
import buildweek.enums.StatusDistributore;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.ZoneId;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-s4-bw");

    public static void main(String[] args) {

        Faker faker = new Faker();
        Random rndm = new Random();
        EntityManager em = emf.createEntityManager();
        Scanner input = new Scanner(System.in);
        UtenteDAO ud = new UtenteDAO(em);
        AbbonamentoDAO ad = new AbbonamentoDAO(em);
        TesseraDAO td = new TesseraDAO(em);
        RivenditoreDAO rd = new RivenditoreDAO(em);
        BigliettoDAO bd = new BigliettoDAO(em);
        MezziDAO md = new MezziDAO(em);
        TrattaDAO trd = new TrattaDAO(em);
        PeriodoDAO ped = new PeriodoDAO(em);

        Supplier<Utente> userSupplier = () -> new Utente(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        );

        //***************** STEP 1 CREARE UTENTI ************************

//        for (int i = 0; i < 8; i++) {
//            ud.save(userSupplier.get());
//        }

        //***************** STEP 2 CREARE TESSERA ************************

//        for (int i = 314; i < 322; i++) {
//            Utente foundUsers = ud.findById(i);
//            Tessera newTessera = new Tessera(
//                    faker.date().past(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                    LocalDate.now(), foundUsers
//
//            );
//            td.save(newTessera);
//        }

        //***************** STEP 3 CREARE ABBONAMENTO ************************
//
//        for (int i = 322; i < 330; i++) {
//
//            Tessera foundTessera = td.findById(i);
//            Abbonamento newAbbonamento =
//                    new Abbonamento(
//                            DurataAbbonamento.values()[faker.number().numberBetween(0, DurataAbbonamento.values().length)],
//                            faker.date().past(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                            LocalDate.now(), foundTessera);
//            ad.save(newAbbonamento);
//        }

        //***************** STEP 4 CREARE DISTRIBUTORE E RIVENDITORE ************************


        Supplier<DistributoreAutomatico> distributoreAutomaticoSupplier = () -> new DistributoreAutomatico(
                faker.address().cityName(),
                StatusDistributore.values()[faker.number().numberBetween(0, StatusDistributore.values().length)]);

        Supplier<RivenditoreAutorizzato> rivenditoreAutorizzatoSupplier = () -> new RivenditoreAutorizzato(
                faker.address().cityName(),
                faker.rickAndMorty().character());
        //        for (int i = 0; i < 2; i++) {
//            rd.save(distributoreAutomaticoSupplier.get());
//            rd.save(rivenditoreAutorizzatoSupplier.get());
//        }

        //***************** STEP 5 CREARE TRATTA ************************

        Supplier<Tratta> trattaSupplier = () -> new Tratta(
                faker.country().capital(),
                faker.country().capital(),
                rndm.nextInt(0, 60));

        //        for (int i = 0; i < 8; i++) {
//            trd.save(trattaSupplier.get());
//        }

        //***************** STEP 6 CREARE MEZZI ************************
//
//        for (int i = 342; i < 346; i++) {
//            Tratta foundTratta = trd.findById(i);
//
//            Autobus autobusSupplier = new Autobus(
//                    rndm.nextInt(25, 40),
//                    StatusMezzo.values()[faker.number().numberBetween(0, StatusMezzo.values().length)], foundTratta
//              );
//            md.save(autobusSupplier);
//        }

//        for (int i = 346; i < 350; i++) {
//            Tratta foundTratta = trd.findById(i);
//            Tram tramSupplier = new Tram(
//                    rndm.nextInt(25, 40),
//                    StatusMezzo.values()[faker.number().numberBetween(0, StatusMezzo.values().length)], foundTratta
//            );
//            md.save(tramSupplier);
//        }

        //***************** STEP 7 CREARE BIGLIETTI ************************

//        for (int i = 0; i < 8; i++) {
//            Rivenditore foundRive = rd.findById(rndm.nextInt(338, 341));
//            Mezzi foundMezzo = md.findById(rndm.nextInt(350, 357));
//            Biglietto newBiglietto = new Biglietto(
//                    Vidimazione.values()[faker.number().numberBetween(0, Vidimazione.values().length)],
//                    foundRive,
//                    faker.date().past(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                    foundMezzo
//            );
//            bd.save(newBiglietto);
//        }

        //***************** STEP 8 CREARE PERIODI ************************

//        for (int i = 350; i < 358; i++) {
//            Mezzi foundMezzi = md.findById(i);
//            Periodo periodoSupplier = new Manutenzione(
//                    faker.date().past(30, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                    faker.date().future(20, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                    foundMezzi
//            );
//            if (foundMezzi.getStatusMezzo() == StatusMezzo.MANUTENZIONE) {
//                ped.save(periodoSupplier);
//            }
//        }
//        for (int i = 350; i < 358; i++) {
//            Mezzi foundMezzi2 = md.findById(i);
//            Periodo periodoSupplier2 = new Servizio(
//                    faker.date().past(30, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                    faker.date().future(20, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                    foundMezzi2
//            );
//            if (foundMezzi2.getStatusMezzo() == StatusMezzo.IN_SERVIZIO) {
//                ped.save(periodoSupplier2);
//            }
//        }


        input.close();
        em.close();
        emf.close();
    }
}
