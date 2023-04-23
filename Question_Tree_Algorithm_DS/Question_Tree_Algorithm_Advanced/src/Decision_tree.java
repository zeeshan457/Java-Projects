
import java.io.IOException;
import java.util.Scanner;

public class Decision_tree {

    // Attributes
    private DT_Node root = null;
    private static Scanner Input = new Scanner(System.in);


    // Create root method
    public void createRoot(int ID, String question) {

        // Creating root node here, passing 2 arguments.
        root = new DT_Node(ID, question);
        System.out.println("Successfully created root Node: " + ID);
    }


    public void addYesNode(int existingID, int ID, String question) {

        if (root == null) {
            System.out.println("ERROR: Root Node is empty!");
            System.exit(0);

        } else if (SearchNodeAddYesNode(root, existingID, ID, question)) {
            System.out.println("Added YES Node ID: " + ID +
                    " onto branch of Node ID: " + existingID);
        } else {
            System.out.println("Node Existing ID: " + existingID + " not found");

        }
    }

    public boolean SearchNodeAddYesNode(DT_Node currentNode,
                                        int existingID, int ID, String question) {

        if (currentNode.nodeID == existingID) {
            if (currentNode.yes != null) {

                System.out.println("SYSTEM: Overwriting the previous node " +
                        "ID: " + currentNode.yes.nodeID);
            } else {

            }
            currentNode.yes = new
                    DT_Node(ID, question);
            return true;
        } else {
            if (currentNode.yes != null) {
                if (SearchNodeAddYesNode(currentNode.yes,
                        existingID, ID, question)) {
                    return true;
                }
                if (currentNode.no != null) {
                    return (SearchNodeAddYesNode(currentNode.no,
                            existingID, ID, question));
                } else {
                    return false;
                }
            }
            return false;
        }
    }


    public void addNoNode(int existingID, int ID, String question) {
        if (root == null) {
            System.out.println("ERROR: No root node!");
            return;
        }
        if (SearchNodeAddNoNode(root, existingID, ID, question)) {
            System.out.println("SYSTEM: Added node " + ID +
                    " onto \"no\" branch of node ID: " + existingID);
        } else {
            System.out.println("SYSTEM: Node " + existingID + " was not found");
        }
    }

    public boolean SearchNodeAddNoNode(DT_Node currentNode,
                                       int existingID, int ID, String question) {
        if (currentNode.nodeID == existingID) {
            // Found node
            if (currentNode.no == null) {

            } else {
                System.out.println("SYSTEM: Overwriting the previous node " +
                        "ID = " + currentNode.no.nodeID);
            }
            currentNode.no = new DT_Node(ID, question);
            return true;

        } else {

            if (currentNode.yes != null) {
                if (SearchNodeAddNoNode(currentNode.yes,
                        existingID, ID, question)) {
                    return true;

                } else {

                    if (currentNode.no != null) {
                        return (SearchNodeAddNoNode(currentNode.no,
                                existingID, ID, question));
                    } else
                        return false;
                }
            } else
                return false;
        }
    }


    public void Query() throws IOException {
        Query_tree(root);
    }

    public void Query_tree(DT_Node currentNode) throws IOException {

        if (root.yes == null) {
            if (currentNode.no == null) {

                System.out.println(currentNode.Question);

            } else {
                System.out.println("Error: Missing \"Yes\" branch at \"" +
                        currentNode.Question + " ID: " + currentNode.nodeID);
            }

        } else if (currentNode.Question == null) {
            System.out.println("Error: You didn't type a response");
        }

        if (currentNode.Question.contains("we will say Goodbye for now")) {
            System.out.println("SYSTEM: Since you don't have Diabetes, Goodbye!");
            System.exit(0);

        } else if (currentNode.Question.contains("Okay, the problem may be an unbalanced Diet")) {
            System.out.println("Okay, the problem may be an unbalanced Diet, try to balance your diet! "
                    + "\n" + "https://www.nhs.uk/live-well/eat-well/" + "\n" + "Goodbye!");
            System.exit(0);

        } else if (currentNode.Question.contains("Cut less on sugary foods")) {
            System.out.println("Cut less on sugary foods, and have a balanced diet, " +
                    "this will dramatically prevent diabetes!" + "\n" +
                    "https://www.nhs.uk/live-well/eat-well/how-to-cut-down-on-sugar-in-your-diet/" + "\n" + "Goodbye!");
            System.exit(0);

        } else if (currentNode.Question.contains("try to Exercise more")) {
            System.out.println("try to Exercise more and have a balanced diet, " +
                    "this will dramatically prevent diabetes!" + "\n"
                    + "https://www.nhs.uk/live-well/exercise/" + "\n" + "Goodbye!");
            System.exit(0);

        }


        // Method call here
        askQuestion(currentNode);
    }

    public void askQuestion(DT_Node currentNode) throws IOException {

        System.out.println(currentNode.Question + " (type \"Yes\" or \"No\")");

        String response = Input.nextLine().toLowerCase();

        if (response.equals("yes")) {
            Query_tree(currentNode.yes);

        } else if (response.equals("no")) {
            Query_tree(currentNode.no);

        } else {
            System.out.println("ERROR: Response must be \"Yes\" or \"No\"");
            askQuestion(currentNode);
        }
    }


    public void outputDecision() {
        System.out.println("\n" + "OUTPUT DECISION TREE!");
        System.out.println("---------------------------------------");
        outputDecisionTree(root);
    }

    public void outputDecisionTree(DT_Node currentNode) {

        if (currentNode == null) {
            return;

        } else {
            System.out.println("ID = " + currentNode.nodeID + " QUESTION = " + currentNode.Question);
            // Recursive calls
            outputDecisionTree(currentNode.yes);
            outputDecisionTree(currentNode.no);
        }


    }
}


