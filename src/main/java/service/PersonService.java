package service;

import proxy.domain.Person;
import proxy.repository.Repository;

import java.util.List;
import java.util.Optional;

public class PersonService {
    private List<Repository> repositories;

    public PersonService(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public Optional<Person> readPerson(String name) {
        Optional<Person> person;

        for (Repository repository : repositories) {
            person = repository.readPerson(name);
            if (person.isPresent()) {
                return person;
            }
        }

        return Optional.empty();
    }
}
