package com.company;

import com.company.mode.Hard;
import com.company.mode.Mode;

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

    public void nextQuiz() {
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
        mainGame.setQuestion(quiz);
        randomChoice();
        mainGame.setScoreLabel(score);
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

    public int getAnswer () {
        return answer;
    }

    public void randomChoice () {
        int ansChoice = new Random().nextInt(3) + 1;
        int[] Choice = new int[4];
        int[] NegOrPos = {-1,1};
        switch (ansChoice) {
            case 1 -> mainGame.setButton1Value(answer);
            case 2 -> mainGame.setButton2Value(answer);
            case 3 -> mainGame.setButton3Value(answer);
            case 4 -> mainGame.setButton4Value(answer);
        }
        switch (mode.getOperator()) {
            case "+":
            case "-":
                for (int i = 1; i < 5; i++) {
                    if (i != ansChoice) {
                        Choice[i] = answer + (new Random().nextInt(20) + 1) * NegOrPos[new Random().nextInt(2)];
                        switch (i) {
                            case 1 -> mainGame.setButton1Value(Choice[i]);
                            case 2 -> mainGame.setButton2Value(Choice[i]);
                            case 3 -> mainGame.setButton3Value(Choice[i]);
                            case 4 -> mainGame.setButton4Value(Choice[i]);
                        }
                    }
                }
                break;
            case "*":
                for (int i = 1; i < 5; i++) {
                    if (i != ansChoice) {
                        Choice[i] = answer + (new Random().nextInt(100) + 1) * NegOrPos[new Random().nextInt(2)];
                        switch (i) {
                            case 1 -> mainGame.setButton1Value(Choice[i]);
                            case 2 -> mainGame.setButton2Value(Choice[i]);
                            case 3 -> mainGame.setButton3Value(Choice[i]);
                            case 4 -> mainGame.setButton4Value(Choice[i]);
                        }
                    }
                }
                break;
            case "/":
                for (int i = 1; i < 5; i++) {
                    if (i != ansChoice) {
                        Choice[i] = answer + (new Random().nextInt(50) + 1) * NegOrPos[new Random().nextInt(2)];
                        switch (i) {
                            case 1 -> mainGame.setButton1Value(Choice[i]);
                            case 2 -> mainGame.setButton2Value(Choice[i]);
                            case 3 -> mainGame.setButton3Value(Choice[i]);
                            case 4 -> mainGame.setButton4Value(Choice[i]);
                        }
                    }
                }
                break;
        }
    }

    public void checkAnswer (String response){
        if (Integer.parseInt(response) == answer) {
            score++;
        } else {
            score--;
        }
        nextQuiz();
    }

    //ไม่แน่ใจ skip()
    public void skip () {
        if (skipCount > 0) {
            skipCount--;
            nextQuiz();
        } else {
            //ให้ขึ้น You already use all skip.
        }
    }

    public int factorial ( int n){
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }
}
