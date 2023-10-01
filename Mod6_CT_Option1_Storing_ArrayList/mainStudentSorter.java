import java.util.ArrayList;

public class mainStudentSorter {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // Adding sample students to list
        students.add(new Student(12, "Mario", "1 Koopa St"));
        students.add(new Student(4, "Luigi", "2 Mushroom Ln" ));
        students.add(new Student(9, "Bowser", "3 Castle Ave"));

        // Sorting using name with NameComparator
        System.out.println("Sorting by Name: ");
        SelectionSort.sort(students, new NameComparator());
        for (Student s : students) {
            System.out.println(s);
        }

        // Sorting using roll number with RollNumberComparator
        System.out.println("\nSorting by Roll Number: ");
        SelectionSort.sort(students, new RollNumberComparator());
        for (Student s : students) {
            System.out.println(s);
        }
    } 
}
