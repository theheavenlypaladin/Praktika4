package PraktikalWork21;
import java.util.ArrayList;
import java.util.List;
public class Task1 {
    public static <T> List<T> arrayToList(T[] array) {
        List<T> result = new ArrayList<>();
        for (T element : array) {
            result.add(element);
        }
        return result;
    }
    public static void main(String[] args) {
        String[] words = {"Java", "Python", "C++"};
        Integer[] numbers = {10, 20, 30};
        System.out.println(arrayToList(words));
        System.out.println(arrayToList(numbers));
    }
}