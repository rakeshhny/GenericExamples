import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rkadulk on 3/2/17.
 */
public class Example7 {

  public static void main(String[] args) {
    // The inference determines that the second argument being passed to the pick method is of type Serializable:
    Object serializable = pick("d", new ArrayList<String>());

//    List<String> list = pick("d", new ArrayList<String>());

    // Type inference and generic methods - example by BoxDemo and DemoBox
    List<DemoBox<Number>> numberBoxes = new ArrayList<>();
    List<DemoBox<Integer>> integerBoxes = new ArrayList<>();
    List<DemoBox<Float>> floatBoxes = new ArrayList<>();

    BoxDemo.<Number>addBox(new Integer(10), numberBoxes);
    BoxDemo.addBox(new Integer(20), numberBoxes);
    BoxDemo.addBox(new Integer(30), numberBoxes);
    outputBoxes(numberBoxes);

//    BoxDemo.<Number>addBox(new Integer(10),integerBoxes);
  }

  public static <T> T pick(T a1, T a2) {
    return a2;
  }

  public static <U> void outputBoxes(List<DemoBox<U>> boxes) {
    int counter = 0;
    for (DemoBox<U> box : boxes) {
      U boxContents = box.getItem();
      System.out.println("Box #" + counter + " contains [" +
          boxContents.toString() + "]");
      counter++;
    }
  }

}


class DemoBox<T> {

  private T item;

  public void setItem(T item) {
    this.item = item;
  }

  public T getItem() {
    return item;
  }
}

class BoxDemo {

  public static <U> void addBox(U u, List<DemoBox<U>> boxes) {
    DemoBox<U> box = new DemoBox<>();
    box.setItem(u);
    boxes.add(box);
  }
}