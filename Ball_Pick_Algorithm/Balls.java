package BallProject;

public class Balls {
    private final String colour;
    private int amount;

    public Balls(String type, int num) {
        colour = type;
        amount = num;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String toString() {
        return colour;
    }
}
