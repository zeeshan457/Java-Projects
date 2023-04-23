
public class DT_Node {

    // Attributes
    public int nodeID;
    public String Question = null;
    public DT_Node yes = null;
    public DT_Node no = null;

    // Constructor
    public DT_Node(int newNodeID, String newQuestion) {
        nodeID = newNodeID;
        Question = newQuestion;
    }

    // Getters for ID and Question
    public int getNodeID() {
        return nodeID;
    }

    public String getQuestion() {
        return Question;
    }
}



