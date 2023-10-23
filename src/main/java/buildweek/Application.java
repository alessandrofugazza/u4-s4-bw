package buildweek;

import buildweek.dao.AbbonamentoDAO;
import buildweek.dao.TesseraDAO;
import buildweek.dao.UtenteDAO;
import buildweek.entities.Abbonamento;
import buildweek.entities.Tessera;
import buildweek.entities.Utente;
import buildweek.enums.DurataAbbonamento;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-s4-bw");

    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(Application.class);
        Faker faker = new Faker();
        Random rndm = new Random();
        EntityManager em = emf.createEntityManager();
        Scanner input = new Scanner(System.in);
        UtenteDAO ud = new UtenteDAO(em);
        AbbonamentoDAO ad = new AbbonamentoDAO(em);
        TesseraDAO td = new TesseraDAO(em);

        Supplier<Utente> userSupplier = () -> new Utente(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        );

//        for (int i = 0; i < 5; i++) {
//            ud.save(userSupplier.get());
//        }


//        for (int i = 71; i < 76; i++) {
//            Utente foundUsers = ud.findById(i);
//            Tessera newTessera = new Tessera(
//                    faker.date().past(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
//                    LocalDate.now(), foundUsers
//
//            );
//            td.save(newTessera);
//        }

        for (int i = 89; i < 94; i++) {

            Tessera foundTessera = td.findById(i);
            Abbonamento newAbbonamento =
                    new Abbonamento(
                            DurataAbbonamento.values()[faker.number().numberBetween(0, DurataAbbonamento.values().length)],
                            faker.date().past(3, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                            LocalDate.now(), foundTessera);
            ad.save(newAbbonamento);
        }


        input.close();
        em.close();
        emf.close();
    }
}
