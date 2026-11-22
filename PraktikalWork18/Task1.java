package PraktikalWork18;
public class Task1 {
    public void exceptionDemo() {
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }
    public static void main(String[] args) {
        Task1 task = new Task1();
        if (args.length > 0 && args[0].equals("1")) {
            System.out.println(2 / 0);
        } else if (args.length > 0 && args[0].equals("2")) {
            System.out.println(2.0 / 0.0);
        } else {
            task.exceptionDemo();
        }
    }
}