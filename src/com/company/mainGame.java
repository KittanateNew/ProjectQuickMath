package com.company;

import javax.swing.*;
import java.awt.*;

public class mainGame extends JFrame {
    private JPanel MainGame;
    private JLabel timer;
    private static JLabel Question;
    private static JButton choice1;
    private static JButton choice3;
    private static JButton choice2;
    private static JButton choice4;
    private static JLabel scoreLabel;
    private static JLabel noSkipLabel;
    private JButton skipButton;

    public static void setButton1Value(int value) {
        choice1.setText(String.valueOf(value));
    }
    public static void setButton2Value(int value){
        choice2.setText(String.valueOf(value));
    }
    public static void setButton3Value(int value){
        choice3.setText(String.valueOf(value));
    }
    public static void setButton4Value(int value){
        choice4.setText(String.valueOf(value));
    }

    public static void setQuestion(String quiz) {
        Question.setText(quiz);
    }

    public static void setScoreLabel(int score) {
        scoreLabel.setText(String.valueOf(score));
    }

    public static void setNoSkipLabel(String text){
        noSkipLabel.setText(text);
    }
}
