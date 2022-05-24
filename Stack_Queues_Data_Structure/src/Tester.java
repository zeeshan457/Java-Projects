
/**
 *
 * @author zeeshan
 */
public class Tester {

    public static void main(String[] args) {
        
        // creating LinkedList Objects
        LinkedList numbers = new LinkedList();
        LinkedList colors = new LinkedList();
        LinkedList names = new LinkedList();

        // Add Data into a specfic position in the List
        numbers.add(500, 0);
        numbers.add(1000, 1);
        numbers.add(2500, 2);

        colors.add("red", 0);
        colors.add("green", 1);
        colors.add("blue", 2);

        names.add("Ben", 0);
        names.add("Paul", 1);
        names.add("Brad", 2);

        // Testing to get the Element from the List
        System.out.println(numbers.get(0) + " " + colors.get(0) + " "
                + names.get(0));

        // Testing to delete the index from the List
        numbers.remove(0);
        colors.remove(0);
        names.remove(0);

        System.out.println(numbers.get(0) + " " + colors.get(0) + " "
                + names.get(0));

        // Testing to pritn the size of the Lists
        System.out.println(numbers.size());
        System.out.println(colors.size());
        System.out.println(names.size());

    }

}
