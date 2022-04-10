package com.company;

import com.company.mode.Mode;

public class Question {
    private int skipCount = 3;
    private int score = 0;
    private int answer = 0;
    private String quiz = "";
    private Mode mode;

    public Question(Mode mode){
        this.mode = mode;
    }

    public void nextQuiz(){

    }

    public String getQuiz(){
        return quiz;
    }

    public void setAnswer(int n1, String operator, int n2){
        switch (operator) {
            case "+" -> answer = n1 + n2;
            case "-" -> answer = n1 - n2;
            case "*" -> answer = n1 * n2;
            case "/" -> answer = n1 / n2;
        }
    }

    public int getAnswer(){
        return answer;
    }

    public void addChoice(){
        //ไม่แน่ใจ
    }

    public Boolean checkAnswer(String response){
        return Integer.parseInt(response) == answer;
    }

    //ไม่แน่ใจ skip()
    public void skip(){
        if (skipCount > 0){
            skipCount--;
            //ให้เปลี่ยนข้อ
        } else {
            score--;
            //เปลี่ยนข้อ
        }
    }
}
