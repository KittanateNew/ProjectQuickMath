package com.company;

import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;
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

        Icon backgroundIcon = new ImageIcon(getClass().getResource("/Resources/p1.jpeg"));
        backGround = new JLabel(backgroundIcon);
        backGround.setSize(850,650);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame frame2 = new modeSelect("Quick Math");
                frame2.setSize(850,650);
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
