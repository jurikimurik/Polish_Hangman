package basic;

import GUI.HangmanView;

import javax.swing.*;

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
        JFrame frame = new JFrame("HangmanView");
        HangmanView view = new HangmanView();
        frame.setContentPane(view.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}