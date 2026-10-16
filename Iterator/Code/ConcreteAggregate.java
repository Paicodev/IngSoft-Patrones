package Iterator.Code;

public class ConcreteAggregate implements Aggregate {

    private String[] elements;

    public ConcreteAggregate(String[] elements) {
        this.elements = elements;
    }

    @Override
    public IteratorInterface createIterator() {
        return new ConcreteIterator(this);
    }

    public int size() {
        return elements.length;
    }

    public Object getElement(int index) {
        return elements[index];
    }
}