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
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> deleteStudent();
                case 5 -> searchByID();
                case 6 -> searchByName();
                case 7 -> calculateAverageGrade();
                case 8 -> showHighestGrade();
                case 9 -> showLowestGrade();
                case 10 -> countStudents();
                case 11 -> sortByGrade();
                case 12 -> sortByName();
                case 13 -> clearAllStudents();
                case 14 -> {
                    System.out.println("Goodbye");
                    exit = true;
                }
                default -> System.out.println("Invalid option. Try again!");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n Student Manager Menu:");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("5. Search Student by ID");
        System.out.println("6. Search Student by Name");
        System.out.println("7. Calculate Average Grade");
        System.out.println("8. Show Highest Grade");
        System.out.println("9. Show Lowest Grade");
        System.out.println("10. Count Total Students");
        System.out.println("11. Sort Students by Grade");
        System.out.println("12. Sort Students by Name");
        System.out.println("13. Clear All Students");
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
        scanner.nextLine();

        Student student = new Student(name, id, grade);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students yet.");
        } else {
            System.out.println("\n All Students:");
            for (Student s : students) {
                s.displayInfo();
            }
        }
    }
    public static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed = students.removeIf(s -> s.id == id);
        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void searchByID() {
        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Student s : students) {
            if (s.id == id) {
                s.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void searchByName() {
        System.out.print("Enter student name to search: ");
        String name = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Student s : students) {
            if (s.name.toLowerCase().contains(name)) {
                s.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with that name.");
        }
    }

    public static void calculateAverageGrade() {
        if (students.isEmpty()) {
            System.out.println("No students to calculate.");
            return;
        }

        double total = 0;
        for (Student s : students) {
            total += s.grade;
        }
        double average = total / students.size();
        System.out.printf("Average Grade: %.2f\n", average);
    }

    public static void showHighestGrade() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student top = Collections.max(students, Comparator.comparingDouble(s -> s.grade));
        System.out.println("Highest Grade Student:");
        top.displayInfo();
    }

    public static void showLowestGrade() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student lowest = Collections.min(students, Comparator.comparingDouble(s -> s.grade));
        System.out.println("Lowest Grade Student:");
        lowest.displayInfo();
    }

    public static void countStudents() {
        System.out.println("Total number of students: " + students.size());
    }

    public static void sortByGrade() {
        students.sort(Comparator.comparingDouble(s -> s.grade));
        System.out.println("Students sorted by grade.");
        viewAllStudents();
    }

    public static void sortByName() {
        students.sort(Comparator.comparing(s -> s.name.toLowerCase()));
        System.out.println("Students sorted by name.");
        viewAllStudents();
    }

    public static void clearAllStudents() {
        students.clear();
        System.out.println("All students have been removed.");
    }
}

