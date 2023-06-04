package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JLettersPanel extends JPanel {
    String[] buttonNames = {"A", "B", "C", "D", "E", "F", "G",
            "H", "I", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "V", "X", "Y", "Z", "Ą", "Ę", "Ł", "Ó", "Ż"};

    ArrayList<JButton> buttons;

    public JLettersPanel() {
        FlowLayout layout = new FlowLayout();
        setLayout(layout);

        buttons = new ArrayList<>();
        for(String text : buttonNames) {
            buttons.add(new JButton(text));
        }
    }

    public void setListenerForButtons(ActionListener listener) {
        for(JButton button : buttons)
            button.addActionListener(listener);
    }

}
