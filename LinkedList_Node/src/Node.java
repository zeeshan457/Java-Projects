
/**
 *
 * @author zeeshan
 */
public class Node {

    Node next = null;
    Object data;

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object value) {
        data = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextNode) {
        next = nextNode;
    }

}
