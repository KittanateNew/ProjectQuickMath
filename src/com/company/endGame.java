package com.company;

import com.company.mode.Easy;
import com.company.mode.Hard;
import com.company.mode.Normal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class endGame extends JFrame{
    private JPanel EndGame;
    private JButton playAgainButton;
    private JButton giveUpButton;
    private JLabel totalScoreLabel;
    private JLabel Star2;
    private JLabel Star1;
    private JLabel Star3;
    private JLabel bestScoreLabel;
    private static int bestScoreEasy = 0;
    private static int bestScoreNormal = 0;
    private static int bestScoreHard = 0;

    private Question q;

    public endGame(String title, Question q){
        super(title);

        this.q = q;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(EndGame);
        this.setVisible(true);
        this.pack();

        totalScoreLabel.setText("Total Score : "+q.getScore());

        if (q.getMode() instanceof Easy){
            if ( q.getScore() > bestScoreEasy){
                bestScoreEasy = q.getScore();
                bestScoreLabel.setText("Best Record : "+ bestScoreEasy);
            }else{
                bestScoreLabel.setText("Best Record : "+ bestScoreEasy);
            }
        }else if(q.getMode() instanceof Normal){
            if ( q.getScore() > bestScoreNormal){
                bestScoreNormal = q.getScore();
                bestScoreLabel.setText("Best Record : "+ bestScoreNormal);
            }else{
                bestScoreLabel.setText("Best Record : "+ bestScoreNormal);
            }
        }else if(q.getMode() instanceof Hard){
            if ( q.getScore() > bestScoreHard){
                bestScoreHard = q.getScore();
                bestScoreLabel.setText("Best Record : "+ bestScoreHard);
            }else{
                bestScoreLabel.setText("Best Record : "+ bestScoreHard);
            }
        }

        if ( q.getScore() > 2){

        }

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame maingameFrame = new mainGame("Quick Math", new Question(q.getMode()));
                maingameFrame.setSize(850,650);
            }
        });

        giveUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame menuFrame = new Menu("Quick Math");
                menuFrame.setSize(850,650);
            }
        });
    }
}
