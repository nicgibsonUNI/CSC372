import java.util.Comparator;

// Class to provide way to compare two student objects using roll numbers.
public class RollNumberComparator implements Comparator<Student> {

    // Method to compare two students using roll numbers.
    @Override   // Establishing concrete implementation of compare method
    public int compare(Student s1, Student s2) {
        return s1.rollno - s2.rollno;   // If result is negative, s1 goes before s2
    }                                   // If result is 0 then s1 and s2 are equal place
}                                       // If result is positive, s2 goes before s1
