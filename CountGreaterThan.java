import java.util.Arrays;
import java.util.List;

/**
 * Created by rkadulk on 3/2/17.
 */
public class CountGreaterThan {

  public static void main(String[] args) {
    System.out.println(NumberCompare.countGreaterThan(Arrays.asList(new Integer(10), new Integer(20)), 20));
  }
}

class NumberCompare {

  public static <T extends Comparable<T>> int countGreaterThan(List<T> list, T elem) {
    int count = 0;

    for (T item : list) {
      if (item.compareTo(elem) > 0) {
        count++;
      }
    }
    return count;
  }
}
