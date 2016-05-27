package spring.boot;

import org.hibernate.internal.IteratorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Zubiran on 5/26/2016.
 */

@SpringBootApplication
public class Application {

    //region PROPERTIES

    private static final Logger Log = LoggerFactory.getLogger(Application.class);

    //endregion PROPERTIES


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    //region CONSTRUCTORS


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS


    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository) {
        return (args) -> {
            Log.info("--------- IT'S WORKING -----------");
//            personRepository.save(new Person("Carlos"));
//            personRepository.save(new Person("Dan"));
//            personRepository.save(new Person("Sean"));

            Person person = new Person();
            person.setFirstName("Java");
            person.setMiddleName("Persistence API");
            person.setLastName("IS AWESOME");
            person.setSSN("222-11-9999");

            personRepository.save(person);

            for (int i = 0; i < 10; i++) {
                Person pers = new Person("Person" + i);
                pers.setLastName("LastName" + i);
                pers.setSSN("111-" + i + i);
                //notes:    individual save
                personRepository.save(pers);

            }


            List<Person> personToListSave = new ArrayList<Person>();
            for (int i = 0; i < 10; i++) {
                Person pers = new Person("PersonL" + i);
                pers.setLastName("LastNameL" + i);
                pers.setSSN("111-" + i + i);

                personToListSave.add(pers);

            }

            //notes:    save a group of objects at once
            personRepository.save(personToListSave);

            //notes:    find an object by ID
            Person foundPerson = personRepository.findOne(20);
            Log.info("Person Found:" + foundPerson.getFirstName() + " " + foundPerson.getLastName());

            //notes: iterate thru all the records in the db

            for (Person p: personRepository.findAll()) {
                Log.info("Person found: " + p.getId() + " " + p.getFirstName() + " " + p.getLastName());
            }

        };
    }

    //endregion CUSTOM METHODS


}
