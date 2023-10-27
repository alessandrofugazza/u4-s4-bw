package buildweek.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "utenti")
@NamedQueries({@NamedQuery(name = "getAllUsers", query = "SELECT u FROM Utente u"),
        @NamedQuery(name = "getUserBYName", query = "SELECT u FROM Utente u WHERE LOWER(u.firstName) = LOWER(:name)"),
        @NamedQuery(name = "getUserBYLastName", query = "SELECT u FROM Utente u WHERE LOWER(u.lastName) = LOWER(:lastName)"),
        @NamedQuery(name = "deleteUserById", query = "DELETE FROM Utente u WHERE u.userId = :userId")
})
public class Utente {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne(mappedBy = "utente", cascade = CascadeType.REMOVE)
    private Tessera tessera;


    public Utente() {
    }

    public Utente(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }


    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "Utente{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
