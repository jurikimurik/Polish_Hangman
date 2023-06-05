package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class HangmanView extends JFrame {
    //---------------VARIABLES--------------------
    private int maxAttemps;
    private JPanel mainPanel;
    private JTextField currentWordField;
    private JTextField descriptionField;
    private JLabel imageLabel;
    private JLettersPanel lettersPanel;
    private JLabel wordLabel;
    private JLabel descriptionLabel;
    private JTextField scoreField;

    //---------------GUI-------------------------------
    public void startGUI(String currentWord, String description, int maxAttemps)
    {
        currentWordField.setText(currentWord);
        descriptionField.setText(description);
        scoreField.setText(String.valueOf(0));
        drawHangman(0);
        this.maxAttemps = maxAttemps;
    }
    public void update(String currentWord, int attemps, int score)
    {
        scoreField.setText(String.valueOf(score));
        currentWordField.setText(currentWord);
        drawHangman(attemps);
    }
    private void drawHangman(int attemps)
    {
        int attempsLeft = maxAttemps-attemps;
        ImageIcon icon = new ImageIcon("src/images/" + attempsLeft + ".png");
        if(icon.getImageLoadStatus() == MediaTracker.ERRORED)
            icon = new ImageIcon("images/" + attempsLeft + ".png");
        imageLabel.setIcon(icon);

        mainPanel.repaint();
    }

    public void openDifficultyWindow(ActionListener listener) {
        JFrame frame = new JFrame("Difficulty");
        frame.setBounds(getBounds());
        JPanel panel = new JPanel();

        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);

        String[] difficulty = {"1 - Easy (12)","2 - Normal (10)","3 - Hard (8)","4 - Extreme (6)","5 - IMPOSSIBLE (4)"};
        JList<String> list = new JList<>(difficulty);

        JButton okButton = new JButton("Select");
        okButton.addActionListener(e -> {
            //Get value between ()
            maxAttemps = Integer.parseInt(list.getSelectedValue().split("\\(")[1].replaceAll("\\D", ""));
            e.setSource(Integer.valueOf(maxAttemps));
            listener.actionPerformed(e);
            frame.setVisible(false);
        });

        panel.add(list, BorderLayout.CENTER);
        panel.add(okButton, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void openResultsWindow(boolean isWin, int score, ActionListener startNewGameListener) {
        setVisible(false);
        JFrame frame = new JFrame("Results");
        frame.setBounds(getBounds());
        JPanel panel = new JPanel();

        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);

        JLabel text = new JLabel();
        if(isWin)
            text.setText("You win!");
        else
            text.setText("YOU DIED!");
        text.setText(text.getText() + " Your score: " + score);

        JButton newGame = new JButton("New Game");
        newGame.addActionListener(e -> {
            frame.setVisible(false);
            startNewGameListener.actionPerformed(e);
        });
        JButton close = new JButton("Close");
        close.addActionListener(e -> exit(0));

        panel.add(text, BorderLayout.CENTER);
        panel.add(newGame, BorderLayout.SOUTH);
        panel.add(close, BorderLayout.NORTH);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //---------------LISTENERS-------------------------

    public void setListenerForButtons(ActionListener listener) {
        lettersPanel.setListenerForButtons(listener);
    }

    //---------------GETTERS AND SETTERS---------------

    public JPanel getMainPanel() {
        return mainPanel;
    }


}
