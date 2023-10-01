import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort {

    // Method sorts list based on given comparator
    public static<T> void sort(ArrayList<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) { // Traverse through whole array
            int indexSmallest = i;  // Sets smallest element as first element of unsorted

            //
            for (int j = i +1; j < list.size(); j++) { 
                // Using comparator to check if it's a smaller element than current smallest
                if (comparator.compare(list.get(j), list.get(indexSmallest)) < 0) {
                    indexSmallest = j;  // If it is smaller, update smallest index
                }
            }
            
            // Swaps current element with smallest one found
            T temp = list.get(indexSmallest);   // Temporary variable to store smallest element
            list.set(indexSmallest, list.get(i));
            list.set(i, temp);
        }
    }
    
}
