import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Rommin Adl
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

    /**
     * Sort an array in place using the insertion sort algorithm.
     *
     * @param values The array to sort.
     * @param order  The comparator to determine the order of the sort.
     * @pre  `order` can be applied to any two values in `values`.
     * @post `values` is sorted according to `order`.
     */
    @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        for (int i = 1; i < values.length; i++) {
            T key = values[i];
            int j = i - 1;

            // Move elements of values[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && order.compare(values[j], key) > 0) {
                values[j + 1] = values[j];
                j = j - 1;
            }
            values[j + 1] = key;
        }
    } // sort(T[], Comparator<? super T>)
} // class InsertionSort