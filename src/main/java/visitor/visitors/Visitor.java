package visitor.visitors;

import visitor.elements.Employee;

public interface Visitor {
    void visit(Employee employee);
}
