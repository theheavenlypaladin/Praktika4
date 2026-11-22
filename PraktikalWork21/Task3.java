package PraktikalWork21;
public class Task3<T> {
    private final T[] array;
    public Task3(T[] array) {
        this.array = array;
    }
    public T get(int index) {
        return array[index];
    }
    public static void main(String[] args) {
        Task3<String> words = new Task3<>(
                new String[] {"Java", "Python", "C++"});
        Task3<Integer> numbers = new Task3<>(
                new Integer[] {10, 20, 30});
        System.out.println(words.get(1));
        System.out.println(numbers.get(2));
    }
}