package proxy;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import proxy.repository.Cache;
import proxy.repository.FileRepository;
import proxy.repository.MySqlRepository;
@RunWith(MockitoJUnitRunner.class)
public class ProxyTest {
    @Mock
    private MySqlRepository mySqlRepository;
    @Mock
    private FileRepository fileRepository;
    @Mock
    private Cache cache;

    private Proxy underTest;

    @Before
    public void setUp() {
        underTest = new Proxy();
    }
}