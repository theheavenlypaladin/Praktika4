package PraktikalWork20;
public class Task1<T, V, K> {
    public static void main(String[] args) {
        Task1<String, Integer, Double> object = new Task1<>();
        System.out.println(
                "Создан объект " + object.getClass().getSimpleName()
                        + " с параметрами типов String, Integer, Double");
    }
}