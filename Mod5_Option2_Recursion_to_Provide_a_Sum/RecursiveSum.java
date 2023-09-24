import java.util.Scanner;

public class RecursiveSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // Reads user input
        int[] numbers = new int[5]; // Array to store numbers that user enters

        // Reads 5 numbers entered by the user
        System.out.println("Please enter five numbers: ");
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Calculates sum using recursive method
        int sum = recursiveSum(numbers, 0);

        // Prints sum
        System.out.println("The sum of the numbers you entered is: " + sum);
    }

    // Recursive method calculates sum of array
    public static int recursiveSum(int[] numbers, int index) {
        if (index == numbers.length) {  // Base Case
            return 0;   
        }

        // Recursive case 
        return numbers[index] + recursiveSum(numbers, index + 1);
    }
}