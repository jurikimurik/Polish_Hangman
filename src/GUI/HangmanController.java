package GUI;

import basic.GameAnswer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanController {
    private final HangmanModel model;
    private final HangmanView view;

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
        view.setVisible(false);

        view.setListenerForButtons(e -> {
            Object obj = e.getSource();
            if(!(obj instanceof JButton))
                return;
            JButton button = (JButton) obj;
            GameAnswer answer = model.check(button.getText());
            if(answer != GameAnswer.WIN && answer != GameAnswer.LOSE) {
                updateGUI();
            } else if(answer == GameAnswer.WIN) {
                view.openResultsWindow(true, model.getScore(), getStartNewGameListener());
                //WIN
            } else {
                view.openResultsWindow(false, model.getScore(), getStartNewGameListener());
                //LOSE
            }
        });

        view.openDifficultyWindow(e -> {
            Object obj = e.getSource();
            if(obj instanceof Integer) {
                startGame((Integer)obj);
            }
        });
    }

    private void updateGUI()
    {
        view.update(model.getCurrentWord(), model.getAttempts(), model.getScore());
    }

    private void startGame(int difficultyAttempts)
    {
        view.setVisible(true);
        model.startNewGame("words.hm", difficultyAttempts);
        view.startGUI(model.getCurrentWord(), model.getDescriptionOfWord(), model.getNumberOfAttempts());
        view.update(model.getCurrentWord(), model.getAttempts(),model.getScore());
    }

    private ActionListener getStartNewGameListener()
    {
        return e -> setup();
    }
}
