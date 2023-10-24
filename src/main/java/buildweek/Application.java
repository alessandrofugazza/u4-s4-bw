package buildweek;

import buildweek.dao.*;
import buildweek.entities.*;
import buildweek.enums.StatusDistributore;
import buildweek.enums.StatusMezzo;
import buildweek.enums.Vidimazione;
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

        Supplier<Utente> userSupplier = () -> new Utente(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        );

//        for (int i = 0; i < 5; i++) {
//            ud.save(userSupplier.get());
//        }


//        for (int i = 1; i < 6; i++) {
//            Utente foundUsers = ud.findById(i);
//            Tessera newTessera = new Tessera(
//                    faker.date().past(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                    LocalDate.now(), foundUsers
//
//            );
//            td.save(newTessera);
//        }

//        for (int i = 6; i < 11; i++) {
//
//            Tessera foundTessera = td.findById(i);
//            Abbonamento newAbbonamento =
//                    new Abbonamento(
//                            DurataAbbonamento.values()[faker.number().numberBetween(0, DurataAbbonamento.values().length)],
//                            faker.date().past(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                            LocalDate.now(), foundTessera);
//            ad.save(newAbbonamento);
//        }

        Supplier<DistributoreAutomatico> distributoreAutomaticoSupplier = () -> new DistributoreAutomatico(
                faker.address().cityName(),
                StatusDistributore.values()[faker.number().numberBetween(0, StatusDistributore.values().length)]);

//        for (int i = 0; i < 5; i++) {
//            rd.save(distributoreAutomaticoSupplier.get());
//        }

        Supplier<RivenditoreAutorizzato> rivenditoreAutorizzatoSupplier = () -> new RivenditoreAutorizzato(
                faker.address().cityName(),
                faker.rickAndMorty().character());
//        for (int i = 0; i < 5; i++) {
//            rd.save(rivenditoreAutorizzatoSupplier.get());
//        }

        for (int i = 0; i < 8; i++) {
            Rivenditore foundRive = rd.findById(rndm.nextInt(104, 113));
            Mezzi foundMezzo = md.findById(rndm.nextInt(144, 151));
            Biglietto newBiglietto = new Biglietto(
                    Vidimazione.values()[faker.number().numberBetween(0, Vidimazione.values().length)],
                    foundRive,
                    foundMezzo
            );

            bd.save(newBiglietto);
        }
        Supplier<Autobus> autobusSupplier = () -> new Autobus(
                rndm.nextInt(25, 40),
                StatusMezzo.values()[faker.number().numberBetween(0, StatusMezzo.values().length)]);

        Supplier<Tram> tramSupplier = () -> new Tram(
                rndm.nextInt(25, 40),
                StatusMezzo.values()[faker.number().numberBetween(0, StatusMezzo.values().length)]);

//        for (int i = 0; i < 2; i++) {
//            md.save(autobusSupplier.get());
//            md.save(tramSupplier.get());
//        }


        input.close();
        em.close();
        emf.close();
    }
}
