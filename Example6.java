/**
 * Created by rkadulk on 3/2/17.
 */
public class Example6 {

  public static void main(String[] args) {

    // This is allowed
    Object someObject = new Object();
    Integer someInteger = new Integer(10);
    someObject = someInteger;   // OK

    // Both of the below calls are valid
    someMethod(new Integer(10));
    someMethod(new Float(10));
    someMethod(new Double(10));

    // the same is true with Generics
    // Lets do a generic type invocation by passing Number
    GenericBox<Number> numberGenericBox = new GenericBox<>();
    numberGenericBox.setItem(new Integer(10));
    numberGenericBox.setItem(new Float(10));
    numberGenericBox.setItem(new Double(10));

    // Let's try and call the method which accepts a GenericBox with Type Number
    someOtherMethod(new GenericBox<Number>());

    // Question - someOtherMethod accepts GenericBox<Number>,
    // so are you allowed to call someOtherMethod with GenericBox<Integer> or GenericBox<Float>

    // Lets take an example of ArrayList / List / Collection

  }




  // Integer is a Number - OK
  // GenericBox<Number> is a GenericBox<Number> is not a GenericBox<Integer>
  // ArrayList<E> implements List<E>
  // ArrayList<String> implements List<String> it does not implement List<Object >
  // ArrayList<Object> implements List<Object>



  public static void someMethod(Number n) {
    // do something
  }

  public static void someOtherMethod(GenericBox<Number> numberGenericBox) {
    // do something
  }
}

class GenericBox<T extends Number> {
  private T item;

  public void setItem(T item) {
    this.item = item;
  }
}
