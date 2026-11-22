package PraktikalWork19;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
public class Task2 {
    public interface StudentInfo {
        String getFullName();
        double getAverageScore();
    }
    public static class Student implements StudentInfo {
        private final String fullName;
        private final double averageScore;
        public Student(String fullName, double averageScore) {
            this.fullName = fullName;
            this.averageScore = averageScore;
        }
        @Override
        public String getFullName() {
            return fullName;
        }
        @Override
        public double getAverageScore() {
            return averageScore;
        }
        @Override
        public String toString() {
            return fullName + ", средний балл: " + averageScore;
        }
    }
    public static class StudentNotFoundException extends Exception {
        private static final long serialVersionUID = 1L;
        public StudentNotFoundException(String message) {
            super(message);
        }
    }
    public static class EmptyStringException extends Exception {
        private static final long serialVersionUID = 1L;
        public EmptyStringException(String message) {
            super(message);
        }
    }
    public static class SortingStudentsByGPA
            implements Comparator<StudentInfo> {
        @Override
        public int compare(StudentInfo first, StudentInfo second) {
            return Double.compare(
                    second.getAverageScore(),
                    first.getAverageScore());
        }
    }
    public static class LabClass {
        private final StudentInfo[] students;
        public LabClass(StudentInfo[] students) {
            this.students = students;
        }
        public StudentInfo[] getStudents() {
            return students;
        }
        public void sortByAverageScore() {
            Arrays.sort(students, new SortingStudentsByGPA());
        }
        public StudentInfo findStudent(String fullName)
                throws EmptyStringException, StudentNotFoundException {
            String name = fullName.trim();
            if (name.isEmpty()) {
                throw new EmptyStringException(
                        "Введите ФИО студента");
            }
            for (StudentInfo student : students) {
                if (student.getFullName().equalsIgnoreCase(name)) {
                    return student;
                }
            }
            throw new StudentNotFoundException(
                    "Студент не найден: " + name);
        }
    }
    public static class LabClassUI extends JFrame {
        private static final long serialVersionUID = 1L;
        private final LabClass labClass;
        private final JTextArea output = new JTextArea();
        private final JTextField nameField = new JTextField(24);
        public LabClassUI(LabClass labClass) {
            super("Поиск и сортировка студентов");
            this.labClass = labClass;
            JPanel searchPanel = new JPanel(new FlowLayout());
            searchPanel.add(new JLabel("ФИО:"));
            searchPanel.add(nameField);
            JButton findButton = new JButton("Найти");
            searchPanel.add(findButton);
            JButton sortButton = new JButton(
                    "Сортировать по среднему баллу");
            output.setEditable(false);
            add(searchPanel, BorderLayout.NORTH);
            add(new JScrollPane(output), BorderLayout.CENTER);
            add(sortButton, BorderLayout.SOUTH);
            findButton.addActionListener(e -> findStudent());
            sortButton.addActionListener(e -> {
                labClass.sortByAverageScore();
                showStudents();
            });
            showStudents();
            setSize(680, 340);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        private void showStudents() {
            output.setText("");
            for (StudentInfo student : labClass.getStudents()) {
                output.append(student.toString() + "\n");
            }
        }
        private void findStudent() {
            try {
                StudentInfo student =
                        labClass.findStudent(nameField.getText());
                JOptionPane.showMessageDialog(
                        this,
                        student.toString(),
                        "Результат поиска",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (EmptyStringException | StudentNotFoundException e) {
                JOptionPane.showMessageDialog(
                        this,
                        e.getMessage(),
                        "Ошибка поиска",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static class LabClassDriver {
        public void start() {
            StudentInfo[] students = {
                    new Student("Иванов Иван Иванович", 4.3),
                    new Student("Петров Пётр Петрович", 3.8),
                    new Student("Сидорова Анна Сергеевна", 4.9),
                    new Student("Смирнов Алексей Андреевич", 4.5)
            };
            LabClass labClass = new LabClass(students);
            LabClassUI window = new LabClassUI(labClass);
            window.setVisible(true);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> new LabClassDriver().start());
    }
}