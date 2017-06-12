package proxy;

import proxy.cache.Cache;
import proxy.domain.Person;
import proxy.service.PersonService;

import java.util.Optional;

public class Proxy {
    private final Cache cache;
    private final PersonService personService;


    public Proxy(Cache cache, PersonService personService) {
        this.cache = cache;
        this.personService = personService;
    }

    public Optional<Person> readPerson(String name) {
        Optional<Person> personOptional = cache.get(name);

        if (personOptional.isPresent()) {
            return personOptional;
        }

        personOptional = personService.readPerson(name);
        personOptional.ifPresent(cache::store);

        return personOptional;
    }
}
