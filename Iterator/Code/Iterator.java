
package Iterator.Code;

public class Iterator {

    public static void main(String[] args) {

        String[] nombres = {"Ana", "Juan", "Pedro"};

        Aggregate aggregate = new ConcreteAggregate(nombres);

        IteratorInterface iterator = aggregate.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
