package com.company.mode;

import java.util.Random;

public class Easy extends Mode {
    @Override
    public void randomOperator() {
        operator = OperatorArray[(int)new Random().nextInt(3)];
    }

    @Override
    public void random2Num() {
        if (operator.equals("+") || operator.equals("-")) {
            num1 = (int) (Math.random()*19)-9;
            num2 = (int) (Math.random()*19)-9;
        } else {
            num1 = (int) (Math.random()*19)-9;
            num2 = (int) (Math.random()*19)-9;
        }
    }
}
