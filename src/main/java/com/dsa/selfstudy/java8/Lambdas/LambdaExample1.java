package com.dsa.selfstudy.java8.Lambdas;

public class LambdaExample1 {
    public static int p =555;
    public static void main(String[] args) {

        MathOperator<Integer,Integer> add = (a, b) -> a+b;
        MathOperator<Integer,Integer> sub = (Integer a, Integer b) -> a-b;
        MathOperator<Integer,Integer> mult = (Integer a, Integer b) -> { return a*b;};
        MathOperator<Double,Integer> div = (Integer a, Integer b) -> { return Double.valueOf(a/b);
        };

        operate(6,3,add);
        operate(6,3,sub);
        operate(6,3,mult);
        operate(6,3,div);
    }

    public static void operate(Integer a, Integer b, MathOperator<? extends Number, Integer> mathOperator){
        System.out.println(mathOperator.operate(a,b));
    }
}

@FunctionalInterface
interface MathOperator<R,T> {

    R operate(T a, T b);
}
