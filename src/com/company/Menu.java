package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel MainMenu;
    private JLabel GameName;
    private JButton playButton;
    private JButton exitButton;
    protected static JLabel backGround;

    public Menu(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainMenu);
        this.setVisible(true);
        this.pack();

        /*
        Icon backgroundIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Resources/p1.jpeg")));
        backGround = new JLabel(backgroundIcon);
        backGround.setSize(850,640);
        */

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame frame2 = new modeSelect("Quick Math");
                frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }


}
