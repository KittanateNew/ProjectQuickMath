package com.company;

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

            }
        });
    }


}
