package PraktikalWork18;
import java.util.Scanner;
public class Task3 {
    public void exceptionDemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = scanner.nextLine();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (Exception e) {
            System.out.println("Caught " + e.getClass().getSimpleName());
        }
    }
    public static void main(String[] args) {
        new Task3().exceptionDemo();
    }
}