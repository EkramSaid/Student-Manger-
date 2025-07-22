import java.util.*;
import java.util.ArrayList;


public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 14 -> {
                    System.out.println("Goodbye 👋");
                    exit = true;
                }
                default -> System.out.println("Invalid option. Try again!");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n📘 Student Manager Menu:");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("14. Exit");
        System.out.print("Choose an option: ");
    }

    public static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // Clear newline

        Student student = new Student(name, id, grade);
        students.add(student);
        System.out.println("✅ Student added successfully!");
    }

    public static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students yet.");
        } else {
            System.out.println("\n👨‍🎓 All Students:");
            for (Student s : students) {
                s.displayInfo();
            }
        }
    }
}