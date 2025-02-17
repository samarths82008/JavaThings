import java.util.*;

public class Merge {

    public static void main(String[] args) {
        // Declare two arrays to store input values
        List<Integer> firstArray = new ArrayList<>();
        List<Integer> secondArray = new ArrayList<>();
        
        // Get the first array
        System.out.println("Enter the values for the first array, up to 10 values, enter a negative number to quit");
        if (!getArrayInput(firstArray)) {
            System.out.println("ERROR: Array not in correct order");
            return;
        }

        // Get the second array
        System.out.println("Enter the values for the second array, up to 10 values. (Enter a negative number to quit.)");
        if (!getArrayInput(secondArray)) {
            System.out.println("ERROR: Array not in correct order");
            return;
        }

        // Merge the two arrays
        List<Integer> mergedArray = mergeArrays(firstArray, secondArray);

        // Print the arrays
        printArray("First Array", firstArray);
        printArray("Second Array", secondArray);
        printArray("Merged Array", mergedArray);
    }

    // Method to read and validate input array
    private static boolean getArrayInput(List<Integer> array) {
        Scanner scanner = new Scanner(System.in);
        int previousValue = Integer.MIN_VALUE; // Track the previous value to check order
        int count = 0; // Count the number of elements entered
        
        while (count < 10) {
            int value = scanner.nextInt();
            
            if (value < 0) { // Stop if a negative number is entered
                break;
            }
            
            if (value < previousValue) {
                return false; // If the order is violated, return false
            }
            
            array.add(value);
            previousValue = value;
            count++;
        }
        
        return true;
    }

    // Method to merge two sorted arrays
    private static List<Integer> mergeArrays(List<Integer> firstArray, List<Integer> secondArray) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge the two arrays
        while (i < firstArray.size() && j < secondArray.size()) {
            if (firstArray.get(i) <= secondArray.get(j)) {
                merged.add(firstArray.get(i));
                i++;
            } else {
                merged.add(secondArray.get(j));
                j++;
            }
        }

        // Add any remaining elements from the first array
        while (i < firstArray.size()) {
            merged.add(firstArray.get(i));
            i++;
        }

        // Add any remaining elements from the second array
        while (j < secondArray.size()) {
            merged.add(secondArray.get(j));
            j++;
        }

        return merged;
    }

    // Method to print an array
    private static void printArray(String arrayName, List<Integer> array) {
        System.out.print(arrayName + ": ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
