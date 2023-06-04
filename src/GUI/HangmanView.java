package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

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

    //---------------GUI-------------------------------
    public void startGUI(String currentWord, String description, int maxAttemps)
    {
        currentWordField.setText(currentWord);
        descriptionField.setText(description);
        drawHangman(0);
        this.maxAttemps = maxAttemps;
    }
    public void update(String currentWord, int attemps)
    {
        currentWordField.setText(currentWord);
        drawHangman(attemps);
    }
    private void drawHangman(int attemps)
    {
        int attempsLeft = maxAttemps-attemps;
        imageLabel.setText(String.valueOf(attempsLeft));
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
