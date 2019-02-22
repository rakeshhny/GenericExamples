import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rkadulk on 3/2/17.
 */
public class Example8 {

  public static void main(String[] args) {

    // Let us write a method that works on List<Integer>, List<Double>, List<Number>
    List<Integer> intergs = Arrays.asList(new Integer(10), new Integer(20));
//    operateOnList(intergs);

    // Alternate solution is to create a generic method
    operateOnListGenericMethod(intergs);

    //Let's have a non-generic solution to this
    operateOnListWithWildcards(intergs);


    // QUESTION - WHICH ONE FROM BELOW IS MORE RESTRICTIVE

    // Unbounded wildcards

    // Lets take a look at the printList method
    List<Object> objects = Arrays.asList("a","b");
    List<Integer> integers = Arrays.asList(new Integer(10), new Integer(20));

//    printList(objects);
//    printList(integers);

    // Solution is to use an unbounded wildcard

//    printListWithUnboundedWildcard(objects);
//    printListWithUnboundedWildcard(integers);

    // Lower Bounded Wildcards - Not so important one
    // I would like to add Integers into a list
    // One way is to use addToList
    // To add more flexibility - addToListLowerBounded
  }

  public static void addToList(List<Integer> integers) {

  }

  public static void addToListLowerBounded(List<? super Integer> integers) {

  }

  // The goal of this method is to print the list of any type but it fails.
  public static void printList(List<Object> list) {
    for (Object elem : list)
      System.out.println(elem + " ");
    System.out.println();
  }

  public static void printListWithUnboundedWildcard(List<?> list) {
    for (Object elem : list)
      System.out.println(elem + " ");
    System.out.println();
  }

  public static void operateOnList(List<Number> numbers) {
    numbers.forEach(System.out::println);
  }

  static <T extends Number> void operateOnListGenericMethod(List<T> numbers) {
    numbers.forEach(System.out::println);
  }

  static void operateOnListWithWildcards(List<? extends Number> numbers) {
    numbers.forEach(System.out::println);

    // I can call the methods defined in the bounds
    numbers.forEach(n -> System.out.println(n.doubleValue()));
  }

  static void clear(List<?> list) {
    list.clear();
  }

}