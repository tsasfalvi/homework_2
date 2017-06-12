package visitor.visitors;

import visitor.elements.Employee;

public class TotalSalaryVisitor implements Visitor {
    private double result;

    @Override
    public synchronized void visit(Employee employee) {
        result += employee.getSalary();
    }

    public double getResult() {
        return result;
    }
}
