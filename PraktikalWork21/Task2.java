package PraktikalWork21;
import java.util.Arrays;
public class Task2<T> {
    private final T[] array;
    public Task2(T[] array) {
        this.array = array;
    }
    public T[] getArray() {
        return array;
    }
    public static void main(String[] args) {
        Task2<Integer> integers =
                new Task2<>(new Integer[] {1, 2, 3});
        Task2<Long> longs =
                new Task2<>(new Long[] {10L, 20L, 30L});
        Task2<Double> doubles =
                new Task2<>(new Double[] {1.5, 2.5, 3.5});
        Task2<String> words =
                new Task2<>(new String[] {"Java", "Generics"});
        System.out.println(Arrays.toString(integers.getArray()));
        System.out.println(Arrays.toString(longs.getArray()));
        System.out.println(Arrays.toString(doubles.getArray()));
        System.out.println(Arrays.toString(words.getArray()));
    }
}