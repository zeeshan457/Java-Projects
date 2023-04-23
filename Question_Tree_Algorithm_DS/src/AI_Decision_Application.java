import java.io.IOException;
import java.util.Scanner;

public class AI_Decision_Application {

    /*//// TODO:
     * CREATE NODE CLASS
     * CREATE A DECISION TREE // METHODS
     * TEST METHODS
     *
     * Either link the program with a dataset (custom dataset or the one provided in Canvas)
     *
     * or, make a program that can diagnose whether someone has diabetes by asking a number of questions.
     *
     *
     *
     *
     *
     */

    // Attributes
    public static Decision_tree tree;

    public static void main(String[] args) throws IOException {

        // Instance of Decision_tree object
        tree = new Decision_tree();

        // Method calls
        GenerateQuestionTree();
        tree.outputDecision();
        GenerateQueryTree();

    }

    public static void GenerateQuestionTree() {

        if (tree != null) {
            System.out.println("\n" + "GENERATING DECISION TREE!");
            System.out.println("-----------------------------------------");
            tree.createRoot(1, "Do you have Diabetes?"); // Root
            tree.addYesNode(1, 2, "Do you consider yourself, to be over-weight?");
            tree.addNoNode(1, 3, "Since you don't have Diabetes, " +
                    "we will say Goodbye for now!"); // End program here
            tree.addYesNode(2, 4, "Do you think being over-weight, " +
                    "has contributed towards your diabetic problems??");
            tree.addNoNode(2, 5, "Since your not over-weight, Do you eat Sugary foods?");
            tree.addYesNode(4, 6, "try to Exercise more and have a balanced diet, " +
                    "this will dramatically prevent diabetes");
            tree.addNoNode(4, 7, "Okay, the problem may be an unbalanced Diet, try to balance your diet!");
            tree.addYesNode(5, 8, "Cut less on sugary foods, and have a balanced diet, " +
                    "this will dramatically prevent diabetes!");
            tree.addNoNode(5, 9, "Okay, the problem may be an unbalanced Diet, try to balance your diet! ");

        } else {
            System.out.println("The Decision tree is Null!");
        }
    }

    public static void GenerateQueryTree() throws IOException {
        System.out.println("\n" + "QUESTIONS!");
        System.out.println("-------------------------------------");
        tree.Query();
    }


}