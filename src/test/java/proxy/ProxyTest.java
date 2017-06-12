package proxy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import proxy.cache.Cache;
import proxy.domain.Person;
import proxy.service.PersonService;

import java.util.Optional;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProxyTest {
    @Mock
    private PersonService personService;
    @Mock
    private Cache cache;

    private Proxy underTest;

    @Before
    public void setUp() {
        underTest = new Proxy(cache, personService);
    }

    @Test
    public void shouldCheckCacheBeforeReadingFromRepository() {
        // Given
        String personName = "";
        when(cache.get(anyString())).thenReturn(Optional.empty());
        when(personService.readPerson(anyString())).thenReturn(Optional.empty());

        // When
        underTest.readPerson(personName);

        // Then
        InOrder inOrder = inOrder(cache, personService);
        inOrder.verify(cache).get(personName);
        inOrder.verify(personService).readPerson(personName);
    }

    @Test
    public void shouldNotQueryRepositoriesWhenCacheHit() {
        // Given
        when(cache.get(anyString())).thenReturn(Optional.of(mock(Person.class)));

        // When
        underTest.readPerson("");

        // Then
        verify(personService, never()).readPerson(anyString());
    }
}