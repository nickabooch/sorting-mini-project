import java.util.Comparator;

/**
 * Tests of MergeSort.
 */
public class MergeSortTester extends SortTester {

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Initialize the sorter to use MergeSort for testing.
     */
    public MergeSortTester() {
        super();
        this.sorter = MergeSort.SORTER;
    } // MergeSortTester()

    // +-----------+---------------------------------------------------
    // | Test Case |
    // +-----------+

    /**
     * Test MergeSort with an unsorted array of integers.
     */
    @Test
    public void testMergeSortIntegers() {
        Integer[] original = {5, 1, 4, 2, 8};
        Integer[] expected = {1, 2, 4, 5, 8};
        sorter.sort(original, Comparator.naturalOrder());
        assertArrayEquals(expected, original, "MergeSort should sort an array of integers.");
    } // testMergeSortIntegers()

} // class MergeSortTester
