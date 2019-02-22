import java.io.Serializable;

/**
 * Created by rkadulk on 3/1/17.
 */
public class Example5 {

  public static void main(String[] args) {
    BoundedType<Integer> integerBox = new BoundedType<Integer>();
    integerBox.set(new Integer(10));

    // Since generic method inspect is written to only accept Number or its subtypes as type argument
//     integerBox.<Integer>inspect(new Integer(10)); // error: this is still String!

    // bounded type allows you to invoke methods defined in the upper bound
    System.out.println(new NaturalNumber<>(10).isEven());
    System.out.println(new NaturalNumber<>(5).isEven());
    System.out.println(new NaturalNumber<>(6).isEven());
    System.out.println(new NaturalNumber<>(3).isEven());
  }
}

class BoundedType<T> {

  private T t;

  public void set(T t) {
    this.t = t;
  }

  public T get() {
    return t;
  }

  public <U extends Number> void inspect(U u) {
    System.out.println("T: " + t.getClass().getName());
    System.out.println("U: " + u.getClass().getName());
  }
}

// Bounded type allows you to invoke methods that are defined within the bounds
class NaturalNumber<T extends Number> {

  private T n;

  public NaturalNumber(T n) {
    this.n = n;
  }

  public boolean isEven() {
    return n.intValue() % 2 == 0;
  }
}

