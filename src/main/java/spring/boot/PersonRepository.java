package spring.boot;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Carlos Zubiran on 5/26/2016.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
