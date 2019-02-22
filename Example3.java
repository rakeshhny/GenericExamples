import java.util.Arrays;
import java.util.List;

/**
 * Created by rkadulk on 3/1/17.
 */
public class Example3 {

  public static void main(String[] args) {

    // The following statements create two instantiations of the OrderedPair class:

    // Instantiates K as a String and V as an Integer.
    // Therefore, the parameter types of OrderedPair's constructor are String and Integer
    Pair<String, Integer> p1 = new OrderedPair<>("Even", new Integer(10));

    // Instantiates K as a String and V as String
    // Therefore, the parameter types of OrderedPair's constructor are String and String
    Pair<String, String> p2 = new OrderedPair<String, String>("hello", "world");

    // using the diamond
    Pair<String, Integer> p1_using_diamond = new OrderedPair<>("Even", 8);
    Pair<String, String> p2_using_diamond = new OrderedPair<>("hello", "world");

    // Substituing type paramter with a paramterized type
    Pair<String, List<String>> stringListPair = new OrderedPair<>("weekdays",
        Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Friday", "Saturday"));
  }
}

interface Pair<K, V> {

  public K getKey();

  public V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {

  private K key;
  private V value;

  public OrderedPair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}


