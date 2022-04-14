package com.company;

import javax.swing.*;

public class QuickMathTester extends Menu{
    public QuickMathTester(String title){
        super(title);
    }

    public static void main(String[] args){
        JFrame frame = new Menu("Quick Math");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.add(Menu.backGround);
    }

}
