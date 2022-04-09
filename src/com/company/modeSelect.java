package com.company;

import javax.swing.*;

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
    }


}
