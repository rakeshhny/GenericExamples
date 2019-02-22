public class Example9 {
    public static void main(String[] args) {

    }
}

//    Consider the following generic class that represents a node in a singly linked list:

class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() { return data; }
    // ...
}

//    Because the type parameter T is unbounded, the Java compiler replaces it with Object:
/*
class Node {

    private Object data;
    private Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() { return data; }
    // ...
}
*/

// In the following example, the generic Node class uses a bounded type parameter:

class Node2<T extends Comparable<T>> {

    private T data;
    private Node2<T> next;

    public Node2(T data, Node2<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() { return data; }
    // ...
}

//    The Java compiler replaces the bounded type parameter T with the first bound class, Comparable:

/*
class Node2 {

    private Comparable data;
    private Node2 next;

    public Node2(Comparable data, Node2 next) {
        this.data = data;
        this.next = next;
    }

    public Comparable getData() { return data; }
    // ...
}
*/