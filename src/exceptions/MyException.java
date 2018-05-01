package exceptions;

public class MyException extends Exception{
    private int detail;

    public MyException(int detail){ this.detail=detail; }

    @Override
    public String toString() {
        return "You enter wrong number ["+ detail+"]";
    }
}
