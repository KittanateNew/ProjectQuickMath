package com.company;

public class Question {
    private static int skipCount = 3;
    private static int score = 0;
    private int answer;
    private String quiz;

    public Question(int n1, String operator, int n2){
        setAnswer(n1, operator, n2);
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

    public void setQuiz(int n1, String operator, int n2){
        quiz = n1 + " " + operator + " " + n2 + " = ?";
    }

    public String getQuiz(){
        return quiz;
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
