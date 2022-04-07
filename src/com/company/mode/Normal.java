package com.company.mode;

import java.util.Random;

public class Normal extends Mode{
    @Override
    public void setOperator() {
        operator = OperatorArray[(int)new Random().nextInt(4)];
        //ไม่แน่ใจ
    }

    @Override
    public void randomNum() {
        if (operator == "+" || operator == "-") {
            num1 = (int) (Math.random()*1999)-999;
            num2 = (int) (Math.random()*1999)-999;
        } else {
            num1 = (int) (Math.random()*199)-99;
            num2 = (int) (Math.random()*199)-99;
        }
    }
}
