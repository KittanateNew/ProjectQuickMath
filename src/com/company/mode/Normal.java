package com.company.mode;

import java.util.ArrayList;
import java.util.Random;

public class Normal extends Mode{
    private int[] notPrime = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20,
                     21, 22, 24, 25, 26, 27, 28, 30, 32, 33, 34, 35, 36, 38, 39, 40,
                     42, 44, 45, 46, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60,
                     62, 63, 64, 65, 66, 68, 69, 70, 72, 74, 75, 76, 77, 78, 80,
                     81, 82, 84, 85, 86, 87, 88, 90, 91, 92, 93, 94, 95, 96, 98, 99};
    @Override
    public void randomOperator() {
        operator = OperatorArray[(int)new Random().nextInt(4)];
        //ไม่แน่ใจ
    }

    @Override
    public void random2Num() {
        int[] NegOrPos = {-1,1};
        if (operator.equals("+") || operator.equals("-")) {
            num1 = (int) (Math.random()*1999)-999;
            num2 = (int) (Math.random()*1999)-999;
        } else if (operator.equals("*")) {
            num1 = (int) (Math.random()*199)-99;
            num2 = (int) (Math.random()*199)-99;
        } else {
            int rnd = new Random().nextInt(notPrime.length);
            num1 = notPrime[rnd] * NegOrPos[new Random().nextInt(NegOrPos.length)];
            ArrayList<Integer> factors = new ArrayList<Integer>();
            for (int i = 1; i <= num1; i++) {
                if (num1 % i == 0){
                    factors.add(i);
                }
            }
            int rnd2 = new Random().nextInt(factors.size());
            num2 = factors.get(rnd2) * NegOrPos[new Random().nextInt(NegOrPos.length)];

        }
    }
}
