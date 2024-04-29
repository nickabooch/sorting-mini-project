import java.util.Comparator;

/**
 * Sort using merge sort algorithm.
 * This class implements the merge sort algorithm for sorting arrays.
 * Merge sort is a divide-and-conquer algorithm that divides the input array
 * into two halves, sorts the two halves, and then merges the sorted halves.
 *
 * @author Rommin Adl
 */
public class MergeSort implements Sorter {

    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The one sorter you can access.
     */
    public static Sorter SORTER = new MergeSort();

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a sorter.
     */
    MergeSort() {
        // Constructor for the merge sort.
    } // MergeSort()

    // +---------+-----------------------------------------------------
    // | Methods |
    // +---------+

    /**
     * Sort an array in place using the merge sort algorithm.
     *
     * @param values The array to sort.
     * @param order  The comparator to determine the order of the sort.
     * @pre  `order` can be applied to any two values in `values`.
     * @post `values` is sorted according to `order`.
     */
    @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        if (values.length < 2) {
            return; // The array is already sorted in this case
        }
        int mid = values.length / 2;
        T[] left = (T[]) new Object[mid];
        T[] right = (T[]) new Object[values.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = values[i];
        }
        for (int i = mid; i < values.length; i++) {
            right[i - mid] = values[i];
        }
        sort(left, order); // Sort the first half
        sort(right, order); // Sort the second half
        merge(values, left, right, order); // Merge the sorted halves
    }

    /**
     * Merge two sorted subarrays into a single sorted array.
     *
     * @param values The array to be sorted.
     * @param left   The left subarray.
     * @param right  The right subarray.
     * @param order  The comparator to determine the order of the sort.
     */
    private <T> void merge(T[] values, T[] left, T[] right, Comparator<? super T> order) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (order.compare(left[i], right[j]) <= 0) {
                values[k++] = left[i++];
            } else {
                values[k++] = right[j++];
            }
        }
        while (i < left.length) {
            values[k++] = left[i++];
        }
        while (j < right.length) {
            values[k++] = right[j++];
        }
    }
} // class MergeSort
