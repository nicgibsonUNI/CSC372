import java.util.Comparator;

// Class that provides way to compare two student objects using names
public class NameComparator implements Comparator<Student> {
    
    // Method to compare two students using name
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);  // Returns negative # if s1 name comes before s2
    }                                        // Returns 0 if s1 name and s2 name are equal in ordering
}                                            // Returns positive number if s1 name comes after s2.

