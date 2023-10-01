public class Student {
    int rollno; // To store roll number of student
    String name;
    String address;

    // Constructor that initializes new student
    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Method essentially setting up format for printing sorted results
    @Override   // Overides method in object class
    public String toString() {
        return "Student  [rollno = " + rollno + ", name = " + name + ", address = " + address + "]";
    }
}