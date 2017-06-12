package proxy.cache;
import proxy.domain.Person;

import java.util.Optional;

public interface Cache {
    Optional<Person> get(String name);

    void store(Person person);
}
