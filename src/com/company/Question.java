package com.company;

import com.company.mode.Hard;
import com.company.mode.Mode;

import javax.swing.*;
import java.util.Random;

public class Question {
    private int skipCount = 3;
    private int score = 0;
    private int answer = 0;
    private String quiz = "";
    private final Mode mode;

    public Question(Mode mode) { //กดปุ๋ม easy -> สร้าง new Question(new Easy())
        this.mode = mode;
    }

    public void nextQuiz(JLabel qLabel, JButton button1, JButton button2, JButton button3, JButton button4) {
        mode.randomOperator();
        mode.random2Num();
        if (mode instanceof Hard && !(((Hard) mode).getOperator2().equals("none"))) {
            if (((Hard) mode).getOperator2().equals("!")){
                quiz = mode.getNum1() + "! " + mode.getOperator() + " " + mode.getNum2() + " = ?";
            } else {
                quiz = mode.getNum1() + ((Hard) mode).getOperator2() + ((Hard) mode).getExponent() + " " +
                        mode.getOperator() + " " + mode.getNum2() + " = ?";
            }
        } else {
            quiz = mode.getNum1() + " " + mode.getOperator() + " " + mode.getNum2() + " = ?";
        }
        setAnswer(mode.getNum1(), mode.getOperator(), mode.getNum2());
        qLabel.setText(quiz);
        randomChoice(button1, button2, button3, button4);
    }

    public String getQuiz() {
        return quiz;
    }

    public void setAnswer(int num1, String operator, int num2) {
        if (mode instanceof Hard && !(((Hard) mode).getOperator2().equals("none"))) {
            switch (((Hard) mode).getOperator2()) {
                case "!":
                    switch (operator) {
                        case "+" -> answer = factorial(num1) + num2;
                        case "-" -> answer = factorial(num1) - num2;
                        case "*" -> answer = factorial(num1) * num2;
                        case "/" -> answer = factorial(num1) / num2;
                    }
                    break;
                case "^":
                    int exp = ((Hard) mode).getExponent();
                    switch (operator) {
                        case "+" -> answer = (int) (Math.pow(num1, exp) + num2);
                        case "-" -> answer = (int) (Math.pow(num1, exp) - num2);
                        case "*" -> answer = (int) (Math.pow(num1, exp) * num2);
                        case "/" -> answer = (int) (Math.pow(num1, exp) / num2);
                    }
                    break;
            }
        } else {
            switch (operator) {
                case "+" -> answer = num1 + num2;
                case "-" -> answer = num1 - num2;
                case "*" -> answer = num1 * num2;
                case "/" -> answer = num1 / num2;
            }
        }
    }

    public int getAnswer() {
        return answer;
    }

    public void randomChoice (JButton button1, JButton button2, JButton button3, JButton button4) {
        int ansChoice = new Random().nextInt(4)+1;
        int[] Choice = new int[4];
        int[] NegOrPos = {-1,1};
        switch (ansChoice) {
            case 1 -> button1.setText(String.valueOf(answer));
            case 2 -> button2.setText(String.valueOf(answer));
            case 3 -> button3.setText(String.valueOf(answer));
            case 4 -> button4.setText(String.valueOf(answer));
        }
        switch (mode.getOperator()) {
            case "+":
            case "-":
                for (int i = 1; i < 5; i++) {
                    if (i != ansChoice) {
                        Choice[i-1] = answer + (new Random().nextInt(20)+1) * NegOrPos[new Random().nextInt(2)];
                        switch (i) {
                            case 1 -> button1.setText(String.valueOf(Choice[i-1]));
                            case 2 -> button2.setText(String.valueOf(Choice[i-1]));
                            case 3 -> button3.setText(String.valueOf(Choice[i-1]));
                            case 4 -> button4.setText(String.valueOf(Choice[i-1]));
                        }
                    }
                }
                break;
            case "*":
                for (int i = 1; i < 5; i++) {
                    if (i != ansChoice) {
                        Choice[i-1] = answer + (new Random().nextInt(100)+1) * NegOrPos[new Random().nextInt(2)];
                        switch (i) {
                            case 1 -> button1.setText(String.valueOf(Choice[i-1]));
                            case 2 -> button2.setText(String.valueOf(Choice[i-1]));
                            case 3 -> button3.setText(String.valueOf(Choice[i-1]));
                            case 4 -> button4.setText(String.valueOf(Choice[i-1]));
                        }
                    }
                }
                break;
            case "/":
                for (int i = 1; i < 5; i++) {
                    if (i != ansChoice) {
                        Choice[i-1] = answer + (new Random().nextInt(50)+1) * NegOrPos[new Random().nextInt(2)];
                        switch (i) {
                            case 1 -> button1.setText(String.valueOf(Choice[i-1]));
                            case 2 -> button2.setText(String.valueOf(Choice[i-1]));
                            case 3 -> button3.setText(String.valueOf(Choice[i-1]));
                            case 4 -> button4.setText(String.valueOf(Choice[i-1]));
                        }
                    }
                }
                break;
        }
    }

    public void checkAnswer (String response, JLabel scoreLabel){
        if (Integer.parseInt(response) == answer) {
            score++;
        } else {
            score--;
        }
        scoreLabel.setText("Score: " + score);
        //nextQuiz(); ทำที่ปุ่ม
    }

    //ไม่แน่ใจ skip()
    public void skip (JLabel label) {
        if (skipCount > 0) {
            skipCount--;
            //nextQuiz(); ทำที่ปุ่ม
            label.setText(skipCount + " skip remain");
        } else {
            label.setText("You already used all the skip");
        }
    }

    public int getSkipCount() {
        return skipCount;
    }

    public int factorial (int n){
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }

    public Mode getMode(){
        return mode;
    }

    public int getScore(){
        return score;
    }
}
