import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Tests of Sorter objects.
 *
 * @author Rommin Adl
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void testWithDuplicateElements() {
      Integer[] original = {4, 2, 3, 2, 1};
      Integer[] expected = {1, 2, 2, 3, 4};
      sorter.sort(original, Comparator.naturalOrder());
      assertArrayEquals(expected, original, "Testing with duplicate elements.");
  }

  @Test
  public void testWithSingleElement() {
      Integer[] original = {42};
      Integer[] expected = {42};
      sorter.sort(original, Comparator.naturalOrder());
      assertArrayEquals(expected, original, "Testing with a single element.");
  }

  @Test
  public void testWithEmptyArray() {
      Integer[] original = {};
      Integer[] expected = {};
      sorter.sort(original, Comparator.naturalOrder());
      assertArrayEquals(expected, original, "Testing with an empty array.");
  }

  @Test
  public void testWithNegativeNumbers() {
      Integer[] original = {-3, -1, -4, -2};
      Integer[] expected = {-4, -3, -2, -1};
      sorter.sort(original, Comparator.naturalOrder());
      assertArrayEquals(expected, original, "Testing with negative numbers.");
  }

  @Test
  public void testWithRandomlyOrderedElements() {
      Integer[] original = {5, 3, 8, 1, 2};
      Integer[] expected = {1, 2, 3, 5, 8};
      sorter.sort(original, Comparator.naturalOrder());
      assertArrayEquals(expected, original, "Testing with randomly ordered elements.");
  }
} // class SortTester


