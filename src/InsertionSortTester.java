
/**
 * Tests of InsertionSort.
 */
public class InsertionSortTester extends SortTester {

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public InsertionSortTester() {
      super();
      this.sorter = InsertionSort.SORTER;
  } // InsertionSortTester()

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * Test sorting of an array of integers in reverse order.
   */
  public void testSortReverseOrderIntegers() {
      Integer[] original = {5, 4, 3, 2, 1};
      Integer[] expected = {1, 2, 3, 4, 5};
      sorter.sort(original, Integer::compareTo);
      for (int i = 0; i < original.length; i++) {
          if (!original[i].equals(expected[i])) {
              System.out.println("testSortReverseOrderIntegers failed.");
              return;
          }
      }
      System.out.println("testSortReverseOrderIntegers passed.");
  }

  /**
   * Test sorting of an already sorted array of strings.
   */
  public void testSortAlreadySortedStrings() {
      String[] original = {"apple", "banana", "cherry", "date", "fig"};
      String[] expected = {"apple", "banana", "cherry", "date", "fig"};
      sorter.sort(original, String::compareTo);
      for (int i = 0; i < original.length; i++) {
          if (!original[i].equals(expected[i])) {
              System.out.println("testSortAlreadySortedStrings failed.");
              return;
          }
      }
      System.out.println("testSortAlreadySortedStrings passed.");
  }

}
