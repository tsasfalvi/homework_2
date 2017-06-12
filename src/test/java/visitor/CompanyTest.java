package visitor;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import visitor.elements.Employee;
import visitor.elements.Visitable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class CompanyTest {
    // @formatter:off
    private List<Visitable> employees = Lists.newArrayList(
            new Employee("elso", 1d, "elsoDep"),
            new Employee("masodik", 2d, "masodikDep")
    );
    // @formatter:on

    private Company underTest;

    @Before
    public void setUp() {
        underTest = new Company(employees);
    }

    @Test
    public void shouldCalculateTotalSalary() {
        // When
        double actual = underTest.getTotalSalaries();

        // Then
        Assert.assertEquals(3d, actual, 0.1d);
    }

    @Test
    public void shouldCalculateNumberOfEmployees() {
        // Given

        // When
        int actual = underTest.getNumberOfEmployees();

        // Then
        Assert.assertEquals(2, actual);
    }

    @Test
    public void shouldCalculateAverageSalary() {
        // Given

        // When
        double actual = underTest.getAverageSalaries();

        // Then
        Assert.assertEquals(1.5d, actual, 0.1d);
    }

    @Test
    public void shouldCollectEmployeesPerDepartment() {
        // Given
        Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("elsoDep", 1);
                put("masodikDep", 1);
            }
        };

        // When
        Map<String, Integer> actual = underTest.getEmployeeCountPerDepartment();

        // Then
        Assert.assertEquals(expected, actual);
    }
}