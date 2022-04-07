package com.company;

public abstract class Mode {
    protected String[] OperatorArray = {"+","-","*","/"};
    protected String operator;
    protected int num1;
    protected int num2;

    public abstract void setOperator();
    public abstract void  randomNum();

    public String getOperator(){
        return operator;
    }

    public int getNum1(){
        return num1;
    }

    public int getNum2(){
        return num2;
    }
}
