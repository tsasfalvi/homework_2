import java.util.List;
import java.util.Map;

import static com.sun.corba.se.impl.util.RepositoryId.cache;

public class Proxy {
    private List<Repository> repositories;

    public Proxy(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public Person readPerson(String name) {
        for (Repository repository : repositories) {
            Person person = repository.readPerson(name);
            if (person != null) {
                return person;
            }
        }

    }
}
