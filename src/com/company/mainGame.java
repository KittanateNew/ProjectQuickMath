package com.company;

import com.company.mode.Easy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainGame extends JFrame {
    private JPanel MainGame;
    private JLabel timer;
    private JLabel Question;
    private JButton choice1;
    private JButton choice3;
    private JButton choice2;
    private JButton choice4;
    private JLabel scoreLabel;
    private JLabel noSkipLabel;
    private JButton skipButton;
    private Question q;

    public mainGame(String title, Question q){
        super(title);
        this.q = q;
        q.nextQuiz(Question, choice1, choice2, choice3, choice4);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainGame);
        this.setVisible(true);
        this.pack();
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (q.getSkipCount() > 0){
                    q.nextQuiz(Question, choice1, choice2, choice3, choice4);
                }
                q.skip(noSkipLabel);
            }
        });

        choice1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                q.checkAnswer(choice1.getText(), scoreLabel);
                q.nextQuiz(Question, choice1, choice2, choice3, choice4);
            }
        });

        choice2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                q.checkAnswer(choice2.getText(), scoreLabel);
                q.nextQuiz(Question, choice1, choice2, choice3, choice4);
            }
        });

        choice3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                q.checkAnswer(choice3.getText(), scoreLabel);
                q.nextQuiz(Question, choice1, choice2, choice3, choice4);
            }
        });

        choice4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                q.checkAnswer(choice4.getText(), scoreLabel);
                q.nextQuiz(Question, choice1, choice2, choice3, choice4);
            }
        });
    }

    public void setButton1Value(int value) {
        choice1.setText(String.valueOf(value));
    }
    public void setButton2Value(int value){
        choice2.setText(String.valueOf(value));
    }
    public void setButton3Value(int value){
        choice3.setText(String.valueOf(value));
    }
    public void setButton4Value(int value){
        choice4.setText(String.valueOf(value));
    }

    public void setQuestion(String quiz) {
        Question.setText(quiz);
    }

    public void setScoreLabel(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void setNoSkipLabel(String text){
        noSkipLabel.setText(text);
    }
}
