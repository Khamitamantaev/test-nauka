package nauka.coming.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WORKERS")
public class WorkerEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRSTNAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LASTNAME" , length = 50, nullable = false)
    private String lastName;

    @Column(name="BIRTHDAY", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date birthday;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "UDALENKA")
    private boolean udalenkaornot;

    @Column(name = "ADRESS")
    private String adress;

    public WorkerEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isUdalenkaornot() {
        return udalenkaornot;
    }

    public void setUdalenkaornot(boolean udalenkaornot) {
        this.udalenkaornot = udalenkaornot;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Rabotnik{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", udalenkaornot=" + udalenkaornot +
                ", adress='" + adress + '\'' +
                '}';
    }
}
