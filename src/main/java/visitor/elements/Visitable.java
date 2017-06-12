package visitor.elements;

import visitor.visitors.Visitor;

public interface Visitable {
    void accept(Visitor visitor);
}
