package proxy;
import proxy.domain.Person;
import proxy.repository.Repository;

import java.util.List;
import java.util.Optional;

public class Proxy {
    private List<Repository> repositories;

    public Proxy(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public Optional<Person> readPerson(String name) {
        for (Repository repository : repositories) {
            Person person = repository.readPerson(name);
            if (person != null) {
                return Optional.of(person);
            }
        }

        return Optional.empty();
    }
}
