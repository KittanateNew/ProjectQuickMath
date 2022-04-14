package com.company;

import com.company.mode.Easy;
import com.company.mode.Hard;
import com.company.mode.Normal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modeSelect extends JFrame{
    private JPanel modeMenu;
    private JLabel GameName;
    private JButton normalButton;
    private JButton easyButton;
    private JButton hardButton;

    public modeSelect(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(modeMenu);
        this.setVisible(true);
        this.pack();
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame frame3 = new mainGame("Quick Math", new Question(new Easy()));
                frame3.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        normalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame frame3 = new mainGame("Quick Math", new Question(new Normal()));
                frame3.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame frame3 = new mainGame("Quick Math", new Question(new Hard()));
                frame3.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }


}
