import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "employeeTable")
public class EmployeeDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor",strategy = "increment")
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "corpKey")
    private String corpKey;
    public String getCorpKey() {
        return corpKey;
    }
    public void setCorpKey(String corpKey) {
        this.corpKey = corpKey;
    }

    @Column(name = "name")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email")
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="squad")
    private  String squad;
    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }


    @Column(name = "tribe")
    private String tribe;

    public String getTribe() {
        return tribe;
    }
    public void setTribe(String tribe) {
        this.tribe = tribe;
    }
}
