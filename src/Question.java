import ModeFolder.Hard;
import ModeFolder.Mode;
import javax.swing.*;
import java.util.Random;

public class Question {
    private int skipCount = 3;
    private int score = 0;
    private int lifePoint = 3;
    private int answer = 0;
    private String quiz = "";
    private final Mode mode;

    public Question(Mode mode) {
        this.mode = mode;
    }

    public void nextQuiz(JLabel qLabel, JButton button1, JButton button2, JButton button3, JButton button4) {
        mode.randomOperator();
        mode.random2Num();
        String num1 = "";
        String num2 = "";
        String operator = "";
        
        if (mode.getOperator().equals("*")){
            operator += "x";
        } else{
            operator += mode.getOperator();
        }

        if (mode.getNum1() < 0) num1 = "( "+mode.getNum1()+" )";
        else num1 = String.valueOf(mode.getNum1());

        if (mode.getNum2() < 0) num2 = "( "+mode.getNum2()+" )";
        else num2 = String.valueOf(mode.getNum2());

        if (mode instanceof Hard && !(((Hard) mode).getOperator2().equals("none"))) {
            if (((Hard) mode).getOperator2().equals("!")){
                quiz = "( " + num1 + "!" + " )" + " " + operator + " " + num2 + " = ?";
            } else {
                quiz = "( " + num1  + ((Hard) mode).getOperator2() + ((Hard) mode).getExponent() + " )" + " " +
                        operator + " " + num2 + " = ?";
            }
        } else {
            quiz = num1 + " " + operator + " " + num2 + " = ?";
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
        int temp = 0;
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
                        if (Math.abs(answer) > 1000){
                            temp = answer + (new Random().nextInt(100) + 1) * NegOrPos[new Random().nextInt(2)];
                            while (this.checkChoice(Choice,temp)){
                                temp = answer + (new Random().nextInt(100) + 1) * NegOrPos[new Random().nextInt(2)];
                            }
                        } else if (Math.abs(answer) > 300){
                            temp = answer + (new Random().nextInt(50) + 1) * NegOrPos[new Random().nextInt(2)];
                            while (this.checkChoice(Choice,temp)){
                                temp = answer + (new Random().nextInt(50) + 1) * NegOrPos[new Random().nextInt(2)];
                            }
                        } else {
                            temp = answer + (new Random().nextInt(20) + 1) * NegOrPos[new Random().nextInt(2)];
                            while (this.checkChoice(Choice,temp)){
                                temp = answer + (new Random().nextInt(20) + 1) * NegOrPos[new Random().nextInt(2)];
                            }
                        }
                        Choice [i-1 ]= temp;
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
                        if (Math.abs(answer) > 10000){
                            temp = answer + (new Random().nextInt(1000)+1) * NegOrPos[new Random().nextInt(2)];
                            while (this.checkChoice(Choice,temp)){
                                temp = answer + (new Random().nextInt(1000)+1) * NegOrPos[new Random().nextInt(2)];
                            }
                        } else if (Math.abs(answer) > 100){
                            temp = answer + (new Random().nextInt(100) + 1) * NegOrPos[new Random().nextInt(2)];
                            while (this.checkChoice(Choice,temp)){
                                temp = answer + (new Random().nextInt(100)+1) * NegOrPos[new Random().nextInt(2)];
                            }
                        } else {
                            temp = answer + (new Random().nextInt(25) + 1) * NegOrPos[new Random().nextInt(2)];
                            while (this.checkChoice(Choice,temp)){
                                temp = answer + (new Random().nextInt(25)+1) * NegOrPos[new Random().nextInt(2)];
                            }
                        }
                        Choice[i-1] = temp;
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
                        temp = answer + (new Random().nextInt(25)+1) * NegOrPos[new Random().nextInt(2)];
                        while (this.checkChoice(Choice,temp)){
                            temp = answer + (new Random().nextInt(25)+1) * NegOrPos[new Random().nextInt(2)];
                        }
                        Choice[ i - 1 ] = temp;
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
            scoreLabel.setText("Score: " + score);
        } else {
            lifePoint--;
        }
    }

    public void skip (JLabel label) {
        if (skipCount > 0) {
            skipCount--;
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

    public boolean checkChoice(int[] choice, int temp){
        boolean check = false;
        for ( int eachChoice : choice){
            if ( eachChoice == temp)
                check = true;
        }
        return  check;
    }
    
    public void decreaseLP(){
        lifePoint--;
    }
    
    public int getLP(){
        return lifePoint;
    }
}