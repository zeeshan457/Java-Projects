package BallProject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Problem 9: You have 20 black balls and 16 white balls in a bag. You repeat
 * the following operation until a single ball is left in the bag. You remove
 * two balls at a time. If they are of the same color, you add a black ball to
 * the bag; if they are of different colors, you add a white ball to the bag.
 * Outline an algorithm that predicts the color of the last ball left in the
 * bag.
 */

public class Bag {

public static void main(String[] args) {

        // CREATING 2 Objects white balls and black balls.
        Balls whiteBalls = new Balls("White", 16);
        Balls blackBalls = new Balls("Black", 20);

        // ADDING the values of whiteBalls with blackBalls.
        int totalBalls = whiteBalls.getAmount() + blackBalls.getAmount();

        // ASSIGNING objects to index i inside an ArrayList called "whiteBalls"
        ArrayList<Balls> white = new ArrayList<>();
        for (int i = 0; i < whiteBalls.getAmount(); i++) {
                white.add(whiteBalls);
        }

        // ASSIGNING objects to index i inside an ArrayList called "blackBalls"
        ArrayList<Balls> black = new ArrayList<>();
        for (int i = 0; i < blackBalls.getAmount(); i++) {
                black.add(blackBalls);
        }

        // CREATING new ArrayList "bag" and making it the size of totalBalls.
        ArrayList<Balls> bag = new ArrayList<>(totalBalls);

        // POPULATE the "bag" ArrayList with white balls at index 0 and black balls at
        // index 16.
        bag.addAll(white);
        bag.addAll(black);

        // COUNT total balls.
        int count = 0;
        // DECLARING a random Object
        Random rnd = new Random();
        // DO while bag size is greater than 1.
        while (bag.size() > 1) { // O(n)
                count++;
                // SELECTING 2 random balls from the bag.
                int select1 = rnd.nextInt(bag.size());
                int select2 = rnd.nextInt(bag.size());
                // IF select 2 is the same as select 1 take a new index value from the bag.
                while (select2 == select1) {    // O(n^2)
                        select2 = rnd.nextInt(bag.size());
                }
                // IF the bag size does not equal 1: Do this.
                if (bag.size() != 1) { // O(n)
                        System.out.println("Amount of Balls left: " + bag.size());

                        // IF - SELECT 1 & 2 ARE BOTH BLACK-BALLS: DO THIS
                        if (bag.get(select1).equals(blackBalls) && bag.get(select2).equals(blackBalls)) {
                                bag.remove(blackBalls);
                                System.out.println("You got 2 Black balls.");
                                System.out.println("Removing 2 Blackballs, Adding Black ball" + System.lineSeparator());
                        }

                        // IF - SELECT 1 & 2 ARE BOTH WHITE-BALLS: DO THIS
                        else if (bag.get(select1).equals(whiteBalls) && bag.get(select2).equals(whiteBalls)) {
                                bag.remove(whiteBalls);
                                bag.remove(whiteBalls);
                                bag.add(blackBalls);
                                System.out.println("You got 2 White balls");
                                System.out.println("Removing 2 White balls. Adding Black ball." + System.lineSeparator());
                        }

                        // IF - SELECT 1 & 2 ARE WHITE AND BLACK OR BLACK AND WHITE: DO THIS
                        else {
                                bag.remove(whiteBalls);
                                bag.remove(blackBalls);
                                bag.add(whiteBalls);
                                System.out.println("Both balls are different.");
                                System.out.println("Removing White and Black balls. Adding White" + System.lineSeparator());
                        }

                }
        }
        System.out.println("BAG SIZE: " + bag.size());
        System.out.println("The last remaining ball is: " + bag);
        System.out.println("Count is : " + count);
}
}
/*
*	The probability that there will be one black ball left at the end is 100% because technically it is impossible to get one white ball left. 
*	We start with 16 white balls, which is even number. During this process, the program picks randomly two balls at the same time and then 	
*	decides what is next step. If we got 2 white balls, the program removes them from the bag and add a black ball, which gives 14 whites(still even number).
*	Repeating these steps, we will get always 0 white balls at the end. If the program picks one white ball and 1 black ball, then
*	it removes them and adds 1 white, which gives in total 0 whites. 
*/
