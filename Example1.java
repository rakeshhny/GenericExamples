import com.apple.laf.AquaImageFactory.NineSliceMetrics;
import java.util.ArrayList;
import java.util.List;
import javax.print.DocFlavor.STRING;

/**
 * Created by rkadulk on 2/28/17.
 */
public class Example1 {

  public static void main(String[] args) {

    // 1 - Some problems are easier to detect, the compile time problems.
    // Programs are much stable since the bugs are detected at compile time

    List<String> strings = new ArrayList<>();
//    strings.add(new Integer(10));
//    String d = strings.get(0);

    // 2 – Generics enables types (Classes / Interfaces ) to be parameters when defining classes, interfaces and methods.
    // Much more like the formal parameters used in the method declaration,
    // the input to formal parameters are values where as input to type parameters are types

    GenericClassExample1<String> stringGenericClassExample1 = new GenericClassExample1<>();
    stringGenericClassExample1.setItem("");

    GenericClassExample1<Integer> integerGenericClassExample1 = new GenericClassExample1<>();
    integerGenericClassExample1.setItem(new Integer(10));

    GenericClassExample1.<Double>firstGenericMethod(new Double(10));
    GenericClassExample1.<Integer>firstGenericMethod(new Integer(10));
    GenericClassExample1.<Float>firstGenericMethod(new Float(10));

    GenericInterfaceExample1.<Double>genericInterfaceMethod(new Double(10));
    GenericInterfaceExample1.<Integer>genericInterfaceMethod(new Integer(10));
    GenericInterfaceExample1.<Float>genericInterfaceMethod(new Float(10));

    // 3 - Elimination of casts
    List objectList = new ArrayList();
    objectList.add(new String("item1"));
    objectList.add(new Integer(10));
    String str = (String) objectList.get(0);
    Integer i = (Integer) objectList.get(1);

    List<String> stringList = new ArrayList<>();
    stringList.add("Hello");
    String ret = stringList.get(0);

    // 4 - It enables programmers to create generic algorithms that can work on a collection of different tyoes.

  }
}


class GenericClassExample1<T> {

  T item;

  public T getItem() {
    return item;
  }

  public void setItem(T item) {
    this.item = item;
  }

  public static <V> void firstGenericMethod(V data) {
    System.out.println(data.getClass());
  }
}


interface GenericInterfaceExample1<T> {

  public static <V> void genericInterfaceMethod(V data) {
    System.out.println(data.getClass());
  }
}
