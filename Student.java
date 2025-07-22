public class Student {
    String name;
    int id;
    double grade;

    // Constructor
    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    // Setters
    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Display student info
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id + ", Grade: " + grade);
    }
}