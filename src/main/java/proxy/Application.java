package proxy;

import proxy.cache.InfiniteCache;
import proxy.repository.FileRepository;
import proxy.repository.MySqlRepository;
import proxy.repository.Repository;
import service.PersonService;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        PersonService personService = createPersonService();

        Proxy proxy = new Proxy(new InfiniteCache(), personService);

        System.out.println(proxy.readPerson(""));
    }

    private static PersonService createPersonService() {
        ArrayList<Repository> repositories = new ArrayList<>();
        repositories.add(new MySqlRepository());
        repositories.add(new FileRepository());

        return new PersonService(repositories);
    }
}
