package visitor.visitors;

import visitor.elements.Employee;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeCountPerDepartmentVisitor implements Visitor {
    private Map<String, Integer> result = new ConcurrentHashMap<>();

    @Override
    public void visit(Employee employee) {
        String department = employee.getDepartment();
        Integer counter = result.computeIfAbsent(department, k -> 0);

        result.put(department, counter + 1);
    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
