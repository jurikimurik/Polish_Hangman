package GUI;

import javax.swing.*;

public class HangmanView extends JFrame {
    private JPanel mainPanel;
    private JTextField currentWordField;
    private JTextField descriptionField;
    private JLabel imageLabel;
    private JLettersPanel lettersPanel;
    private JLabel wordLabel;
    private JLabel descriptionLabel;

    public HangmanView()
    {

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
