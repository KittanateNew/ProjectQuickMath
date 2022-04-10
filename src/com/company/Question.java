package com.company;

import com.company.mode.Hard;
import com.company.mode.Mode;

public class Question {
    private int skipCount = 3;
    private int score = 0;
    private int answer = 0;
    private String quiz = "";
    private Mode mode;

    public Question(Mode mode) { //กดปุ๋ม easy -> สร้าง new Question(new Easy())
        this.mode = mode;
    }

    public void nextQuiz() {
        mode.randomOperator();
        mode.random2Num();
        if (mode instanceof Hard) {

        } else {
            quiz = mode.getNum1() + " + " + mode.getNum2() + " = ?";
            setAnswer(mode.getNum1(), mode.getOperator(), mode.getNum2());
        }
    }

    public String getQuiz() {
        return quiz;
    }

    public void setAnswer(int num1, String operator, int num2) {
        if (mode instanceof Hard) {
            if (((Hard) mode).getOperator2().equals("none")) {
                switch (operator) {
                    case "+" -> answer = num1 + num2;
                    case "-" -> answer = num1 - num2;
                    case "*" -> answer = num1 * num2;
                    case "/" -> answer = num1 / num2;
                }
            } else if (((Hard) mode).getOperator2().equals("!")) {
                switch (operator) {
                    case "+" -> answer = factorial(num1) + num2;
                    case "-" -> answer = factorial(num1) - num2;
                    case "*" -> answer = factorial(num1) * num2;
                    case "/" -> answer = factorial(num1) / num2;
                }
            } else if (((Hard) mode).getOperator2().equals("^")) {
                int exp = ((Hard) mode).getExponent();
                switch (operator) {
                    case "+" -> answer = (int)(Math.pow(num1, exp) + num2);
                    case "-" -> answer = (int)(Math.pow(num1, exp) - num2);
                    case "*" -> answer = (int)(Math.pow(num1, exp) * num2);
                    case "/" -> answer = (int)(Math.pow(num1, exp) / num2);
                }
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
        if (mode.getOperator() == "+" || mode.getOperator() == -) {

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
            //ให้เปลี่ยนข้อ
        } else {
            score--;
            //เปลี่ยนข้อ
        }
    }

    public int factorial ( int n){
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }
}
