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
        int rows = 4;
        GridLayout layout = new GridLayout(rows, buttonNames.length/rows);
        setLayout(layout);

        int index = 0;
        buttons = new ArrayList<>();
        for(String text : buttonNames) {
            JButton button = new JButton(text);
            buttons.add(button);
            add(button, index++);
        }
    }

    public void setListenerForButtons(ActionListener listener) {


        for(JButton button : buttons) {

            for(ActionListener buttonListener : button.getActionListeners())
                button.removeActionListener(buttonListener);

            button.addActionListener(listener);
        }

    }

}
