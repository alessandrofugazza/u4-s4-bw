package buildweek;

import buildweek.dao.*;
import buildweek.entities.DistributoreAutomatico;
import buildweek.entities.Mezzi;
import buildweek.entities.RivenditoreAutorizzato;
import buildweek.entities.Tratta;
import buildweek.enums.StatusDistributore;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
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


        //***************** STEP 1 CREARE TESSERA ************************

//        Utente foundUser = ud.findById(378);
//        Tessera newTessera = new Tessera(
//                faker.date().past(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                LocalDate.now(), foundUser);
//        td.save(newTessera);


        //***************** STEP 2 CREARE UTENTI ************************

//        for (int i = 0; i < 1; i++) {
//            Utente User = new Utente(
//                    faker.name().firstName(),
//                    faker.name().lastName(),
//                    faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
//            );
//            ud.save(User);
//        }

        
        //***************** STEP 3 CREARE ABBONAMENTO ************************

//        for (int i = 379; i < 380; i++) {
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

//        Mezzi m1 = md.findById(351);
//        m1.setStatusMezzo(StatusMezzo.IN_SERVIZIO);
//        md.save(m1);
//
//        for (int i = 351; i < 352; i++) {
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
//        for (int i = 351; i < 352; i++) {
//            Mezzi foundMezzi2 = md.findById(i);
//            Periodo periodoSupplier2 = new Servizio(
//                    faker.date().past(30, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                    faker.date().future(20, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                    foundMezzi2
//            );
//            if (foundMezzi2.getStatusMezzo() == StatusMezzo.IN_SERVIZIO) {
//                ped.save(periodoSupplier2);
//            }


        //*************************** QUERY TEST *********************************

        //UTENTE

//        GET USER BY ID
//        List<Utente> u1 = ud.getUserBYId(314);
//        u1.forEach(elem -> System.out.println(elem));
//
//        // GET USER BY FIRSTNAME
//        List<Utente> u2 = ud.getUserBYName("taryn");
//        u2.forEach(elem -> System.out.println(elem));
//
//        // GET USER BY LASTNAME
//        List<Utente> u3 = ud.getUserBYLastName("lockman");
//        u3.forEach(elem -> System.out.println(elem));

        //PERIODO

        //List<Periodo> p1 = ped.getServizioByDataDiInizio(LocalDate.of(2023, 10, 13));
        //p1.forEach(System.out::println);

        //ped.findPeriodoByDataInizioAndUpdateDataInizio(LocalDate.of(2023, 10, 13), LocalDate.of(2023, 11, 7));
        //ped.findPeriodoByDataFineAndUpdateDataFine(LocalDate.of(2023, 12, 13), null);


        //deleteUserById
        //ud.deleteUserById(321);

        //getTesseraByNumber
        //List<Tessera> t1 = td.getTesseraByNumber(327);
        //t1.forEach(System.out::println);

        //getTesseraByIdUser
        //List<Tessera> t2 = td.getTesseraByIdUser(314);
        //t2.forEach(System.out::println);


        //getTessereScadute
        //List<Tessera> t3 = td.getTessereScadute();
        //t3.forEach(System.out::println);

        //getTessereInCorso
        //List<Tessera> t3 = td.getTessereInCorso();
        //t3.forEach(System.out::println);

        List<Mezzi> m1 = md.getMezziByCapienzaMoreThen20();
        // m1.forEach(System.out::println);

        loop:
//        while (true) {
//            try {
//                System.out.println("Benvenuto, premi 1 se sei un ADMIN, 2 se sei uno USER, 0 per uscire ");
//                int choose = Integer.parseInt(input.nextLine());
//                if (choose == 0) {
//                    break loop;
//                }
//                switch (choose) {
//                    case 1: {
//                        System.out.println("Benvenuto Admin");
//                        System.out.println("Cosa vuoi fare?");
//                        System.out.println("""
//                                1: Cerca uno User tramite Id,
//                                2: Elimina uno User,
//                                3: Cerca una tessera tramite id,
//                                4: Stampa una lista di tutte le tessere scadute,
//                                5: Stampa una lista di tutte le tessere in corso,
//                                6: Cerca una abbonamento tramite numero tessera,
//                                7: Cerca una abbonamento per durata,
//                                8: Stampa una lista di abbonamenti scaduti,
//                                9: Stampa una lista di abbonamenti in corso,
//                                10: Cerca biglietto per vidimazione,
//                                11: Cerca biglietto per id del mezzo,
//                                12: Stampa una lista di mezzi in manutenzione,
//                                13: Stampa una lista di mezzi in servizio,
//                                \s""");
//                        int choose2 = Integer.parseInt(input.nextLine());
//                        switch (choose2) {
//                            case 1: {
//                                System.out.println("Inserisci l'id dell'utente");
//                                int idUtente = Integer.parseInt(input.nextLine());
//                                List<Utente> u1 = ud.getUserBYId(idUtente);
//                                u1.forEach(System.out::println);
//                                break;
//                            }
//                            case 2: {
//                                System.out.println("Inserisci l'id dell'utente da eliminare");
//                                int idUtente = Integer.parseInt(input.nextLine());
//                                ud.deleteUserById(idUtente);
//                                break;
//                            }
//                            case 3: {
//                                System.out.println("Inserisci l'id della tessera");
//                                int idTessera = Integer.parseInt(input.nextLine());
//                                List<Tessera> t1 = td.getTesseraByNumber(idTessera);
//                                t1.forEach(System.out::println);
//                                break;
//                            }
//                            case 4: {
//                                List<Tessera> t2 = td.getTessereScadute();
//                                t2.forEach(System.out::println);
//                                break;
//                            }
//                            case 5: {
//                                List<Tessera> t3 = td.getTessereInCorso();
//                                t3.forEach(System.out::println);
//                                break;
//                            }
//                            case 6: {
//                                System.out.println("Inserisci l'id dell'abbonamento");
//                                int idAbbonamento = Integer.parseInt(input.nextLine());
//                                Abbonamento a1 = ad.findById(idAbbonamento);
//                                System.out.println(a1);
//                                break;
//                            }
//                            case 7: {
//                                System.out.println("1: SETTIMANALI, 2: MENSILI");
//                                int choose3 = Integer.parseInt(input.nextLine());
//                                if (choose3 == 1) {
//                                    ad.getAbbonamentiByDurata(DurataAbbonamento.SETTIMANALE).forEach(System.out::println);
//                                    break;
//                                } else {
//                                    ad.getAbbonamentiByDurata(DurataAbbonamento.MENSILE).forEach(System.out::println);
//                                    break;
//                                }
//                            }
//                            case 8: {
//                                ad.getAbbonamentiScaduti().forEach(System.out::println);
//                                break;
//                            }
//                            case 9: {
//                                ad.getAbbonamentiInCorso().forEach(System.out::println);
//                                break;
//                            }
//                            case 10: {
//                                System.out.println("1: VIDIMATI, 2: NON-VIDIMATI");
//                                int choose3 = Integer.parseInt(input.nextLine());
//                                if (choose3 == 1) {
//                                    bd.getBigliettiVidimati(Vidimazione.TRUE).forEach(System.out::println);
//                                    break;
//                                } else {
//                                    bd.getBigliettiVidimati(Vidimazione.FALSE).forEach(System.out::println);
//                                    break;
//                                }
//                            }
//                            case 11: {
//                                System.out.println("Inserisci l'id del mezzo");
//                                int idMezzo = Integer.parseInt(input.nextLine());
//                                List<Biglietto> b1 = bd.getByMezzo(idMezzo);
//                                b1.forEach(System.out::println);
//                                break;
//                            }
//                            case 12: {
//                                md.getMezziByStatusManutenzione().forEach(System.out::println);
//                                break;
//                            }
//                            case 13: {
//                                md.getMezziByStatusInServizio().forEach(System.out::println);
//                                break;
//                            }
//                        }
//                    }
//                    case 2: {
//                        System.out.println("Cosa vuoi fare?");
//                        System.out.println("""
//                                1: Creare un account con una tessera,
//                                2: Compra un biglietto,
//                                3: Compra un abbonamento,
//                                4: Cerca le tratte,
//                                5: ,
//                                """);
//                        int choose3 = Integer.parseInt(input.nextLine());
//                        switch (choose3) {
//                            case 1: {
//                                System.out.println("Inserisci la tua data di nascita(Anno-mese-giorno)");
//                                LocalDate dataUser = LocalDate.parse(input.nextLine());
//                                System.out.println("Inserisci il tuo nome");
//                                String nameUser = (input.nextLine());
//                                System.out.println("Inserisci il tuo cognome");
//                                String lastNameUser = (input.nextLine());
//
//                                Tessera newTessera = new Tessera(
//                                        faker.date().past(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                                        LocalDate.now());
//                                td.save(newTessera);
//
//                                Tessera foundTessera = newTessera;
//                                Utente User = new Utente(
//                                        nameUser,
//                                        lastNameUser,
//                                        dataUser,
//                                        foundTessera);
//                                ud.save(User);
//                                System.out.println("Benvenuto " + nameUser);
//                                break;
//                            }
//                            case 2: {
//                                Rivenditore foundRive = rd.findById(rndm.nextInt(338, 342));
//                                Mezzi foundMezzo = md.findById(rndm.nextInt(350, 357));
//                                Biglietto newBiglietto = new Biglietto(
//                                        Vidimazione.FALSE,
//                                        foundRive,
//                                        LocalDate.now(),
//                                        foundMezzo
//                                );
//                                bd.save(newBiglietto);
//                                break;
//                            }
//                            case 3: {
//
//                            }
//                        }
//                    }
//                    break;
//                }
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }

            input.close();
            em.close();
            emf.close();
        }
    }

