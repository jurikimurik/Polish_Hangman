package basic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.startNewGame();

        Scanner scan = new Scanner(System.in);
        boolean isEnd = false;
        while(!isEnd) {

            String letter = scan.nextLine();
            switch (game.check(letter)) {
                case LETTER_ACCEPTED -> System.out.println("Accepted!");
                case LETTER_REJECTED -> System.out.println("Rejected!");
                case ERROR -> System.out.println("Error!");
                case NONE -> System.out.println("Nothing!");
                case WIN -> {
                    System.out.println("You won!");
                    isEnd = true;
                }
                case LOSE -> {
                    System.out.println("You lose!");
                    isEnd = true;
                }
            }
            System.out.println(game);
        }

    }
}