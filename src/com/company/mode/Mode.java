package com.company.mode;

public abstract class Mode {
    protected String[] OperatorArray = {"+", "-", "*", "/"};
    protected String operator;
    protected int num1;
    protected int num2;

    public abstract void randomOperator();
    public abstract void random2Num();

    public void setOperator(String operator) {
        this.operator = operator;
    } //ใช้ตรวจเจาะจงบางเครื่องหมายเช่น ตรวจหารว่าทำได้ตามเขียนโค้ดไว้ไหม

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
