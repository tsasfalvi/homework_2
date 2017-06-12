package proxy.repository;

import proxy.domain.Person;

import java.util.Optional;

public class MySqlRepository implements Repository {
    @Override
    public Optional<Person> readPerson(String name) {
        return null;
    }
}
