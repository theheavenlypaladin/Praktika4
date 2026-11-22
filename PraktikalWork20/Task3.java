package PraktikalWork20;
import java.io.Serializable;
public class Task3<
        T extends Comparable<T>,
        V extends Task3.Animal & Serializable,
        K> {
    private final T first;
    private final V second;
    private final K third;
    public static class Animal {
        @Override
        public String toString() {
            return "Animal";
        }
    }
    public static class Cat extends Animal implements Serializable {
        private static final long serialVersionUID = 1L;
        @Override
        public String toString() {
            return "Cat";
        }
    }
    public Task3(T first, V second, K third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    public T getFirst() {
        return first;
    }
    public V getSecond() {
        return second;
    }
    public K getThird() {
        return third;
    }
    public void printClassNames() {
        System.out.println(first.getClass().getName());
        System.out.println(second.getClass().getName());
        System.out.println(third.getClass().getName());
    }
    public static void main(String[] args) {
        Task3<String, Cat, Integer> object =
                new Task3<>("Java", new Cat(), 20);
        System.out.println(object.getFirst());
        System.out.println(object.getSecond());
        System.out.println(object.getThird());
        object.printClassNames();
    }
}