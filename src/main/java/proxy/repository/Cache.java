package proxy.repository;
import proxy.domain.Person;

import java.util.Map;

public class Cache implements Repository {
    private Map<String, Person> cache;

    @Override
    public Person readPerson(String name) {
        return cache.get(name);
    }
}
