package PraktikalWork19;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Task1 {
    public static class InvalidInnException extends Exception {
        private static final long serialVersionUID = 1L;
        public InvalidInnException(String message) {
            super(message);
        }
    }
    public static void checkInn(String fullName, String inn,
                                Map<String, String> clients)
            throws InvalidInnException {
        String correctInn = clients.get(fullName);
        if (correctInn == null || !correctInn.equals(inn)) {
            throw new InvalidInnException(
                    "Недействительный ИНН для указанного клиента");
        }
    }
    public static void main(String[] args) {
        Map<String, String> clients = new HashMap<>();
        clients.put("Иванов Иван Иванович", "123456789047");
        clients.put("Петров Пётр Петрович", "123456789490");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        String fullName = scanner.nextLine().trim();
        System.out.print("Введите ИНН: ");
        String inn = scanner.nextLine().trim();
        try {
            checkInn(fullName, inn, clients);
            System.out.println("ИНН подтверждён. Заказ оформлен.");
        } catch (InvalidInnException e) {
            System.out.println(e.getMessage());
        }
    }
}