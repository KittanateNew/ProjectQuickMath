package ModeFolder;

public abstract class Mode {
    protected String[] OperatorArray = {"+", "-", "*", "/"};
    protected String operator;
    protected int num1;
    protected int num2;

    public abstract void randomOperator();
    public abstract void random2Num();

    public void setOperator(String operator) {
        this.operator = operator;
    } //Use to check for specific operator such as check dividing is it possible to do it according to the code written?

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