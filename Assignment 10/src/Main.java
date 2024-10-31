import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 8, 4, 2));

        // Bubble Sort
        SortAlgorithms.bubbleSort(numbers, Comparator.naturalOrder());
        System.out.println("Bubble Sorted: " + numbers);

        // Reinitialize list for merge sort
        numbers = new ArrayList<>(Arrays.asList(5, 3, 8, 4, 2));

        // Merge Sort
        SortAlgorithms.mergeSort(numbers, Comparator.naturalOrder());
        System.out.println("Merge Sorted: " + numbers);
    }
}
