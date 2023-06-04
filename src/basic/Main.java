package basic;

import GUI.HangmanController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        chooseVersion();
    }
    public static void startGameInConsole()
    {
        ConsoleGame game = new ConsoleGame();
    }
    public static void startGameInApp()
    {
        HangmanController controller = new HangmanController();
    }
    public static void chooseVersion() {
        JFrame frame = new JFrame("Version");
        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Choose version: ");
        panel.add(label, BorderLayout.NORTH);

        //For buttons special panel
        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        panel.add(centerPanel, BorderLayout.CENTER);

        JButton consoleButton = new JButton("Console");
        consoleButton.addActionListener(e -> {
            frame.setVisible(false);
            startGameInConsole();
            exit(0);
        });
        JButton GUIButton = new JButton("GUI");
        GUIButton.addActionListener(e -> {
            frame.setVisible(false);
            startGameInApp();
        });

        centerPanel.add(consoleButton);
        centerPanel.add(GUIButton);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}