import javax.swing.*;
import java.util.Objects;
import ModeFolder.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EndGame extends javax.swing.JFrame {
    private static int bestScoreEasy = 0;
    private static int bestScoreNormal = 0;
    private static int bestScoreHard = 0;
    private Question q;
    private Music music;
    
    public EndGame(String title, Question q, Music music){
        super(title);
        this.q = q;
        this.setVisible(true);
        this.music = music;
        music.close();
        
        initComponents();
        final Icon wStar = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Resources/whiteStar.gif")));

        totalScoreLabel.setText("Total Score : "+q.getScore());
        
        try {
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

        if ( q.getScore() < 10){
            star1.setIcon(wStar);
            star2.setIcon(wStar);
            star3.setIcon(wStar);
            music.setFile(4);
            music.setVolume(0.05);
            music.start();
        }else if( q.getScore() < 20){
            star2.setIcon(wStar);
            star3.setIcon(wStar);
        }else if( q.getScore() < 30){
            star3.setIcon(wStar);
        }    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EndGame = new javax.swing.JPanel();
        timeOutLabel = new javax.swing.JLabel();
        star1 = new javax.swing.JLabel();
        star2 = new javax.swing.JLabel();
        star3 = new javax.swing.JLabel();
        playAgainButton = new javax.swing.JButton();
        giveUpButton = new javax.swing.JButton();
        totalScoreLabel = new javax.swing.JLabel();
        bestScoreLabel = new javax.swing.JLabel();
        modeSelectButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        EndGame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeOutLabel.setFont(new java.awt.Font("Arial", 0, 120)); // NOI18N
        timeOutLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeOutLabel.setText("Time Out");
        EndGame.add(timeOutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 530, -1));

        star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/SmallStar.png"))); // NOI18N
        EndGame.add(star1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/SmallStar.png"))); // NOI18N
        EndGame.add(star2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, -1, -1));

        star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/SmallStar.png"))); // NOI18N
        EndGame.add(star3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 150, -1, -1));

        playAgainButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/playAgain.png"))); // NOI18N
        playAgainButton.setBorder(null);
        playAgainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAgainButtonActionPerformed(evt);
            }
        });
        EndGame.add(playAgainButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, -1, -1));

        giveUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/menu.png"))); // NOI18N
        giveUpButton.setBorder(null);
        giveUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giveUpButtonActionPerformed(evt);
            }
        });
        EndGame.add(giveUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 750, -1, -1));

        totalScoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        totalScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalScoreLabel.setText("Total Score: 0");
        EndGame.add(totalScoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 340, 80));

        bestScoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        bestScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        bestScoreLabel.setText("Best Record: 0");
        EndGame.add(bestScoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 390, 60));

        modeSelectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/modeSelect.png"))); // NOI18N
        modeSelectButton.setBorder(null);
        modeSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeSelectButtonActionPerformed(evt);
            }
        });
        EndGame.add(modeSelectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 640, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/rickroll.gif"))); // NOI18N
        EndGame.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/end.gif"))); // NOI18N
        EndGame.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 840));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(EndGame, javax.swing.GroupLayout.PREFERRED_SIZE, 1540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(EndGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void giveUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giveUpButtonActionPerformed
        dispose();
        JFrame menuFrame = new Menu("Quick Math", music);
        menuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menuFrame.setLocationRelativeTo(null);
        music.close();
        music.setFile(0);
        music.start();
        music.loop();
    }//GEN-LAST:event_giveUpButtonActionPerformed

    private void playAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgainButtonActionPerformed
        dispose();
        JFrame mainGameFrame = new MainGame("Quick Math", new Question(q.getMode()), music);
        mainGameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainGameFrame.setLocationRelativeTo(null);
        music.close();
        if ( q.getMode() instanceof Easy){
            music.setFile(1);
            music.setVolume(0.08);
        }else if (q.getMode() instanceof Normal){
            music.setFile(2);
            music.setVolume(0.05);  
        }else { 
            music.setFile(3);
            music.setVolume(0.1);   
        }
        music.start();
        music.loop();
    }//GEN-LAST:event_playAgainButtonActionPerformed

    private void modeSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeSelectButtonActionPerformed
        dispose();
        JFrame modeSelectFrame = new ModeSelect("Quick Math", music);
        modeSelectFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        modeSelectFrame.setLocationRelativeTo(null);
        music.close();
        music.setFile(0);
        music.start();
        music.loop();
    }//GEN-LAST:event_modeSelectButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EndGame;
    private javax.swing.JLabel background;
    private javax.swing.JLabel bestScoreLabel;
    private javax.swing.JButton giveUpButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton modeSelectButton;
    private javax.swing.JButton playAgainButton;
    private javax.swing.JLabel star1;
    private javax.swing.JLabel star2;
    private javax.swing.JLabel star3;
    private javax.swing.JLabel timeOutLabel;
    private javax.swing.JLabel totalScoreLabel;
    // End of variables declaration//GEN-END:variables
}
