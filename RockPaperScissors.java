package q2;

import java.util.Random;
import java.util.Scanner;

/**
 * <p>
 * This program allows user to play a game of rock paper scissors with the
 * computer, it will continue to play until user chooses to stop.
 * </p>
 *
 * @author Trista Huang
 * @version 1.0
 */
public class RockPaperScissors {
    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     *
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        String personPlay = null; // User's play -- "R", "P", or "S"
        String computerPlay = null; // Computer's play -- "R", "P", or "S"
        int computerInt; // Randomly generated number used to determine
                         // computer's play
        int tie = 0;
        int win = 0;
        int lose = 0;

        Scanner scan = new Scanner(System.in);

        while (!"X".equals(personPlay)) {
            System.out.println("Enter your play: R, P, or S."
                    + "Type X to stop playing.");
            personPlay = scan.next().toUpperCase();

            if (!(personPlay.equals("R") || personPlay.equals("P")
                    || personPlay.equals("S") || personPlay.equals("X"))) {
                throw new IllegalArgumentException(
                        "The play can only be either R, P, S, or X.");
            }

            if (personPlay.equals("X")) {
                System.out.println("Play has stopped.");

            } else {

                // Get player's play -- note that this is stored as a string
                // Make player's play uppercase for ease of comparison
                // Generate computer's play (0,1,2)
                // Translate computer's randomly generated play to string

                final int compGen = 3;
                Random generator = new Random();
                computerInt = generator.nextInt(compGen);

                switch (computerInt) {
                case 0:
                    computerPlay = "R";
                    break;
                case 1:
                    computerPlay = "P";
                    break;
                case 2:
                    computerPlay = "S";
                    break;
                default:
                    break;
                }

                System.out.println("Computer play is: " + computerPlay);

                if (personPlay.equals(computerPlay)) {
                    System.out.println("It's a tie!");
                    tie++;
                }

                if (personPlay.equals("R")) {

                    if (computerPlay.equals("S")) {
                        System.out.println("Rock crushes scissors. You win!!");
                        win++;
                    } else if (computerPlay.equals("P")) {
                        System.out.println("Paper covers rocks. You lose.");
                        lose++;
                    }
                }
                if (personPlay.equals("P")) {
                    if (computerPlay.equals("R")) {
                        System.out.println("Paper covers rocks. You win!!");
                        win++;
                    } else if (computerPlay.equals("S")) {
                        System.out.println("Scissor cuts through papers."
                                + "You lose.");
                        lose++;
                    }
                }
                if (personPlay.equals("S")) {
                    if (computerPlay.equals("R")) {
                        System.out.println("Rock crushes scissors. You lose.");
                        lose++;
                    } else if (computerPlay.equals("P")) {
                        System.out.println("Scissor cuts through papers."
                                + "You win!!");
                        win++;
                    }
                }
            }
        }
        System.out.println("You have: " + win + " wins, " + lose + " loses, "
                + tie + " ties.");
        System.out.println("Question two was called and ran sucessfully.");
    }
};
