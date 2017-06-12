package visitor;

import visitor.elements.Visitable;
import visitor.visitors.EmployeeCountPerDepartmentVisitor;
import visitor.visitors.TotalSalaryVisitor;

import java.util.Collection;
import java.util.Map;

public class Company {
    private Collection<Visitable> visitables;

    public Company(Collection<Visitable> visitables) {
        this.visitables = visitables;
    }

    public double getTotalSalaries() {
        TotalSalaryVisitor visitor = new TotalSalaryVisitor();
        visitables.forEach(visitable -> visitable.accept(visitor));

        return visitor.getResult();
    }

    public int getNumberOfEmployees() {
        // not really fits into the visitor paradigm
        return visitables.size();
    }

    public double getAverageSalaries() {
        return getTotalSalaries() / getNumberOfEmployees();
    }

    public Map<String, Integer> getEmployeeCountPerDepartment() {
        EmployeeCountPerDepartmentVisitor visitor = new EmployeeCountPerDepartmentVisitor();
        visitables.forEach(visitable -> visitable.accept(visitor));

        return visitor.getResult();
    }

    // TODO: salary raise???
}
