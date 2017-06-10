package proxy.repository;
import proxy.domain.Person;
public interface Repository {
    Person readPerson(String name);
}
