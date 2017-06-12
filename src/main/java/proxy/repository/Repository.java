package proxy.repository;
import proxy.domain.Person;

import java.util.Optional;

public interface Repository {
    Optional<Person> readPerson(String name);
}
