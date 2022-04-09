package com.company;

import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;

public class Menu extends JFrame{
    private JPanel MainMenu;

    public Menu(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainMenu);
        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args){
        JFrame frame = new Menu("Quick Math");
        frame.setSize(650,450);
        System.out.println("new");
    }
}
