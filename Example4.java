/**
 * Created by rkadulk on 3/1/17.
 */
public class Example4 {

  public static void main(String[] args) {
    KeyValuePair<Integer, String> p1 = new KeyValuePair<>(1, "apple");
    KeyValuePair<Integer, String> p2 = new KeyValuePair<>(2, "pear");

    // Note that the type has been explicitly provided
    boolean same = Util.<Integer, String>compare(p1, p2);
    System.out.println("Pairs are same = " + (same ? "YES" : "NO"));

    // Note that the type has been explicitly provided
    same = Util.<Integer, String>compare(p1, p1);
    System.out.println("Pairs are same = " + (same ? "YES" : "NO"));

    // Generally, explicit types can be left out since compiler can infer types.
    same = Util.compare(p1, p1);

    // Open Questions
//    KeyValuePair<String, String> p3 = new KeyValuePair<>("1", "apple");
//    KeyValuePair<Integer, String> p4 = new KeyValuePair<>(2, "pear");

//    same = Util.compare(p3,p4);

  }
}

class Util {

  // This is a generic method

  public static <K, V> boolean compare(KeyValuePair<K, V> p1, KeyValuePair<K, V> p2) {
    return p1.getKey().equals(p2.getKey()) &&
        p1.getValue().equals(p2.getValue());
  }
}


class KeyValuePair<K, V> {

  private K key;
  private V value;

  public KeyValuePair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}