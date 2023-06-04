package basic;

import GUI.HangmanController;

public class Main {

    public static void main(String[] args) {
        startGameInApp();
    }
    public static void startGameInConsole()
    {
        ConsoleGame game = new ConsoleGame();
    }
    public static void startGameInApp()
    {
        HangmanController controller = new HangmanController();
    }
}