package proxy.cache;
import proxy.domain.Person;

import java.util.Map;
import java.util.Optional;

public class InfiniteCache implements Cache {
    private Map<String, Person> cache;

    @Override
    public Optional<Person> get(String name) {
        return Optional.ofNullable(cache.get(name));
    }

    @Override
    public void store(Person person) {
        cache.put(person.getName(), person);
    }
}
