package com.company;

import com.company.mode.Easy;
import com.company.mode.Hard;
import com.company.mode.Normal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class endGame extends JFrame{
    private JPanel EndGame;
    private JButton playAgainButton;
    private JButton giveUpButton;
    private JLabel totalScoreLabel;
    private JLabel Star2;
    private JLabel Star1;
    private JLabel Star3;
    private JLabel bestScoreLabel;
    private JLabel timeOutLabel;
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
        final Icon wStar = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Resources/whiteStar.gif")));

        totalScoreLabel.setText("Total Score : "+q.getScore());
        try{
            File scoreFile = new File("src\\BestScoreInfo.txt");
            Scanner scoreReader = new Scanner(scoreFile);
            int easyData = Integer.parseInt(scoreReader.nextLine());
            bestScoreEasy = easyData;
            int normalData = Integer.parseInt(scoreReader.nextLine());
            bestScoreNormal = normalData;
            int hardData = Integer.parseInt(scoreReader.nextLine());
            bestScoreHard = hardData;
        } catch (FileNotFoundException e){

        }

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


        try{
            FileWriter fWriter = new FileWriter("src\\BestScoreInfo.txt", false);
            PrintWriter pWriter = new PrintWriter(fWriter);
            pWriter.println(bestScoreEasy);
            pWriter.println(bestScoreNormal);
            pWriter.println(bestScoreHard);
            pWriter.close();
        } catch (IOException e) {

        }

        if ( q.getScore() == 0){
            Star1.setIcon(wStar);
            Star2.setIcon(wStar);
            Star3.setIcon(wStar);
        }else if( q.getScore() < 2){
            Star2.setIcon(wStar);
            Star3.setIcon(wStar);
        }else if( q.getScore() <3){
            Star3.setIcon(wStar);
        }

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame mainGameFrame = new mainGame("Quick Math", new Question(q.getMode()));
                mainGameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        giveUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame menuFrame = new Menu("Quick Math");
                menuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }
}
