package com.company.mode;

import java.util.Random;

public class Easy extends Mode {
    @Override
    public void setOperator() {
        operator = OperatorArray[(int)new Random().nextInt(3)];
        //ไม่แน่ใจ
    }

    @Override
    public void randomNum() {
        if (operator == "+" || operator == "-") {
            num1 = (int) (Math.random()*199)-99;
            num2 = (int) (Math.random()*199)-99;
        } else {
            num1 = (int) (Math.random()*19)-9;
            num2 = (int) (Math.random()*19)-9;
        }
    }
}
