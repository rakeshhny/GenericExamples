import java.util.List;
import javax.print.DocFlavor.STRING;
import sun.net.www.content.text.Generic;

/**
 * Created by rkadulk on 3/1/17.
 */
public class Example2 {

  public static void main(String[] args) {
    NonGenerciBox box = new NonGenerciBox();

    // There is no way at compile time to know how a class is used.
    // Some part of the code places an Integer and tries to cast it to String and result in runtime error
    box.setItem(new String("Hello"));
    Object obj = box.getItem();


    GenericBoxClass<String> stringGenericBoxClass = new GenericBoxClass<String>();
    stringGenericBoxClass.setItem("10");
    String str = stringGenericBoxClass.getItem();


    // The diamond - Java SE7 or Later
    // <> is informally called the diamond operator
    GenericBoxClass<Integer> integerGenericBoxClass = new GenericBoxClass<>();
  }
}

class NonGenerciBox {

  private Object item;

  public void setItem(Object item) {
    this.item = item;
  }

  public Object getItem() {
    return item;
  }
}

// This type variable T can be used throughout this class.
// A type variable can be any type - class / interface / array / even another type variable
class GenericBoxClass<T> {

  private T item;

  public void setItem(T item) {
    this.item = item;
  }

  public T getItem() {
    return item;
  }
}
