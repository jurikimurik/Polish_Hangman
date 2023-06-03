package basic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleGame {
    private static HangmanGame game;
    private static Scanner scanner;

    public ConsoleGame() {
        scanner = new Scanner(System.in);
        startNewGame();
    }

    private void startNewGame()
    {
        System.out.println("Starting a new game!");

        int input = -1;
        while(input < 1 || input > 5)
        {
            System.out.println("Choose difficulty: ");
            System.out.println("1 - Easy (12)");
            System.out.println("2 - Normal (10)");
            System.out.println("3 - Hard (8)");
            System.out.println("4 - Extreme (6)");
            System.out.println("5 - IMPOSSIBLE (4)");
            input = getIntInput();
        }

        switch (input) {
            case 1 -> game = new HangmanGame("words.hm", 12);
            case 2 -> game = new HangmanGame("words.hm", 10);
            case 3 -> game = new HangmanGame("words.hm", 8);
            case 4 -> game = new HangmanGame("words.hm", 6);
            case 5 -> game = new HangmanGame("words.hm", 4);
        }

        GameAnswer turnResult;
        do
        {
            turnResult = turn();
        } while(turnResult != GameAnswer.WIN || turnResult != GameAnswer.LOSE);


        showResult(turnResult);
    }

    private void showResult(GameAnswer turnResult) {
        if(turnResult == GameAnswer.WIN) {
            System.out.println("You won! Your score: " + game.getScore());
        } else if(turnResult == GameAnswer.LOSE) {
            System.out.println("Unfortunatly, you lose. What a shame!");
        } else {
            System.out.println("Something strange happened.");
        }
    }

    private GameAnswer turn()
    {
        return  GameAnswer.NONE;
    }

    public String getStringInput() {
        return scanner.nextLine();
    }

    public static int getIntInput() {
        int number = 0;
        boolean shouldAccept = false;
        while(!shouldAccept) {
            try {
                number = scanner.nextInt();
                shouldAccept = true;
            } catch (InputMismatchException ex) {
                ex.printStackTrace();
            }
        }
        return number;
    }
}
