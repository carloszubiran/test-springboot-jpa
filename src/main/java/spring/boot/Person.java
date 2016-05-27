package spring.boot;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by Carlos Zubiran on 5/26/2016.
 */

@Entity
public class Person {

    //region PROPERTIES

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Integer Id;


    @Version
    private Integer version;

    private String firstName;
    private String middleName;
    private String lastName;
    private String SSN;

    //endregion PROPERTIES

    //region CONSTRUCTORS

    public Person() {

    }

    public Person(String firstName) {
        this.firstName = firstName;
    }


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS


    //endregion CUSTOM METHODS


}
