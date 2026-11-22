package PraktikalWork18;
import java.util.Scanner;
public class Task4 {
    public void exceptionDemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = scanner.nextLine();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("The entered value is not an integer");
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        } finally {
            System.out.println("The finally block has been executed");
        }
    }
    public static void main(String[] args) {
        new Task4().exceptionDemo();
    }
}