package buildweek;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-s4-bw");

    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(Application.class);
        Faker faker = new Faker();
        EntityManager em = emf.createEntityManager();
        Scanner input = new Scanner(System.in);
        

        input.close();
        em.close();
        emf.close();
    }
}
