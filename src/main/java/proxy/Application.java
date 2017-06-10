package proxy;
import proxy.repository.Cache;
import proxy.repository.FileRepository;
import proxy.repository.MySqlRepository;
import proxy.repository.Repository;

import java.util.ArrayList;
public class Application {

    public static void main(String[] args) {
        ArrayList<Repository> repositories = new ArrayList<>();
        repositories.add(new Cache());
        repositories.add(new FileRepository());
        repositories.add(new MySqlRepository());

        new Proxy(repositories);
    }
}
