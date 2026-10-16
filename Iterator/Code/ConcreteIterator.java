package Iterator.Code;

public class ConcreteIterator implements IteratorInterface {

    private ConcreteAggregate aggregate;
    private int position;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < aggregate.size();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            return null;
        }

        return aggregate.getElement(position++);
    }
}