package nauka.coming.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WORKERS")
public class Rabotnik {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "FIRSTNAME", length = 50, nullable = false)
    private String firstname;

    @Column(name = "LASTNAME" , length = 50, nullable = false)
    private String lastname;

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

    public Rabotnik() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
}
