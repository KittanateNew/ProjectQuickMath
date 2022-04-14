package com.company;

import com.company.mode.Easy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class mainGame extends JFrame {
    private JPanel MainGame;
    private JLabel timerLabel;
    private JLabel Question;
    private JButton choice1;
    private JButton choice3;
    private JButton choice2;
    private JButton choice4;
    private JLabel scoreLabel;
    private JLabel noSkipLabel;
    private JButton skipButton;
    private Question q;

   private int second = 0;
   private int minute = 1;
   private DecimalFormat dFormat = new DecimalFormat("00");
   private Timer timeCount;

    public mainGame(String title, Question q){
        super(title);
        this.q = q;
        q.nextQuiz(Question, choice1, choice2, choice3, choice4);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainGame);
        this.setVisible(true);
        this.pack();

        timerLabel.setText("Time 01:00");
        countdownTimer();
        timeCount.start();

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

    public void countdownTimer() {
        timeCount = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                second--;
                String ddSecond = dFormat.format(second);
                String ddMinute = dFormat.format(minute);
                timerLabel.setText("Time " + ddMinute + ":" + ddSecond);

                if (second == -1) {
                    second = 59;
                    minute--;
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);
                    timerLabel.setText("Time " + ddMinute + ":" + ddSecond);
                }

                if (minute == 0 && second == 0) {
                    timeCount.stop();
                    dispose();
                    JFrame frame4 = new endGame("Quick Math", q);
                    frame4.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
            }
        });
    }


}
