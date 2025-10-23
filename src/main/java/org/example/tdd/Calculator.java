package org.example.tdd;

public class Calculator {
    public int add (int a, int b)
    {

        return a+b;
    }
    public int  sub (int a, int b)
    {
        return a-b;
    }
    public int  multiply (int a, int b)
    {
        return a*b;
    }
    public double  divide (double a, double b)
    {
        if(b==0){throw new ArithmeticException("Cannot divide by zero");}
        return a/b;
    }
    public double power (double a, double b)
    {
        return Math.pow(a,b);
    }
    public double squareRoot(double a)
    {
        if(a<0){throw new ArithmeticException("Cannot take square root of a negative number");}
        return Math.sqrt(a);
    }

}
