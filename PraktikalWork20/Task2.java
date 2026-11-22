package PraktikalWork20;
public class Task2<T, V, K> {
    private final T first;
    private final V second;
    private final K third;
    public Task2(T first, V second, K third) {
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
        Task2<String, Integer, Double> object =
                new Task2<>("Java", 18, 4.5);
        System.out.println(object.getFirst());
        System.out.println(object.getSecond());
        System.out.println(object.getThird());
        object.printClassNames();
    }
}