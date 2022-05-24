
/**
 *
 * @author zeeshan
 */
public class LinkedList {

    private Node head;
    private int listSize;

    public LinkedList() {
        head = new Node(null);
        listSize = 0;
    }

    public void add(Object data, int index) {

        Node StartNode = new Node(data);

        // if index < 0, throws this Error
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        // if index is 0, Add here.
        if (index == 0) {
            StartNode.next = head;
            head = StartNode;

            // Else, add at a specfic index, whatever was passed.  
        } else {
            Node indexNode = new Node(data);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;

            }
            indexNode.next = current.next;
            current.next = indexNode;
        }
    }

    public Object get(int index) {

        // if index < 0, throws this Error
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // Returns the current object based on the position in the List
        return (Object) current.data;
    }

    public boolean remove(int index) {

        // if index < 0, throws this Error
        if (index < 0) {
            throw new IndexOutOfBoundsException();

        }

        if (index == 0) {
            head = head.next;

        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        return true;
    }

    public int size() {

        // Iterating the Node, start at head, != null && iterate next
        for (Node n = head; n.next != null; n = n.next) {
            listSize++;

        }
        return listSize;
    }

}
