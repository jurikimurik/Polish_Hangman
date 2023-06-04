package GUI;

import GUI.HangmanModel;
import GUI.HangmanView;
import basic.GameAnswer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanController {
    private HangmanModel model;
    private HangmanView view;

    public HangmanController()
    {
        model = new HangmanModel();
        view = new HangmanView();
        setup();
    }
    public HangmanController(HangmanModel model, HangmanView view)
    {
        this.model = model;
        this.view = view;

        setup();
    }

    private void setup()
    {
        view.setContentPane(view.getMainPanel());
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.pack();
        view.setVisible(true);

        view.setListenerForButtons(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();
                if(!(obj instanceof JButton))
                    return;
                JButton button = (JButton) obj;
                GameAnswer answer = model.check(button.getText());
                if(answer != GameAnswer.WIN && answer != GameAnswer.LOSE)
                    updateGUI();
                else if(answer == GameAnswer.WIN) {
                    setup();
                    //WIN
                } else {
                    setup();
                    //LOSE
                }
            }
        });

        model.startNewGame();
        view.startGUI(model.getCurrentWord(), model.getDescriptionOfWord(), model.getNumberOfAttempts());
    }

    private void updateGUI()
    {
        view.update(model.getCurrentWord(), model.getAttempts());
    }
}
